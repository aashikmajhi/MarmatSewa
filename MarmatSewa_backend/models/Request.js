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
		}
	},
	{ timestamps: true }
);

module.exports = mongoose.model('Request', Request);
