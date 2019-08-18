var fn1 = function (a, b, callback) {
    return 2 * callback(a, b);
}

var result = fn1(3, 4, (a, b) => 2 * a + b);

console.log('Result:', result);
