const express = require('express');
const Request = require('../models/Request');
const auth = require('../middlewares/authentication');

const router = express.Router();

//for user and admin to view available features ...
router
	.route('/')
	.get(auth.verifyUser, (req, res, next) => {
		Request.find()
			.populate('featureGarageOwner')
			.then((request) => {
				res.status(200).json(request);
			})
			.catch(next);
	})
	.post(auth.verifyUser, (req, res, next) => {
		Request.create({ ...req.body, user: req.user.id })
			.then((Feature_GarageOwner) => {
				res.status(201).json(Feature_GarageOwner);
			})
			.catch(next);
	});

router
	.route('/garages')
	//for garageOwner to get requests sent by user to specific garage...
	//GET requests with status PENDING only ...
	.get(auth.verifyUser, (req, res, next) => {
		Request.find({ garageOwner: { $in: req.user.id }, status: 'PENDING' })
			.populate('user')
			.populate('feature')
			.then((request) => res.json(request).catch(next));
	});

router.route('/approvelist').get(auth.verifyUser, (req, res, next) => {
	Request.find({ status: 'APPROVED' })
		.populate('user')
		.populate('garageOwner')
		.populate('feature')
		.then((reply) => res.json(reply))
		.catch(next);

});

router.route('/donelist').get(auth.verifyUser, (req, res, next) => {
	Request.find({ status: 'DONE' })
		.populate('garageOwner')
		.populate('feature')
		.then((reply) => res.json(reply))
		.catch(next);
});

router
	.route('/garages/:request_id')
	//for garageOwner log to display APPROVED requests ...
	//for get, just put random string as parameter ...
	.get(auth.verifyUser, (req, res, next) => {
		Request.find({ garageOwner: { $in: req.user.id }, status: 'APPROVED' })
			.populate('user')
			.populate('feature')
			.then((request) => res.json(request));
	})
	//to change status of requests by garageOwner after accepting the request ...
	.put(auth.verifyUser, (req, res, next) => {
		const request = req.body;
		Request.findByIdAndUpdate(req.params.request_id, { $set: request }, { new: true })
			.then((request) => {
				res.status(201).send(request);
			})
			.catch(next);
	});


module.exports = router;
