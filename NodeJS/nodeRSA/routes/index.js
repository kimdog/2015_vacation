
    var express = require("express"),
        router = express.Router(),
        controller = require("../controller");

    router.get("/", function(req,res) {
        controller.loginForm(req,res);

    });

    router.post("/loginProcess", function(req,res) {
        controller.loginProcess(req,res);
    });


    module.exports = router;