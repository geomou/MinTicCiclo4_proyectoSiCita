/* eslint-disable require-jsdoc */

class Empresa {
  constructor(
      id, identificacion, razonsocial, direccion, telefono1, telefono2,
      contacto, urlapi, clave, estado
  ) {
    this.id=id;
    this.identificacion=identificacion;
    this.razonsocial=razonsocial;
    this.direccion=direccion;
    this.telefono1=telefono1;
    this.telefono2=telefono2;
    this.contacto=contacto;
    this.urlapi=urlapi;
    this.clave=clave;
    this.estado=estado;
  }
}
module.exports=Empresa;
