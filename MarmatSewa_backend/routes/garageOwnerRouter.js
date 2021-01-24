const express = require('express');
const validators = require('../utils/garageValidation');
const GarageOwner = require('../models/GarageOwner');
const User = require('../models/User');
const bcrypt = require('bcryptjs');
const auth = require('../middlewares/authentication');

const router = express.Router();

router.route('/')
.get((req, res, next ) => {
    console.log("Get req to be sent ...")

    GarageOwner.find()
    .then(garageOwner => {
        res.status(200).json(garageOwner);
    })

})
.post((req, res, next) => {
    let { errors, isValid } = validators.GarageInput(req.body);
    if (!isValid) {
        return res.status(400).json({
            status: 'error',
            message: errors
        });
    }
    let { businessName, ownerName, email, password, address, contactNo, registrationType,

    panDoc, registrationDoc, controlsAndBrakes, electricity, puncture, wheelAndControl, latitude, longitude } = req.body;

//     panNo, registrationDoc, latitude, longitude } = req.body;


    panNo, registrationDoc, latitude, longitude } = req.body;

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
                GarageOwner.create({ businessName, ownerName,  email, password: hash, address, contactNo, 

                    registrationType, panDoc,  registrationDoc, controlsAndBrakes, electricity, puncture, wheelAndControl, latitude, longitude })
                    // registrationType, panNo,  registrationDoc, latitude, longitude })
                    
                    registrationType, panNo,  registrationDoc, latitude, longitude })

                    .then(user => {
                        res.status(201).json({ "status": "Registration successful" });
                    })
            }).catch(next);
        }).catch(next);
    }).catch(next);
});

router.route('/:garage_id')
.get(auth.verifyUser, (req, res, next) => {
    GarageOwner.findById(req.params.garage_id)
    .then(garage => {
        res.status(200).json(garage);
    })
})

//reviews
router.route('/:garage_id/reviews')
.get(auth.verifyUser, (req, res, next) => {
    GarageOwner.findById(req.params.garage_id)
    .then(garage => {
        res.status(200).json(garage.reviews);
    })
})

.post(auth.verifyUser, (req, res, next) => {
    const rv = { review, rating } = req.body;
    rv.user = req.user.id;
	GarageOwner.findById(req.params.garage_id)
    .then(garage => {
       garage.reviews.push(rv);
       garage.save()
       .then(newReview => res.status(201).json(newReview)).catch(next);
    }).catch(next);


// })
});

});


router.route('/:garage_id/reviews/:review_id')
.get(auth.verifyUser, (req, res, next) => {
    GarageOwner.findById(req.params.garage_id)
    .then(garage => {
        res.status(200)
        .json(garage.reviews.id(req.params.review_id));
    }).catch(next);
})
.put(auth.verifyUser, (req, res, next) => {
    GarageOwner.findById(req.params.garage_id)
    .then(garage => {
        let oldReview = garage.reviews.id(req.params.review_id);
        oldReview.review = req.body.review;
        oldReview.rating = req.body.rating;
        garage.save()
        .then(updatedGarage => {
            res.status(201).json(updatedGarage.reviews.id(req.params.review_id));
        }).catch(next);
    })
})
.delete(auth.verifyUser, (req, res, next) => {
    GarageOwner.findById(req.params.garage_id)
    .then((garage) => {
        garage.reviews = garage.reviews.filter((review) => {
            return review.id !== req.params.review_id;
        });
        garage.save()
            .then((garage) => {
                res.json(garage.reviews);
            }).catch(next);
    }).catch(next);
})
module.exports = router;


