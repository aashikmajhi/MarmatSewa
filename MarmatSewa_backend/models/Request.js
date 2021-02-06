const mongoose = require('mongoose');

const Request = new mongoose.Schema(
	{
		user: {
			type: mongoose.Schema.Types.ObjectId,
			ref: 'User',
			required: true
		},
		feature: {
			type: mongoose.Schema.Types.ObjectId,
			ref: 'Feature',
			required: true
		},
		garageOwner: {
			type: mongoose.Schema.Types.ObjectId,
			ref: 'Feature',
			required: true
		},
		status: {
			type: String,
			enum: [ 'PENDING', 'APPROVED', 'DONE' ],
			default: 'PENDING'
		},
		serviceTypes: {
			type: String,
			enum: [ 'DROP IN SERVICE', 'PICKUP AND DELIVERY', 'ON THE SPOT' ]
		}
	},
	{ timestamps: true }
);

module.exports = mongoose.model('Request', Request);
