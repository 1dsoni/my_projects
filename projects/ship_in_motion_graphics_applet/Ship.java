/*
<applet code="Ship.class" width="600" height="700"></applet>
*/
import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//to do make the game

public class Ship extends Applet{
	
	@Override
	public String getAppletInfo() {
		return "*************************\nAuthor: diwanshu_soni\n*************************\n (X_X) zzZZ\n";
	}

	private static final long REFRESH_RATE = 1;
	static int i=700, flagStop=0,flagNight=0,flagParty=0,moveWater=0,changeColor=0,flagBirds=0,birdMotion=0,sizeChange=0;
	int l[] = new int[1000];		//coordinates
	int b[] = new int[1000];		//for stars position
	final int a=190;

	Color seaColor=new Color(102,255,255);
	Color shipMiddle=new Color(102,0,0);
	Color chimneyColor=new Color(44,27,18);
	Color windowColor=new Color(204,204,0);
	Color skyColor=new Color(204,255,255);

	Button day;
	Choice cc;
	List cc2;

	@Override
	public void init() {


		for(int ii=0;ii<180;ii++){
			l[ii]=(int)(Math.random()*2000);
			b[ii]=(int)(Math.random()*100);
		}
		//setSize(1300,7200);
		setSize(getMaximumSize());


		cc=new Choice();
		cc.add("Day-time");
		cc.add("Night-time");
		add(cc);
		day=new Button("ok");
		add(day);

		day.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(cc.getSelectedItem().equals("Day-time")){
					flagNight=0;
				}
				else{
					flagNight=1;
				}

			}
		});
		cc2=new List();
		cc2.add("Party!");
		cc2.add("Sleep");
		cc2.add("Birds");
		cc2.add("clear-sky");
		cc2.add("STOP_SHIP");
		cc2.add("RESUME");
		add(cc2);
		cc2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(cc2.getSelectedItem().equals("Party!")){
					flagParty=1;
				}
				else if(cc2.getSelectedItem().equals("Sleep")){
					flagParty=0;
				}
				if(cc2.getSelectedItem().equals("Birds")){
					flagBirds=1;
					birdMotion=0;
				}
				else if(cc2.getSelectedItem().equals("clear-sky")){
					flagBirds=0;
					birdMotion=0;
				}
				if(cc2.getSelectedItem().equals("STOP_SHIP")){
					flagStop=1;
				}else if(cc2.getSelectedItem().equals("RESUME")){
					flagStop=0;
				}
			}
		});
	}
	@Override
	public void start() {
		repaint();
	}

