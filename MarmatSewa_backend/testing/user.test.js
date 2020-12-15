const express = require('express')
const request = require('supertest')

const userRouter = require('../routes/userRouter')
require('dotenv').config()
require('./setup')


const app = express();
app.use(express.json());
app.use('/api/users', userRouter)

describe('Test for user route', () => {
    test('should be able to register a new user', () => {
        return request(app).post('/api/users/register')
            .send({
                fullname: 'testingapi',
                email: 'test@abc.com',
                password: 'test123',
                phoneNo: '1234567890',
                address: 'teststreet',
                dob: '1988-01-20',
                gender: 'MALE',
                role: 'USER',
                scannedLicense: 'license.png'
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(201)
            })

    })

    test('should not register user with same email', () => {
        return request(app).post('/api/users/register')
            .send({
                fullname: 'testingapi1',
                email: 'test@abc.com',
                password: 'test1234',
                phoneNo: '1234567891',
                address: 'teststreet1',
                dob: '1988-02-20',
                gender: 'FEMALE',
                role: 'USER',
                scannedLicense: 'license.png'
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(400)
            })
    })

    test('should not register user with invalid email format', () => {
        return request(app).post('/api/users/register')
            .send({
                fullname: 'testingapi2',
                email: 'testabc.com',
                password: 'test12345',
                phoneNo: '1234567891',
                address: 'teststreet1',
                dob: '1988-02-20',
                gender: 'FEMALE',
                role: 'USER',
                scannedLicense: 'license.png'
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(400)
            })
    })

    test('should not register user with short password', () => {
        return request(app).post('/api/users/register')
            .send({
                fullname: 'testingapi1',
                email: 'test@abc.com',
                password: 'Test1',
                phoneNo: '1234567891',
                address: 'teststreet1',
                dob: '1988-02-20',
                gender: 'FEMALE',
                role: 'USER',
                scannedLicense: 'license.png'
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(400)
            })
    })

    test('should be able to login', () => {
        return request(app).post('/api/users/login')
        .send({
        email: 'test@abc.com',
        password: 'test123',
    }).then((res) => {
        console.log(res.body)
        expect(res.statusCode).toBe(200)
        })
    })

    test('should be not be able to login with wrong password', () => {
        return request(app).post('/api/users/login')
            .send({
                email: 'test@abc.com',
                password: 'test121',
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(400)
                // expect(res.body.status).toBe('error')
            })
    })

    test('should not be able to login with wrong username', () => {
        return request(app).post('/api/users/login')
            .send({
                email: 'test1@abc.com',
                password: 'test123',
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(400)
                // expect(res.body.status).toBe('error')
            })
    })


})