const express = require('express')
const request = require('supertest')

const garageOwner = require('../routes/garageOwnerRouter')
require('dotenv').config()
require('./setup')


const app = express();
app.use(express.json());
app.use('/api/garageOwnerRouter', garageOwner)

describe('Test for user route', () => {
    test('should be able to register a new user', () => {
        return request(app).post('/api/garageOwnerRouter')
            .send({
                ownerName: 'garageowner1',
                email: 'test@abcd.com',
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
                expect(res.statusCode).toBe(201)
            })

    })

    test('should not register user with same email', () => {
        return request(app).post('/api/garageOwnerRouter')
            .send({
                ownerName: 'garageowner1',
                email: 'test@abcd.com',
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
        return request(app).post('/api/garageOwnerRouter')
            .send({
                ownerName: 'garageowner1',
                email: 'test@abcd.com',
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

    test('should be not able to register a new user', () => {
        return request(app).post('/api/garageOwnerRouter')
            .send({
                ownerName: 'garageowner1',
                email: 'test@abcd.com',
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
})