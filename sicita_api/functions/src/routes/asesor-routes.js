/* eslint-disable new-cap */
const express = require("express");
const asesor = require("../controllers/asesorController");
const router = express.Router();

router.get("/Asesores", asesor.getTodosAsesores);
router.post("/Asesores", asesor.addAsesor);
router.get("/Asesores/:id", asesor.getAsesor);
router.put("/Asesores/:id", asesor.updateAsesor);
router.delete("/Asesores/:id", asesor.delAsesor);

module.exports = {
  routes: router,
};
