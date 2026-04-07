//there is difference between not defined and undefined
const x = [];
x[4] = 1;
x.forEach(i => {
  console.log(i);
});
//prints only 1 as others are not defined
const x1 = [1, , 3, undefined, 5];
x1.forEach(i => {
  console.log(i);
});
//prints only 1 3 undefined 5 as others are not defined

const arr = [1, 2, 3];
const str = "1,2,3";
console.log(arr == str);
//JS tries to convert non-primitive [1,2,3] to primitive using toString so output is true
console.log(3 * "9"); //27
console.log("9" * 3); //27
console.log(4 / 0); //lool this prints the word "Infinity"

var a = 10;
var result = (function () {
  //delete a;
  return a;
})();
console.log(result);

var string1 = "123";
var intval = 123;
console.log(string1+intval);
//intval will be concactenated as string