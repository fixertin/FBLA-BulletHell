package com.alexnaustin.bullethell.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.ui.SelectableOption;

public class HelpState extends State{
	private SelectableOption back = new SelectableOption(handler, ">back", handler.getMenuState(), handler.getWidth()-60*5, handler.getHeight()-32);
	
	public HelpState(Handler handler) {
		super(handler);
		
	}

	@Override
	public void tick() {
		back.tick();
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
			back.isActivated = true;
		}
	}

	@Override
	public void render(Graphics g) {
		Assets.drawSentence(50, 100, "press  w  to move up", g);
		Assets.drawSentence(50, 100+(17), "press  a  to move left", g);
		Assets.drawSentence(50, 100+(17*2), "press  s  to move down", g);
		Assets.drawSentence(50, 100+(17*3), "press  d  to move right", g);
		Assets.drawSentence(50, 100+(17*6), "press  esc  exit game", g);
		Assets.drawSentence(50, 100+(17*4), "hold  shift  to move slower", g);
		back.render(g);
		
	}

}
