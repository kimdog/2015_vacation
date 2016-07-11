/**
 * Created by 김정수 on 2015-08-03.
 */

    function printClock() {
        // 버튼을 누르면 실행되요!!
        // 1. 출력할 영역을 확보해요
        // HTML tag(div)를 javascript객체로 가져와야 해요
        var div = document.getElementById("myDiv");

        // 2. 1초마다 반복해서 현지 시간을 해당 역영에
        // 출력
        window.setInterval(function() {
            var time = (new Date()).toLocaleString();
            div.innerHTML = time;
        },1000);
    }

    printClock();