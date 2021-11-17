/* eslint-disable new-cap */
const express = require("express");
const usuarioempresa = require("../controllers/usuarioempresaController");
const router = express.Router();
router.get("/UsuarioEmpresa", usuarioempresa.getTodosUusuarioEmpresa);
router.post("/UsuarioEmpresa", usuarioempresa.addUsuarioEmpresa);
router.get("/UsuarioEmpresa/:id", usuarioempresa.getUsuarioEmpresa);
router.put("/UsuarioEmpresa/:id", usuarioempresa.updateUsuarioEmpresa);
router.delete("/UsuarioEmpresa/:id", usuarioempresa.delUsuarioEmpresa);
module.exports = {
  routes: router,
};
