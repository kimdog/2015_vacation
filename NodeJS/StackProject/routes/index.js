
    var express = require("express"),
        router = express.Router(),
        controller = require("../controller/index");


    router.get("/",function(req,res) {
        res.render("index",{
            title : "Stack Team Project",
            state : ""
        });
    });

    router.get("/signup",function(req,res) {

        res.render("signup",{
            title : "Stack Team Project"
        });
    });

    router.post("/userinfo",function(req,res) {

        controller.userinfo(req,res);

    });

    router.post("/register",function(req,res) {

        controller.register(req,res);

    });


    module.exports = router;