
//"use strict";

const db = require("../configdb/config");
const Usuario = require("../models/Usuario");



const getTodosUsuarios = async (req, res, next) => {
    try {
        const usuarios = await db.collection('Usuarios');
        const datos = await usuarios.get();
     
        const listadousuarios = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const usuario = new Usuario(
                    doc.id,
                    doc.data().nombre,
                    doc.data().telefono1,
                    doc.data().movil,
                    doc.data().direccion,
                    doc.data().email,
                    doc.data().clave
                );
                listadousuarios.push(usuario)

            });
            res.send(listadousuarios);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

module.exports = {
    getTodosUsuarios
}