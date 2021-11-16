/* eslint-disable new-cap */
const express = require("express");
const horariodet = require("../controllers/horariodetController");
const router = express.Router();


router.get("/HorarioDetalle", horariodet.getTodosHorarioDetalle);
router.post("/HorarioDetalle", horariodet.addHorarioDetalle);
router.get("/HorarioDetalle/:id", horariodet.getHorarioDetalle);
router.put("/HorarioDetalle/:id", horariodet.updateHorarioDetalle);
router.delete("/HorarioDetalle/:id", horariodet.delHorarioDetalle);


module.exports = {
  routes: router,
};
