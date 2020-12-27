const validator = require('validator');

const FeatureInput = (data) => {
    let errors = {};
    if (data.name) {
        if (!validator.isLength(data.name.trim(), { min: 6, max: 30 })) {
            errors.name = 'Feature name must be between 6 and 30 characters.';
        }
    } else errors.FeatureInput = 'Feature name is required.';

    if (!data.img) {
         errors.img = 'Owner name name is required.';
    }
    if (!data.garage) {
        errors.img = 'Garage_id is required.';
    }
    return {
        errors,
        isValid: Object.keys(errors).length === 0
    }
}
module.exports = {
    FeatureInput
}