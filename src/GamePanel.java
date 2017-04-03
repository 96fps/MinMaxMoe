import java.awt.Color;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;
import javax.imageio.*;


import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements MouseListener, KeyListener, ActionListener {
	static public boolean running=true;
	
	static public boolean controls;
	double itter=.025;
	Timer clock= new Timer((int)(itter*1000), this);
	double time=0;
	Controlset c= new Controlset();
	int sceneID=0;
	boolean playersTurn = true;

	pos2d gameRes=new pos2d(256,256);
	menuScene menu= new menuScene();
	
	@Override
	public void actionPerformed(ActionEvent e) {//new game "tick"
		time+=itter;
		
		
		if(running){
			menu.dologicTick(c, itter);
		}
			
		repaint();
		//scenerepaint
		
	}	
	
	GamePanel()
	{
		clock.start();
		addKeyListener(this);

		setFocusable(true);
		
		addMouseListener(this);
		
		setPreferredSize(new Dimension((int)gameRes.x, (int)gameRes.y));
		
		repaint();
			
		
	}
	

	public void paintComponent(Graphics g)
	{	
		menu.render(g,gameRes);		
	}
	
	public void mouseClicked(MouseEvent e)
	{	
		if(sceneID==0){
			int i = (e.getX()-32)/64;
			int j = (e.getY()-32)/64;

			char playerChar = '-';
			if(playersTurn) 
				playerChar = 'x';
			else 
				playerChar = 'o';

			if(i>=0 && i<3 && j>=0 && j<3){
				if(menu.tacky.move(i,j,playerChar)){
					menu.tacky.printGrid();
					playersTurn = !playersTurn;
				}
				else{
					if(menu.tacky.full()){
						System.out.println("resetting");
						menu.tacky = new TicTacGame();
					}
					else
						System.out.println("try another move");
				}
			}
		}
	}

	@Override
	
	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			controls=true;
		}
	/*	if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			controls=!control;
		}*/
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			controls=false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}