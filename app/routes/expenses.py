from flask import Blueprint, request, jsonify
from ..services import expense_service

expenses_bp = Blueprint("expenses", __name__)


@expenses_bp.get("/expenses")
def list_expenses():
    category = request.args.get("category")
    start_date = request.args.get("startDate")
    end_date = request.args.get("endDate")

    expenses = expense_service.list_expenses(category, start_date, end_date)
    return jsonify({"data": [e.to_dict() for e in expenses], "total": len(expenses)}), 200


@expenses_bp.post("/expenses")
def create_expense():
    data = request.get_json()

    # Basic validation
    if not data or not data.get("title") or data.get("amount") is None:
        return jsonify({
            "error": "Validation failed",
            "details": ["title must not be empty", "amount is required"]
        }), 400

    expense = expense_service.create_expense(data)
    return jsonify(expense.to_dict()), 201


@expenses_bp.get("/expenses/<string:expense_id>")
def get_expense(expense_id):
    expense = expense_service.get_expense(expense_id)
    if not expense:
        return jsonify({"error": "Expense not found"}), 404
    return jsonify(expense.to_dict()), 200


@expenses_bp.put("/expenses/<string:expense_id>")
def update_expense(expense_id):
    data = request.get_json()
    expense = expense_service.update_expense(expense_id, data)
    if not expense:
        return jsonify({"error": "Expense not found"}), 404
    return jsonify(expense.to_dict()), 200


@expenses_bp.delete("/expenses/<string:expense_id>")
def delete_expense(expense_id):
    deleted = expense_service.delete_expense(expense_id)
    if not deleted:
        return jsonify({"error": "Expense not found"}), 404
    return "", 204


@expenses_bp.delete("/expenses")
def bulk_delete_expenses():
    data = request.get_json()
    ids = data.get("ids", []) if data else []
    count = expense_service.bulk_delete_expenses(ids)
    return jsonify({"deleted": count}), 200
