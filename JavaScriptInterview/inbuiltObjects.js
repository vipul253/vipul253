let d1 = new Date();
console.log(d1 + "");


let b1 = new Boolean();
console.log(b1); //false
console.log(new Boolean());//false
console.log(new Boolean(""));//false
console.log(new Boolean(" "));//true
console.log(new Boolean(false));//false
console.log(new Boolean(true));//true
console.log(new Boolean("false"));//true
console.log(new Boolean("true"));//true
console.log(new Boolean(-1));//true
console.log(new Boolean(2));//true
console.log(new Boolean(-2));//true
console.log(new Boolean(0));//false
console.log(new Boolean(1));//true


let n1 = new Number();
console.log(n1);//0
console.log(new Number());//0
console.log(new Number(""));//0
console.log(new Number(" "));//0
console.log(new Number(11));//11
console.log(new Number("11"));//11
console.log(new Number(false));//0
console.log(new Number(true));//1


function abc() {
  {
    a = 10; // this gets global scope as we dont even define is as var
    var b = 11; // function scoped
    let c = 12; // block scoped
    console.log("inside block a" + a);
    console.log("inside block b" + b);
    console.log("inside block c" + c);
  }
  console.log("outside block a" + a);
  console.log("outside block b" + b);
  //console.log("outside block c" + c);
}
abc();
console.log("outside func a" + a);
//console.log("outside func b" + b);
var add = function (a, b) {
  console.log(a + b);
};
var add = function (a, b, c) {
  //overrides add declared above
  console.log(a + b + c);
};
var add = function (a, ...b) {
  //rest operator
  //overrides add declared above
  let res = a;
  for (let i = 0; i < b.length; i++) {
    res = res + b[i];
  }
  console.log(res);
};

add(10, 20);
add(10, 20, 30);
add(10, 20, 30, 40);
