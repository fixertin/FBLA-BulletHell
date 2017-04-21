package com.fblaTeam.bullethell.GFX;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Assets {
	public static BufferedImage player, pBullet, eBullet, enemy, ui, select, selectedLetter, lifeIcon, titleScreen, largeBullet, largeBulletChild,
								smallShipB, smallShipBr, smallShipP, smallShipR, tankShip, smallShip2;
	public static BufferedImage[] pBulletA, eBulletA, explosion, playerRespawn;
	public static HashMap<Character, BufferedImage> letterMap = new HashMap<Character, BufferedImage>();
	public static HashMap<Character, BufferedImage> letterMap32 = new HashMap<Character, BufferedImage>();
	
	public static final int WIDTH = 64, HEIGHT = 64;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet.png"));
		player = sheet.crop(0, 0, WIDTH, HEIGHT);
		pBullet = sheet.crop(0, 4, WIDTH, HEIGHT);
		
		
		pBulletA = new BufferedImage[3];
		pBulletA[0] = sheet.crop(0, 4, WIDTH, HEIGHT);
		pBulletA[1] = sheet.crop(1, 4, WIDTH, HEIGHT);
		pBulletA[2] = sheet.crop(2, 4, WIDTH, HEIGHT);
		
		eBulletA = new BufferedImage[3];
		eBulletA[0] = sheet.crop(0, 5, WIDTH, HEIGHT);
		eBulletA[1] = sheet.crop(1, 5, WIDTH, HEIGHT);
		eBulletA[2] = sheet.crop(2, 5, WIDTH, HEIGHT);
		
		playerRespawn = new BufferedImage[8];
		playerRespawn[0] = sheet.crop(1, 0, WIDTH, HEIGHT);
		playerRespawn[1] = sheet.crop(2, 0, WIDTH, HEIGHT);
		playerRespawn[2] = sheet.crop(3, 0, WIDTH, HEIGHT);
		playerRespawn[3] = sheet.crop(4, 0, WIDTH, HEIGHT);
		playerRespawn[4] = sheet.crop(5, 0, WIDTH, HEIGHT);
		playerRespawn[5] = sheet.crop(6, 0, WIDTH, HEIGHT);
		playerRespawn[6] = sheet.crop(7, 0, WIDTH, HEIGHT);
		playerRespawn[7] = sheet.crop(8, 0, WIDTH, HEIGHT);
		
		explosion = new BufferedImage[10];
		for(int i=0; i<10; i++){
			explosion[i] = sheet.crop(i, 7, WIDTH, HEIGHT);
		}
		
		fillLetters("/textures/alphebetSpritesheet.png", letterMap, 16, 16);
		fillLetters("/textures/alphebetSpritesheet32.png", letterMap32, 32, 32);
		
		enemy = sheet.crop(0, 3, WIDTH, HEIGHT);
		tankShip = sheet.crop(1, 3, WIDTH, HEIGHT);
		smallShipR = sheet.crop(2, 3, WIDTH, HEIGHT);
		smallShipBr = sheet.crop(4, 3, WIDTH, HEIGHT);
		smallShipB = sheet.crop(5, 3, WIDTH, HEIGHT);
		smallShipP = sheet.crop(3, 3, WIDTH, HEIGHT);
		smallShip2 = sheet.crop(6, 3, WIDTH, HEIGHT);
		
		//eBullet = sheet.crop(0, 5, WIDTH, HEIGHT);
		largeBullet = sheet.crop(3, 4, WIDTH, HEIGHT);
		largeBulletChild = sheet.crop(4, 4, WIDTH, HEIGHT);
		ui = ImageLoader.loadImage("/textures/ui.png");
		selectedLetter = ImageLoader.loadImage("/textures/selectedLetter.png");
		titleScreen = ImageLoader.loadImage("/textures/titleScreen.png");
	}
	
	public static void fillLetters(String path, HashMap<Character, BufferedImage> map, int w, int h){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(path));
		map.put('a', sheet.crop(0, 0, w, h));
		map.put('b', sheet.crop(1, 0, w, h));
		map.put('c', sheet.crop(2, 0, w, h));
		map.put('d', sheet.crop(3, 0, w, h));
		map.put('e', sheet.crop(4, 0, w, h));
		map.put('f', sheet.crop(5, 0, w, h));
		map.put('g', sheet.crop(0, 1, w, h));
		map.put('h', sheet.crop(1, 1, w, h));
		map.put('i', sheet.crop(2, 1, w, h));
		map.put('j', sheet.crop(3, 1, w, h));
		map.put('k', sheet.crop(4, 1, w, h));
		map.put('l', sheet.crop(5, 1, w, h));
		map.put('m', sheet.crop(0, 2, w, h));
		map.put('n', sheet.crop(1, 2, w, h));
		map.put('o', sheet.crop(2, 2, w, h));
		map.put('p', sheet.crop(3, 2, w, h));
		map.put('q', sheet.crop(4, 2, w, h));
		map.put('r', sheet.crop(5, 2, w, h));
		map.put('s', sheet.crop(0, 3, w, h));
		map.put('t', sheet.crop(1, 3, w, h));
		map.put('u', sheet.crop(2, 3, w, h));
		map.put('v', sheet.crop(3, 3, w, h));
		map.put('w', sheet.crop(4, 3, w, h));
		map.put('x', sheet.crop(5, 3, w, h));
		map.put('y', sheet.crop(0, 4, w, h));
		map.put('z', sheet.crop(1, 4, w, h));
		map.put('0', sheet.crop(2, 4, w, h));
		map.put('1', sheet.crop(3, 4, w, h));
		map.put('2', sheet.crop(4, 4, w, h));
		map.put('3', sheet.crop(5, 4, w, h));
		map.put('4', sheet.crop(0, 5, w, h));
		map.put('5', sheet.crop(1, 5, w, h));
		map.put('6', sheet.crop(2, 5, w, h));
		map.put('7', sheet.crop(3, 5, w, h));
		map.put('8', sheet.crop(4, 5, w, h));
		map.put('9', sheet.crop(5, 5, w, h));
		map.put(' ', ImageLoader.loadImage("/textures/space.png"));
		map.put('>', ImageLoader.loadImage("/textures/SelectArrow.png"));
		map.put('*', ImageLoader.loadImage("/textures/life.png"));
	}
	
	public static BufferedImage getLetter(char letter){
		return letterMap.get(letter);
	}
	public static BufferedImage[] getSentence(String sentence, HashMap<Character, BufferedImage> map){
		BufferedImage[] images = new BufferedImage[sentence.length()];
		char[] chars = sentence.toCharArray();
		for(int i=0; i<chars.length; i++){
			images[i] = map.get(chars[i]);
		}	
		return images;
	}
	
	public static void drawSentence(int x, int y, String sentence, Graphics g){
		BufferedImage[] images = getSentence(sentence.toLowerCase(), letterMap);
		for(int i = 0; i<sentence.length(); i++){
			g.drawImage(images[i], x + (16*i), y, null);
		}
	}
	
	public static void drawSentence32(int x, int y, String sentence, Graphics g){
		BufferedImage[] images = getSentence(sentence.toLowerCase(), letterMap32);
		for(int i = 0; i<sentence.length(); i++){
			g.drawImage(images[i], x + (32*i), y, null);
		}
	}
	

	
}
