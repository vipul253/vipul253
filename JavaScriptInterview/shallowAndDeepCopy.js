//shallow copy
//Spread Operator (...): A concise way for both objects and arrays
const original = {
  a: 1,
  b: { c: 2 },
};
const shallowCopy = { ...original }; //...operator used a is copy but b is still reference
shallowCopy.b.c = 5;
console.log(original.b.c); // Output: 5 (original changed)

//Object.assign(): Copies enumerable own properties
const shallowCopy2 = Object.assign({}, original);
shallowCopy2.b.c = 10;
console.log(original.b.c); // Output: 5 (original changed)

//Array.prototype.slice() and Array.prototype.concat()
//For arrays, these methods create a shallow copy

//Deep Copy Methods
//JSON.parse(JSON.stringify(obj)): A simple, common method for plain, JSON-compatible objects.
//Limitation: It will not work on objects containing functions, undefined, Symbol, Date, or 
//circular references, as these are not serializable in JSON
//structuredClone(obj): The modern, built-in global function in most modern JavaScript environments for 
//creating deep copies. It handles more data types than the JSON method but still has limitations 
//(e.g., cannot clone functions)
//Libraries (e.g., Lodash): For complex scenarios, especially when dealing with non-serializable data or circular references, the _.cloneDeep() method from the Lodash library is a robust, production-grade solution.
//Custom Recursive Function: A custom function can be written for full control over what is copied

const deepOriginal = {
  a: 1,
  b: { c: 2 },
};
const deepCopy1 = JSON.parse(JSON.stringify(deepOriginal));
const deepCopy2 = structuredClone(deepOriginal);
deepCopy1.b.c = 100;
deepCopy2.b.c = 1000;
console.log(deepOriginal.b.c); //original is unaffected