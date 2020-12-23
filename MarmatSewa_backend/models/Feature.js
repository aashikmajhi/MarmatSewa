const mongoose = require('mongoose');

const featureSchema = new mongoose.Schema({
    feature: {
        type: String,
        maxlength: 255,
        required: true
    },
    img: {
        type: String,
        maxlength: 255
    },
    garage: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'GarageOwner',
        required: true
    }
}, { timestamps: true });

module.exports = mongoose.model('Feature', featureSchema); 
