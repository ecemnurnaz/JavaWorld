package edu.sabanciuniv.it526.mbeans;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import edu.sabanciuniv.it526.entity.User;
import edu.sabanciuniv.it526.services.UserService;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	@Inject private UserService userService;

	private List<User> users;
	private User user;
	private String username;
	private String password;

	@PostConstruct
	public void initPage() {

		if (userService.checkData() == null) {

			createUser();
		}
	}

	public String checkUser() {
		
		user = new User();
		users = userService.getAllUsers();
		
		for (User x : users) {
			if(x.getUsername().equals(this.username)) {
				int id = x.getId();
				user=userService.getUserById(id);
			}
		}
		return "result?faces-redirect=true";
	}

	public void createUser() {

		User u1 = new User("admin", "ecem@hotmail.com", "1234");
		u1.setAdmin(true);
		
		User u2 = new User("ecem", "e@abc.com", "123");
		
		userService.save(u1);
		userService.save(u2);
	}
	
	public String logout() {
		 FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        return "/categorylist.xhtml?faces-redirect=true";
	}

	public UserService getLoginService() {
		return userService;
	}

	public void setLoginService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser() {
		this.user.setUsername(this.username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
