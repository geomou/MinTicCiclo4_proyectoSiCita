const db = require("../configdb/config");
const marcamodelo = require("../models/marca");

const getTodosMarcaModelo = async (req, res, next) => {
    try {
        const marcamodelos = await db.collection('MarcaModelo');
        const datos = await marcamodelos.get();

        const listadomarcasmodelos = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const marcamodelo = new MarcaModelo(
                    doc.id,
                   doc.data().codigo,
                   doc.data().descripcion,
                   doc.data().es_mawrca,
                   doc.data().id_marcamodelo,

                );
                listadousuarios.push(marcamodelo)

            });
            res.send(listadomarcasmodelos);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addMarcaModelo = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('MarcaModelo').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getMarcaModelo = async (req, res) => {
    try {
        const id = req.params.id;
        const marcamodelo = await db.collection('MarcaModelo').doc(id);
        const data = await marcamodelo.get();

        if (!data.exists) {
            res.status(404).send('Marca o Modelo no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updMarcaModelo = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const marcamodelo = await db.collection('MarcaModelo').doc(id);
        await marcamodelo.update(data);
        res.send('Marca o Modelo actualizado con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delMarcaModelo = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('MarcaModelo').doc(id).delete();
        res.send('Marca o Modelo  eliminado con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosMarcaModelo,
    addMarcaModelo,
    getMarcaModelo,
    updMarcaModelo,
    delMarcaModelo

}