const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const User = require('../models/User');

const router = express.Router();

router.post('/register', (req, res, next) => {
    let { fullname, email, password, phone_no, address, dob, gender, scanned_license} = req.body;
    User.findOne({ email })
        .then(user => {
            if (user) {
                let err = new Error('Email already exists!');
                err.status = 400;
                return next(err);
            }
            bcrypt.hash(password, 10)
                .then((hash) => {
                    User.create({fullname, email, password: hash, phone_no, address, dob, gender, scanned_license })
                        .then(user => {
                            res.status(201).json({ "status": "Registration successful" });
                        })
                })
        }).catch(next);
});

router.post('/login', (req, res, next) => {
    let { email, password } = req.body;
    User.findOne({ email })
        .then((user) => {
            if (!user) {
                let err = new Error('User does not exists!');
                err.status = 400;
                return next(err);
            }
            bcrypt.compare(password, user.password)
                .then(isMatch => {
                    if (!isMatch) {
                        let err = new Error('Password does not match!');
                        err.status = 400;
                        return next(err);
                    }
                    let payload = {
                        id: user.id,
                       email: user.email    
                    }
                    jwt.sign(payload, process.env.SECRET, (err, token) => {
                        if (err) return next(err);
                        res.json({
                            status: "Login successful",
                            token: `Bearer ${token}`
                        });
                    });
                })
        }).catch(next);
});

module.exports = router;