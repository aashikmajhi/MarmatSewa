const request = require('supertest')
const express = require('express')
const userRouter = require('../routes/userRouter')
require('dotenv').config()

const app = express();
app.use(express.json)
app.use('/users', userRouter)

require('./setup')

describe('Test for user route', () => {
    test('should be able to register a new user', () => {
        return request(app).post('users/register')
            .send({
                fullname: 'testingapi',
                email: 'test@abc.com',
                passwor: 'test123',
                phoneNo: '1234567890',
                address: 'teststreet',
                dob: '1988-10-01',
                gender: 'MALE',
                scannedLicense: "license.jpg"
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(201)
            })
    })
})