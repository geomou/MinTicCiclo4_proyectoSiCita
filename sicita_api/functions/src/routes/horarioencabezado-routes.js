/* eslint-disable new-cap */
const express = require("express");
const horarioenc = require("../controllers/horarioencaController");
const router = express.Router();
router.get("/HorarioEncabezado", horarioenc.getTodosHorarioEnca);
router.post("/HorarioEncabezado", horarioenc.addHorarioEnca);
router.get("/HorarioEncabezado/:id", horarioenc.getHorarioEnca);
router.put("/HorarioEncabezado/:id", horarioenc.updateHorarioEnca);
router.delete("/HorarioEncabezado/:id", horarioenc.delHorarioEnca);


module.exports = {
  routes: router,
};
