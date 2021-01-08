const validator = require('validator');

const GarageInput = (data) => {
    let errors = {};
    if (data.businessName) {
        if (!validator.isLength(data.businessName.trim(), { min: 6, max: 30 })) {
            errors.businessName = 'Business must be between 6 and 30 characters.';
        }
    } else errors.businessName = 'Business name is required.';

    if (data.ownerName) {
        if (!validator.isLength(data.ownerName.trim(), { min: 6, max: 30 })) {
            errors.ownerName = 'Owner name must be between 6 and 30 characters.';
        }
    } else errors.ownerName = 'Owner name name is required.';

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

    if (!data.panNo) {
        errors.panNo = 'Pan No is required.';
    } 

    if (!data.registrationDoc) {
        errors.registrationDoc = 'Registration document is required.';
    }

    // let NO_OF_SELECTED_FEATURES = 0;
    // if (data.controlsAndBrakes) NO_OF_SELECTED_FEATURES++;
    // if (data.puncture) NO_OF_SELECTED_FEATURES++;
    // if (data.electricity) NO_OF_SELECTED_FEATURES++;
    // if (data.wheelAndControl) NO_OF_SELECTED_FEATURES++;

    // if (NO_OF_SELECTED_FEATURES < 2) {
    //      errors.panDoc = 'At least 2 services most be selected.';
    // }

    // if (data.name) {
    //     if (!validator.isLength(data.businessName.trim(), { min: 6, max: 30 })) {
    //         errors.businessName = 'Business must be between 6 and 30 characters.';
    //     }
    // } else errors.businessName = 'Business name is required.';


    return {
        errors,
        isValid: Object.keys(errors).length === 0
    }
}
module.exports = {
    GarageInput
}