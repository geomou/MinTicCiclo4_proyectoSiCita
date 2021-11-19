const db = require("../configdb/config");
const CanalCita = require("../models/canalcita");

const getTodosCanalCita = async (req, res, next) => {
    try {
        const canalcita = await db.collection('canalcita');
        const datos = await canalcita.get();

        const listadocanalcita = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros' 
            );
        } else {
            datos.forEach(doc => {
                const canalcita = new CanalCita(
                    doc.id,
                    doc.data().descripcion,
                  
                    
                );
                listadousuarios.push(canalcita)

            });
            res.send(listadocanalcita);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addCanalCita = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('canalcita').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getCanalCita = async (req, res) => {
    try {
        const id = req.params.id;
        const canalcita = await db.collection('canalcita').doc(id);
        const data = await canalcita.get();

        if (!data.exists) {
            res.status(404).send('Tipo de canal de  cita no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateCanalCita = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const canalcita = await db.collection('canalcita').doc(id);
        await canalcita.update(data);
        res.send('Tipo de Canal de  Cita actualizada con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delCanalCita = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('canalcita').doc(id).delete();
        res.send('Tipo de Canal de Cita eliminada con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosCanalCita,
    addCanalCita,
    getCanalCita,
    updateCanalCita,
    delCanalCita

}