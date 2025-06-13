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
  li.classList.add("listElement");

  let span = document.createElement("span");
  span.textContent = `${amount} x ${product}`;

  let checkBox = document.createElement("input");
  checkBox.type = "checkbox";
  checkBox.addEventListener("click", () =>
    li.classList.contains("checked")
      ? li.classList.remove("checked")
      : li.classList.add("checked")
  );

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

