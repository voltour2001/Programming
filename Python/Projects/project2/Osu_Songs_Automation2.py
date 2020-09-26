from flask import Flask

app = Flask(__name__)
a='osu link'
@app.route("/")
def home():
    return """
    <html>
    <body>
    </body>
    </html>"""


if __name__ == "__main__":
    app.run()