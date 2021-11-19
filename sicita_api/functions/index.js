const functions = require("firebase-functions");
const morgan = require("morgan");
const express = require("express");
const cors = require("cors");
const app = express();
app.use(cors({
  origin: true,
}));

app.use(morgan("tiny"));
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({
  extend: true,
}));

const rutasusuarios = require("./src/routes/usuarios-routes");
const rutaasesores = require("./src/routes/asesor-routes");
const rutacanalcita = require("./src/routes/canalcita-routes");
const rutacita = require("./src/routes/cita-routes");
const rutaempresa = require("./src/routes/empresa-routes");
const rutahorariodetalle = require("./src/routes/horariodetalle-routes");
const rutahorarioencabezado = require("./src/routes/horarioencabezado-routes");
const rutamarcamodelo = require("./src/routes/marcamodelo-routes");
const rutatipocita = require("./src/routes/tipocita-routes");
const rutausuarioempresa = require("./src/routes/usuarioempresa-routes");
const rutavehiculo = require("./src/routes/vehiculo-routes");
app.use("/api/", rutasusuarios.routes);
app.use("/api/", rutaasesores.routes);
app.use("/api/", rutacanalcita.routes);
app.use("/api/", rutacita.routes);
app.use("/api/", rutaempresa.routes);
app.use("/api/", rutahorariodetalle.routes);
app.use("/api/", rutahorarioencabezado.routes);
app.use("/api/", rutamarcamodelo.routes);
app.use("/api/", rutatipocita.routes);
app.use("/api/", rutausuarioempresa.routes);
app.use("/api/", rutavehiculo.routes);


app.get("/api/Conectar", (req, res) => {
  return res.status(200).send("Conectado SICITA");
});

exports.app = functions.https.onRequest(app);
