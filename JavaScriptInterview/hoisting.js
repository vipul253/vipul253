// Hoisting is a concept in JavaScript that allows variables and function declarations to be accessed 
// before they are actually defined in the code. During the memory creation phase of the execution context, 
// variables are initialized to undefined, while function declarations are stored in memory as they are.

// Variables are initialized as undefined and function declarations are stored as they are during the 
// memory allocation phase.
// Hoisting enables us to use variables and call functions before they are actually declared in the code.
// Using a variable or calling a function before its declaration will not result in an error, but the variable 
// will have the value undefined until it is assigned a value. If a variable is not declared at all, it is 
// considered "not defined" and will result in an error when accessed. Hoisting works differently for function 
// declarations, function expressions and arrow function expression. Function declarations are fully hoisted, 
// while function expressions and arrow function expression behave like variables and are hoisted with an 
// initial value of undefined.

//getName can execute because function declaration was toped to scope before execution
getName(); // Namaste Javascript
console.log(x); // undefined
var x = 7;
function getName() {
    console.log('Namaste Javascript');
}

//now get name is treated as a variable because it is function expression assigned to var getName
//getName(); // Uncaught TypeError: getName is not a function, which is undefined initially
//console.log(getName);
var getName = function () {
    console.log('Namaste JavaScript');
};
// The code won't execute as the first line itself throws a TypeError.

var x = 1;
a();
b(); // we are calling the functions before defining them. This will work properly, as seen in Hoisting.
console.log(x);

function a() {
  var x = 10; // local scope because of separate execution context
  console.log(x);
}

function b() {
  var x = 100;
  console.log(x);
}
//Output 10 100 1

//Unlike function declaration, class declarations are not hoisted. This means you cannot accessed a 
//class before its declaration.
//new Car(); // ReferenceError: cannot access "Car" before initialization
//class Car{}

//Import declarations are hoisted. This means that all methods and functions of an imported value are 
//accessible in another module even before its declaration.
//const sum = f.add(2+3);
//import f from './library/package'