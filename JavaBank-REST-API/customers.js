document.addEventListener("DOMContentLoaded", () => {
  getData("http://localhost:8080/javabank/api/customer/");
  initEventListeners();
});

function initEventListeners() {
  const updateButton = document.getElementById("update-button");
  const resetButton = document.getElementById("reset-button");
  const addButton = document.getElementById("add-button");

  updateButton.addEventListener("click", (e) => {
    e.preventDefault();
    editCustomerForReal();
  });

  resetButton.addEventListener("click", (e) => {
    e.preventDefault();
    customerInUse = null;
  });

  addButton.addEventListener("click", (e) => {
    e.preventDefault();
    addCustomerForReal();
  });
}

function getData(url) {
  fetch(url)
    .then((response) => response.json())
    .then((data) => tableFiller(data))
    .catch((error) => console.error(error));
}

function tableFiller(data) {
  const costumersTable = document.getElementById("customers-table");

  for (let i = 0; i < data.length; i++) {
    const newRow = costumersTable.insertRow();

    const cell1 = newRow.insertCell();
    const cell2 = newRow.insertCell();
    const cell3 = newRow.insertCell();
    const cell4 = newRow.insertCell();
    const cell5 = newRow.insertCell();
    const cell6 = newRow.insertCell();

    cell1.innerHTML = data[i].firstName;
    cell2.innerHTML = data[i].lastName;
    cell3.innerHTML = data[i].email;
    cell4.innerHTML = data[i].phone;
    cell5.innerHTML = `<button id="edit-button" onclick="getCustomer(${data[i].id})">Edit</button>`;
    cell6.innerHTML = `<button id="delete-button" onclick="deleteCustomerForReal(${data[i].id})">Delete</button>`;
  }
}

let customerInUse = null;

async function getCustomer(id) {
  const api = `http://localhost:8080/javabank/api/customer/${id}`;
  const response = await fetch(api);
  const body = await response.json();

  if (!response.ok) {
    throw new Error(body.message);
  }

  customerInUse = id;
  fillCustomerManagement(body);
}

function fillCustomerManagement(body) {
  document.getElementById("input-first-name").value = body.firstName;
  document.getElementById("input-last-name").value = body.lastName;
  document.getElementById("input-email").value = body.email;
  document.getElementById("input-number").value = body.phone;
}

function createCustomerDTO() {
  const customer = {
    firstName: document.getElementById("input-first-name").value,
    lastName: document.getElementById("input-last-name").value,
    email: document.getElementById("input-email").value,
    phone: document.getElementById("input-number").value,
  };

  return customer;
}

async function editCustomerForReal() {
  const customer = createCustomerDTO();

  const api = `http://localhost:8080/javabank/api/customer`;
  const response = await fetch(`${api}/${customerInUse}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(customer),
  });

  location.reload();
}

async function addCustomerForReal() {
  const customer = createCustomerDTO();

  const api = `http://localhost:8080/javabank/api/customer`;
  const response = await fetch(`${api}/`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(customer),
  });

  location.reload();
}

async function deleteCustomerForReal(id) {
  const api = `http://localhost:8080/javabank/api/customer`;
  const response = await fetch(`${api}/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  });

  location.reload();
}
