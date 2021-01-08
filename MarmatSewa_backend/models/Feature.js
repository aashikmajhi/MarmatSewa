const mongoose = require('mongoose');

const featureSchema = new mongoose.Schema({
    feature: {
        type: String,
        maxlength: 255,
        required: true
    },
    admin: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'User',
        required: true
    }
}, { timestamps: true });

module.exports = mongoose.model('Feature', featureSchema); 
