const mongoose = require('mongoose');

const Request = new mongoose.Schema({
    user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
        required: true
    },
    feature: {
        type: mongoose.Schema.Types.ObjectId, 
        ref: 'Feature',
        required:true
    },
    garageOwner: {
        type: mongoose.Schema.Types.ObjectId, 
        ref: 'Feature',
        required:true
    },
    status: {
        type: String,
        enum: ['REQUESTED', 'PENDING', 'APPROVED'],
        default: 'REQUESTED'
    },
    // requestType: {
    //     type: String,
    //     //what will be the options ... 
    // }
},{timestamps: true});

module.exports = mongoose.model('GarageOwner', garageOwnerSchema); 
