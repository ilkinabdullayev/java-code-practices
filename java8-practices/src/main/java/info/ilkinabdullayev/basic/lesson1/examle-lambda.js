var fn1 = function (a, b, callback) {
    return 2 * callback(a, b);
}

var result = fn1(3, 4, function(a, b) {
    return a + b;
});

var result2 = fn1(3, 4, (a, b) => a + b);

console.log('Result:', result);
console.log('Result2:', result2);