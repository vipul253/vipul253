//It is a function which take all the values of array and gives a single output of it.
//It reduces the array to give a single output.
const array = [5, 1, 3, 2, 6];
// Calculate sum of elements of array - Non functional programming way
function findSum(arr) {
  let sum = 0;
  for (let i = 0; i < arr.length; i++) {
    sum = sum + arr[i];
  }
  return sum;
}
console.log(findSum(array)); // 17

// reduce function way
const sumOfElem = array.reduce(function (accumulator, current) {
  // current represent the value of array
  // accumulator is used the result from element of array.
  // In comparison to previous code snippet, *sum* variable is *accumulator* and *arr[i]* is *current*
  accumulator = accumulator + current;
  return accumulator;
}, 0);
//In above example sum was initialized with 0, so over here accumulator also needs to be initialized,
//so the second argument to reduce function represent the initialization value.
console.log(sumOfElem); // 17

// find max inside array: Non functional programming way:
function findMax(arr) {
  let max = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
  }
  return max;
}
console.log(findMax(array)); // 6

// using reduce
const output1 = array.reduce((acc, current) => {
  if (current > acc) {
    acc = current;
  }
  return acc;
}, 0);
console.log(output1); // 6

// acc is just a label which represent the accumulated value till now,
// so we can also label it as max in this case
const output2 = array.reduce((max, current) => {
  if (current > max) {
    max = current;
  }
  return max;
}, 0);
console.log(output2); // 6

//tricky reduce
const users = [
  { firstName: "Alok", lastName: "Raj", age: 23 },
  { firstName: "Ashish", lastName: "Kumar", age: 29 },
  { firstName: "Ankit", lastName: "Roy", age: 29 },
  { firstName: "Pranav", lastName: "Mukherjee", age: 50 },
];
// Get the count/report of how many unique people with unique age are there
// like: {29 : 2, 23 : 1, 50 : 1}
// We should use reduce, why? we want to deduce some information from the array. Basically we want to get a single object as output
const report = users.reduce((acc, curr) => {
  if (acc[curr.age]) {
    acc[curr.age] = ++acc[curr.age];
  } else {
    acc[curr.age] = 1;
  }
  return acc; //to every time return updated object
}, {});
console.log(report); // {29 : 2, 23 : 1, 50 : 1}

// function chaining
// First name of all people whose age is less than 30
const output3 = users.filter(user => user.age < 30).map(user => user.firstName);
console.log(output3); // ["Alok", "Ashish", "Ankit"]

//challenge: Implement the same logic using reduce
const output4 = users.reduce((acc, curr) => {
  if (curr.age < 30) {
    acc.push(curr.firstName);
  }
  return acc;
}, []);
console.log(output4); // ["Alok", "Ashish", "Ankit"]
