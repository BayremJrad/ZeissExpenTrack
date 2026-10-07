from dataclasses import dataclass, field
from typing import Optional


@dataclass
class Expense:
    id: str
    title: str
    amount: float
    category: str
    date: str
    notes: Optional[str] = None

    def to_dict(self):
        return {
            "id": self.id,
            "title": self.title,
            "amount": self.amount,
            "category": self.category,
            "date": self.date,
            "notes": self.notes,
        }
