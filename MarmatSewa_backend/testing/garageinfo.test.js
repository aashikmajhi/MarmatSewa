const express = require('express')
const request = require('supertest')

const garageOwner = require('../routes/garageOwner')
require('dotenv').config()
require('./setup')


const app = express();
app.use(express.json());
app.use('/api/garageOwner', garageOwner)

describe('Test for user route', () => {
    test('should be able to register a new user', () => {
        return request(app).post('/api/garageOwner/')
            .send({
                // fullname: 'testingapi',
                email: 'test@abc.com',
                password: 'test123',
                // phoneNo: '1234567890',
                // address: 'teststreet',
                // dob: '1988-01-20',
                // gender: 'MALE',
                // role: 'USER',
                // scannedLicense: 'license.png',
                businessName: 'testGarage',
                address: 'garageStreet',
                contactNo: '9807654321',
                registrationType: 'PAN',
                panDoc: 'pandoc.png',
                registrationDoc: 'regd.png',
                controlsAndBrakes: true,
                electricity: true,
                puncture: true,
                wheelAndControl: true
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(201)
            })

    })

    test('should not register user with same email', () => {
        return request(app).post('/api/garageOwner')
            .send({
                email: 'test@abc.com',
                password: 'test123',
                businessName: 'testGarage',
                address: 'garageStreet',
                contactNo: '9807654321',
                registrationType: 'PAN',
                panDoc: 'pandoc.png',
                registrationDoc: 'regd.png',
                controlsAndBrakes: true,
                electricity: true,
                puncture: true,
                wheelAndControl: true
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(400)
            })
    })

    test('should not register user without fulfilling required fields', () => {
        return request(app).post('/api/garageOwner/')
            .send({
                email: 'test@abc.com',
                password: 'test123',
                businessName: '',
                address: 'garageStreet',
                contactNo: '',
                registrationType: 'PAN',
                panDoc: '.png',
                registrationDoc: 'regd.png',
                controlsAndBrakes: true,
                electricity: true,
                puncture: true,
                wheelAndControl: true
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(400)
            })
    })
})