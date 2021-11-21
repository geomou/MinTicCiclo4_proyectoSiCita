/* eslint-disable new-cap */
const express = require("express");
const us = require("../controllers/usuariosController");
const router = express.Router();
router.get("/Usuarios", us.getTodosUsuarios);
router.post("/Usuario", us.addUsuario);
router.get("/Usuario/:id", us.getUsuario);
router.put("/Usuario/:id", us.updateUsuario);
router.delete("/Usuario/:id", us.delusuario);
router.get("/Usuario/:nombre", us.getlogueoUsuario);

module.exports = {
  routes: router,
};