//	public void run ()	{
//		while (true)  {	
//			repaint ();
//			try
//			{	Thread.sleep (REFRESH_RATE);
//			}
//			catch (Exception exc)
//			{}
//		}
//	}

	@Override
	public void paint(Graphics g) {
		//the ALMOST titanic	

		{//water behind the ship
			g.setColor(seaColor);
			g.fillRect(0,600 , 2000,100);
			g.setColor(Color.BLACK);
		}
		
//		{//draw_human
//			g.drawOval(300, 300, 13-sizeChange,15-sizeChange);
//			g.drawOval(300, 315, 8-sizeChange,30-sizeChange);
//			g.drawLine(300-sizeChange, 325-sizeChange, 280+sizeChange, 325+sizeChange);
//			g.drawLine(307, 325, 326, 325);
//			g.drawLine(300, 340, 295, 370);
//			g.drawLine(307, 340, 310, 370);
//		}
//		sizeChange=5;

		g.drawLine(547+i, 279+a, 620+i, 471+a);		//front slant line
		//		g.drawLine(2080+i, 471+a, 2138+i, 324+a);	//back-end slant

		g.drawLine(1790+189+i, 304+a, 2138+i, 304+a);		//the minor lines on back-side 1
		g.drawLine(1790+189+i, 309+a, 2138+i, 309+a);		//2
		g.drawLine(1790+189+i, 314+a, 2138+i, 314+a);		//3
		g.drawLine(1790+189+i, 319+a, 2138+i, 319+a);		//4
		g.drawLine(2138+i, 324+a, 2138+i, 304+a);			//the small perpendicular line at the back-side

		g.drawLine(620+i, 471+a, 2080+i, 471+a);	//bottom line
		//		g.drawLine(566+i, 324+a, 1352+i+(1352-566), 324+a);	// third line from top

		{
			int xx[]={620+i,2080+i,2138+i,563+i,620+i};		//bottom of the ship
			int yy[]={471+a,471+a,324+a,324+a,471+a};		//
			g.setColor(Color.BLACK);						//
			g.fillPolygon(xx, yy, 4);						//
		}

		int xx1[]={564+i,558+i,825+i,842+i};		//upper design lower
		int yy1[]={324+a,306+a,306+a,324+a};		//
		g.fillPolygon(xx1, yy1, 4);					//

		g.setColor(shipMiddle);

		int xx2[]={558+i,547+i,935+i,910+i,842+i,825+i};		//upper design upper
		int yy2[]={306+a,279+a,279+a,324+a,324+a,306+a};		//
		g.fillPolygon(xx2, yy2, 6);								//

		int xx3[]={910+i,935+i,1790+189+i,1790+189+i,910+i};		//upper design long
		int yy3[]={324+a,279+a,279+a,324+a,324+a};					//
		g.fillPolygon(xx3, yy3, 5);									//


		{
			int xx4[]={1979+i, 1979+i,  1790+i, 1790+i, 1862+i, 1862+i, 980+i, 980+i, 1205+i, 1180+i,  952+i,  952+i, 1122+i, 1097+i };		//upper design long
			int yy4[]={279+a,  214+a,    214+a,  159+a,  159+a, 129+a, 129+a, 159+a,  159+a,  204+a,  204+a,  234+a,  234+a, 279+a, };		//
			g.setColor(Color.white);						//
			g.fillPolygon(xx4, yy4, 14);						//
		}


		{//upper windows fill
			int xx5[]={1043+i,1043+i,1205+i,1180+i};
			int yy5[]={204+a,159+a,159+a,204+a};
			g.setColor(Color.LIGHT_GRAY);
			g.fillPolygon(xx5, yy5, 4);
		}


		{//lower windows fill
			int xx6[]={991+i,991+i,1127+i,1097+i};
			int yy6[]={279+a,234+a,234+a,279+a};
			g.fillPolygon(xx6, yy6, 4);
		}

		{//water in front of the ship
			//moveWater=320;
			int times=1;
			g.setColor(seaColor);
			g.fillArc(530+i, 300+320+5, 200-moveWater,200,45,90); g.fillArc(530+i+100-20, 300+320+5, 200-moveWater,200,45,90);
			g.fillArc(530+i+100+100-20, 300+320+5+5, 200-moveWater,200,45,90); g.fillArc(790+i,635, 200-moveWater,200,45,90);

			g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);   g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);  g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);
			g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);   g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);  g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);
			g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);   g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);  g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);
			g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);   g.fillArc(790+i+60*times++,635,200- --moveWater,200,45,90);  g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);
			g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);   g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);  g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);
			g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);   g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);  g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);
			g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);   g.fillArc(790+i+60*times++,635, 200- --moveWater,200,45,90);

			if(moveWater<-100){
				moveWater=20;
			}
		}


		{	//skeleton of ship--black lines
			g.setColor(Color.BLACK);
			g.drawLine(559+i, 306+a, 825+i, 306+a);		// middle line up-to middle slant
			g.drawLine(825+i, 306+a, 842+i, 324+a);		// slant part of middle line design
			g.drawLine(547+i, 279+a, 1097+i, 279+a);	// upper line of the base of ship
			g.drawLine(991+i, 279+a, 991+i, 234+a);		//perpendicular support of 1st floor
			g.drawLine(1060+i, 279+a, 1060+i, 234+a);	//perpendicular support 2 of 1st floor
			g.drawLine(1122+i, 234+a, 1097+i, 279+a);	//upper slant to 2nd  floor
			g.drawLine(1122+i, 234+a,952+i,234+a);		//2nd floor base line
			g.drawLine(952+i,204+a,952+i,234+a);		//2nd floor straight line
			g.drawLine(952+i,204+a,1180+i,204+a);		//2nd floor guard rail
			g.drawLine(1205+i,159+a,1180+i,204+a);		//slant line to 3rd floor --top
			g.drawLine(1205+i,159+a,980+i,159+a);		//3rd floor base
			g.drawLine(1043+i, 159+a, 1043+i, 204+a);		//perpendicular support
			g.drawLine(1127+i, 159+a, 1127+i, 204+a);	//perpendicular support 2
			g.drawLine(980+i,129+a,980+i,159+a);		//3rd floor straight line
			g.drawLine(1862+i,129+a,980+i,129+a);		//3rd floor top top-most line
			g.drawLine(1862+i,129+a,1862+i,159+a);		//perpendicular drop from top floor back-side
			g.drawLine(1862+i,159+a,1790+i,159+a);		//base of 3rd floor back-side
			g.drawLine(1790+i,159+a,1790+i,214+a);		//drop to 1st floor back-side
			g.drawLine(1790+i,214+a,1790+189+i,214+a);		//base of 2nd floor
			g.drawLine(1790+i,204+a,1790+189+i,204+a);
			g.drawLine(1790+189+i,204+a,1790+189+i,214+a);
			g.drawLine(1790+189+i,214+110+a,1790+189+i,214+a);	//drop to floor
		}



		{	//room on top

			{	//upper roof room color-fill
				g.setColor(Color.DARK_GRAY);
				g.fillRect(1054+i, 89+a, 55, 40);		//top floor rectangles
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(1070+i, 109+a, 25, 15);	//top floor inner rectangle
			}
			g.setColor(Color.black);
			g.drawRect(1054+i, 89+a, 55, 40);		//top floor rectangles
			g.drawRect(1070+i, 109+a, 25, 15);	//top floor inner rectangle
		}


		{	//chimney design
			{	//set of chimney blocks upper
				g.setColor(Color.black);
				g.fillRect(1194+i, 24+a, 80, 40);			//top of chimney1
				g.fillRect(1194+i+166, 24+a, 80, 40);		//top of chimney2
				g.fillRect(1194+i+166+166, 24+a, 80, 40);		//top of chimney3
				g.fillRect(1194+i+166+166+166, 24+a, 80, 40);		//top of chimney4
			}
			{	//set of chimney blocks lower
				g.setColor(chimneyColor);
				g.fillRect(1194+i, 24+a+40, 80,105- 40);		//bottom chimney1st
				g.fillRect(1194+i+166, 24+a+40, 80,105- 40);		//bottom chimney2nd
				g.fillRect(1194+i+166+166, 24+a+40, 80, 105- 40);		//bottom chimney3rd
				g.fillRect(1194+i+166+166+166, 24+a+40, 80, 105- 40);	//bottom chimney4th
			}
		}



		//skeleton over..

		//windows
		{
			//		g.setColor(Color.gray); //window panes color
			g.setColor(new Color(224,224,224));
			if(flagNight==1){
				g.setColor(new Color(204,204,0));
			}
			if(flagParty==0){
				g.setColor(Color.gray);
				if(flagNight==0){
					g.setColor(new Color(224,224,224));
				}
			}else if(flagParty==1){
				int[] rr ={255,255,0,128};
				int[] gg={0,153,255,128,128};
				int[] bb={0,0,0,255,128};
				if(changeColor>rr.length-2){
					changeColor=0;
				}
				windowColor=new Color(rr[++changeColor],gg[changeColor],bb[changeColor]);
				g.setColor(windowColor);
			}
			g.fillRect(1230+i, 190+a, 15, 15);
			g.fillRect(1250+i, 190+a, 15, 15);  g.fillRect(1250+i, 159+a, 15, 15);		//the windows upper
			g.fillRect(1270+i, 190+a, 15, 15);  g.fillRect(1270+i, 159+a, 15, 15);	
			g.fillRect(1290+i, 190+a, 15, 15);  g.fillRect(1290+i, 159+a, 15, 15);		
			g.fillRect(1310+i, 190+a, 15, 15);  g.fillRect(1310+i, 159+a, 15, 15);	
			g.fillRect(1330+i, 190+a, 15, 15);  g.fillRect(1330+i, 159+a, 15, 15);		
			g.fillRect(1350+i, 190+a, 15, 15);  g.fillRect(1350+i, 159+a, 15, 15);
			g.fillRect(1370+i, 190+a, 15, 15);  g.fillRect(1370+i, 159+a, 15, 15);		
			g.fillRect(1390+i, 190+a, 15, 15);  g.fillRect(1390+i, 159+a, 15, 15);	
			g.fillRect(1410+i, 190+a, 15, 15);  g.fillRect(1410+i, 159+a, 15, 15);		
			g.fillRect(1430+i, 190+a, 15, 15);  g.fillRect(1430+i, 159+a, 15, 15);	
			g.fillRect(1450+i, 190+a, 15, 15);  g.fillRect(1450+i, 159+a, 15, 15);		
			g.fillRect(1470+i, 190+a, 15, 15);  g.fillRect(1470+i, 159+a, 15, 15);
			g.fillRect(1490+i, 190+a, 15, 15);  g.fillRect(1490+i, 159+a, 15, 15);
			g.fillRect(1510+i, 190+a, 15, 15);  g.fillRect(1510+i, 159+a, 15, 15);		
			g.fillRect(1530+i, 190+a, 15, 15);  g.fillRect(1530+i, 159+a, 15, 15);	
			g.fillRect(1550+i, 190+a, 15, 15);  g.fillRect(1550+i, 159+a, 15, 15);		
			g.fillRect(1570+i, 190+a, 15, 15);  g.fillRect(1570+i, 159+a, 15, 15);	
			g.fillRect(1590+i, 190+a, 15, 15);  g.fillRect(1590+i, 159+a, 15, 15);		
			g.fillRect(1610+i, 190+a, 15, 15);  g.fillRect(1610+i, 159+a, 15, 15);
			g.fillRect(1630+i, 190+a, 15, 15);  g.fillRect(1630+i, 159+a, 15, 15);		
			g.fillRect(1650+i, 190+a, 15, 15);  g.fillRect(1650+i, 159+a, 15, 15);	
			g.fillRect(1670+i, 190+a, 15, 15);  g.fillRect(1670+i, 159+a, 15, 15);		
			g.fillRect(1690+i, 190+a, 15, 15);  g.fillRect(1690+i, 159+a, 15, 15);	
			g.fillRect(1710+i, 190+a, 15, 15);  g.fillRect(1710+i, 159+a, 15, 15);		
			g.fillRect(1730+i, 190+a, 15, 15);  g.fillRect(1730+i, 159+a, 15, 15);
			g.fillRect(1750+i, 190+a, 15, 15);  g.fillRect(1750+i, 159+a, 15, 15);

			g.fillRect(1150+i, 263+a, 15, 15);		//the windows lower
			g.fillRect(1170+i, 234+a, 15, 15);  g.fillRect(1170+i, 263+a, 15, 15);
			g.fillRect(1190+i, 234+a, 15, 15);  g.fillRect(1190+i, 263+a, 15, 15);
			g.fillRect(1210+i, 234+a, 15, 15);  g.fillRect(1210+i, 263+a, 15, 15);
			g.fillRect(1230+i, 234+a, 15, 15);  g.fillRect(1230+i, 263+a, 15, 15);
			g.fillRect(1250+i, 234+a, 15, 15);  g.fillRect(1250+i, 263+a, 15, 15);		
			g.fillRect(1270+i, 234+a, 15, 15);  g.fillRect(1270+i, 263+a, 15, 15);	
			g.fillRect(1290+i, 234+a, 15, 15);  g.fillRect(1290+i, 263+a, 15, 15);		
			g.fillRect(1310+i, 234+a, 15, 15);  g.fillRect(1310+i, 263+a, 15, 15);	
			g.fillRect(1330+i, 234+a, 15, 15);  g.fillRect(1330+i, 263+a, 15, 15);		
			g.fillRect(1350+i, 234+a, 15, 15);  g.fillRect(1350+i, 263+a, 15, 15);
			g.fillRect(1370+i, 234+a, 15, 15);  g.fillRect(1370+i, 263+a, 15, 15);		
			g.fillRect(1390+i, 234+a, 15, 15);  g.fillRect(1390+i, 263+a, 15, 15);	
			g.fillRect(1410+i, 234+a, 15, 15);  g.fillRect(1410+i, 263+a, 15, 15);		
			g.fillRect(1430+i, 234+a, 15, 15);  g.fillRect(1430+i, 263+a, 15, 15);	
			g.fillRect(1450+i, 234+a, 15, 15);  g.fillRect(1450+i, 263+a, 15, 15);		
			g.fillRect(1470+i, 234+a, 15, 15);  g.fillRect(1470+i, 263+a, 15, 15);  
			g.fillRect(1490+i, 234+a, 15, 15);  g.fillRect(1490+i, 263+a, 15, 15);
			g.fillRect(1510+i, 234+a, 15, 15);  g.fillRect(1510+i, 263+a, 15, 15);
			g.fillRect(1530+i, 234+a, 15, 15);  g.fillRect(1530+i, 263+a, 15, 15);
			g.fillRect(1550+i, 234+a, 15, 15);  g.fillRect(1550+i, 263+a, 15, 15);
			g.fillRect(1570+i, 234+a, 15, 15);  g.fillRect(1570+i, 263+a, 15, 15);
			g.fillRect(1590+i, 234+a, 15, 15);  g.fillRect(1590+i, 263+a, 15, 15);
			g.fillRect(1610+i, 234+a, 15, 15);  g.fillRect(1610+i, 263+a, 15, 15);
			g.fillRect(1630+i, 234+a, 15, 15);  g.fillRect(1630+i, 263+a, 15, 15);
			g.fillRect(1650+i, 234+a, 15, 15);  g.fillRect(1650+i, 263+a, 15, 15);
			g.fillRect(1670+i, 234+a, 15, 15);  g.fillRect(1670+i, 263+a, 15, 15);		
			g.fillRect(1690+i, 234+a, 15, 15);  g.fillRect(1690+i, 263+a, 15, 15);	
			g.fillRect(1710+i, 234+a, 15, 15);  g.fillRect(1710+i, 263+a, 15, 15);		
			g.fillRect(1730+i, 234+a, 15, 15);  g.fillRect(1730+i, 263+a, 15, 15);	
			g.fillRect(1750+i, 234+a, 15, 15);  g.fillRect(1750+i, 263+a, 15, 15);		
			g.fillRect(1770+i, 234+a, 15, 15);  g.fillRect(1770+i, 263+a, 15, 15);
			g.fillRect(1790+i, 234+a, 15, 15);  g.fillRect(1790+i, 263+a, 15, 15);		
			g.fillRect(1810+i, 234+a, 15, 15);  g.fillRect(1810+i, 263+a, 15, 15);	
			g.fillRect(1830+i, 234+a, 15, 15);  g.fillRect(1830+i, 263+a, 15, 15);		
			g.fillRect(1850+i, 234+a, 15, 15);  g.fillRect(1850+i, 263+a, 15, 15);	
			g.fillRect(1870+i, 234+a, 15, 15);  g.fillRect(1870+i, 263+a, 15, 15);		
			g.fillRect(1890+i, 234+a, 15, 15);  g.fillRect(1890+i, 263+a, 15, 15);  
			g.fillRect(1910+i, 234+a, 15, 15);  g.fillRect(1910+i, 263+a, 15, 15);
			g.fillRect(1930+i, 234+a, 15, 15);  g.fillRect(1930+i, 263+a, 15, 15);		
			g.setColor(Color.BLACK); //color back to normal
		}

		//night time
		if(flagNight==1)
		{
			setBackground(Color.GRAY);
			//moon
			g.setColor(Color.WHITE);
			g.fillOval(40, 100, 50,55);
			g.setColor(Color.yellow);
			//stars
			for(int ll=0;ll<170;ll++){
				g.drawString("*", l[ll], b[ll]);
			}
		}
		else if(flagNight==0)
		{
			setBackground(skyColor);
			//sun
			g.setColor(Color.yellow);
			g.fillOval(40, 20, 50,55);
			if(flagBirds==1){
				{///birds 
					g.setColor(Color.black);
					int factor=3;
					g.drawString("~", 20+birdMotion, 115);  
					g.drawString("~", 25+birdMotion, 115+3); 
					g.drawString("~", 30+birdMotion, 115+6);	
					g.drawString("~", 35+birdMotion, 115+12);
					g.drawString("~", 40+birdMotion, 115+18); 
					g.drawString("~", 45+birdMotion, 115+24);

					g.drawString("~", 45+birdMotion, 115+24+2);
					g.drawString("~", 40+birdMotion, 115+18+6*factor++);
					g.drawString("~", 35+birdMotion, 115+12+6*factor++); 
					g.drawString("~", 30+birdMotion, 115+6+6*factor++);	
					g.drawString("~", 25+birdMotion, 115+3+6*factor++);
					g.drawString("~", 20+birdMotion, 115+6*factor++); 

					birdMotion++;
					if(birdMotion>1400){
						birdMotion=0;
					}
				}
			}else if(flagBirds==0){
			}
			if(flagStop==0){
				i-=4;
			}else if(flagStop==1){
				i=i;
			}
			try{
				Thread.sleep(30);
				repaint(REFRESH_RATE);
			}catch (Exception e) {

			}	
		}
		
		if(flagBirds==1){
			{///birds 
				int factor=3;
				g.setColor(Color.black);
				g.drawString("~", 20+birdMotion, 115);  
				g.drawString("~", 25+birdMotion, 115+3); 
				g.drawString("~", 30+birdMotion, 115+6);	
				g.drawString("~", 35+birdMotion, 115+12);
				g.drawString("~", 40+birdMotion, 115+18); 
				g.drawString("~", 45+birdMotion, 115+24);

				g.drawString("~", 45+birdMotion, 115+24+2);
				g.drawString("~", 40+birdMotion, 115+18+6*factor++);
				g.drawString("~", 35+birdMotion, 115+12+6*factor++); 
				g.drawString("~", 30+birdMotion, 115+6+6*factor++);	
				g.drawString("~", 25+birdMotion, 115+3+6*factor++);
				g.drawString("~", 20+birdMotion, 115+6*factor++); 

				birdMotion++;
				if(birdMotion>1400){
					birdMotion=0;
				}
			}
		}else if(flagBirds==0){
		}

		//to reset the motion when ship reaches the end
		if(i<=-2115){	
			i=700;			
		}

//		i-=7;			//motion speed 


		//ship-motion up-down			??
		//		if(a>190){
		//			do{
		//				a--;
		//			}while(a>180);
		//		}else{
		//			do{
		//				a++;
		//			}while(a<190);
		//		}
		
		if(flagStop==0){
			i-=4;
		}else if(flagStop==1){
			i=i;
		}
		
		try{
			Thread.sleep(10);
			repaint(REFRESH_RATE);
		}catch (Exception e) {
		}		
	}

	@Override
	public void destroy() {
		System.out.println(getAppletInfo());
	}
}