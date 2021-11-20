const db = require("../configdb/config");
const Asesor = require("../models/asesor");



const getTodosAsesores = async (req, res) => {
   try {
        const asesores = await db.collection('asesor');
        const datos = await asesores.get();

        const listadoasesores = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const asesor = new Asesor(
                    doc.id,
                    doc.data().identificacion,
                    doc.data().nombre,
                    doc.data().telefono1,
                    doc.data().movil,
                    doc.data().email,
                    doc.data().idsede
                );
                listadoasesores.push(asesor);

            });
            res.send(listadoasesores);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
} 
const addAsesor = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('asesor').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getAsesor = async (req, res) => {
    try {
        const id = req.params.id;
        const asesor = await db.collection('asesor').doc(id);
        const data = await asesor.get();

        if (!data.exists) {
            res.status(404).send('Asesor no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateAsesor = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const asesor = await db.collection('asesor').doc(id);
        await asesor.update(data);
        res.send('Asesor actualizado con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delAsesor = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('asesor').doc(id).delete();
        res.send('Asesor eliminado con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosAsesores,
    addAsesor,
    getAsesor,
    updateAsesor,
    delAsesor

}