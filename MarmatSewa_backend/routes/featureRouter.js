const express = require('express');
<<<<<<< HEAD
const validators = require('../utils/featureValidation');
=======
>>>>>>> Development
const Feature = require('../models/Feature');
const auth = require('../middlewares/authentication');

const router = express.Router();

router.route('/')
.get(auth.verifyUser, (req, res, next ) => {
    Feature.find()
    .then(feature => {
        res.status(200).json(feature);
    }).catch(next)

})
<<<<<<< HEAD
.post(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
    let { errors, isValid } = validators.FeatureInput(req.body);
    if (!isValid) {
        return res.status(400).json({
            status: 'error',
            message: errors
        });
    }
    Feature.create({... req.body, garage: req.user.id})
=======
.post(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    Feature.create({... req.body, admin: req.user.id})
>>>>>>> Development
    .then(feature => {
        res.status(201).json(feature);
    }).catch(next);
});

router.route('/:feature_id')
<<<<<<< HEAD
.put(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
    let { errors, isValid } = validators.FeatureInput(req.body);
    if (!isValid) {
        return res.status(400).json({
            status: 'error',
            message: errors
        });
    }
    const feature = { name, img } = req.body;
    Feature.findByIdAndUpdate(req.params.feature_id, { $set: feature }, {new: true})
=======
.put(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    const feat = req.body;
    console.log(feat)
    Feature.findByIdAndUpdate(req.params.feature_id, { $set: feat }, {new: true})
>>>>>>> Development
    .then(updatedFeature => {
        res.status(201).send(updatedFeature);
    }).catch(next);
})
.delete(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    Feature.findByIdAndDelete(req.params.feature_id)
    .then(deletedFeature => {
        res.status(200).send(deletedFeature);
    }).catch(next);
})
module.exports = router;