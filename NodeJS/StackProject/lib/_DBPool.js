
    var mysql = require("mysql");
    var genericPool = require("generic-pool");

    var pool = genericPool.Pool({
        name : "my Connection Pool",
        max : 10,                               // 최대 10개
        min : 5,                                // 최소 5개
        log : false,                            // 로그 찍기
        create : function(callback) {
            var config = {
                host : "localhost",
                port : 3306,
                user : "java",
                password : "java",
                database : "test"
            };
            var conn = mysql.createConnection(config);
            conn.connect(function(err) {
                if(err) {
                    console.log("Connection 생성 실패!");
                }
                callback(err,conn);             // 최소 5번
            });

        },
        destroy : function(conn) {
            conn.end();
        }

    });


    module.exports = pool;