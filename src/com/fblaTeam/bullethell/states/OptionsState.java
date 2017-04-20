package com.alexnaustin.bullethell.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.alexnaustin.bullethell.GFX.Assets;
import com.alexnaustin.bullethell.GFX.Background;
import com.alexnaustin.bullethell.main.Handler;
import com.alexnaustin.bullethell.ui.SelectableOption;

public class OptionsState extends State{
	public Background background;
	public SelectableOption[] buttons;
	public int selectedIndex;
	public String option1Message, option2Message;

	public OptionsState(Handler handler) {
		super(handler);
		background = new Background(handler);
		buttons = new SelectableOption[3];
		buttons[0] = new SelectableOption(handler, "Toggle Sound", null, 100, 100);
		buttons[1] = new SelectableOption(handler, "Toggle Music", null, 100, 118);
		buttons[2] = new SelectableOption(handler, "back", handler.getMenuState(), handler.getWidth() - (16*4) - 10, handler.getHeight() - 20);
		buttons[selectedIndex].isSelected = true;
		buttons[0].isActivated = true;
		buttons[1].isActivated = true;
		setOptionMessages();
	}
	
	public void init(){
		
	}

	@Override
	public void tick() {
		background.tick();
		for(int i=0; i<buttons.length; i++){
			buttons[i].tick();
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W) && selectedIndex != 0){
			buttons[selectedIndex].isSelected = false;
			selectedIndex--;
			buttons[selectedIndex].isSelected = true;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S) && selectedIndex < buttons.length-1){
			buttons[selectedIndex].isSelected = false;
			selectedIndex++;
			buttons[selectedIndex].isSelected = true;
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
			buttons[selectedIndex].isActivated = !buttons[selectedIndex].isActivated;
		}
		setOptionMessages();
		if(buttons[0].isActivated)
			handler.setSoundToggle(true);
		else 
			handler.setSoundToggle(false);
			
		if(buttons[1].isActivated)
			handler.setMusicToggle(true);
		else
			handler.setMusicToggle(false);
	}

	@Override
	public void render(Graphics g) {
		background.render(g);
		for(int i=0; i<buttons.length; i++){
			buttons[i].render(g);
		}
		Assets.drawSentence((int)buttons[0].x + 15*16, (int)buttons[0].y, option1Message, g);
		Assets.drawSentence((int)buttons[1].x + 15*16, (int)buttons[1].y, option2Message, g);
	}
	
	private void setOptionMessages(){
		if(buttons[0].isActivated)
			option1Message = "on";
		else
			option1Message = "off";
		
		if(buttons[1].isActivated)
			option2Message = "on";
		else
			option2Message = "off";
	}

}
