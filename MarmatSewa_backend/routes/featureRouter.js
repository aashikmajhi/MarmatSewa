const express = require('express');
const validators = require('../utils/garageValidation');
const Feature = require('../models/Feature');
const auth = require('./authentication');

const router = express.Router();

router.route('/')
.get(auth.verifyUser, auth.verifyGarageOwner, (req, res, next ) => {
    Feature.findById(req.user.id)
    .then(feature => {
        res.status(201).json(feature);
    }).catch(next)

})
.post(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
    Feature.create({... req.body, garage: req.user.id})
    .then(feature => {
        res.status(201).json(feature);
    }).catch(next);
})
.put((req, res, next) => {

})
module.exports = router;