class Usuarios {
  constructor(
      id, nombre, telefono1, movil, direccion, email, clave
  ) {
    this.id = id;
    this.nombre = nombre;
    this.telefono1 = telefono1;
    this.movil = movil;
    this.direccion = direccion;
    this.email = email;
    this.clave = clave;
  }
}
module.exports = Usuarios;
