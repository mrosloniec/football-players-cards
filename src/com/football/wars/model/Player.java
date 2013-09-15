package com.football.wars.model;

public class Player {

	private int id;
	private String name;
	private Country country;
	private String attack;
	private String defense;
	private int image;

	public Player(int id, String name, Country country, String attack, String defense, int image) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.attack = attack;
		this.defense = defense;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public String getAttack() {
		return attack;
	}

	public String getDefense() {
		return defense;
	}

	public int getImage() {
		return image;
	}
}
