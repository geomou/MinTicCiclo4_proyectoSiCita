/* eslint-disable new-cap */
const express = require("express");
const tipocita = require("../controllers/tipocitaController");
const router = express.Router();
router.get("/TipoCita", tipocita.getTodosTiposCita);
router.post("/TipoCita", tipocita.addTipoCita);
router.get("/TipoCita/:id", tipocita.getTipoCita);
router.put("/TipoCita/:id", tipocita.updateTipoCita);
router.delete("/TipoCita/:id", tipocita.delTipoCita);
module.exports = {
  routes: router,
};
