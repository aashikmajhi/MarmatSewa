const express = require('express');
const jwt = require('jsonwebtoken');
const GarageInfo = require('../models/GarageInfo');
const auth = require('../routes/authentication');

const router = express.Router();

router.route('/')
.get((req, res, next ) => {
    console.log("Get req to be sent ...")
})
.post(auth.verifyUser,(req, res, next) => {
	GarageInfo.create({... req.body, user: req.user.id})
    .then((garage) => {
        res.status(201).json(garage);
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

