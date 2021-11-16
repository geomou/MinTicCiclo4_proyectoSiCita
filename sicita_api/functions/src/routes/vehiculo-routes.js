const express = require("express");
const vehiculo = require("../controllers/vehiculoController");
const router = express.Router();


router.get("/Vehiculos", vehiculo.getTodosVehiculos);
router.post("/Vehiculos", vehiculo.addVehiculo);
router.get("/Vehiculos/:id", vehiculo.getVehiculo);
router.put("/Vehiculos/:id", vehiculo.updateVehiculo);
router.delete("/Vehiculos/:id", vehiculo.delVehiculo);


module.exports = {
  routes: router,
};
