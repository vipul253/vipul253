//Function currying in JavaScript transforms a function with multiple arguments into a sequence of
//nested functions, each taking a single argument.

function outest(num1) {
  console.log(num1);
  function outer(num2) {
    console.log(num2);
    function inner(num3) {
      console.log(num3);
    }
    return inner;
  }
  return outer;
}
outest(1)(2)(3);

//OR
function printNum(a) {
  return function (b) {
    return function (c) {
      console.log(a, b, c);
      // Or perform any desired action with the arguments
    };
  };
}
// Usage:
printNum(1)(2)(3); // Output: 1 2 3
