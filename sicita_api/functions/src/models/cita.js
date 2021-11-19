/* eslint-disable require-jsdoc */
class Cita {
  constructor(
      idempresa,
      idsede,
      idvehiculo,
      fecha,
      hora,
      idtipocita,
      idcanalcita,
      observaciones,
      tiempoestimado,
      transporte
  ) {
    this.idempresa = idempresa;
    this.idsede = idsede;
    this.idvehiculo = idvehiculo;
    this.fecha = fecha;
    this.hora = hora;
    this.idtipocita = idtipocita;
    this.idcanalcita = idcanalcita;
    this.observaciones = observaciones;
    this.tiempoestimado = tiempoestimado;
    this.transporte == transporte;
  }
}
module.exports = Cita;
