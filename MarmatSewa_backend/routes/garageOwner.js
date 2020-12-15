const express = require('express');
const validators = require('../utils/garageOwner');
const GarageOwner = require('../models/GarageOwner');
const User = require('../models/User');
const bcrypt = require('bcryptjs');

const router = express.Router();

router.route('/')
.get((req, res, next ) => {
    console.log("Get req to be sent ...")
})
.post((req, res, next) => {
    let { errors, isValid } = validators.GarageInput(req.body);
    if (!isValid) {
        return res.status(400).json({
            status: 'error',
            message: errors
        });
    }
    let { businessName, email, password, address, contactNo, registrationType,
    panDoc, registrationDoc, controlsAndBrakes, electricity, puncture, wheelAndControl } = req.body;
    User.findOne({ email })
    .then(user => {
        if (user) {
            let err = new Error('Email already exists!');
            err.status = 400;
            return next(err);
        }
        GarageOwner.findOne({ email })
        .then(garageOwner => {
            if (garageOwner) {
                let err = new Error('Email already exists!');
                err.status = 400;
                return next(err);
            }
            bcrypt.hash(password, 10)
            .then((hash) => {
                GarageOwner.create({ businessName, email, password: hash, address, contactNo, 
                    registrationType, panDoc,  registrationDoc, controlsAndBrakes, electricity, puncture, wheelAndControl })
                    .then(user => {
                        res.status(201).json({ "status": "Registration successful" });
                    })
            }).catch(next);
        }).catch(next);
    }).catch(next);
});

// router.route('/:book_id')
// .get((req, res, next) => {
// 	Book.findById(req.params.book_id)
// 	.populate('category')
// 	.populate('owner')
//     .then(book => {
//         res.status(200).json(book);
//     }).catch(next);
// })

// .put(auth.verifyUser, (req, res, next) => {
// 	Book.findByIdAndUpdate(req.params.book_id, {$set: req.body}, {new: true})
// 	.then(updatedBook => {
// 		res.status(200).send(updatedBook);
// 	}).catch(next);
// })
// .delete(auth.verifyUser, (req, res, next) => {
// 	Book.findByIdAndDelete(req.params.book_id) 
// 	.then(book => {
// 		res.status(200).send(book);
// 	}).catch(next);
// });	 

// router.route('/user/book')
// .get(auth.verifyUser, (req, res, next) => {
// 	Book.find({owner: req.user.profileId})
// 	.populate('category')
//     .then((books) => {
//         res.status(200).json(books);
//     }).catch(next);
// });

module.exports = router;

