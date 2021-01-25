const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const validators = require('../utils/userValidation');
const User = require('../models/User');
const GarageOwner = require('../models/GarageOwner');

const router = express.Router();

router.post('/register', (req, res, next) => {
	let { errors, isValid } = validators.RegisterInput(req.body);
	if (!isValid) {
		return res.status(400).json({
			status: 'error',
			message: errors
		});
	}

	// let { errors, isValid } = validators.RegisterInput(req.body);
	// if (!isValid) {
	//     return res.status(400).json({
	//         status: 'error',
	//         message: errors
	//     });
	// }

	// let { fullname, email, password, phoneNo, address, dob, gender, scannedLicense, isAdmin } = req.body;
	// User.findOne({ email })
	//     .then(user => {
	//         if (user) {
	//             let err = new Error('Email already exists!');
	//             err.status = 400;
	//             return next(err);
	//         }
	//         GarageOwner.findOne({ email })
	//         .then(garageOwner => {
	//             if (garageOwner) {
	//                 let err = new Error('Email already exists!');
	//                 err.status = 400;
	//                 return next(err);
	//             }
	//             bcrypt.hash(password, 10)
	//             .then((hash) => {
	//                 User.create({fullname, email, password: hash, phoneNo, address, dob, gender, scannedLicense, isAdmin })
	//                 .then(user => {
	//                     res.status(201).json({ "status": "Registration successful" });
	//                 }).catch(next);
	//             }).catch(next);
	//         }).catch(next);
	//     }).catch(next);

	let { fullname, email, password, phoneNo, address, dob, gender, scannedLicense, isAdmin } = req.body;
	User.findOne({ email })
		.then((user) => {
			if (user) {
				let err = new Error('Email already exists!');
				err.status = 400;
				return next(err);
			}
			GarageOwner.findOne({ email })
				.then((garageOwner) => {
					if (garageOwner) {
						let err = new Error('Email already exists!');
						err.status = 400;
						return next(err);
					}
					bcrypt
						.hash(password, 10)
						.then((hash) => {
							User.create({
								fullname,
								email,
								password: hash,
								phoneNo,
								address,
								dob,
								gender,
								scannedLicense,
								isAdmin
							})
								.then((user) => {
									res.status(201).json({ status: 'Registration successful' });
								})
								.catch(next);
						})
						.catch(next);
				})
				.catch(next);
		})
		.catch(next);
});

router.post('/login', (req, res, next) => {
	let { email, password } = req.body;
	let { errors, isValid } = validators.LoginInput(req.body);
	if (!isValid) {
		return res.status(400).json({
			status: 'error',
			message: errors
		});
	}

	User.findOne({ email })
		.then((user) => {
			//FOR GARAGE OWNER
			if (!user) {
				GarageOwner.findOne({ email })
					.then((garageOwner) => {
						if (!garageOwner) {
							let err = new Error('User does not exists!');
							err.status = 400;
							return next(err);
						} else {
							bcrypt
								.compare(password, garageOwner.password)
								.then((isMatch) => {
									if (!isMatch) {
										let err = new Error('Password does not match!');
										err.status = 400;
										return next(err);
									}
									let payload = {
										id: garageOwner.id,
										email: garageOwner.email,
										role: 'GARAGE_OWNER'
									};
									jwt.sign(payload, process.env.SECRET, (err, token) => {
										if (err) return next(err);
										res.json({
											status: 'Login successful',
											token: `Bearer ${token}`,
											role: payload.role,
											user_id: payload.id
										});
									});
								})
								.catch(next);
						}
					})
					.catch(next);
			} else {
				//FOR USER & ADMIN
				bcrypt
					.compare(password, user.password)
					.then((isMatch) => {
						if (!isMatch) {
							let err = new Error('Password does not match!');
							err.status = 400;
							return next(err);
						}

						let payload = {
							id: user._id,
							email: user.email
						};

						if (user.isAdmin) {
							payload.role = 'ADMIN';
						} else {
							payload.role = 'USER';
						}

						console.log(payload);

						User.findOne({ email })
							.then((user) => {
								//FOR GARAGE OWNER
								if (!user) {
									GarageOwner.findOne({ email })
										.then((garageOwner) => {
											if (!garageOwner) {
												let err = new Error('User does not exists!');
												err.status = 400;
												return next(err);
											} else {
												bcrypt
													.compare(password, garageOwner.password)
													.then((isMatch) => {
														if (!isMatch) {
															let err = new Error('Password does not match!');
															err.status = 400;
															return next(err);
														}
														let payload = {
															id: garageOwner.id,
															email: garageOwner.email,
															role: 'GARAGE_OWNER'
														};
														jwt.sign(payload, process.env.SECRET, (err, token) => {
															if (err) return next(err);
															res.json({
																status: 'Login successful',
																token: `Bearer ${token}`,
																role: payload.role,
																user_id: payload.id
															});
														});
													})
													.catch(next);
											}
										})
										.catch(next);
								} else {
									//FOR USER & ADMIN
									bcrypt
										.compare(password, user.password)
										.then((isMatch) => {
											if (!isMatch) {
												let err = new Error('Password does not match!');
												err.status = 400;
												return next(err);
											}

											let payload = {
												id: user._id,
												email: user.email
											};

											if (user.isAdmin) {
												payload.role = 'ADMIN';
											} else {
												payload.role = 'USER';
											}

											console.log(payload);

											jwt.sign(payload, process.env.SECRET, (err, token) => {
												if (err) return next(err);
												res.json({
													status: 'Login successful',
													token: `Bearer ${token}`
												});
											});
										})
										.catch(next);
								}
							})
							.catch(next);

						jwt.sign(payload, process.env.SECRET, (err, token) => {
							if (err) return next(err);
							res.json({
								status: 'Login successful',
								token: `Bearer ${token}`,
								role: payload.role
							});
						});
					})
					.catch(next);
			}
		})
		.catch(next);
});

module.exports = router;
