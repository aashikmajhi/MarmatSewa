const validator = require('validator');

const RegisterInput = (data) => {
    let errors = {};
    if (data.fullname) {
        if (!validator.isLength(data.Fullname.trim(), { min: 6, max: 30 })) {
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
        } 
        // else if (!validator.isStrongPassword(data.password.trim(), {  minLowercase: 1, minUppercase: 1 })) {
        //     errors.password = 'Password must contain 1 lower-case and 1 upper-case. '
        // }
    } else errors.password = 'Password is required.';

    if (data.phone_no) {
        if (!validator.isLength(data.phone_no.trim(), { min: 10, max: 10 })) {
            errors.phone_no = 'Phone number must be 10 character.';
        } else if (!validator.isInt()) {
            errors.phone_no = 'Phone number must be INT.';
        }
    } else errors.phone_no = 'Phone number is required.';

    if (data.address) {
        if (!validator.isLength(data.address.trim(), { min: 5, max: 30 })) {
            errors.phone_no = 'Phone number must be 10 character.';
        } 
    } else errors.phone_no = 'Phone number is required.';
  
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
    } else errors.password = 'Email is required.';
  
    return {
        errors,
        isValid: Object.keys(errors).length === 0
    }
}



module.exports = {
    RegisterInput, LoginInput
}