const db = require("../configdb/config");
const Cita = require("../models/cita");

const getTodosCita = async (req, res, next) => {
    try {
        const cita = await db.collection('cita');
        const datos = await cita.get();

        const listadocitas = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const cita = new Cita(
                    doc.id,
                    doc.date().idempresa,
                    doc.data().idsede, 
                    doc.date().idvehiculo,
                    doc.data().fecha,
                    doc.data().hora,
                    doc.data().idtipocita, 
                    doc.data().idcanalcita,
                    doc.date().observaciones, 
                    doc.data().tiempoestimado,
                    doc.data().transporte,
                    
                );
                listadocitas.push(cita)

            });
            res.send(listadocitas);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getfiltroCita = async (req, res, next) => {
    try {
        const id = req.params.id;
        const cita = await db.collection('cita').doc(id);
        const datos = await cita.get();

        const listadocita = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const cita = new Cita(
                    doc.id,
                    doc.data().idmarcamodelo,
                    doc.data().placa,
                    doc.data().año,
                    doc.data().caracteristicas, 
                    data.doc().idusuario  
                );
                listadocita.push(cita)

            });
            res.send(listadocita);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addCita = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('cita').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getCita = async (req, res) => {
    try {
        const id = req.params.id;
        const cita = await db.collection('cita').doc(id);
        const data = await cita.get();

        if (!data.exists) {
            res.status(404).send('Cita no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateCita = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const cita = await db.collection('cita').doc(id);
        await cita.update(data);
        res.send('Cita  Actualizada con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delCita= async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('cita').doc(id).delete();
        res.send('Cita eliminada con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosCita,
    addCita,
    getCita,
    updateCita,
    delCita, 
    getfiltroCita

}