// In JavaScript, Promise.resolve().then() executes its callback before setTimeout(..., 0)
// due to the event loop's priority system. Promises are handled in the microtask queue,
// which has a higher priority than the macrotask queue (or task queue) where setTimeout callbacks are placed
"use strict";
console.log("Start");

setTimeout(() => {
  console.log("1 sec");
}, 1000);
setTimeout(() => {
  console.log("0 sec");
}, 0);
setTimeout(() => {
  console.log("no time sec");
});
setTimeout(() => {
  console.log("0.5 sec");
}, 500);
Promise.resolve().then(() => {
  console.log("Promise callback");
});

console.log("End");
