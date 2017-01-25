package com.cricket.webApp.cricketAPP.api;

import java.util.ArrayList;

public class RegisterTeam {

	
	private String teamName;
	private String registerDate;
	private ArrayList<Player> player;
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public ArrayList<Player> getPlayer() {
		return player;
	}
	public void setPlayer(ArrayList<Player> player) {
		this.player = player;
	}
	
	
}
