import java.awt.Color;
import java.awt.Graphics;


public class menuScene extends Scene{

	int turnsIn=0;
	TicTacGame tacky = new TicTacGame();

	public menuScene(){
		//build

	}
	public void dologicTick(Controlset c, double itter){
		//do logic
	}
	public void render(Graphics g, pos2d gameRes){
		
		g.setColor(Color.black);
		g.fillRect(0, 0, (int)gameRes.x, (int)gameRes.y);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(32, 0, (int)gameRes.x-64, 32);
		g.setColor(Color.white);
		g.drawString("Min-Max-Moe",32+10,32-10);
				
		g.setColor(new Color(32,32,32));
		g.fillRect(32, 32, (int)gameRes.x-64, (int)gameRes.y-64);
		
		g.setColor(new Color(64,64,64,64));
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				g.fillRect(32+2 + 64*i,32+2 + 64*j,64-4,64-4);
			}
		}
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(tacky.grid[i][j]=='x'){
					g.setColor(Color.black);
					g.fillRect(32+16 + 64*i,32+16 + 64*j,64-32,64-32);
				}
				if(tacky.grid[i][j]=='o'){
					g.setColor(Color.white);
					g.fillRect(32+16 + 64*i,32+16 + 64*j,64-32,64-32);
				}
			}
		}
		
	}
}
