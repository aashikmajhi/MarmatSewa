const validator = require('validator');

const GarageInput = (data) => {
    let errors = {};
    if (data.businessName) {
        if (!validator.isLength(data.businessName.trim(), { min: 6, max: 30 })) {
            errors.businessName = 'Business must be between 6 and 30 characters.';
        }
    } else errors.businessName = 'Business name is required.';

    if (data.address) {
        if (!validator.isLength(data.address.trim(), { min: 6, max: 30 })) {
            errors.address = 'Address must be between 6 and 30 characters.';
        } 
    } else errors.address = 'Address is required.';

    if (data.contactNo) {
    if (!validator.isInt(data.contactNo)) {
            errors.contactNo = 'Contact number must be INT.';
        }
    } else errors.contactNo = 'Contact number is required.';

    if (!data.registrationType) {
        errors.registrationType = 'Registration type is required.';
    } 

    if (!data.panDoc) {
        errors.panDoc = 'Pan Document is required.';
    } 

    if (!data.registrationDoc) {
        errors.registrationDoc = 'Registration document is required.';
    }
    if (!data.featuringServices) {
        errors.featuringServices = 'Featuring services is required.';
    }
    return {
        errors,
        isValid: Object.keys(errors).length === 0
    }
 
}
module.exports = {
    GarageInput
}