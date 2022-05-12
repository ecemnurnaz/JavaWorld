package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Answer;

@SessionScoped
public class AnswerDao implements Serializable {

	  public List<Answer> findAll() {
	  
		  List<Answer> answers = new ArrayList<Answer>();
	  
	  try (Connection connection = ConnectionManager.getConnection()) {
	  
	  String query = "select * from answer";
	  
	  PreparedStatement psmt = connection.prepareStatement(query);
	  
	  ResultSet rs = psmt.executeQuery();
	  
	  while (rs.next()) { 
		  Answer ans = new Answer(rs.getInt("id"),rs.getInt("question_id"),rs.getString("option"),rs.getString("text"),rs.getBoolean("iscorrect")); 
		  answers.add(ans);
	  
	  }
	  
	  } catch (SQLException e) { // TODO Auto-generated catch block
	  e.printStackTrace(); }
	  
	  return answers;
	  
	  }
	  
	 
}
