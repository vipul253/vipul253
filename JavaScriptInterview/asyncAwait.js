//async and await in JavaScript provide a cleaner, synchronous-looking syntax for working with promises,
//making asynchronous code easier to read and manage
//An async function always returns a Promise. The await keyword can only be used inside an async function
//and it pauses the function's execution until the promise settles (resolves or rejects)

// A function that returns a Promise, simulating an asynchronous operation
function resolveAfter2Seconds() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve("Operation completed");
    }, 2000);
  });
}

// An async function to use 'await'
async function fetchData() {
  console.log("Starting data fetch...");
  // Pause execution until the promise resolves, then assign the result
  const result = await resolveAfter2Seconds();
  console.log(`Result: ${result}`); // Logs "Result: Operation completed" after 2 seconds
  console.log("Finished data fetch.");
}

// Call the async function
fetchData();
console.log("This message prints before the data fetch finishes!");
//This demonstrates that while the async function pauses internally,
// it does not block the main JavaScript thread

//Real-World Example (Fetching Data with Error Handling)
//A common use case is fetching data from an API. async/await works seamlessly with the built-in Fetch API,
//and error handling is done using standard try...catch blocks
async function fetchUserData() {
  try {
    // Await the fetch request
    const response = await fetch("https://api.example.com/users/1");

    if (!response.ok) {
      // Throw an error if the response status is not ok
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    // Await the JSON parsing of the response body
    const user = await response.json();
    console.log("User data:", user);
  } catch (error) {
    // Catches any errors in the try block, including network errors
    console.error("Error fetching user data:", error.message);
  }
}
fetchUserData();
//Key Concepts
//async Keyword: Used to declare an asynchronous function. It ensures the function returns a promise.
//await Keyword: Pauses the async function's execution until a promise is resolved or rejected. 
//It unwraps the value of the resolved promise.
//Error Handling: Use try...catch blocks within the async function to handle rejected promises, 
//offering a more familiar structure than .catch() chains.
//Promise.all: For running multiple independent asynchronous operations concurrently, 
//use await Promise.all([...]) to wait for all of them to complete and get their results in an array