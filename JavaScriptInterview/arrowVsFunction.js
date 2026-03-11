"use strict";
const name = "Angular";
var person = {
  name: "react",
  age: 30,
  getDetail: function () {
    console.log("getDetail " + this.name);
  },
  getName: () => {
    console.log("getName " + this.name);
  },
};
person.getDetail();
person.getName(); // undefined as arrow function does not have its own this binding
