package model;

import java.util.Objects;

public class Answer{

	private int id;
	private int question_id;
	private String option;
	private String text;
	private boolean isCorrect;
	
	private Question question;
	
	
	public Answer() {
	}
	
	public Answer(int id, int question_id, String option, String text, boolean isCorrect) {
		super();
		this.id = id;
		this.question_id = question_id;
		this.option = option;
		this.text = text;
		this.isCorrect = isCorrect;
	}


	

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		return Objects.equals(text, other.text);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setquestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
