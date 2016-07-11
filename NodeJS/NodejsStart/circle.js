

    var PI = Math.PI;

    function calcArea(input) {
        return input*input * PI;
    }

    // module이라는 객체가 return되는건 맞는데
    // exports => module.exports 객체에 대한 reference

    exports.area = calcArea;
    exports.sample = PI;

