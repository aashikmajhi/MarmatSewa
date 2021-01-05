const express = require('express');
const Feature_GarageOwner = require('../models/FeatureGarageOwner');
const auth = require('../middlewares/authentication');

const router = express.Router();

router.route('/')
.get(auth.verifyUser, (req, res, next ) => {
    Feature_GarageOwner.findById(req.user.id)
    .then(Feature_GarageOwner => {
        res.status(201).json(Feature_GarageOwner);
    }).catch(next)
})

.post(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    Feature_GarageOwner.create({... req.body, garage: req.user.id})
    .then(Feature_GarageOwner => {
        res.status(201).json(Feature_GarageOwner);
    }).catch(next);
});

router.route('/:FeatureGarageOwner_id')
.delete(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    Feature_GarageOwner.findByIdAndDelete(req.params.FeatureGarageOwner_id)
    .then(deletedFeature_GarageOwner => {
        res.status(200).send(deletedFeature_GarageOwner);
    }).catch(next);
});

module.exports = router;