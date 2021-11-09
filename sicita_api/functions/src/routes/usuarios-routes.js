const express = require("express");
const  us = require('../controllers/usuariosController');
const router = express.Router();


router.get("/Usuarios", us.getTodosUsuarios);
module.exports = {
  routes: router,
};
