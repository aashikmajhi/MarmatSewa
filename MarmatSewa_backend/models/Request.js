const mongoose = require('mongoose');

const requestSchema = new mongoose.Schema({
    user: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
        required: true
    },
    featureGarageOwner:{
        type: mongoose.Schema.Types.ObjectId, 
        ref: 'FeatureGarageOwner',
        required:true
    },
   
    status: {
        type: String,
        enum: ['REQUESTED', 'PENDING', 'APPROVED'],
        default: 'REQUESTED'
    },
    requestType: {
        type: String,
        enum: ['PICKUP AND DELIVERY','DROPPIN SERVICE','ON THE SPOT SERVICE']
    }
},{timestamps: true});

module.exports = mongoose.model('Request', requestSchema); 
