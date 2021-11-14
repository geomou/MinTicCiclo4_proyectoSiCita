const db = require("../configdb/config");
const TipoCita = require("../models/tipocita");

const getTodosTiposCita = async (req, res, next) => {
    try {
        const tiposcita = await db.collection('tipocita');
        const datos = await tiposcita.get();

        const listadotiposcita = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const tipocita = new TipoCita(
                    doc.id,
                    doc.data().descripcion,
                    doc.data().tiempo,
                    
                );
                listadousuarios.push(tipocita)

            });
            res.send(listadotiposcita);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addTipoCita = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('tipocita').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getTipoCita = async (req, res) => {
    try {
        const id = req.params.id;
        const tipocita = await db.collection('tipocita').doc(id);
        const data = await tipocita.get();

        if (!data.exists) {
            res.status(404).send('Tipo de cita no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateTipoCita = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const tipocita = await db.collection('tipocita').doc(id);
        await tipocita.update(data);
        res.send('Tipo de Cita actualizada con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delTipoCita = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('tipocita').doc(id).delete();
        res.send('Tipo de Cita eliminada con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosTiposCita,
    addTipoCita,
    getTipoCita,
    updateTipoCita,
    delTipoCita

}