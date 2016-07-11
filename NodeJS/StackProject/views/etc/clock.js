

    function printClock() {

        var div = document.getElementById("myDiv");

        window.setInterval(function() {
            var time = (new Date()).toLocaleString();
            div.innerHTML = time;
        },1000);
    }