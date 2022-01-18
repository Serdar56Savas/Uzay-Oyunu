package com.game.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet 
{
	private final float x;
	private float y, velY;
	private ObjectId id;
	private int width = 2, height = 4;
	private Color color = new Color(240, 240, 240);
	
	public Bullet(float x, float y, float velY)
	{
		this.x = x;
		this.y = y;
		this.velY = velY;
		this.id = ObjectId.Bullet;
	}
	
	public void tick()
	{
		y += velY;
	}
	
	public void render(Graphics g)
	{
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public float getY() { return y;}
	public ObjectId getId() { return id;}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, width, height);
	}
}
