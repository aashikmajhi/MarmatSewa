const express = require('express');
const GarageOwner = require('../models/GarageOwner');
// const Admin = require('../models/Admin');
const auth = require('../middlewares/authentication');

const router = express.Router();

router.route('/')
.get(auth.verifyUser, auth.verifyAdmin, (req, res, next ) => {
    GarageOwner.find({status: 'PENDING'})
    .then(garageOwner => {
        res.status(200).send(garageOwner);
    })
})

router.route('/:garageOwner_id')
.put(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    const status = req.body;
    GarageOwner.findByIdAndUpdate(req.params.garageOwner_id, { $set: status }, { new: true })
    .then(updatedGarageOwner => {
        res.status(201).send(updatedGarageOwner);
    }).catch(next);
});

module.exports = router;