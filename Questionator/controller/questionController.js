import questionService from "../service/questionService";
import questionView from "../view/questionView";

export async function init() {
  const question = await questionService.getQuestion;
  questionView.render(question);
}
