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
});

router.route('/:feature_id')
.put(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
    const feature = { name, img } = req.body;
    Feature.findByIdAndUpdate(req.params.feature_id, { $set: feature }, {new: true})
    .then(updatedFeature => {
        res.status(200).send(updatedFeature);
    }).catch(next);
})
.delete(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
    Feature.findByIdAndDelete(req.params.feature_id)
    .then(deletedFeature => {
        res.status(200).send(deletedFeature);
    }).catch(next);
})
module.exports = router;