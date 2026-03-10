// The Global Scope (Concept)
// Definition: The global scope is the top-level context where code runs and variables 
// are accessible everywhere.
// Environment-Dependent: The actual object that represents the global scope changes depending 
// on the JavaScript runtime environment.
// In web browsers, this object is window.
// In Node.js, it's an object called global.
// In Web Workers, it's self.
// Universal Access: The modern, standardized way to access the global object in any environment is using 
// the globalThis property

// In a browser's global scope (not a module)
var userName = "John"; // Becomes window.userName
function greet() { /* ... */ } // Becomes window.greet()

console.log(window.userName); // "John"
console.log(userName); // "John"

//JS has global scope, function(){} scope, block {} scope