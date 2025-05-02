const box = document.querySelector("#box");

function move({ target }) {

  const actualPosition = parseInt(getComputedStyle(target).left);

  if (actualPosition > 300) {
    target.style.left = actualPosition - 15 + "px";
    return;
  }
  
  target.style.left = actualPosition + 15 + "px";
}

box.addEventListener("click", (box) => {
  move(box);
});
