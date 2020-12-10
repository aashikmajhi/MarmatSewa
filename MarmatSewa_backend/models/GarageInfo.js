const mongoose = require('mongoose');

const garageInfo = new mongoose.Schema({
    businessName: {
        type: String,
        maxlength: 255,
        required: true
    },
    address: {
        type: String,
        maxlength: 255,
        required: true,
    },
    contactNo: {
        type: String,
        maxlength:255,
        required: true
    },
    registrationType: {
        type: String,
        maxlength: 255,
        required: true
        // options to be added 
    },
    panDoc: {
        type: String,
        maxlength: 255,
        required: true
    },
    registrationDoc: {
        type: String,
        maxlength: 255,
        required: true
    },
    featuringServices: {
        type: String,
        maxlength: 255,
        required: true
    },
    user: {
		type: mongoose.Schema.Types.ObjectId,
		ref: 'User',
		required: true
    },
 
},{timestamps: true});

module.exports = mongoose.model('GarageInfo', garageInfo); 
