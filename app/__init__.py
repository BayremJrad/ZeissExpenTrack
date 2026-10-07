from flask import Flask
from .routes.expenses import expenses_bp
from .routes.categories import categories_bp


def create_app():
    app = Flask(__name__)

    app.register_blueprint(expenses_bp)
    app.register_blueprint(categories_bp)

    return app
