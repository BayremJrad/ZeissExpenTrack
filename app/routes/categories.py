from flask import Blueprint, request, jsonify
from ..services import category_service

categories_bp = Blueprint("categories", __name__)


@categories_bp.get("/categories")
def list_categories():
    categories = category_service.list_categories()
    return jsonify({"data": [c.to_dict() for c in categories]}), 200


@categories_bp.post("/categories")
def create_category():
    data = request.get_json()

    if not data or not data.get("name"):
        return jsonify({
            "error": "Validation failed",
            "details": ["name is required"]
        }), 400

    category = category_service.create_category(data)
    return jsonify(category.to_dict()), 201
