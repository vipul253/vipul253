"use strict";
//It is basically used to transform a array. The map() method creates a new array with the results of 
//calling a function for every array element.
//const output = arr.map(function) 
//this function tells map that what transformation I want on each element of array

// Task 2: Triple the array element
const arr = [5, 1, 3, 2, 6];
// Transformation logic
function triple(x) {
  return x * 3;
}
const tripleArr = arr.map(triple);
console.log(tripleArr); // [15, 3, 9, 6, 18]

// Task 3: Convert array elements to binary
const arr1 = [5, 1, 3, 2, 6];
// Transformation logic:
function binary(x) {
    return x.toString(2);
}
const binaryArr1 = arr1.map(binary);

// The above code can be rewritten as :
const binaryArr2 = arr1.map(function binary(x) {
    return x.toString(2);
})
// OR -> Arrow function
const binaryArr3 = arr1.map((x) => x.toString(2));
//So basically map function is mapping each and every value and transforming it based on given condition.