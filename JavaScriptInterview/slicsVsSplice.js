// the primary difference between slice and splice is that slice is non-destructive (it returns a copy), 
// while splice is destructive (it modifies the original array)

const colors = ["red", "green", "blue", "yellow"];
const subset = colors.slice(1, 3); // Extracts from index 1 to 2
// (start, end) (end index not inclusive).
console.log(subset); // ["green", "blue"]
console.log(colors); // ["red", "green", "blue", "yellow"] (Unchanged)


const fruits = ["apple", "banana", "cherry"];
// Remove 1 item at index 1 and add 'orange'
const removed = fruits.splice(0, 1, "orange", "mango");
// (start, deleteCount, item1, item2, ...)
console.log(fruits); // ["apple", "orange", "cherry"] (Modified)
console.log(removed); // ["banana"] (The deleted item)
