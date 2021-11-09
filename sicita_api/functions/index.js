const functions = require("firebase-functions");
const morgan = require("morgan");
const express = require("express");
const cors = require("cors");
const app = express();
app.use(cors({
  origin: true
}));
const rutasusuarios = require('./src/routes/usuarios-routes');

app.use(morgan("tiny"));
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({
  extend: true
}));

app.use("/api/", rutasusuarios.routes);


app.get("/api/Conectar", (req, res) => {
  return res.status(200).send("Conectado SICITA");
});

exports.app = functions.https.onRequest(app);