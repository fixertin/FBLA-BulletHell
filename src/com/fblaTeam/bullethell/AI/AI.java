package com.fblaTeam.bullethell.AI;

import java.awt.Rectangle;

import com.fblaTeam.bullethell.entities.Enemy;
import com.fblaTeam.bullethell.main.Handler;

public abstract class AI {
	public enum AIState{
		Success,
		Failure,
		Running
	}
	
	protected AIState state;
	protected Handler handler;
	protected Enemy e;
	protected Rectangle hitbox;
	
	public AI(Handler handler, Enemy e){
		this.handler = handler;
		this.e = e;
	}
	
	public void start(){
		this.state = AIState.Running;
	}
	public abstract void reset(Enemy e);
	public abstract void tick();
	
	
	protected void succeed(){
		this.state = AIState.Success;
	}
	protected void fail(){
		this.state = AIState.Failure;
	}
	public boolean isSuccess(){
		return state.equals(AIState.Success);
	}
	public boolean isFailure(){
		return state.equals(AIState.Failure);
	}
	public boolean isRunning(){
		return state.equals(AIState.Running);
	}
	public AIState getState(){
		return state;
	}
	
}
