const db = require("../configdb/config");
const UsuarioEmpresa = require("../models/usuariompresa");

const getTodosUusuarioEmpresa = async (req, res, next) => {
    try {
        const usuarioempresa = await db.collection('usuarioempresa');
        const datos = await usuarioempresa.get();

        const listadousuarioempresa = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const usuarioempresa = new UsuarioEmpresa(
                    doc.id,
                    doc.data().idusuario,
                    doc.date().idemp,            
                    
                );
                listadousuarioempresa.push(usuarioempresa)

            });
            res.send(listadousuarioempresa);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addUsuarioEmpresa = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('usuarioempresa').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getUsuarioEmpresa = async (req, res) => {
    try {
        const id = req.params.id;
        const usuarioempresa = await db.collection('usuarioempresa').doc(id);
        const data = await usuarioempresa.get();

        if (!data.exists) {
            res.status(404).send('Tipo de canal de  cita no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateUsuarioEmpresa = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const usuarioempresa = await db.collection('usauarioempresa').doc(id);
        await usuarioempresa.update(data);
        res.send('Usuario por Empresa actualizado con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delUsuarioEmpresa = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('usuarioempresa').doc(id).delete();
        res.send('Usuario por Empresa eliminada con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosUusuarioEmpresa,
    addUsuarioEmpresa,
    getUsuarioEmpresa,
    updateUsuarioEmpresa,
    delUsuarioEmpresa

}