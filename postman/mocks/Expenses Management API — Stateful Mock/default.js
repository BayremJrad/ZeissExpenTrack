/**
 * Stateful mock for the Expenses Management API.
 *
 * Endpoints:
 *   @endpoint GET    /expenses          — list all expenses
 *   @endpoint POST   /expenses          — create an expense
 *   @endpoint GET    /expenses/:id      — get a single expense
 *   @endpoint PUT    /expenses/:id      — update an expense
 *   @endpoint DELETE /expenses/:id      — delete an expense
 *   @endpoint GET    /categories        — list all categories
 *   @endpoint POST   /categories        — create a category
 *
 * State is persisted across requests via pm.state.
 * Seed data is loaded on first request.
 */
const http = require("http");
const PORT = process.env.PORT || 4500;
const JSON_HEADER = { "Content-Type": "application/json" };

// ── helpers ──────────────────────────────────────────────────────────────────

function parseBody(req) {
  return new Promise((resolve) => {
    let raw = "";
    req.on("data", (c) => (raw += c));
    req.on("end", () => {
      try { resolve(raw ? JSON.parse(raw) : {}); } catch { resolve({}); }
    });
  });
}

function send(res, status, body) {
  res.writeHead(status, JSON_HEADER);
  res.end(body === undefined ? "" : JSON.stringify(body));
}

function idFromUrl(url, prefix) {
  // e.g. /expenses/exp_001  →  "exp_001"
  const parts = url.split("?")[0].split("/").filter(Boolean);
  const idx = parts.indexOf(prefix);
  return idx !== -1 && parts[idx + 1] ? parts[idx + 1] : null;
}

// ── seed data ─────────────────────────────────────────────────────────────────

const SEED_EXPENSES = [
  { id: "exp_001", title: "Team lunch",    amount: 45.50,  category: "Food",   date: "2026-10-07", notes: "Quarterly team lunch" },
  { id: "exp_002", title: "Flight to NYC", amount: 320.00, category: "Travel", date: "2026-10-05", notes: "" },
];

const SEED_CATEGORIES = [
  { id: "cat_001", name: "Food",   description: "Meals and dining" },
  { id: "cat_002", name: "Travel", description: "Business travel expenses" },
];

async function ensureSeeded() {
  const expenses   = await pm.state.get("expenses");
  const categories = await pm.state.get("categories");
  if (!expenses)   await pm.state.set("expenses",   SEED_EXPENSES);
  if (!categories) await pm.state.set("categories", SEED_CATEGORIES);
}

// ── server ────────────────────────────────────────────────────────────────────

const server = http.createServer(async (req, res) => {
  const { method, url } = req;
  const path = url.split("?")[0];

  await ensureSeeded();

  // ── GET /expenses ──────────────────────────────────────────────────────────
  if (method === "GET" && path === "/expenses") {
    const expenses = (await pm.state.get("expenses")) || [];
    return send(res, 200, { data: expenses, total: expenses.length });
  }

  // ── POST /expenses ─────────────────────────────────────────────────────────
  if (method === "POST" && path === "/expenses") {
    const body = await parseBody(req);
    const errors = [];
    if (!body.title || body.title.trim() === "") errors.push("title must not be empty");
    if (body.amount === undefined || body.amount === null) errors.push("amount is required");
    if (errors.length) return send(res, 400, { error: "Validation failed", details: errors });

    const expenses = (await pm.state.get("expenses")) || [];
    const newExpense = {
      id:       `exp_${Date.now()}`,
      title:    body.title,
      amount:   body.amount,
      category: body.category || "",
      date:     body.date || new Date().toISOString().slice(0, 10),
      notes:    body.notes || "",
    };
    expenses.push(newExpense);
    await pm.state.set("expenses", expenses);
    return send(res, 201, newExpense);
  }

  // ── GET /expenses/:id ──────────────────────────────────────────────────────
  if (method === "GET" && /^\/expenses\/[^/]+$/.test(path)) {
    const id = idFromUrl(path, "expenses");
    const expenses = (await pm.state.get("expenses")) || [];
    const expense = expenses.find((e) => e.id === id);
    if (!expense) return send(res, 404, { error: "Expense not found" });
    return send(res, 200, expense);
  }

  // ── PUT /expenses/:id ──────────────────────────────────────────────────────
  if (method === "PUT" && /^\/expenses\/[^/]+$/.test(path)) {
    const id = idFromUrl(path, "expenses");
    const expenses = (await pm.state.get("expenses")) || [];
    const idx = expenses.findIndex((e) => e.id === id);
    if (idx === -1) return send(res, 404, { error: "Expense not found" });

    const body = await parseBody(req);
    const updated = { ...expenses[idx], ...body, id };
    expenses[idx] = updated;
    await pm.state.set("expenses", expenses);
    return send(res, 200, updated);
  }

  // ── DELETE /expenses/:id ───────────────────────────────────────────────────
  if (method === "DELETE" && /^\/expenses\/[^/]+$/.test(path)) {
    const id = idFromUrl(path, "expenses");
    let expenses = (await pm.state.get("expenses")) || [];
    const idx = expenses.findIndex((e) => e.id === id);
    if (idx === -1) return send(res, 404, { error: "Expense not found" });

    expenses.splice(idx, 1);
    await pm.state.set("expenses", expenses);
    res.writeHead(204);
    return res.end();
  }

  // ── GET /categories ────────────────────────────────────────────────────────
  if (method === "GET" && path === "/categories") {
    const categories = (await pm.state.get("categories")) || [];
    return send(res, 200, { data: categories });
  }

  // ── POST /categories ───────────────────────────────────────────────────────
  if (method === "POST" && path === "/categories") {
    const body = await parseBody(req);
    if (!body.name || body.name.trim() === "") {
      return send(res, 400, { error: "Validation failed", details: ["name is required"] });
    }
    const categories = (await pm.state.get("categories")) || [];
    const newCategory = {
      id:          `cat_${Date.now()}`,
      name:        body.name,
      description: body.description || "",
    };
    categories.push(newCategory);
    await pm.state.set("categories", categories);
    return send(res, 201, newCategory);
  }

  // ── 404 fallback ───────────────────────────────────────────────────────────
  send(res, 404, {
    error:   "Endpoint not defined",
    message: `No handler for ${method} ${url}`,
  });
});

server.listen(PORT, () => console.log(`Expenses mock running on port ${PORT}`));