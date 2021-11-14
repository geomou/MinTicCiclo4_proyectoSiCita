const db = require("../configdb/config");
const horarioenca = require("../models/horarioenca");

const getTodosHorarioEnca = async (req, res, next) => {
    try {
        const horarioenca = await db.collection('horarioenca');
        const datos = await horarioenca.get();

        const listadohorarioenca = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const horarioenca = new HorarioEncabezado(
                    doc.id,
                    doc.data().idemp, 
                    doc.data().idsede, 
                    doc.data().nombre
                );
                listadohorarioenca.push(horarioenca)

            });
            res.send(listadohorarioenca);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addHorarioEnca = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('horarioenca').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getHorarioEnca = async (req, res) => {
    try {
        const id = req.params.id;
        const horarioenca = await db.collection('horarioenca').doc(id);
        const data = await horarioenca.get();

        if (!data.exists) {
            res.status(404).send('Horario no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateHorarioEnca = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const horarioenca = await db.collection('horarioenca').doc(id);
        await horarioenca.update(data);
        res.send('Horario  actualizada con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delHorarioEnca = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('horarioenca').doc(id).delete();
        res.send('Horario eliminado con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosHorarioEnca,
    addHorarioEnca,
    getHorarioEnca,
    updateHorarioEnca,
    delHorarioEnca
}