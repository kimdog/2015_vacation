
    // 항상 인코딩은 유니코드 UTF-8로 맞춰준다 생각하면 편하다

    // 1. 필요한 module require
    var fs = require("fs");

    // 동기 method가 있고
/*
    console.log("현재 폴더 : " + __dirname);
    var result = fs.readFileSync("sample.txt","utf8");     // Sync -> 동기로 처리
    console.log("데이터는 : " + result);
    console.log("프로그램 종료!!");

*/
    // 비동기 method가 있어요
    // system에서 자동으로 호출되는 함수를 callback함수
    fs.readFile("sample.txt","utf8",function(err,data) {
        console.log("데이터는 : " + data);
    });
    console.log("프로그램 종료!!");