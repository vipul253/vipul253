//Implement a private counter using closures:
//You can use a closure to create a private counter that is not directly accessible from the outside.
function createCounter() {
  let count = 0; // Private variable
  return {
    increment: function() {
      count++;
    },
    getCount: function() {
      return count;
    }
  };
}
const counter = createCounter();
counter.increment();
console.log(counter.getCount()); // Logs 1
console.log(counter.count); // Undefined (private variable)

function outerFunction() {
  const outerVariable = "Hello";
  function innerFunction() { // innerFunction is the closure
    console.log(outerVariable); // Accesses outerVariable
  }
  return innerFunction;
}
let leakyClosure = outerFunction(); // A closure is created and referenced by 'leakyClosure'
// ... use the closure ...
leakyClosure(); // Output: "Hello"
// To "remove" the closure and allow GC of its captured scope:
leakyClosure = null; // The reference is gone, allowing the GC to reclaim memory

function outer() {
  var a = 10;
  function inner() {
    console.log(a);
  } // inner forms a closure with outer
  return inner;
}
//outer()(); // 10 
// over here first `()` will return inner function and then using secong `()` to call inner function

function outer1(str) {
  let a = 10;
  function inner1() {
    console.log(a, str);
  }
  return inner1;
}
//outer1('Hello There')(); // 10 "Hello There"
//Ans: Inner function will now form closure and will have access to both a and str

function outest() {
  var c = 20;
  function outer(str) {
    let a = 10;
    function inner() {
      console.log(a, c, str);
    }
    return inner;
  }
  return outer;
}
//outest()('Hello There')(); // 10 20 "Hello There"
//Ans: Yes, inner will have access to all its outer environment.

function outest() {
  var c = 20;
  function outer(str) {
    //let a = 10;
    function inner() {
      console.log(a, c, str);
    }
    return inner;
  }
  return outer;
}
let a = 100;
outest()('Hello There')(); // 10 20 "Hello There"
//Ans: Still the same output, the inner function will have reference to inner a, so conflicting 
// name won't matter here. If it wouldn't have find a inside outer function then it would have 
// went more outer to find a and thus have printed 100. So, it try to resolve variable in scope 
// chain and if a wouldn't have been found it would have given reference error.
// here you see closure got access to global scope as well due to chaining scopes


// without closures
var count = 0;
function increment(){
  count++;
}
// in the above code, anyone can access count and change it.

// (with closures) -> put everything into a function
// function counter1() {
//   var count = 0;
//   function increment(){
//     count++;
//   }
// }
// console.log(count); 
// this will give referenceError as count can't be accessed. So now we are able to achieve hiding of data

//(increment with function using closure) true function
function counter5() {
  var count = 0;
  return function increment(){
    count++;
    console.log(count);
  }
}
var counter1 = counter5(); //counter function has closure with count var.
counter1(); // increments counter

var counter2 = counter5();
counter2(); // here counter2 is whole new copy of counter function and it wont impack the output of counter1

// Above code is not good and scalable for say, when you plan to implement decrement counter at a later stage.
// To address this issue, we use *constructors*

// Adding decrement counter and refactoring code:
function Counter4() {
//constructor function. Good coding would be to capitalize first letter of constructor function.
  var count = 0;
  this.incrementCounter = function() { //anonymous function
    count++;
    console.log(count);
  }
   this.decrementCounter = function() {
    count--;
    console.log(count);
  }
}

var counter1 = new Counter4();  // new keyword for constructor fun
counter1.incrementCounter();
counter1.incrementCounter();
counter1.decrementCounter();
// returns 1 2 1

//an example of a function that takes a function as an argument and returns a new function that wraps 
// the original function, logging the number of times it’s called:
function logCallCount(fn) {
  let callCount = 0;

  return function wrapper() {
    callCount++;
    console.log(`Function called ${callCount} times`);
    return fn.apply(this, arguments);
  };
}

const loggedAdd = logCallCount(function add(a, b) {
  return a + b;
});

console.log(loggedAdd(1, 2)); // logs "Function called 1 times" and returns 3
console.log(loggedAdd(3, 4)); // logs "Function called 2 times" and returns 7

//we create a new function loggedAdd that wraps the original add function. Each time we call loggedAdd, 
//it logs the updated call count and returns the result of the original add function.