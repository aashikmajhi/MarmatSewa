const express = require('express')
const request = require('supertest')

const featureRouter = require('../routes/featureRouter')
const userRouter = require('../routes/userRouter')
const garageOwnerRouter = require('../routes/garageOwnerRouter')

const auth = require('../middlewares/authentication')

require('dotenv').config()
require('./setup')

const app = express()
app.use(express.json())
app.use('/api/features', featureRouter)
app.use('/api/users', userRouter)
app.use('/api/garageOwner', garageOwnerRouter)

let garage_owner_Token;
let garage_owner_Id;


describe('Test for feature router', () => {
    beforeAll(() => {
        return request(app).post('/api/garageOwner')
            .send({
                ownerName: "Rakesh Gyawali",
                businessName: "KTM Garage Store",
                email: "garage_owner@gmail.com",
                password: "Password",
                address: "Bharatpur-11",
                registrationType: "Some Type",
                contactNo: "98765432",
                panNo: "pan.jpeg",
                registrationDoc: "reg.jpeg",
                featuringServices: "Puncture Repair"
            }).then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(201)
                garage_owner_Id = res.body._id
                return request(app).post('/api/users/login')
                    .send({
                        email: "garage_owner@gmail.com",
                        password: "Password"
                    }).then((res) => {
                        console.log(res.body)
                        // console.log(res)
                        expect(res.statusCode).toBe(200)
                        garage_owner_Token = res.body.token
                    })
            })
    })

    let featureId;
    test('should be able to add features', () => {
        return request(app.use(auth.verifyGarageOwner)).post('/api/features/')
            .set('authorization', garage_owner_Token)
            .send({
                feature: 'Vehicle Towing',
                img: 'towing.png'
            }).then((res) => {
                console.log(res.body)
                featureId = res.body._id
                console.log(featureId)
                expect(res.statusCode).toBe(201)
            })
    })

    test('should be able to get features', () => {
        return request(app.use(auth.verifyGarageOwner)).get('/api/features/')
            .set('authorization', garage_owner_Token)
            .then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(200)
            })
    })


    test('should be able to update specific features', () => {
        return request(app.use(auth.verifyGarageOwner)).put(`/api/features/${featureId}`)
            .set('authorization', garage_owner_Token)
            .send({
                feature: 'Towing'
            })
            .then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(201)
            })
    })

    test('should be able to delete particular feature', () => {
        return request(app.use(auth.verifyGarageOwner)).delete(`/api/features/${featureId}`)
            .set('authorization', garage_owner_Token)
            .then((res) => {
                console.log(res.body)
                expect(res.statusCode).toBe(200)
            })
    })
})

