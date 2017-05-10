var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');

/* GET home page. */
router.use('/', function(req, res, next) {
    next();
});

router.post("/login", function (req, res, next) {

    var data = req.body;
    var name = data.account;
    var passwd = data.passwd;


    var result={
        status: 0,
        message: "login success"
    }

    if (name === "zhao"  && passwd === "123456") {

    }
    else {
        result.status = -1;
        result.message = "账号或者密码错误";
    }
    res.send(JSON.stringify(result))
})

module.exports = router;