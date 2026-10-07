from dataclasses import dataclass
from typing import Optional


@dataclass
class Category:
    id: str
    name: str
    description: Optional[str] = None

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "description": self.description,
        }
