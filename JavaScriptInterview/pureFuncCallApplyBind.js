//pure functions are predictable functions that produce no side effects, meaning it does not modify
//external state, variables, or perform I/O operations (like console logging, making API calls,
//or changing the DOM).
// pure func sample -
function multiply(a, b) {
  return a * b;
}

//while call(), apply(), and bind() are methods used to control the value of 'this' and arguments
//of functions. bind() is particularly useful for currying (or partial application) by creating
//new functions with pre-set arguments.
// Create a new function 'multiplyByTwo' with the first argument 'a' permanently set to 2.
// The first argument to bind() is the 'this' context (set to null here as it's not used).
const multiplyByTwo = multiply.bind(null, 2);
//This technique avoids redundant variable passing and helps create reusable, specialized functions
console.log(multiplyByTwo(4)); // Output: 8

//another sample where 'this' of nameObj is binded to PrintName.sayHi, it does not
//modify the original printName
let nameObj = {
  name: "Tony",
};
let PrintName = {
    name: "steve",
    sayHi: function (age) {
        console.log(this.name + " age is " + age);
    }
}
let HiFun = PrintName.sayHi.bind(nameObj, 42);
HiFun();

//we can make out own custom bind() using object[prototype]
Object.prototype.MyBind = function (bindObj, ...args) {
    bindObj.myMethod = this;
    return function () {
        bindObj.myMethod(...args);
    }
}
let HiFunMyBind = PrintName.sayHi.MyBind(nameObj, 42);
HiFunMyBind();


//call() method invokes the function immediately and sets 'this' to the first argument.
//Any additional arguments are passed directly to the function.
let nameObj2 = {
  name: "Tony",
};
let PrintName2 = {
  name: "steve",
  sayHi: function (age) {
    console.log(this.name + " age is " + age);
  },
};
PrintName2.sayHi.call(nameObj2, 42);
//here nameObj2 is passed as 'this' and sayHi sees nameObj as its obj instead of printName
//we can make out own custom call() using object[prototype]
Object.prototype.MyCall = function (bindObj, ...args) {
    bindObj.myMethod = this;

    bindObj.myMethod(...args);

}
PrintName2.sayHi.MyCall(nameObj, 42);
//The only difference from the bind polyfill is that MyCall does not return a new function 
//just like JavaScript’s built-in call()

//apply() method calls a function immediately and sets this to the first argument passed. 
//Unlike call(), the additional arguments must be provided as an array, 
//which are then passed to the function.
PrintName.sayHi.apply(nameObj, [42]); // 42 passed as array

//we can make out own custom apply() using object[prototype]
Object.prototype.MyApply = function (bindObj, args) {
    bindObj.myMethod = this;

    bindObj.myMethod(...args);

}
PrintName.sayHi.MyApply(nameObj, [42]);
//In this polyfill, we pass arguments as an arrayjust like the native apply() method. 
//Other than accepting arguments differently, 
//the implementation works the same way as our call() polyfill.