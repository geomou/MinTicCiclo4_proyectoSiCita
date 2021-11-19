/* eslint-disable new-cap */
const express = require("express");
const canal = require("../controllers/canalcitaController");
const router = express.Router();
router.get("/Canales", canal.getTodosCanalCita);
router.post("/Canales", canal.addCanalCita);
router.get("/Canales/:id", canal.getCanalCita);
router.put("/Canales/:id", canal.updateCanalCita);
router.delete("/Canales/:id", canal.delCanalCita);

module.exports = {
  routes: router,
};
