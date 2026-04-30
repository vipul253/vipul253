var add = function (a, ...b) {
  //can use only one rest operator and it must be at the end
  //rest operator
  let res = a;
  for (let i = 0; i < b.length; i++) {
    res = res + b[i];
  }
  console.log(res);
};
add(10, 20, 30, 40);

var emp = ["re", 25, 35555, "Tester"];

function disp(name, age, sal, desg) {
  console.log("name : " + name);
  console.log("age : " + age);
  console.log("sal : " + sal);
  console.log("desg : " + desg);
}

disp(emp);
disp(...emp); //spread operator

// In JavaScript, the rest and spread operators share the same triple-dot syntax (...) but perform opposite functions.
// The spread operator expands (unpacks) elements from a collection, while the rest operator gathers (packs) multiple
// individual values into a single collection

function disp1(name, age, sal, desg, city, state, country, pin) {
  console.log("name : " + name);
  console.log("age : " + age);
  console.log("sal : " + sal);
  console.log("desg : " + desg);
  console.log("city : " + city);
  console.log("state : " + state);
  console.log("country : " + country);
  console.log("pin : " + pin);
}

var emp = ["re", 25, 35555, "Tester"];
var addr = ["mum", "mah", "Ind"];
var pin = 400;
disp1(...emp, addr, pin);
disp1(...emp, ...addr, pin);

//spread can be used anywhere, rest is used only in function call;
//Comparison Overview
//Feature 	      Spread Operator (...)	                                  Rest Operator (...)
//Primary Action  Unpacks (expands) an iterable into individual elements. Packs (collects) multiple values into a single array or object.
//Context	      Used in array/object literals and function calls.	      Used in function parameters and destructuring.
//Position	      Can be placed anywhere (start, middle, or end).	      Must be the last parameter/element in the list.

let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];
let arr3 = [7, 8, 9];
let list1 = [arr1, arr2, arr3];
let list2 = [...arr1, ...arr2, ...arr3];

console.log(list1);
console.log(list2);
