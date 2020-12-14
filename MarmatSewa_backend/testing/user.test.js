const request=require('supertest')
const express = require('express')
const userRouter=require('../routes/userRouter')
require('dotenv').config()
require('./setup')


const app = express();
app.use(express.json)
app.use('/api/users', userRouter)

describe('Test for user route', ()=>{
    test('should be able to register a new user', () => {
        return request(app).post('/api/users/register')
        .send({
            fullname:'testingapi',
            email:'test@abc.com',
            passwor: 'test123',
            phoneNo:'1234567890',
            address:'St. Paul, teststreet',
            dob:'20/01/1988',
            gender:'male',
            role:'USER'
        })
    }).then((res)=>{
        console.log(res.body)
        expect(res.statusCode).toBe(201)
    })
    
})