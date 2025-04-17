function randomColor(element) {
  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);
  const color = `rgb(${r},${g},${b})`;
  element.getElementsByClassName("p")[0].textContent = rgbToHex(r, g, b);
  return color;
}

function rgbToHex(r, g, b) {
  return (
    "#" + [r, g, b].map((valor) => valor.toString(16).padStart(2, "0")).join("")
  );
}

function applyNewColors() {
  const body = document.getElementById("body");

  body.childNodes.forEach((element) => {
    if (element.nodeType === 1) {
      element.style.backgroundColor = randomColor(element);
    }
  });
}

let isRandomOn = false;
let interval = null;

function buttonReaction() {
  if (!isRandomOn) {
    interval = setInterval(applyNewColors, 100);
    isRandomOn = true;
    return;
  }
  clearInterval(interval);
  isRandomOn = false;
}

function initEventListeners() {
  const button = document.getElementById("button");

  button.addEventListener("click", buttonReaction);
}

document.addEventListener("DOMContentLoaded", initEventListeners());
