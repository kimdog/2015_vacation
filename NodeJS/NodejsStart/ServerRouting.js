
    // 1. 필요한 module require
    var http = require("http");

    // 2. 서버 생성 후 listen
    http.createServer(function(req,res) {
        var reqPath = req.url;
        res.writeHeader(200, {
            "Content-Type" : "text/html; charset=utf8"
        });

        if( reqPath == "/") {
            res.write("<h1>환영합니다!</h1>");
        } else if(reqPath == "/intro") {
            res.write("<h1>회사 소개 페이지 입니다</h1>");
        } else if(reqPath == "/product") {
            res.write("<h1>제품 소개 페이지 입니다</h1>");
        } else if(reqPath == "/product/notebook") {
            res.write("<h1>notebook 페이지 입니다</h1>");
        } else {
            res.write("<h1>존재하지 않는 페이지 입니다</h1>");
        }
        res.end();
    }).listen(5000,"localhost");
    console.log("서버기동 라우팅 - 5000");