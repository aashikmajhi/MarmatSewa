const validator = require('validator');

const RegisterInput = (data) => {
    let errors = {};
    if (data.fullname) {
        if (!validator.isLength(data.fullname.trim(), { min: 6, max: 30 })) {
            errors.fullname = 'Fullname must be between 6 and 30 characters.';
        }
    } else errors.fullname = 'Fullname is required.';

	if (data.email) {
        if (!validator.isLength(data.email.trim(), { min: 5})) {
            errors.email = 'Email cannot be less than 5 characters.';
        } else if (!validator.isEmail(data.email.trim())) {
            errors.email = 'Invalid email.'
        }
    } else errors.email = 'Email is required.';

    if (data.password) {
        if (!validator.isLength(data.password.trim(), { min: 6, max: 30 })) {
            errors.password = 'Password must be between 6 and 30 characters.';
        }  else if (validator.isStrongPassword(data.password.trim(), {  minUppercase: 1 })) {
            errors.password = 'Password must contain  1 upper-case. '
        }
    } else errors.password = 'Password is required.';

    if (data.phoneNo) {
        if (!validator.isLength(data.phoneNo, { min: 10, max: 10 })) {
            errors.phoneNo = 'Phone number must be 10 character.';
        } else if (!validator.isInt(data.phoneNo)) {
            errors.phoneNo = 'Phone number must be INT.';
        }
    } else errors.phoneNo = 'Phone number is required.';

    if (data.address) {
        if (!validator.isLength(data.address.trim(), { min: 6, max: 30 })) {
            errors.address = 'Address must be between 6 and 30 characters.';
        } 
    } else errors.address = 'Address is required.';
  
    if (!data.dob) {
        errors.dob = 'Date of birth is required.';
    } 

    if (!data.gender) {
        errors.address = 'Gender is required.';
    } 

    if (!data.scannedLicense) {
        errors.address = 'Gender is required.';
    }
    return {
        errors,
        isValid: Object.keys(errors).length === 0
    }
}

const LoginInput = (data) => {
    let errors = {};
    if (data.password) {
        if (!validator.isLength(data.password.trim(), { min: 6, max: 30 })) {
            errors.password = 'Password must be between 6 and 30 characters.';
        }
    } else errors.password = 'Password is required.';

	if (data.email) {
        if (!validator.isLength(data.email.trim(), { min: 5})) {
            errors.email = 'Email cannot be less than 5 characters.';
        } else if (!validator.isEmail(data.email.trim())) {
            errors.email = 'Invalid email.'
        }
    } else errors.email = 'Email is required.';
  
    return {
        errors,
        isValid: Object.keys(errors).length === 0
    }
}

module.exports = {
    RegisterInput, LoginInput
}