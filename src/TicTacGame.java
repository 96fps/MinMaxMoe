
public class TicTacGame {

	public char[][] grid = new char[3][3];
	
	public TicTacGame(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				grid[i][j]='-';	
			}
		}
	}

	public TicTacGame(char[][] parent){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				grid[i][j]=parent[i][j];	
			}
		}
	}


	public void printGrid(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print(" "+grid[j][i]+" ");
				if (j<3-1)
					System.out.print("|");
				else
					System.out.print("\n");
			}
			if (i==2)
				System.out.print("\n");
		}
	}

	public boolean move(int x, int y, char c){
		if( grid[x][y] == '-'){
			grid[x][y] = c;
			return true;
		}
		else
			return false;
	}
	public boolean full(){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(grid[j][i] == '-')
					return false;
			}
		}
		return true;
	}
}
