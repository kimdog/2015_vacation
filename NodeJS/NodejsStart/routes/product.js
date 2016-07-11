
    var express = require("express");
    var router = express.Router();

    router.get("/",function(req,res) {
        res.write(req + "<h1>상품페이지 입니다.</h1>");
    });

    router.get("/notebook",function(req,res) {
        res.write(req + "<h1>노트북페이지 입니다.</h1>");
    });

    module.exports = router;