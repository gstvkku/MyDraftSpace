// CUSTOMER "CONSTRUCTOR"

function Customer(name, age) {
  return {
    name,
    age,
  };
}

// FAKE CUSTOMERS

const person1 = Customer("John", 25);
const person2 = Customer("Wafelda", 30);
const person3 = Customer("Malfada", 35);

// GENERIC SERVICE MODULE

const service = function () {
  let serviceName = "✨Best Service✨";
  let customers = [];

  return {
    name: function () {
      return serviceName;
    },
    add: function (customer) {
      customers.push(customer);
      console.log("Customer added.");
    },
    remove: function (customerName) {
      for (let i = customers.length - 1; i > 0; i--) {
        if (customers[i].name === customerName) {
          customers.splice(i, 1);
          console.log("Customer removed.");
          return;
        }
      }
      console.log("This customer don't exists.");
    },
    destroy: function () {
      customers = [];
      console.log("The list was reseted");
    },
    update: function (customerName, customerUpdated) {
      for (let i = 0; customers.length; i++) {
        if (customers[i].name === customerName) {
          customers[i] = customerUpdated;
          console.log("Customer updated.");
          return;
        }
      }
      console.log("This customer don't exists.");
    },
    get: function (customerName) {
      for (let i = 0; customers.length; i++) {
        if (customers[i] === undefined) return "This customer don't exists.";
        if (customers[i].name === customerName) {
          return customers[i];
        }
      }
      return "This customer don't exists."
    },
    list: function () {
        if (customers.length !== 0) 
      return customers;
    },
  };
};

//TEST SECTION

const myService = service();

console.log("\n");
console.log("Testing customers:");
console.log(person1.name);
console.log(person2.age);

console.log("\n");
console.log("Testing name function:");
console.log(myService.name());

console.log("\n");
console.log("Testing add customer:");
myService.add(person1);
myService.add(person2);
myService.add(person3);

console.log("\n");
console.log("Testing list:");
console.log(myService.list());

console.log("\n");
console.log("Testing name function:");
myService.remove("Wafelda");
console.log(myService.list());

console.log("\n");
console.log("Testing get:");
console.log(myService.get("Wafelda"))
console.log(myService.get("Malfada"));

console.log("\n");
console.log("Testing update:");
const person4 = Customer("Álvaro", 28);
myService.update("John", person4);
console.log(myService.list());

console.log("\n");
console.log("Testing destroy:");
console.log(myService.destroy());