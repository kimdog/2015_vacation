
    var mysql = require("mysql");
    var genericPool = require("generic-pool");

    var pool = genericPool.Pool({               // Pool method를 호출해서 pool에 저장
        name : "my Connection Pool",
        max : 10,                               // 최대 10개
        min : 5,                                // 최소 5개
        log : true,                            // 로그 찍기
        create : function(callback) {
            var config = {
                host : "localhost",
                port : 3306,
                user : "nodejs",
                password : "nodejs",
                database : "library"
            };
            var conn = mysql.createConnection(config);
            conn.connect(function(err) {        // connction 끝나고 function 호출해
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


    // connection pool로 부터 connection을 얻어와서 사용하면 되요!

    pool.acquire(function(err,conn) {
        if(err) {
            console.log("connection 획득에 실패");
        } else {
            conn.query("select btitle, bauthor from books where bprice > 50000", function (err, result, fields) {
                    // 실제 업무에서 * << 쓰지 않는다. 너무 느려짐
                    // err : 만약 error가 있으면 error message포함
                    // result : 결과가 담겨요!! ( javascript 객체로 )
                    // fields : 사용된 필드에 대한 정보
                    console.log("error : " + err);
                    console.log(result);
                    conn.destroy();
            });
        }
    });



    /*
    // mysql 내용 받아올 객체
    var conn = mysql.createConnection({
        host : "localhost",
        port : 3306,
        user : "nodejs",
        password : "nodejs",
        database : "library"
    });



    // 접속 시도..
    conn.connect();


    conn.query("select btitle, bauthor from books where bprice > 50000",
        function(err,result,fields) {                               // 실제 업무에서 * << 쓰지 않는다. 너무 느려짐
        // err : 만약 error가 있으면 error message포함
        // result : 결과가 담겨요!! ( javascript 객체로 )
        // fields : 사용된 필드에 대한 정보
        console.log("error : " + err);
        console.log(result);
        conn.end();     // << 이 위치로
    });

    //conn.end();       << 비동기 이기 때문에 이 위치에 있으면 쿼리를 날리자마자 처리안되고 바로 end된다.

*/