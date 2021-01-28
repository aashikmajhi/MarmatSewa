const express = require('express');

const validators = require('../utils/featureValidation');

const Feature = require('../models/Feature');
const auth = require('../middlewares/authentication');

const router = express.Router();

router
	.route('/')
	.get(auth.verifyUser, (req, res, next) => {
		Feature.find()
			.then((feature) => {
				res.status(200).json(feature);
			})
			.catch(next);
	})
	// .post(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {
	// 	let { errors, isValid } = validators.FeatureInput(req.body);
	// 	if (!isValid) {
	// 		return res.status(400).json({
	// 			status: 'error',
	// 			message: errors
	// 		});
	// 	}
	// 	Feature.create({ ...req.body, garage: req.user.id });

	// 	// .post(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    //     //     Feature.create({... req.body, admin: req.user.id})
    // })

.post(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    Feature.create({... req.body, admin: req.user.id})

    .then(feature => {
        res.status(201).json(feature);
    }).catch(next);
});

// router.route('/:feature_id')

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
    .then(res.status(201).json(feature)).catch(next);
})
.post(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    Feature.create({... req.body, admin: req.user.id})
    .then(feature => {
        res.status(201).json(feature);
    }).catch(next);
});
=======
// .put(auth.verifyUser, auth.verifyGarageOwner, (req, res, next) => {

//     let { errors, isValid } = validators.FeatureInput(req.body);
//     if (!isValid) {
//         return res.status(400).json({
//             status: 'error',
//             message: errors
//         });
//     }
//     const feature = { name, img } = req.body;
//     Feature.findByIdAndUpdate(req.params.feature_id, { $set: feature }, {new: true})
//     .then(res.status(201).json(feature)).catch(next);
// })


// .post(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
//     Feature.create({... req.body, admin: req.user.id})
//     .then(feature => {
//         res.status(201).json(feature);
//     }).catch(next);
// });
>>>>>>> dc0d3206be6fe3133a31be21964079b896e684eb

router.route('/:feature_id')
.put(auth.verifyUser, auth.verifyAdmin, (req, res, next) => {
    const feat = req.body;
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
});
module.exports = router;
