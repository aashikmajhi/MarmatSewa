const express = require('express');
const User = require('../models/User');
const auth = require('../middlewares/authentication');
const bcrypt = require('bcryptjs');

const router = express.Router();

router.route('/')
.get(auth.verifyUser, (req, res, next ) => {
    User.findById(req.user.id)
    .then(user => {
        res.status(200).json(user);
    }).catch(next)
})

.put(auth.verifyUser,  (req, res, next) => {
    let {password, phoneNo} = req.body;
    User.findById(req.user.id)
    .then(user => { 
        bcrypt.hash(password, 10)
        .then((hash) => {
            user.password = hash;
            user.phoneNo = phoneNo;
           user.save()
            .then(user => {
                res.status(201).json(user);
            }).catch(next);
        })
    })
});

module.exports = router;
