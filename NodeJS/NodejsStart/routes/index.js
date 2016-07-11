
    var express = require("express");
    var router = express.Router();      // express가 하는 일 중 routing하는 일만 뽑아낸다


    router.get("/",function(req,res) {
        res.write(req + "<h1>환영합니다</h1>");
        res.end();
    });

    router.get("/intro",function(req,res) {
        res.write(req + "<h1>회사 소개 페이지 입니다</h1>");
        res.end();
    });

    module.exports = router;            // 하나의 객체를 exports