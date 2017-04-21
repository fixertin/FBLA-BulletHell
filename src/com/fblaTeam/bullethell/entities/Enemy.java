package com.fblaTeam.bullethell.entities;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.fblaTeam.bullethell.AI.AI;
import com.fblaTeam.bullethell.AI.InfinShootStraight;
import com.fblaTeam.bullethell.AI.MoveArc;
import com.fblaTeam.bullethell.AI.MoveTo;
import com.fblaTeam.bullethell.AI.MoveToEdge;
import com.fblaTeam.bullethell.AI.ShootAndMove;
import com.fblaTeam.bullethell.AI.ShootArc;
import com.fblaTeam.bullethell.AI.ShootArcFlurry;
import com.fblaTeam.bullethell.AI.ShootAtPlayer;
import com.fblaTeam.bullethell.AI.ShootCircle;
import com.fblaTeam.bullethell.AI.ShootFlurry;
import com.fblaTeam.bullethell.AI.ShootShotgun;
import com.fblaTeam.bullethell.AI.Wait;
import com.fblaTeam.bullethell.clock.Timer;
import com.fblaTeam.bullethell.main.Handler;

public abstract class Enemy extends Creature{
	protected ArrayList<AI> movements = new ArrayList<AI>();
	protected boolean isRemoved;
	protected boolean isDead;
	protected int scoreReward, health;
	protected Rectangle movementHitbox;
	public Rectangle test = new Rectangle();

	


	public Enemy(Handler handler, double x, double y) {
		super(handler, x, y);
		hitbox = new Rectangle();
		movementHitbox = new Rectangle();
		scoreReward = 100;
		health = 1;
	}
	
	public int getHealth(){
		return health;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public Rectangle getMovementHitbox(){
		return movementHitbox;
	}
	
	public int getScoreReward(){
		return scoreReward;
	}
	public void setScoreReward(int scoreReward){
		this.scoreReward = scoreReward;
	}
	public boolean isRemoved() {
		return isRemoved;
	}
	public void setRemoved(boolean isRemoved) {
		this.isRemoved = isRemoved;
	}
	public void addMovement(double distance, double angle){
		movements.add(new MoveTo(handler, distance, this, angle));
	}
	public void addWait(double time){
		movements.add(new Wait(handler, this, new Timer(time)));
	}
	public void addShootPatternCircle(double shotGap){
		movements.add(new ShootCircle(handler, this, shotGap));
	}
	public void addShootPatternAtPlayer(int amount, double gap){
		movements.add(new ShootAtPlayer(handler, this, amount, gap));
	}
	public void addShootFlurry(double shotGap, double length){
		movements.add(new ShootFlurry(handler, this, shotGap, length));
	}
	public void addMoveToEdge(double angle){
		movements.add(new MoveToEdge(handler, this, angle));
	}
	public void addMoveArc(double distance, double angleChange, double startingAngle, int movementAmount){
		movements.add(new MoveArc(handler, this, distance, angleChange, startingAngle, movementAmount));
	}
	public void addShootShotgun(int minAngle, int cone, int shotAmount){
		movements.add(new ShootShotgun(handler, this, minAngle, cone, shotAmount));
	}
	public void addInfinShootStraight(double shootAngle, double frameGap){
		movements.add(new InfinShootStraight(handler, this, shootAngle, (int)frameGap));
	}
	public void addInfinShootStraightMoving(double shootAngle, double moveAngle, double frameGap){
		movements.add(new InfinShootStraight(handler, this, shootAngle, moveAngle, (int)frameGap));
	}
	public void addShootArc(double shotgap, double startAngle, double arcSize){
		movements.add(new ShootArc(handler, this, shotgap, startAngle, arcSize));
	}
	public void addShootArc(double shotgap, double startAngle, double arcSize, double speed){
		movements.add(new ShootArc(handler, this, shotgap, startAngle, arcSize, speed));
	}
	public void addShootArcFlurry(double shotGap, double length, int arcStart, int arcLength){
		movements.add(new ShootArcFlurry(handler, this, shotGap, length, arcStart, arcLength));
	}
	public void shootAndMove(double distance, double angle, double shootAngle, double frameGap){
		movements.add(new ShootAndMove(handler, distance, this, angle, shootAngle, frameGap));
	}
	public void shootAndMove(double distance, double angle, double shootAngle, double frameGap, double speed){
		movements.add(new ShootAndMove(handler, distance, this, angle, shootAngle, frameGap, speed));
	}
	public ArrayList<AI> getMovements() {
		return movements;
	}
	public void setMovements(ArrayList<AI> movements) {
		this.movements = movements;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
}
