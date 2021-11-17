/* eslint-disable require-jsdoc */
class Vehiculos {
  constructor(idmarcamodelo, placa, año, caracteristicas, idusuario) {
    this.idmodelo = idmarcamodelo;
    this.placa = placa;
    this.año = año;
    this.caracteristicas = caracteristicas;
    this.idusuario=idusuario;
  }
}
module.exports = Vehiculos;
