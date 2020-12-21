const jwt = require('jsonwebtoken');

function verifyUser(req, res, next) {
    let authHeader = req.headers.authorization;
    if (!authHeader) {
        let err = new Error('No authentication information!');
		err.status = 401;
        return next(err);
    }

    let token = authHeader.split(' ')[1];
    jwt.verify(token, process.env.SECRET, (err, payload) => {
        if (err) {
            let err = new Error('Token could not be found!');
            err.status = 401;
            return next(err);
        } else { 
            req.user = payload;
            // console.log(req.user.id);
            next();
        }
    })
};

function verifyGarageOwner(req, res, next) {
    if (req.user.role !== 'GARAGE_OWNER') {
        let err = new Error('Forbidden');
        err.status = 403;
        return next(err);
	}
    next();
}

function verifyAdmin(req, res, next) {
    if (req.user.role !== 'ADMIN') {
        let err = new Error('Forbidden');
        err.status = 403;
        return next(err);
	}
    next();
}

module.exports = {
    verifyUser, verifyGarageOwner, verifyAdmin
}
