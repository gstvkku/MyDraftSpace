const USD = 5.54;
const EUR = 6.42;
const GBP = 7.54;

const form = document.querySelector("form");
const amount = document.getElementById("amount");
const currency = document.getElementById("currency");
const footer = document.querySelector("main footer");
const description = document.getElementById("description");
const result = document.getElementById("result");

amount.addEventListener("input", () => {
const regex = /\D+/g
amount.value = amount.value.replace(regex, "");
})

form.onsubmit = (event) => {
event.preventDefault();

switch (currency.value) {

  case "USD" : 
  convertCurrency(amount.value, USD, "US$");
  break

  case "EUR" :
  convertCurrency(amount.value, EUR, "€");
  break;

  case "GBP" : 
  convertCurrency(amount.value, GBP, "£");
}
}

function convertCurrency (amount, price, symbol) {

try {
description.textContent = `${symbol} 1 = ${formatCurrencyBRL(price)}`;
let total = amount * price;
result.textContent = formatCurrencyBRL(total);
footer.classList.add("show-result");
} catch(error) {
alert("It was not possible to complete the operation, please try again later.")
footer.classList.remove("show-result");
}
}

function formatCurrencyBRL(value) {
  return Number(value).toLocaleString("pt-BR", {
    style: "currency",
    currency: "BRL"
  })
}