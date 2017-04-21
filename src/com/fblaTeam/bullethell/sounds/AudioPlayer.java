package com.fblaTeam.bullethell.sounds;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class AudioPlayer {
	public static Map<String, Sound> soundMap = new HashMap<String, Sound>();
	public static Map<String, Music> musicMap = new HashMap<String, Music>();

	public static void init(){
		try {
			soundMap.put("shoot", new Sound("/res/sounds/shoot.ogg"));
			soundMap.put("explosion", new Sound("/res/sounds/explosion.ogg"));
			soundMap.put("select", new Sound("/res/sounds/select.ogg"));
			
			musicMap.put("test", new Music("/res/sounds/test.ogg"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Music getMusic(String key){
		return musicMap.get(key);
	}
	
	public static Sound getSound(String key){
		return soundMap.get(key);
	}

}
