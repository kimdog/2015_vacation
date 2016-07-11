
    var express = require("express"),
        router = express.Router(),
        controller = require("../controller/index");

    // router는 경로만 처리
    // 라우터를 통해 받은 정보를 controller가 처리

    router.get("/",function(req,res) {
        // 가지고 있는 index.ejs를 보내줄 거에요
        // sendFile - 정적파일 render - 동적파일 줄 수 있다
        res.render("index",{
            title : "Library Management System"
        });
    });

    router.get("/list",function(req,res) {
        // 도서출력 페이지를 보여줘요! ( 전체 책 목록을 다 보여줘요 )
        // 로직처리!! controller를 이용해서 처리할거에요
        // DB연동하고 결과 가지고 view 보내주는 코드가 나와야 해요
        controller.listAll(req,res);
        // 클라이언트 응답에 대한 req, res를 보낸다.

        // 처음에 controller/index로 require 받을 때, exports로 넘어온 객체에 listAll이 있기 때문에
        // 사용 가능. exports << 던지고 require << 받고
    });

    // register 페이지 처리
    router.get("/register",function(req,res) {
        res.render("reg_1");
    });

    // register success 처리
    router.get("/register/success",function(req,res) {
        controller.register(req,res);
    });

    module.exports = router;    // 라우터 기능을 넘긴다