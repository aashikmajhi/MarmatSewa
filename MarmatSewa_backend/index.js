const express = require('express');
const mongoose = require('mongoose');

require('dotenv').config(); 

const userRouter = require('./routes/userRouter');

const app = express();

mongoose.connect(process.env.DBUri,{
    useNewUrlParser: true,
    useUnifiedTopology: true,
    useFindAndModify: true
})
.then(()=> console.log('----------------- Database server connected --------------------'))
.catch((err) => console.log(err));

app.use(express.json());
app.use(express.urlencoded({extended: false}));

app.get('/', (req, res) => {
    res.send('Welcome To My App, Stranger!!!');
});

app.use('/api/users', userRouter);

app.listen(process.env.Port,  () => {
    console.log(`Server is running at localhost:${process.env.Port}`);
});