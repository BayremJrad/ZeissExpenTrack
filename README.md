# ZeissExpenTrack — Expenses Management API

A simple Flask REST API for tracking expenses and categories.

## Project structure

```
├── app/
│   ├── __init__.py          # App factory
│   ├── models/
│   │   ├── expense.py       # Expense dataclass
│   │   └── category.py      # Category dataclass
│   ├── routes/
│   │   ├── expenses.py      # /expenses endpoints
│   │   └── categories.py    # /categories endpoints
│   └── services/
│       ├── expense_service.py   # Business logic for expenses
│       └── category_service.py  # Business logic for categories
├── postman/                 # Postman collections, specs, environments
├── run.py                   # Entry point
└── requirements.txt
```

## Getting started

```bash
# Install dependencies
pip install -r requirements.txt

# Run the server (default: http://localhost:5000)
python run.py
```

## API endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/expenses` | List all expenses (filter by `category`, `startDate`, `endDate`) |
| POST | `/expenses` | Create an expense |
| GET | `/expenses/:id` | Get a single expense |
| PUT | `/expenses/:id` | Update an expense |
| DELETE | `/expenses/:id` | Delete an expense |
| DELETE | `/expenses` | Bulk delete expenses |
| GET | `/categories` | List all categories |
| POST | `/categories` | Create a category |

## Next steps

- Replace the in-memory store in `services/` with a real database (SQLite, PostgreSQL, etc.)
- Add authentication
- Add proper input validation (e.g. with `marshmallow` or `pydantic`)
