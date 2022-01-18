package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.game.input.KeyInput;

public class Menu 
{		
	public static enum STATE { Play, Help, Quit};
	public static STATE menuState = STATE.Play;
	
	private boolean play;
	private boolean help;
	private boolean quit;

	public void tick()
	{
			play = menuState == STATE.Play;
			help = menuState == STATE.Help;
			quit = menuState == STATE.Quit;	
	
			if(play && KeyInput.menuEnter)
				Game.gameState = Game.STATE.Game;
			else if(quit && KeyInput.menuEnter)
				System.exit(-1);
	}
	
	public void render(Graphics g)
	{
		Font font = new Font("Impact", 1, 28);
		g.setFont(font);

		
		if(Game.gameState == Game.STATE.Menu)
		{
			if(play)
			{
				g.setColor(Color.GREEN);
				g.drawString(">Oyun", 100, 400);
				g.drawString("Yardım/Oynanış", 100, 450);
				g.drawString("Çıkış", 100, 500);
			}
			else if(help)
			{
				g.setColor(Color.GREEN);
				g.drawString("Oyun", 100, 400);
				g.drawString(">Yardım/Oynanış", 100, 450);
				g.drawString("Çıkış", 100, 500);
			}
			else if(quit)
			{
				g.setColor(Color.GREEN);
				g.drawString("Oyun", 100, 400);
				g.drawString("Yardım/Oynanış", 100, 450);
				g.drawString(">Çıkış", 100, 500);
			}
		}
		else if(Game.gameState == Game.STATE.Help)
		{
			g.setColor(Color.red);
			g.drawString("************Kontroller***********", 25, 400);
			g.drawString("1-Sol veya Sağa yönelmek için A/D ya da Yön tuşlarını Kullanın.", 25, 430);
			g.drawString("2-Ateş etmek için SPACE ye basın.", 25, 460);
			g.drawString("3-Geri Gitmek İçin Enter a basın", 25, 490);
		}
	}
}
