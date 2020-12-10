const express = require('express');
const mongoose = require('mongoose');

require('dotenv').config();

const userRouter = require('./routes/userRouter');
const garageInfoRouter = require('./routes/garageInfoRouter');

const app = express();

<<<<<<< HEAD
mongoose.connect(process.env.DbURI,{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: true
})
.then(()=> console.log('----------------- Database server connected --------------------'))
.catch((err) => console.log(err));
=======
mongoose
	.connect(process.env.DbURI, {
		useNewUrlParser: true,
		useUnifiedTopology: true,
		useFindAndModify: true
	})
	.then(() => console.log('----------------- Database server connected --------------------'))
	.catch((err) => console.log(err));
>>>>>>> 17d3a3190610be6b5f3e55b3e63f0f01836d0156

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.get('/', (req, res) => {
	res.send('Welcome To My App, Stranger!!!');
});

app.use('/api/users', userRouter);
app.use('/api/garage-infos', garageInfoRouter);

app.listen(process.env.Port, () => {
	console.log(`Server is running at localhost:${process.env.Port}`);
});
