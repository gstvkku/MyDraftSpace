const users = require("./users.js");

const filteredArray = users.filter(user => (user.id % 2 !== 0));
const mappedArray = []; 
filteredArray.forEach(person => mappedArray.push(newObject(person.id, person)));

console.log(mappedArray);

