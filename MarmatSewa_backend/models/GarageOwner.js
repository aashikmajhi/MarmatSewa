const mongoose = require('mongoose');

const garageInfo = new mongoose.Schema({
    businessName: {
        type: String,
        maxlength: 255,
        required: true
    },
    email: {
        type: String,
        maxlength: 255,
        required: true
    },
    password: {
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
    controrlsAndBrakes: {
        type: Boolean,
        required: true
    },
    electricity: {
        type: Boolean,
        required: true
    },
    puncture: {
        type: Boolean,
        required: true
    },
    wheelAndControl: {
        type: Boolean,
        required: true
    },
    // isApproved: {
    //     type: Boolean,
    //     default: false
    // }
  
},{timestamps: true});

module.exports = mongoose.model('GarageInfo', garageInfo); 
