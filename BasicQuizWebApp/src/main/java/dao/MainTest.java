package dao;

import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Question;

public class MainTest {
	
	public static void main(String[] args) {
		
		
		
		QuestionDao qDao = new QuestionDao();
		AnswerDao aDao = new AnswerDao();
		Answer a = new Answer();
		Question que = new Question();
		
		List<Answer> alist = new ArrayList<Answer>();
		que=qDao.findRandomQue();
		System.out.println(que);
		alist = aDao.findAll();
		
		for (Answer answer : alist) {
			System.out.println(answer);
		}
		
		
	}
	
	
	

}
