const mongoose = require('mongoose');

const featureGarageOwner = new mongoose.Schema({
    feature: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Feature', 
        required: true
    },
    garageOwner: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'GarageOwner',
        required: true
    }
}, { timestamps: true });

module.exports = mongoose.model('FeatureGarageOwner', featureGarageOwner); 
