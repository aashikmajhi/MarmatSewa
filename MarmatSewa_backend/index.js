const express = require('express');
const mongoose = require('mongoose');
const path = require('path');
const cors = require('cors');

require('dotenv').config();

const userRouter = require('./routes/userRouter');
const garageOwnerRouter = require('./routes/garageOwnerRouter');
const featureRouter = require('./routes/featureRouter');
const adminRouter = require('./routes/adminRouter');
const requestRouter = require('./routes/requestRouter');
const featureFilteredRouter = require('./routes/featureFilteredRouter');
const profileRouter = require('./routes/userProfileRouter');

const uploadRouter = require('./routes/uploadRouter');

const featureGarageOwnerRouter = require('./routes/featureGarageOwnerRouter');
const { profile } = require('console');

const app = express();
app.use(cors('*'));

mongoose
	.connect(process.env.DbURI, {
		useNewUrlParser: true,
		useUnifiedTopology: true,
		useFindAndModify: true
	})
	.then(() => console.log('----------------- Database server connected --------------------'))
	.catch((err) => console.log(err));

app.use(express.json()); //json
app.use(express.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
	res.send('Welcome To My App, Stranger!!!');
});

app.use('/api/users', userRouter);
app.use('/api/garageOwner', garageOwnerRouter);
app.use('/api/features', featureRouter);
app.use('/api/requests', requestRouter);
app.use('/api/profiles', profileRouter);
app.use('/api/garagefeatures', featureGarageOwnerRouter);
app.use('/api/filteredFeatures', featureFilteredRouter);

app.use('/api/upload', uploadRouter);

app.use('/api/admin', adminRouter);

app.listen(process.env.Port, () => {
	console.log(`Server is running at localhost:${process.env.Port}`);
});
