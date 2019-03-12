package br.ucsal.game;

import java.util.Random;
import javax.swing.JOptionPane;

public class Game{

	static final Random RD = new Random();
	static int baseRange = 1;
	static int topRange = 100;

	public static void main(String[] args){
		int numberGen = Game.generateNum();

		for(int i = 0; i < 10;){
			int userNum = Game.readNum();
			if(Game.result(numberGen, userNum))
				break;
			++i;
			if(i == 10)
				JOptionPane.showMessageDialog(null, "Você falhou!");
			
		}
	}

	private static int generateNum(){
		return (Game.RD.nextInt(100) + 1);
	}

	private static int readNum(){
		return new Integer(JOptionPane.showInputDialog(String.format("Informe um número de %d a %d", Game.baseRange, Game.topRange)));
	}

	private static boolean result(int value, int user){
		boolean win = false;
		if(user == value){
			JOptionPane.showMessageDialog(null, "Você acertou!");
			win = true;
		}
		else if(user > value){
			JOptionPane.showMessageDialog(null, "O valor é menor!");
			Game.topRange = user <= Game.topRange ? user - 1 : Game.topRange;
		}
		else{
			JOptionPane.showMessageDialog(null, "O valor é maior!");
			Game.baseRange = user >= Game.baseRange ? user + 1 : Game.baseRange;
		}
		return win;
	}
}