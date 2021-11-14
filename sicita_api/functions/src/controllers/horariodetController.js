const db = require("../configdb/config");
const HorarioDetalle = require("../models/horariodet");

const getTodosHorarioDetalle = async (req, res, next) => {
    try {
        const horariodet = await db.collection('horariodet');
        const datos = await horariodet.get();

        const listadohorariodet = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const horariodet = new HorarioDetalle(
                    doc.id,
                    doc.data().idhorarioenc, 
                    doc.data().diasemana, 
                    doc.data().horainicial, 
                    doc.data().horafinal, 
                    dopc.data().disponible
                );
                listadohorariodet.push(horariodet)

            });
            res.send(listadohorariodet);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addHorarioDetalle = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('horariodet').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getHorarioDetalle = async (req, res) => {
    try {
        const id = req.params.id;
        const horariodet = await db.collection('horariodet').doc(id);
        const data = await horariodet.get();

        if (!data.exists) {
            res.status(404).send('Horario Detalle no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateHorarioDetalle = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const horariodet = await db.collection('horariodet').doc(id);
        await horariodet.update(data);
        res.send('Horario Detalle actualizada con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delHorarioDetalle = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('horariodet').doc(id).delete();
        res.send('Horario Det eliminado con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosHorarioDetalle,
    addHorarioDetalle,
    getHorarioDetalle,
    updateHorarioDetalle,
    delHorarioDetalle
}