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

const addUsuario = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('Usuarios').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getUsuario = async (req, res) => {
    try {
        const id = req.params.id;
        const usuario = await db.collection('Usuarios').doc(id);
        const data = await usuario.get();

        if (!data.exists) {
            res.status(404).send('Usuario no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateUsuario = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const usuario = await db.collection('Usuarios').doc(id);
        await usuario.update(data);
        res.send('Usuario actualizado con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delusuario = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('Usuarios').doc(id).delete();
        res.send('Usuario eliminado con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosUsuarios,
    addUsuario,
    getUsuario,
    updateUsuario,
    delusuario

}