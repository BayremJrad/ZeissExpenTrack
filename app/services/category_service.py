"""
Category service — contains the business logic for managing categories.
All methods currently use an in-memory store; replace with your DB layer here.
"""
from typing import List, Optional
from ..models.category import Category

# ---------------------------------------------------------------------------
# In-memory store (replace with a real DB later)
# ---------------------------------------------------------------------------
_categories: dict[str, Category] = {}
_counter = 1


def _next_id() -> str:
    global _counter
    category_id = f"cat_{_counter:03d}"
    _counter += 1
    return category_id


# ---------------------------------------------------------------------------
# CRUD operations
# ---------------------------------------------------------------------------

def list_categories() -> List[Category]:
    """Return all categories."""
    return list(_categories.values())


def get_category(category_id: str) -> Optional[Category]:
    """Return a single category by ID, or None if not found."""
    return _categories.get(category_id)


def create_category(data: dict) -> Category:
    """Create and persist a new category."""
    # TODO: add validation / duplicate-name check
    category = Category(
        id=_next_id(),
        name=data["name"],
        description=data.get("description"),
    )
    _categories[category.id] = category
    return category
