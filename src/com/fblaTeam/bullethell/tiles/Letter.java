package com.alexnaustin.bullethell.tiles;

public class Letter {
	private char character;
	private boolean isSelected;
	private double x, y;
	
	public Letter(char character, double x, double y){
		this.character = character;
		this.x = x;
		this.y = y;
	}
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
