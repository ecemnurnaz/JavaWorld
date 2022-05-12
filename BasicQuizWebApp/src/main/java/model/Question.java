package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {

	private int id;
	private String text;


	public Question() {
	}

	public Question(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	

	@Override
	public String toString() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}

}
