package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

import model.Question;

@SessionScoped
public class QuestionDao implements Serializable{
	
	public List<Question> findAll() {
		
		List<Question> questions = new ArrayList<Question>();
		
		try (Connection connection = ConnectionManager.getConnection()) {

			String query = "select * from question";

			PreparedStatement psmt = connection.prepareStatement(query);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
			Question que = new Question(rs.getInt("id"),rs.getString("text"));
				questions.add(que);

			}
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return questions;
	}
	
	public Question findRandomQue() {
		
		
		Question question = new Question();
		List<Question> questions = new ArrayList<Question>();
		List<Integer> chosenInt = new ArrayList<Integer>();
		
		try (Connection connection = ConnectionManager.getConnection()) {

			String query = "select * from question";

			PreparedStatement psmt = connection.prepareStatement(query);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
			Question que = new Question(rs.getInt("id"),rs.getString("text"));
				questions.add(que);

			}
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random rnd = new Random();
		int selectedNumber = rnd.nextInt(10);
		selectedNumber+=1;
		
		
		for (Question que : questions) {
			if(que.getId()==selectedNumber & !chosenInt.contains(selectedNumber)) {
				question=que;
				chosenInt.add(selectedNumber);
			}
		}
		return question;
	}
}