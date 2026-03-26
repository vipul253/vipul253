// api.createOrder(cart, function () {
//   api.proceedToPayment(function () {
//     api.showOrderSummary(function () {
//       api.updateWallet();
//     });
//   });
// });
// Callback Hell

//When we have a large codebase and multiple apis and have dependency on each other,
//then we fall into callback hell. These codes are tough to maintain. These callback hell
//structure is also known as Pyramid of Doom.
//now lets discuss about Inversion of Control.
//It is very important to understand in order to get comfortable around the concept of promise.
//Inversion of control is like you lose the control of code when we are using callback.

// api.createOrder(cart, function () {
//   api.proceedToPayment();
// });

//Over here we are creating a order and then we are blindly trusting `createOrder` to call `proceedToPayment`
//It is risky, as `proceedToPayment` is important part of code and we are blindly trusting `createOrder` to
//call it and handle it. When we pass a function as a callback, basically we are dependant on our parent
//function that it is his responsibility to run that function. This is called `inversion of control` because
//we are dependant on that function. What if parent function stopped working, what if it was developed by
//another programmer or callback runs two times or never run at all.
//we will see how we can fix such problems.

//A Promise is an object representing the eventual completion or failure of an asynchronous operation
//Promise guarantee, it will callback the attached function once it has the fulfilled data.
//And it will call it only once. Just once.

const cart = ["shoes", "pants", "kurta"];
// Consumer part of promise
const promise = createOrder(cart); // orderId
// Our expectation is above function is going to return me a promise.
console.log(promise);
// It prints Promise {<pending>}, but why?
// Because above createOrder is going to take sometime to get resolved, so pending state. But once
// the promise is resolved, `.then` would be executed for callback promise
//   .then(function (orderId) {
//     proceedToPayment(orderId);
//   })
//   .catch(function (err) {
//     //failure aka reject handling
//     console.log(err);
//   });

// Now we will see, how createOrder is implemented so that it is returning a promise
// In short we will see, "How we can create Promise" and then return it.

// Producer part of Promise
function createOrder(cart) {
  // JS provides a Promise constructor through which we can create promise
  // It accepts a callback function with two parameter `resolve` & `reject`
  const promise = new Promise(function (resolve, reject) {
    // What is this `resolve` and `reject`?
    // These are function which are passed by javascript to us in order to handle success and failure of function call.
    // Now we will write logic to `createOrder`
    /** Mock logic steps
     * 1. validateCart
     * 2. Insert in DB and get an orderId
     */
    // We are assuming in real world scenario, validateCart would be defined
    if (!validateCart(cart)) {
      // If cart not valid, reject the promise
      const err = new Error("Cart is not Valid");
      reject(err);
    }
    const orderId = "12345"; // We got this id by calling to db (Assumption)
    if (orderId) {
      // Success scenario
      setTimeout(() => {
        console.log("dummy delay");
        resolve(orderId);
      }, 3000);
    }
  });
  return promise;
}

function proceedToPayment(cart) {
  return new Promise(function (resolve, reject) {
    // We are assuming in real world scenario, some reject clause will be defined
    if (!validateCart(cart)) {
      //validate not needed here just tp
      // If cart not valid, reject the promise
      const err = new Error("Cart is not Valid");
      reject(err);
    }
    // For time being, we are simply `resolving` promise
    resolve("Payment Successful");
  });
}
function validateCart(cart) {
  cart = null; //lol
  return true;
}
//In promise chaining, whatever is returned from first .then become data for next .then and so on...
//At any point of promise chaining, if promise is rejected, the execution will fallback to .catch
//and others promise won't run.

createOrder(cart)
  .then(function (orderId) {
    // success aka resolved promise handling
    proceedToPayment(orderId);
    return orderId;
  })
  .then(function (orderId) {
    // Promise chaining
    // we will make sure that `proceedToPayment` returns a promise too
    return proceedToPayment(orderId);
  })
  .then(function (paymentInfo) {
    // from above, `proceedToPayment` is returning a promise so we can consume using `.then`
    console.log(paymentInfo);
  })
  .catch(function (err) {
    // failure aka reject handling
    console.log(err);
  });
