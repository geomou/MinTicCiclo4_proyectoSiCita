const db = require("../configdb/config");
const Vehiculo = require("../models/vehiculo");

const getTodosVehiculos = async (req, res, next) => {
    try {
        const vehiculo = await db.collection('vehiculo');
        const datos = await vehiculo.get();

        const listadoVehiculos = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const vehiculo = new Vehiculo(
                    doc.id,
                    doc.data().idmarcamodelo,
                    doc.data().placa,
                    doc.data().año,
                    doc.data().caracteristicas, 
                    data.doc().idusuario  
                );
                listadoVehiculos.push(vehiculo)

            });
            res.send(listadoVehiculos);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getfiltroVehiculosUsuario = async (req, res, next) => {
    try {
        const id = req.params.id;
        const vehiculo = await db.collection('vehiculo').doc(id);
        const datos = await vehiculo.get();

        const listadoVehiculos = [];
        if (datos.empty) {
            res.status(404).send(
                'No existen registros'
            );
        } else {
            datos.forEach(doc => {
                const vehiculo = new Vehiculo(
                    doc.id,
                    doc.data().idmarcamodelo,
                    doc.data().placa,
                    doc.data().año,
                    doc.data().caracteristicas, 
                    data.doc().idusuario  
                );
                listadoVehiculos.push(vehiculo)

            });
            res.send(listadoVehiculos);
        }
    } catch (error) {
        res.status(404).send(error.message);
    }
}

const addVehiculo = async (req, res) => {
    try {
        const data = req.body;
        await db.collection('vehiculo').doc().set(data);
        res.send('Registro Actualizado');
    } catch (error) {
        res.status(404).send(error.message);
    }
}
const getVehiculo = async (req, res) => {
    try {
        const id = req.params.id;
        const vehiculo = await db.collection('vehiculo').doc(id);
        const data = await vehiculo.get();

        if (!data.exists) {
            res.status(404).send('Vehículo no existe');
        } else {
            res.send(data.data());
        }

    } catch (error) {
        res.status(404).send(error.message);
    }
}

const updateVehiculo = async (req, res) => {
    try {
        const id = req.params.id;
        const data = req.body;
        const vehiculo = await db.collection('vehiculo').doc(id);
        await vehiculo.update(data);
        res.send('Vehículoq Actualizado con éxito')


    } catch (error) {
        res.status(404).send(error.message);
    }
}

const delVehiculo = async (req, res) => {
    try {
        const id = req.params.id;
        await db.collection('vehiculo').doc(id).delete();
        res.send('Vehículo eliminado con éxito')
    } catch (error) {
        res.status(404).send(error.message);

    }
}
module.exports = {
    getTodosVehiculos,
    addVehiculo,
    getVehiculo,
    updateVehiculo,
    delVehiculo, 
    getfiltroVehiculosUsuario

}