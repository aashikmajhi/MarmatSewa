const express = require('express');
const Feature_GarageOwner = require('../models/FeatureGarageOwner');
const auth = require('../middlewares/authentication');

const router = express.Router();

router
	.route('/')
	// GET Feature_GarageOwner from garageOwner_id
	.get(auth.verifyUser, (req, res, next) => {
		Feature_GarageOwner.find()
			.populate('feature')
			.then((Feature_GarageOwner) => {
				res.status(200).json(Feature_GarageOwner);
			})
			.catch(next);
	})
	.post(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
		Feature_GarageOwner.create({ ...req.body, garageOwner: req.user.id })
			.then((Feature_GarageOwner) => {
				res.status(201).json(Feature_GarageOwner);
			})
			.catch(next);
	});

// router.route('/:FeatureGarageOwner_id').delete(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
// 	Feature_GarageOwner.findByIdAndDelete(req.params.FeatureGarageOwner_id)
// 		.then((deletedFeature_GarageOwner) => {
// 			res.status(200).send(deletedFeature_GarageOwner);
// 		})
// 		.catch(next);
// });



//GET garageOwner Detail from feature_id
router.route('/:feature_id')
.get(auth.verifyUser, (req, res, next) => {
	Feature_GarageOwner.find({ feature: req.params.feature_id })
		.populate('garageOwner')
		.then((feature_garageOwner) => {
			res.status(200).json(feature_garageOwner);
		})
		.catch(next);
});
module.exports = router;
