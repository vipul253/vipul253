//setTimeout(), DOM APIs, fetch(), localstorage, console (yes, even console.log is not JS!!), 
// location and so many more
// setTimeout() : Timer function
// DOM APIs : eg.Document.xxxx ; Used to access HTML DOM tree. (Document Object Manipulation)
// fetch() : Used to make connection with external servers eg. Netflix servers etc.
// We get all these inside call stack through global object ie. window
// Use window keyword like : window.setTimeout(), window.localstorage, window.console.log() to log something 
// inside console. As window is global obj, and all the above functions are present in global object, 
// we don't explicity write window but it is implied.

console.log("Start"); 
// this calls the console web api (through window) which in turn actually modifies values in console.
setTimeout(function cbT() {
  console.log("CB Timeout");
}, 5000);
//cbT is sent to webApI env with timeout of 5sec and then placed back in callback queue by eventLoop
fetch("https://jsonplaceholder.typicode.com/users").then(function cbF() {
    console.log("CB Netflix");
}); 
// take time to bring response, but response is set to cbF which is a promise callback so placed in
//microtask queue which has higher priority
console.log("End");
//output as CB Netflix comes from microtask queue which has higher priority than macrotask queue that is
//the callBack queue