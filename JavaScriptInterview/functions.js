//function have their own Function execution stack which is added to call stack
//JS is single threaded so all execution is synchronous with asych call capacity
var b = function (param1, param2) {
  // labels/identifiers are parameters
  console.log(param1 + "b called" + param2);
};
b(arg1, arg2); // arguments - values passed inside function call

var b = function (param1) {
  console.log(param1); // prints " f() {} "
};
b(function () {});

// Other way of doing the same thing:
var b = function (param1) {
  console.log(param1);
};
function xyz() {}
b(xyz); // same thing as prev code

// we can return a function from a function:
var b = function (param1) {
  return function () {};
};
console.log(b()); //we log the entire fun within b


//Functions are first class citizens ie. take a function A and pass it to another function B. Here, 
//A is a callback function. So basically I am giving access to function B to call function A. This 
//callback function gives us the access to whole Asynchronous world in Synchronous world.
setTimeout(function () {
  console.log('Timer');
}, 1000); // first argument is callback function and second is timer.

//JS is a synchronous and single threaded language. But due to callbacks, we can do async things in JS.

setTimeout(function () {
  console.log('timer');
}, 5000);
function x(y) {
  console.log('x');
  y();
}
x(function y() {
  console.log('y');
});
// x y timer

// Another Example of callback
function printStr(str, cb) {
  setTimeout(() => {
    console.log(str);
    cb();
  }, Math.floor(Math.random() * 100) + 1);
}
function printAll() {
  printStr('A', () => {
    printStr('B', () => {
      printStr('C', () => {});
    });
  });
}
printAll(); // A B C // in order
