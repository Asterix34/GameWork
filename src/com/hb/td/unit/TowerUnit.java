package com.hb.td.unit;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.hb.td.graphic.Drawable;
import com.hb.td.graphic.Screen;
import com.hb.unit.Unit;

public class TowerUnit extends Unit implements Drawable {
	
	protected String textureFile;
	protected Image texture;
	
	public static final TowerUnit[] towerArray = new TowerUnit[200];
	
	public static final TowerUnit lightningTower = new TowerLightning(0).setTextureFile("lightning");
	
	public TowerUnit() {
		
	}

	public String getTextureFile() {
		return textureFile;
	}

	public TowerUnit setTextureFile(String textureFile) {
		this.textureFile = textureFile;
		this.texture = new ImageIcon("res/textures/unit/tower/"+textureFile+".png").getImage();
		return this;
	}
	
	@Override
	public void draw(Screen s, Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(texture, this.getPosition().x*Screen.cellWidth+50, this.getPosition().y*Screen.cellHeight+50, Screen.cellWidth, Screen.cellHeight, null);
	}
	

}
