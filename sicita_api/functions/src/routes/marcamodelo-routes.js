/* eslint-disable new-cap */
const express = require("express");
const marcamodelo = require("../controllers/marcamodeloController");
const router = express.Router();
router.get("/MarcaModelo", marcamodelo.getTodosMarcaModelo);
router.post("/MarcaModelo", marcamodelo.addMarcaModelo);
router.get("/MarcaModelo/:id", marcamodelo.getMarcaModelo);
router.put("/MarcaModelo/:id", marcamodelo.updMarcaModelo);
router.delete("/MarcaModelo/:id", marcamodelo.delMarcaModelo);
module.exports = {
  routes: router,
};
