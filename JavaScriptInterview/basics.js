//The output of the following code will be 3 printed three times because the callback functions 
// all share the same i variable which has a final value of 3 after the loop finishes.

// using var
for (var i = 0; i < 3; i++) {
  setTimeout(function() {
    console.log(i); // Logs 3, three times
  }, 1000);
}

// using let standard ES6+ solution is to use let instead of var, as let is block-scoped, 
// creating a new variable for each iteration.
for (let i = 0; i < 3; i++) {
  setTimeout(function() {
    console.log(i); // Logs 3, three times
  }, 1000);
}

// Always use let and const to create variables
// let and const are the standard way of declaring variables in JavaScript. They remove the 
// unpredictable code behavior that comes with using var.

// There is almost no reason to use var to declare variables in modern JavaScript.