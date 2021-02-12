const express = require('express');

const Feature = require('../models/Feature');
const auth = require('../middlewares/authentication');
const FeatureGarageOwner = require('../models/FeatureGarageOwner');

const router = express.Router();

//compare added features (featureGarageOwnerRouter.js) and features and filter ...

router.route('/')
.get(auth.verifyUser, (req, res, next) => {
    FeatureGarageOwner.find({ garageOwner: { $in: req.user.id }})
    .then(featureGarage => {
        Feature.find()
        .then(feature => {
            for (let x = 0; x < featureGarage.length; x++) {
                for (let y = 0; y < feature.length; y++) {
                    if (JSON.stringify(featureGarage[x].feature) === JSON.stringify(feature[y]._id)) feature[y].remove();
                }
            }
            res.json(feature);
        }).catch(next);
    }).catch(next);
});


module.exports = router;
