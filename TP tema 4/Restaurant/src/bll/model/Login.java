package bll.model;

import java.io.Serializable;

public class Login implements Serializable{
	private String name;
	private String pass;
	
    public Login(String name, String pass) {
    	this.name=name;
    	this.pass=pass;
    }
    public void setName(String name) {
    	this.name=name;
    }
    public String getName() {
    	return this.name;
    }
    public void setPass(String pass) {
    	this.pass=pass;
    }
    public String getPass() {
    	return pass;
    }
}
