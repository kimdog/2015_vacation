
    var http = require("http"),
        express = require("express"),
        app = express(),
        server = http.createServer(app),
        io = require("socket.io").listen(server);        // port 하나를 두개의 server processor가 받으려고(+web socket)

    app.get("/",function(req,res) {
        res.sendFile("webSocketClient.html",{
            root : __dirname
        });
    });

    // connection이란 event가 발생하면 function() 해 ! -> connection 은 이미 정해진 event다
    // io : WebSocket Server
    // socket : 접속한 client와 통신할 수 있는 socket
    // 이렇게 만들어진 socket은 events.EventEmitter를 상속해서 생성된
    // 객체
    io.on("connection",function(socket) {

        socket.emit("ServerEcho",{
            msg : "서버 접속 성공이에요!"
        });

        socket.on("sendChatMSG",function(data) {
            socket.emit("ServerEcho",{
                msg : data.msg
            });
            /*
            // 모든 사람에게 broadcasting . socket 을 io로만 바꾸면 된다.
             io.emit("ServerEcho",{
             msg : data.msg
             });
             */
        });
    });

    server.listen(5000,"localhost");
    console.log("WebSocket Server 기동 5000");
