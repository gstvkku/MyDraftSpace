const form = document.getElementById("form");
const list = document.getElementById("list");

form.addEventListener("submit", (event) => {
  event.preventDefault();

  let product = document.getElementById("product-name").value;
  let amount = document.getElementById("amount").value;

  if (!verifyInputValidity(product, amount)) {
    alert("Invalid input! Please try again.");
    return;
  }

  let li = document.createElement("li");
  let span = document.createElement("span");
  span.textContent = `${amount} x ${product}`;
  let checkBox = document.createElement("input");
  checkBox.type = "checkbox";

  li.appendChild(span);
  li.appendChild(checkBox);
  list.appendChild(li);

  document.getElementById("product-name").value = "";
  document.getElementById("amount").value = "";
});

function verifyInputValidity(product, amount) {
  let validity = product === "" || amount <= 0 ? false : true;
  return validity;
}
