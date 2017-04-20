package com.alexnaustin.bullethell.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.alexnaustin.bullethell.worlds.Score;

public class HighscoreReader {
	
	
	public static ArrayList<String> getLines(String path){
		ArrayList<String> lines = new ArrayList<String>();
		String line = null;
		try {
			FileReader fr = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fr);
			while((line = bufferedReader.readLine()) != null)
				lines.add(line);
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void reWriteHighScores(String path, Score[] scores){
		try {
			FileReader fr = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fr);
			BufferedWriter out = new BufferedWriter(new FileWriter(path, false));
			while(bufferedReader.readLine() != null)
				out.write("");
			for(int i=0; i<scores.length; i++){
				if(scores[i] != null){
					out.write(scores[i].getName() + " " + scores[i].getScore());
					out.newLine();
				}
			}
			bufferedReader.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
