const express = require('express');
const Request = require('../models/Request');
const auth = require('../middlewares/authentication');

const router = express.Router();

router.route('/')
.get(auth.verifyUser, (req, res, next ) => {
    Request.find()
    .populate('featureGarageOwner')
    .then(request => {
        res.status(200).json(request);
    }).catch(next)
})

.post(auth.verifyUser, (req, res, next) => {
    Request.create({... req.body, user: req.user.id})
    .then(Feature_GarageOwner => {
        res.status(201).json(Feature_GarageOwner);
    }).catch(next);
});

router.route('/:request_id')
.put(auth.verifyUser, (req, res, next) => {
    const request = req.body;
    Request.findByIdAndUpdate(req.params.request_id, { $set: request }, {new: true} )
    .then(request => {
        res.status(201).send(request);
    }).catch(next);
})

module.exports = router;