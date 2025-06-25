const container = document.getElementById("container");

const icon = document.createElement("i");
icon.classList.add("fa-solid", "fa-clover");

const h1 = document.createElement("h1");
h1.textContent = "Randonumber";

const header = document.createElement("header");
header.append(icon, h1);
container.append(header);

const formDiv = document.createElement("div");
formDiv.classList.add("form_div");

const numbersDiv = document.createElement("div");
numbersDiv.classList.add("numbers_div");

const form = document.createElement("form");

function createLabelInput(labelText, inputName, inputType = "number") {
  const wrapper = document.createElement("div");
  wrapper.classList.add("label-input");

  const label = document.createElement("label");
  label.textContent = labelText;
  label.setAttribute("for", inputName);

  const input = document.createElement("input");
  input.setAttribute("type", inputType);
  input.setAttribute("name", inputName);
  input.setAttribute("id", inputName);

  wrapper.append(label, input);
  return wrapper;
}

const amountOfNumbers = createLabelInput("Amount of numbers", "amount_of_numbers");
const minNumber = createLabelInput("Start of break", "min_number");
const maxNumber = createLabelInput("End of break", "max_number");

form.append(amountOfNumbers, minNumber, maxNumber);
formDiv.append(form);

const button = document.createElement("button");
button.textContent = "Submit";
button.classList.add("submit");

button.addEventListener("click", (event) => {
  event.preventDefault();
  if (button.classList.contains("submit")) {
    submitInput();
  } else {
    reset();
  }
});

const main = document.createElement("main");
main.append(formDiv, numbersDiv, button);
container.append(main);

function submitInput() {
  const numbers = document.getElementById("amount_of_numbers");
  const startOfBreak = document.getElementById("min_number");
  const endOfBreak = document.getElementById("max_number");

  const amount = parseInt(numbers.value);
  const min = parseInt(startOfBreak.value);
  const max = parseInt(endOfBreak.value);

  if (isNaN(amount) || isNaN(min) || isNaN(max) || amount <= 0 || min > max) {
    alert("Please enter valid values.");
    return;
  }

  const output = [];

  for (let i = 0; i < amount; i++) {
    const randomNumber = Math.floor(Math.random() * (max - min + 1)) + min;
    output.push(randomNumber);
  }

  numbers.value = "";
  startOfBreak.value = "";
  endOfBreak.value = "";

  generateOutput(output);
}

function generateOutput(output) {
  formDiv.style.display = "none";
  numbersDiv.style.display = "flex";

  output.forEach((number) => {
    const numberDiv = document.createElement("div");
    numberDiv.classList.add("number");
    numberDiv.textContent = number;
    numbersDiv.appendChild(numberDiv);
  });

  button.classList.remove("submit");
  button.classList.add("reset");
  button.textContent = "Reset";
}

function reset() {
  formDiv.style.display = "flex";
  numbersDiv.innerHTML = "";
  numbersDiv.style.display = "none";

  button.classList.remove("reset");
  button.classList.add("submit");
  button.textContent = "Submit";
}
