const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
	fullname: {
        type: String,
        maxlength: 255,
        required: true,
    },
    email: {
        type: String,
        maxlength: 255,
        unique: true,
        required: true
    },
    password: {
        type: String,
        required: true
    },
    phoneNo: {
        type: String,
        maxlength: 255,
        required: true
    },
    address: {
        type: String,
		maxlength: 255,
		required: true
    },
    dob: {
        type: Date,
        required: true
    },
	gender: {
        type: String,
		enum: ['MALE', 'FEMALE', 'OTHERS'],
		required: true
	},
    scannedLicense: {
        type: String,
		maxlength: 25,
		required: true
    },
    isAdmin: {
        type: Boolean,
        default: false
    }
},
{timestamps: true});

module.exports = mongoose.model('User', userSchema); 