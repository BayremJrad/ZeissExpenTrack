"""
Expense service — contains the business logic for managing expenses.
All methods currently use an in-memory store; replace with your DB layer here.
"""
from typing import List, Optional
from ..models.expense import Expense

# ---------------------------------------------------------------------------
# In-memory store (replace with a real DB later)
# ---------------------------------------------------------------------------
_expenses: dict[str, Expense] = {}
_counter = 1


def _next_id() -> str:
    global _counter
    expense_id = f"exp_{_counter:03d}"
    _counter += 1
    return expense_id


# ---------------------------------------------------------------------------
# CRUD operations
# ---------------------------------------------------------------------------

def list_expenses(category: Optional[str] = None,
                  start_date: Optional[str] = None,
                  end_date: Optional[str] = None) -> List[Expense]:
    """Return all expenses, optionally filtered."""
    results = list(_expenses.values())

    # TODO: implement filtering logic
    if category:
        results = [e for e in results if e.category == category]
    if start_date:
        results = [e for e in results if e.date >= start_date]
    if end_date:
        results = [e for e in results if e.date <= end_date]

    return results


def get_expense(expense_id: str) -> Optional[Expense]:
    """Return a single expense by ID, or None if not found."""
    return _expenses.get(expense_id)


def create_expense(data: dict) -> Expense:
    """Create and persist a new expense."""
    # TODO: add validation logic
    expense = Expense(
        id=_next_id(),
        title=data["title"],
        amount=data["amount"],
        category=data["category"],
        date=data["date"],
        notes=data.get("notes"),
    )
    _expenses[expense.id] = expense
    return expense


def update_expense(expense_id: str, data: dict) -> Optional[Expense]:
    """Update an existing expense. Returns None if not found."""
    expense = _expenses.get(expense_id)
    if not expense:
        return None

    # TODO: add partial-update / validation logic
    expense.title = data.get("title", expense.title)
    expense.amount = data.get("amount", expense.amount)
    expense.category = data.get("category", expense.category)
    expense.date = data.get("date", expense.date)
    expense.notes = data.get("notes", expense.notes)
    return expense


def delete_expense(expense_id: str) -> bool:
    """Delete an expense. Returns True if deleted, False if not found."""
    if expense_id not in _expenses:
        return False
    del _expenses[expense_id]
    return True


def bulk_delete_expenses(ids: List[str]) -> int:
    """Delete multiple expenses. Returns the count of deleted items."""
    deleted = 0
    for expense_id in ids:
        if delete_expense(expense_id):
            deleted += 1
    return deleted
