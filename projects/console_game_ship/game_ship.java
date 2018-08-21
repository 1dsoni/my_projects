import java.util.Scanner;
public class game_ship {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameMain gameMain = new GameMain();
		do{
			gameMain.initShit();
			gameMain.winCondition();
			System.out.println("THANK YOU FOR PLAYING\nPLAY AGAIN? : y\n");
		}while(sc.nextLine().equals("y"));
		System.out.println("GAME OVER");
		for(int i=0; i<10;i++){
			System.out.print("+.");
		}
		System.out.print("| developed by diwanshu |");
		for(int i=0; i<10;i++){
			System.out.print("+.");
		}
	}
	
}

class GameMain {
	
	//game looks
	private static final char USER_INIT = 'u', PC_INIT = 'p', DESTROYED = 'X', SAFE_ = 'O';
	
	private String user ;	//the name of player
	
	private int row;
	private char[][] seamatrix ;
	private int[] userShips, pcShips, doneSpots ;

	private int counter = 0;
	
	private int uC=0, pC=0;  //keeps note of winner 
	
	private Scanner sc ;
	
	public GameMain() {
		sc = new Scanner(System.in);
	}
	
	public void initShit(){

		System.out.println("WelCome TO THE LUCK_FIGHTERS");
		System.out.println("Enter max no. of rows for grid of size NxN");
		row = sc.nextInt();
		while(row<2){
			System.out.println("INVALID input rows must be atleast 2");
			row = sc.nextInt();
		}
		System.out.println("Enter A UserName");
		sc.nextLine();	//enter key buffer removal
		user = sc.nextLine();
		
		seamatrix = new char[row][row]; //creates the main grid
		doneSpots = new int[row*row];  //storing all the moves which cannot be redone
		userShips = new int[row];  //stores init user pos
		pcShips = new int[row];    //stores init pc pos
		
		counter=0;
		uC=0; pC=0;
	}
	private void play(){
		userChance();
		pcChance();
	}
	
	public Boolean winCondition(){
		
		firstTurn();
		while (pC < row && uC < row){
			
			play();
			System.out.println("Score \n"+user+ "- "+uC);
			System.out.println("pc- "+pC);
		}
		System.out.println("Winner is : " +(uC>pC ? user:uC==pC? "DRAW":"PC"));
		return false;
		
	}
	
	private Boolean pcChance(){
		try{
			System.out.println("Pc Turn");
			Thread.sleep(1000);
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		int t = randomVal();
		while(!(validTurn(t)) || (containsCopy(t, pcShips) != -1) || (containsCopy(t, doneSpots) != -1)){
			t = randomVal();
		}
		
		if (containsCopy(t, userShips) > 0){
			pC++;
			attack(t, DESTROYED);
			return true;
		}else{
			attack(t, SAFE_);
		}
		return false;
	}
	private Boolean userChance(){
		System.out.println(user+" Turn");
		int t = sc.nextInt();
		
		while((!validTurn(t)) || (containsCopy(t, userShips) != -1) || (containsCopy(t, doneSpots) != -1)){
			System.out.println("Invalid Value!");
			t = sc.nextInt();
		}
		if ( containsCopy(t, pcShips) > 0){
			uC++;
			attack(t, DESTROYED);
			return true;
		}else{
			attack(t, SAFE_);
		}
		return false;
	}
	
	private void pcFirstRun(){
		System.out.println("pc deploying ships.. done");
		int tempCounter = 0;
		while(tempCounter < row){
			int num = randomVal();
			if(!(containsCopy(num, userShips)>=0)&&!(containsCopy(num, pcShips)>=0)&&validTurn(num)){
				pcShips[tempCounter++] = num;
			}
			else{
			}
		}
		//processInputUser(pcShips, 'p');
		//showSea();
	}
	
	private void firstTurn(){
		System.out.println(user+" enter "+row+" different cordinates (1 to "+(row*row)+") to deploy the ships");
		int tempCounter = 0;
		while(tempCounter < row){
			int num = sc.nextInt();
			if(!(containsCopy(num, userShips)>=0)&&validTurn(num)){
				userShips[tempCounter++] = num;
			}
			else{
				System.out.println("NOt Allowed Duplicate/out Of Index value!! : "+ num);
			}
		}
		System.out.println(user+" deployed Ships");
		processInputUser(userShips, USER_INIT);
		showSea();
		System.out.println();
		pcFirstRun();
		System.out.println();
	}
	
	private void attack(int i, char type){
		doneSpots[counter++] = i;
		int a, b;
		i = i-1;	a = i/row;	b = i%row;
		if (a<0)		//to convert to cordinates
			a=0;
		if (b<0)
			b=0;
		seamatrix[a][b]=type;
		showSea();
	}
	
	private void processInputUser(int[] array, char val){
		for (int i : array){
			int a, b;
			i = i-1;
			a = i/row;
			b = i%row;
			seamatrix[a][b]=val;
		}
	}
	
	private int containsCopy(int n, int[] array){
		for (int i =0 ; i<array.length; i++){
			if (n == array[i]){
				return i+1;
			}
		}
		return -1;
	}
	
	private void showSea(){
		int counterr = 1;
		for (int i =0; i <row;i++){
			for (int j=0; j <row; j++){
				System.out.print(seamatrix[i][j]+" |"+counterr++ +"|"+"\t"); //   +" |"+counter++ +"|"
			}	
			System.out.println();
		}
	}	
	
	private Boolean validTurn(int num){
		if (num >=1 && num <= row*row){
			return true;
		}
		return false;
	}
	
	private int randomVal(){
		return (1+ (int) (Math.random()*(row*row)));
	}
	
}
