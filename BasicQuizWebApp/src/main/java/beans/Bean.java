package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.AnswerDao;
import dao.QuestionDao;
import model.Answer;
import model.Question;

@Named
@SessionScoped
public class Bean implements Serializable{

	@Inject
	AnswerDao answerDao;
	@Inject
	QuestionDao questionDao;
	
	private List<Answer> queAnswers=new ArrayList<Answer>();
	private List<Answer> answers= new ArrayList<Answer>();
	private Question selectedQuestion;
	private int selectedAnsId;
	private Answer trueAnswer = new Answer();
	
	private int queNo;
	private int correctAnswers;
	private int wrongAnswers;
	private int score;
	private boolean isCorrectAnswer;

	@PostConstruct
	public void init() {
		
		this.queNo=1;
		selectedQuestion = questionDao.findRandomQue();
		answers = answerDao.findAll();		//databasedeki tüm cevaplar
		queAnswers = findQueAnswers();		//seçilen sorunun cevapları
		trueAnswer=getCorrectAnswer();
		
		
		//Hocam quiz.xhtmlde selectOneRadio'dan seçilen cevabı alamadım bir türlü dolayısıyla doğru/yanlış/score/tablo doğru çalışmıyor
		
		if(selectedAnsId==trueAnswer.getId()) { 
			correctAnswers++;
		}
		else {wrongAnswers++;}
	}
	public String saveAnsNextQue() { //Verilen cevaba göre doğru veya yanlış sayısı arttıran bir sonraki soruya geçmeye yarayan metot
			queNo++;
			if(queNo==6) {
				score = correctAnswers*20;
				return "final";
			}else {
				selectedQuestion = questionDao.findRandomQue();
				
				queAnswers = new ArrayList<>();
				queAnswers = findQueAnswers();
				trueAnswer=getCorrectAnswer();
				
				if(selectedAnsId==trueAnswer.getId()) {
					correctAnswers++;
				}
				else {wrongAnswers++;}
				
			}
		return null;
	}
	public Answer getCorrectAnswer() { //seçilen soruya göre ona ait doğru cevabı döndüren metot
	
		for (Answer a : queAnswers) {
			if(a.isCorrect()==true ) {
				trueAnswer=a;
				break;
			}
		}
		return trueAnswer;
	}

	public String restartQuiz() {
		
		queAnswers= new ArrayList<Answer>();
		correctAnswers=0;
		wrongAnswers=0;
		init();
		return "quiz";
	}

	public List<Answer> findQueAnswers() { //seçilen soruya göre ona ait cevapları döndüren metot

		int queId = selectedQuestion.getId();

		for (Answer answer : answers) {
			if (answer.getQuestion_id() == queId) {
				queAnswers.add(answer);
			}
		}
		return queAnswers;

	}

	

	public int getSelectedAnsId() {
		return selectedAnsId;
	}
	public void setSelectedAnsId(int selectedAnsId) {
		this.selectedAnsId = selectedAnsId;
	}
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question getSelectedQuestion() {
		return selectedQuestion;
	}

	public Answer getTrueAnswer() {
		return trueAnswer;
	}
	public void setTrueAnswer(Answer trueAnswer) {
		this.trueAnswer = trueAnswer;
	}
	public void setSelectedQuestion(Question selectedQuestion) {
		this.selectedQuestion = selectedQuestion;
	}

	public List<Answer> getQueAnswers() {
		return queAnswers;
	}

	public void setQueAnswers(List<Answer> queAnswers) {
		this.queAnswers = queAnswers;
	}

	public int getQueNo() {
		return queNo;
	}

	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}

	public void setCorrectAnswer(boolean isCorrectAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
	}

}
