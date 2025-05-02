async function getQuestion() {
  try {
    const question = await connectWithTrivia();
    return question;
  } catch (error) {
    console.error("Erro ao obter questões:", error);
  }
}

async function connectWithTrivia() {
  const api = `https://opentdb.com/api.php?amount=1&difficulty=medium&type=multiple`;
  const response = await fetch(api);
  const body = await response.json();

  if (!response.ok) {
    throw new Error(body.message);
  }

  return body;
}

export default { getQuestion };
