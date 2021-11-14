const db = require("../configdb/config");
const Empresa = require("../models/Empresa");

const getTodosEmpresa = async (req, res, next) => {
    try {
        const empresas = await db.collection('Empresas');
        const datos = await empresas.get();

        const listadouempresas = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const empresa = new Empresa(
                    doc.id,
                    doc.data().razonsocial,
                    doc.data().razonsocial,
                    doc.data().direccion,
                    doc.data().telefono1,
                    doc.data().telefono2,
                    doc.data().contacto,
                    doc.data().urlapi,
                    doc.data().clave,
                    doc.data().estado,                  
                    
                );
                listadouempresas.push(empresa)

            });
            res.send(listadouempresas);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addEmpresa = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('Empresas').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getEmpresa = async (req, res) => {
    try {
        const id = req.params.id;
        const empresa = await db.collection('Empresas').doc(id);
        const data = await empresa.get();

        if (!data.exists) {
            res.status(404).send('Empresa no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateEmpresa = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const usuario = await db.collection('Empresas').doc(id);
        await usuario.update(data);
        res.send('Empresa actualizado con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delEmpresa = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('Empresas').doc(id).delete();
        res.send('Usuario eliminado con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosEmpresa,
    addEmpresa,
    getEmpresa,
    updateEmpresa,
    delEmpresa

}