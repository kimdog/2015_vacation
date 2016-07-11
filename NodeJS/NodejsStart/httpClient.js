
    var http = require("http");

    // http://Localhost:5000/
    var option = {
        host : "localhost",
        port : 5000,
        method : "GET",
        path : "/"
    };

    var req = http.request(option, function (res) {
        console.log("상태코드 : " + res.statusCode);
        console.log("헤더정보 : " + res.headers);
        res.setEncoding("utf8");
        res.on("data",function(result) {
            console.log("전달받은 데이터 : " , result)
        });
    });

    req.end(); // 그래야 request가 전송된다.