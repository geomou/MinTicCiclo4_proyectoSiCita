/* eslint-disable new-cap */
const express = require("express");
const empresa = require("../controllers/empresaController");
const router = express.Router();


router.get("/Empresas", empresa.getTodosEmpresa);
router.post("/Empresas", empresa.addEmpresa);
router.get("/Empresas/:id", empresa.getEmpresa);
router.put("/Empresas/:id", empresa.updateEmpresa);
router.delete("/Empresas/:id", empresa.delEmpresa);


module.exports = {
  routes: router,
};
