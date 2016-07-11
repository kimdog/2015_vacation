
    // 1. 필요한 module require
    var http = require("http"),
        express = require("express"),
        app = express(),
        fs = require("fs"),             // 파일 스트림
        busboy = require("connect-busboy"),
        path = require("path");

    app.use(busboy());

    // 2. view setting
    app.set("views",path.join(__dirname,"views"));
    app.set("view engine","ejs");

    app.post("/fileUpload",function(req,res) {
        // 파일 upload 처리
        var fstream;                    // 파일이 너무 클 수 있으므로 stream으로 처리
        req.pipe(req.busboy);           // busboy에게 req를 pipe로 이어준다.
        req.busboy.on("file",function(fieldName,file,fileName) {
            console.log("업로드 파일명 : " + fileName);
            fstream =
                fs.createWriteStream(__dirname + "/files/" + fileName);
            file.pipe(fstream);         // 보낼 파일과 쓰는 stream을 잇는다. 잇는 순간 바로 전달시작 (writestream)
            fstream.on("close",function() {
                res.render("complete");
            });                         // 파일의 내용이 다 끝나서 stream이 닫혔을 때 close이벤트가 뜬다
        });
    });                                 // on으로 file이란 이벤트를 처리


    http.createServer(app).listen(5000,"localhost");
    console.log("파일 업로드 - 5000");