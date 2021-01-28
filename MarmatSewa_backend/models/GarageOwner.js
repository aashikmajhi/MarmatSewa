const mongoose = require('mongoose');

<<<<<<< Updated upstream
const reviewSchema = new mongoose.Schema(
	{
		review: {
			type: String,
			maxlength: 255,
			required: true
		},
		rating: {
			type: Number,
			min: 1,
			max: 5,
			required: true
		},
		user: {
			type: mongoose.Schema.Types.ObjectId,
			ref: 'User',
			required: true
		}
	},
	{ timestamps: true }
);

const garageOwnerSchema = new mongoose.Schema(
	{
		businessName: {
			type: String,
			maxlength: 255,
			required: true
		},
		ownerName: {
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
			required: true
		},
		contactNo: {
			type: String,
			maxlength: 255,
			required: true
		},
		registrationType: {
			type: String,
			maxlength: 255,
			required: true
		},
		panNo: {
			type: String,
			maxlength: 255,
			required: true
		},
		registrationDoc: {
			type: String,
			maxlength: 255,
			required: true
		},
		status: {
			type: String,
			enum: [ 'PENDING', 'APPROVED' ],
			default: 'PENDING'
		},
		latitude: {
			type: mongoose.Types.Decimal128
		},
		longitude: {
			type: mongoose.Types.Decimal128
		},
		vehicleType: {
			type: String,
			enum: [ 'TWO_WHEEL', 'FOUR_WHEEL', 'BOTH' ]
		},
		reviews: [ reviewSchema ]
	},
	{ timestamps: true }
);

module.exports = mongoose.model('GarageOwner', garageOwnerSchema);
=======
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
>>>>>>> Stashed changes
