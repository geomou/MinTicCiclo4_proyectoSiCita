/* eslint-disable new-cap */
const express = require("express");
const cita = require("../controllers/citaController");
const router = express.Router();


router.get("/Citas", cita.getTodosCita);
router.post("/Citas", cita.addCita);
router.get("/Citas/:id", cita.getCita);
router.put("/Citas/:id", cita.updateCita);
router.delete("/Citas/:id", cita.delCita);
router.delete("/Citasfiltro/:id", cita.getfiltroCita);


module.exports = {
  routes: router,
};
