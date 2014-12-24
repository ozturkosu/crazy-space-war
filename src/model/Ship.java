package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point ;
import java.awt.Rectangle;
//import java.awt.Event;
import java.awt.image.BufferedImage ;
import java.io.File;
import javax.imageio.ImageIO;
//import javax.swing.JPanel;

public class Ship extends GameObject 
{
	//Properties
	// Bu classta ship'in 
	
	private  BufferedImage image ;
	//Ben haraket olarak cell tan›mlad›m
	
	//carpısma algoritması için gemi bi circle ve r si var
	final int r=10;
	
	//private int x , y ;
	//Rectangle bounds;
	
	private int lifeEnergy;
	private int shipType ;
	
	private int destroyForce;
	
	public Ship()
	{	
	}
	
	public Ship(int shipType, int x, int y)
	{
	//	this.setShipType(shipType);
		this.setShipTypeImg(shipType);
		this.xPos=x;
		this.yPos=y;
		//this.bounds = bounds;
		this.setLifeEnergy(3) ;
		
	}
	
	//Methods
	
	public boolean moveRight()
	{
		xPos+=cell ;
		//if(!bounds.contains(xPos,yPos))
		//	return false;
		return true;
	}
	
	
	public boolean moveLeft()
	{
		xPos-=cell ;
		//if(!bounds.contains(xPos,yPos))
			//return false;
		return true;
	}
	
	public boolean moveY()
	{
		return true;
	}
	
	public int getShipType()
	{
		return shipType;
	}
	
	public void setShipType(int type)
	{
		shipType = type ;
	}
	
	public void setShipTypeImg(int shipType)
	{
		try{
			String png = "ship"+ shipType +".png";
			System.out.println(png);
			image = ImageIO.read(new File(png));
			System.out.println("as");
		}
		catch(Exception e){
			
		}
		
		this.setShipType(shipType) ;
	}
	public int getLifeEnergy() {
		return lifeEnergy;
	}
	public void setLifeEnergy(int lifeEnergy) {
		this.lifeEnergy = lifeEnergy;
	}
	
	public boolean doesCollideEnemy(Enemy e)
	{
		if(Math.pow(xPos- e.getXpos(),2)+Math.pow(yPos- e.getYpos() ,2) > 4*Math.pow(r, 2) )
			return false;
		else
			return true;
	}

	public boolean doesContain(Point p)
	{
		return Math.pow(xPos-p.x, 2)+Math.pow(yPos- p.y, 2) < Math.pow(r, 2) ;
	}



	public int getDestroyForce() {
		return destroyForce;
	}



	public void setDestroyForce(int destroyForce) {
		this.destroyForce = destroyForce;
	}
	
	
	
}
