const express = require('express');
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
.post(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    Feature.create({... req.body, admin: req.user.id})
    .then(feature => {
        res.status(201).json(feature);
    }).catch(next);
});

router.route('/:feature_id')
.put(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    const feat = req.body;
    console.log(feat)
    Feature.findByIdAndUpdate(req.params.feature_id, { $set: feat }, {new: true})
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