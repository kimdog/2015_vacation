
    // controller(로직처리까지 포함)
    var pool = require("../lib/_DBPool");
    var mysql = require("mysql");

    exports.listAll = function(req,res) {
        // 모든 책을 보여주는 로직을 작성해서 view로 던지는
        // 코드를 만들어 보아요
        pool.acquire(function(err,conn) {   // error가 날 수도 있꼬 connection 가져올 수도 있다
            if(err) {
                console.log("Connection 획득에 실패");
            } else {
                conn.query("select * from books",function(err,result,fields) {
                    if(err) {
                        console.log("Query에 문제가 있어요");
                    } else {
                        res.render("list",{
                            result : result
                        });
                    }
                });
            }
        });
    }

    exports.register = function(req,res) {
        pool.acquire(function(err,conn) {
            if(err) {
                console.log("Connection 획득에 실패");
            } else {
                var sql = "insert into books(bimgurl,btitle,bprice,bauthor,bisbn) values(?,?,?,?,?)";

                //post 방식일 때는 body로 받는다. form 자체를 받기 때문
/*                var bimgurl = req.body.bimgurl,
                    btitle = req.body.btitle,
                    bprice = req.body.bprice,
                    bauthor = req.body.bauthor,
                    bisbn = req.body.bisbn;*/
                // get 방식일 때는 query 형태로 쭉 받아준다
                var bimgurl = req.query.bimgurl,
                    btitle = req.query.btitle,
                    bprice = req.query.bprice,
                    bauthor = req.query.bauthor,
                    bisbn = req.query.bisbn;


                var params = [
                    bimgurl,
                    btitle,
                    bprice,
                    bauthor,
                    bisbn
                ];

                sql = mysql.format(sql,params);

                conn.query(sql,function(err,rows,cols) {
                    if(err) {
                        console.log("Query Error : ",err);
                        conn.rollback(function () {
                            throw err;
                        });
                        // error 페이지 render 하기
                        res.render("error");
                    }
                    conn.commit(function(err) {
                        if(err) {
                            conn.rollback(function() {
                               throw err;
                            });
                        }
                        console.log("commit Complete!");
                    });
                    pool.release(conn);
                    //res.redirect("/register/reg_2"); redirect 하기 보다는 render 해버린다
                    res.render("reg_2",{
                        bimgurl : bimgurl,
                        btitle : btitle,
                        bprice : bprice,
                        bauthor : bauthor,
                        bisbn : bisbn
                    });
                });
            }
        });
    }