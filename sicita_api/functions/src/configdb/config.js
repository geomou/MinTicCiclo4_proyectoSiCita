const admin = require("firebase-admin");
const serviceAccount = require("./sicita_archivo_api.json");
admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: "https://sicita-8e3c0-default-rtdb.firebaseio.com",
});
const db = admin.firestore();
module.exports = db;