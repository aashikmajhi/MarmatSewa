const express = require('express')
const request = require('supertest')

const adminRouter = require('../routes/adminRouter')
const userRouter = require('../routes/userRouter')
require('dotenv').config()
require('./setup')

const app = express()
app.use(express.json())
app.use('/api/admin', adminRouter)
app.use('/ap/users', userRouter)


let adminToken;
let adminId;

describe('Test for admin routes', () => {

    test('should register an admin', () => {
        return request(app).post('/api/users/register')
            .send({
                fullname: 'thisisadmin',
                email: 'admin@abc.com',
                password: 'admin123',
                phoneNo: '1234566891',
                address: 'adminstreet',
                dob: '1980-01-08',
                gender: 'MALE',
                role: 'ADMIN',
                scannedLicense: 'license.png'
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(201)
                adminId = res.body._id
                return request(app).post('/api/users/login')
                    .send({
                        email: 'admin@abc.com',
                        password: 'admin123'
                    }).then((res) => {
                        console.log(res.body)
                        expect(res.statusCode).toBe(200)
                        adminToken = res.body.token
                    })
            })
    })

    test('Should get all posted questions', () => {
        return request(app).get('/api/users')
            // .set('authorization', token)
            .then((res) => {
                console.log(res.body);
                expect(res.statusCode).toBe(200);
            })
    })
    // beforeAll(() => {
    //     return request(app).post('/api/users/register')
    //         .send({
    //             fullname: 'thisisadmin',
    //             email: 'admin@abc.com',
    //             password: 'admin123',
    //             phoneNo: '1234566891',
    //             address: 'adminstreet',
    //             dob: '1980-01-08',
    //             gender: 'MALE',
    //             role: 'ADMIN',
    //             scannedLicense: 'license.png'
    //         }).then((res) => {
    //             console.log(res.body)
    //             expect(res.statusCode).toBe(201)
    //             adminId = res.body._id
    //             return request(app).post('/api/users/login')
    //                 .send({
    //                     email: 'admin@abc.com',
    //                     password: 'admin123'
    //                 }).then((res) => {
    //                     console.log(res.body)
    //                     expect(res.statusCode).toBe(200)
    //                     adminToken = res.body.token
    //                 })
    //         })
    // })




})

