// Feature 	     var	                  let	                   const
// Scope	     Function/Global scope	  Block scope	           Block scope
// Reassignable	 Yes	                  Yes	                   No
// Re-declarable Yes (within same scope)  No (within same scope)   No
// Hoisting	     Yes, as undefined	      Yes, but uninitialized   Yes, but remains uninitialized
//                                        (Temporal Dead Zone)     (Temporal Dead Zone)
// 
// Declaration   Yes	                  Yes	                   No (must be initialized at declaration)
// without initialization	

//var is function-scoped, meaning it's available throughout the entire function it's declared in, 
//or globally if declared outside a function. This can lead to unexpected bugs where a variable in a 
//block (like an if statement or for loop) is accessible outside that block.

//let and const are block-scoped, meaning they are only accessible within the specific block (defined by {}) 
//where they are declared. This provides more predictable and safer behavior.

let a;
a = 10;
console.log(a) 
// 10. Note declaration and assigning of a is in different lines.

const b=10;
//b = 10;
console.log(b); 
// SyntaxError: Missing initializer in const declaration. (This type of declaration won't work with const. 
// only const b = 10 will work)

const b1 = 100;
//b1 = 1000; //cannot reassign
//this gives us TypeError: Assignment to constant variable.

// the most significant drawback is that const does not make the value itself immutable; 
// it only creates a read-only reference or immutable binding. For primitive values 
// (like numbers or strings), the value cannot be changed. However, for objects and arrays, their 
// properties or elements can still be modified (mutated).
const person = { name: "Sheldon" };
person.name = "Leonard"; // This is allowed, the object property is changed
//person = { name: "Leonard" }; // This is a TypeError, as you are reassigning the variable

for(var i=0;i<3;i++){
    setTimeout(()=>{
        console.log("var" + i);//prints 3 3 3
    },1000);
}

for(let i=0;i<3;i++){
    setTimeout(()=>{
        console.log("var" + i);//prints 0 1 2
    },1000);
}