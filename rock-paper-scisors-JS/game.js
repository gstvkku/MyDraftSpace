const hand = ["Rock", "Paper", "Scissors"]


const player1 = {
    image: document.getElementById("player1"),
    scoreDisplay: document.getElementById("scoreP1"),
    hand: null,
    score: 0
    }

const player2 = {
    image: document.getElementById("player2"),
    scoreDisplay: document.getElementById("scoreP2"),
    hand: null,
    score: 0
}

function choseRandomHand() {
    let chosenHand = Math.floor(Math.random() * hand.length);
    return hand[chosenHand];
}


function associateHandImage(player) {
    const filename = player.hand.toLowerCase(); 
    player.image.src = `assets/${filename}.png`;
}


function winnerVerification() {
    if (player1.hand === "Rock" && player2.hand === "Scissors" ||
        player1.hand === "Paper" && player2.hand === "Rock" ||
        player1.hand === "Scissors" && player2.hand === "Paper") {
        player1.score++;
        return;
    }
    if(player1.hand === player2.hand){
        return;
    }

    player2.score++;
}

function updateScore(){
    player1.scoreDisplay.textContent = `Score: ${player1.score}`;
    player2.scoreDisplay.textContent = `Score: ${player2.score}`;
}

function playRound() {
    player1.hand = choseRandomHand();
    associateHandImage(player1);

    player2.hand = choseRandomHand();
    associateHandImage(player2);

    winnerVerification();
    updateScore();
}

function initEventListeners() {
    const button = document.getElementById("playButton");
    button.addEventListener("click", playRound);
}

document.addEventListener("DOMContentLoaded", initEventListeners())