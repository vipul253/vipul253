//Higher-order functions are regular functions that take one or more functions as arguments
//and/or return functions as a value from it.
function x() {
  console.log("Hi");
}
function y(x) {
  x();
}
y(x); // Hi
// y is a higher order function
// x is a callback function

//Let's try to understand how we should approach solution in interview. I have an array of radius and
//I have to calculate area using these radius and store in an array.
//First Approach:
const radius = [1, 2, 3, 4];
const calculateArea = function (radius) {
  const output = [];
  for (let i = 0; i < radius.length; i++) {
    output.push(Math.PI * radius[i] * radius[i]);
  }
  return output;
};
console.log(calculateArea(radius));

//The above solution works perfectly fine but what if we have now requirement to calculate array of
//circumference. Code now be like
const radius1 = [1, 2, 3, 4];
const calculateCircumference = function (radius1) {
  const output = [];
  for (let i = 0; i < radius1.length; i++) {
    output.push(2 * Math.PI * radius1[i]);
  }
  return output;
};
console.log(calculateCircumference(radius1));

//But over here we are violating some principle like DRY Principle,
//now lets observe the better approach.
const radiusArr = [1, 2, 3, 4];

// logic to calculate area
const area = function (radius) {
  return Math.PI * radius * radius;
};
// logic to calculate circumference
const circumference = function (radius) {
  return 2 * Math.PI * radius;
};

const calculate = function (radiusArr, operation) {
  const output = [];
  for (let i = 0; i < radiusArr.length; i++) {
    output.push(operation(radiusArr[i]));
  }
  return output;
};
console.log(calculate(radiusArr, area));
console.log(calculate(radiusArr, circumference));
// Over here calculate is HOF High Order Function
// Over here we have extracted logic into separate functions.
// This is the beauty of functional programming.

// Polyfill of map
// Over here calculate is nothing but polyfill of map function
// console.log(radiusArr.map(area)) == console.log(calculate(radiusArr, area));

//Lets convert above calculate function as map function and try to use.
// So, we can add calcuate to Array object prototype for our use

Array.prototype.calculate = function (operation) {
  const output = [];
  for (let i = 0; i < this.length; i++) {
    output.push(operation(this[i]));
  }
  return output;
};
console.log(radiusArr.calculate(area));

//In JavaScript, every object has a hidden internal link (known as its [[Prototype]])
// to another object, called its prototype. This mechanism enables prototypal inheritance,
// allowing objects to share and reuse methods and properties, rather than duplicating them in
// every instance
//Shared Blueprint: The prototype acts as a blueprint, storing common methods and properties for all
// instances of a specific type (e.g., all arrays share methods like map() and push() from Array.prototype).
//Memory Efficiency: Methods defined on the prototype are stored once in memory, rather than being
// duplicated for every new object instance, which is more efficient.
//Arrow Functions: Do not use arrow functions for prototype methods if you need access to the this keyword, 
// as arrow functions do not bind their own this value
