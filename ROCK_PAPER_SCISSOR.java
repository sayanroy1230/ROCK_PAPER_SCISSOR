import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ROCK_PAPER_SCISSOR implements ActionListener{
	int comscore=0;
	int userscore=0;
	int count=0;
	int round=1;
	Random rand=new Random();
	JFrame frame= new JFrame("ROCK_PAPER_SCISSOR");
	JLabel uppertext=new JLabel();	
	JLabel computer=new JLabel();	
	JLabel compscore=new JLabel();
	JLabel you=new JLabel();	
	JLabel yourscore=new JLabel();
	JLabel cmove=new JLabel();
	JLabel crps=new JLabel();
	JLabel vs=new JLabel();
	JLabel ymove=new JLabel();
	JButton specialbutton = new JButton();
    ImageIcon rock = new ImageIcon(new ImageIcon("image\\rock.jpg").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
    ImageIcon paper = new ImageIcon(new ImageIcon("image\\paper.jpg").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
    ImageIcon scissor = new ImageIcon(new ImageIcon("image\\scissor.jpg").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
    JButton rockbutton = new JButton(rock);
	JButton paperbutton = new JButton(paper);
	JButton scissorbutton = new JButton(scissor);
	
	ROCK_PAPER_SCISSOR(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(530,75,500,650);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(192,192,192));
		frame.setVisible(true);
		frame.setResizable(false);
		
		uppertext.setBackground(Color.black);
		uppertext.setForeground(Color.green);
		uppertext.setFont(new Font("Verdana",Font.BOLD,30));
		uppertext.setHorizontalAlignment(JLabel.CENTER);
		uppertext.setText("ROUND 1");
		uppertext.setOpaque(true);
		uppertext.setBounds(0,0,500,50);
		
		computer.setBackground(Color.black);
		computer.setForeground(Color.red);
		computer.setFont(new Font("Verdana",Font.BOLD,25));
		computer.setHorizontalAlignment(JLabel.CENTER);
		computer.setText("COMPUTER");
		computer.setOpaque(true);
		computer.setBounds(0,70,165,50);
		
		compscore.setForeground(Color.red);
		compscore.setFont(new Font("Verdana",Font.BOLD,35));
		compscore.setHorizontalAlignment(JLabel.CENTER);
		compscore.setText("0");
		compscore.setBounds(0,115,165,50);
		
		you.setBackground(Color.black);
		you.setForeground(Color.blue);
		you.setFont(new Font("Verdana",Font.BOLD,25));
		you.setHorizontalAlignment(JLabel.CENTER);
		you.setText("YOU");
		you.setOpaque(true);
		you.setBounds(335,70,165,50);
		
		yourscore.setForeground(Color.blue);
		yourscore.setFont(new Font("Verdana",Font.BOLD,35));
		yourscore.setHorizontalAlignment(JLabel.CENTER);
		yourscore.setText("0");
		yourscore.setBounds(335,115,165,50);
		
		crps.setText("?");
		crps.setFont(new Font("Verdana",Font.BOLD,70));
		crps.setForeground(Color.black);
		crps.setIcon(null);
		crps.setBackground(Color.red);
		crps.setOpaque(true);
		crps.setHorizontalAlignment(JLabel.CENTER);
		crps.setBounds(210,180,90,90);
		
		cmove.setForeground(Color.red);
		cmove.setFont(new Font("Verdana",Font.BOLD,40));
		cmove.setText("COMPUTER");
		cmove.setBounds(130,275,300,50);

		vs.setForeground(Color.black);
		vs.setFont(new Font("Verdana",Font.BOLD,30));
		vs.setHorizontalAlignment(JLabel.CENTER);
		vs.setText("VS");
		vs.setBounds(155,330,200,50);
		

		ymove.setForeground(Color.blue);
		ymove.setFont(new Font("Verdana",Font.BOLD,40));
		ymove.setText("YOU");
		ymove.setBounds(205,380,200,50);
		
		rockbutton.addActionListener(this);
		rockbutton.setBounds(110,440,90,90);
		rockbutton.setFocusable(false);
		rockbutton.setBackground(Color.white);
		
		paperbutton.addActionListener(this);
		paperbutton.setBounds(210,440,90,90);
		paperbutton.setFocusable(false);
		paperbutton.setBackground(Color.white);
		
		scissorbutton.addActionListener(this);
		scissorbutton.setBounds(310,440,90,90);
		scissorbutton.setFocusable(false);
		scissorbutton.setBackground(Color.white);

		specialbutton.addActionListener(this);
		specialbutton.setText("Next Round");
		specialbutton.setFont(new Font("Verdana",Font.BOLD,13));
		specialbutton.setBackground(Color.black);
		specialbutton.setForeground(Color.green);
		specialbutton.setBounds(185,105,130,50);
		specialbutton.setEnabled(false);

		frame.add(uppertext);
		frame.add(computer);
		frame.add(compscore);
		frame.add(you);
		frame.add(yourscore);
		frame.add(cmove);
		frame.add(crps);
		frame.add(vs);
		frame.add(ymove);
		frame.add(rockbutton);
		frame.add(paperbutton);
		frame.add(scissorbutton);
		frame.add(specialbutton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int usermove;
		int computermove;
		if(e.getSource()==rockbutton) {
			if(crps.getText()=="?") {
				count++;
			    usermove=0;
			    computermove=computer();
			    rockbutton.setBackground(Color.blue);
			    paperbutton.setEnabled(false);
			    scissorbutton.setEnabled(false);
			    specialbutton.setEnabled(true);
			    check(rockbutton,usermove,computermove);
			}
		}
		else if(e.getSource()==paperbutton) {
			if(crps.getText()=="?") {
				count++;
		     	usermove=1;
			    computermove=computer();
			    paperbutton.setBackground(Color.blue);
			    rockbutton.setEnabled(false);
			    scissorbutton.setEnabled(false);
			    specialbutton.setEnabled(true);
			    check(paperbutton,usermove,computermove);
			}
        }
		else if(e.getSource()==scissorbutton) {
			if(crps.getText()=="?") {
				count++;
			    usermove=2;
		     	computermove=computer();
			    scissorbutton.setBackground(Color.blue);
	    		rockbutton.setEnabled(false);
	    		paperbutton.setEnabled(false);
		    	specialbutton.setEnabled(true);
    			check(scissorbutton,usermove,computermove);
			}
		}
		else
			specialbutton.setEnabled(false);
		if(e.getSource()==specialbutton) {
			round++;
			if(round==3) {
				specialbutton.setText("Reset");
			}
			uppertext.setText("ROUND "+Integer.toString(round));
			rockbutton.setEnabled(true);
			paperbutton.setEnabled(true);
			scissorbutton.setEnabled(true);
			rockbutton.setBackground(Color.white); // reset button background color
			paperbutton.setBackground(Color.white);
			scissorbutton.setBackground(Color.white);
			crps.setText("?");
			crps.setIcon(null);
			crps.setBackground(Color.red);
			if(specialbutton.getText()=="RESET") {
			    yourscore.setText("0");
			    compscore.setText("0");
			    round=1;
			    count=0;
			    userscore=0;
			    comscore=0;
			    specialbutton.setText("Next Round");
			    uppertext.setText("ROUND 1");
			}
		}
			if (count==3) {
			    checkwinner();
			    specialbutton.setText("RESET");
			}
	    }
	
    public void checkwinner() {
	    if(userscore==comscore)
		    uppertext.setText("DRAW!!!");
	    else if(userscore>comscore)
		    uppertext.setText("YOU WON!!!");
	    else
		    uppertext.setText("COMPUTER WON!!!");			
    }

	public int computer() {
		int number=rand.nextInt(3);
		if (number==0) {
			crps.setIcon(rock);
		    crps.setText("");
		}
		else if (number==1){
			crps.setIcon(paper);
		    crps.setText("");
		}
		else if (number==2){
			crps.setIcon(scissor);
		    crps.setText("");
		}
		return number;
	}
	
	public void check(JButton extrabutton,int user,int comp) {
		if(user==comp) {
			crps.setBackground(Color.pink);
			extrabutton.setBackground(Color.pink);
		}
		else if((user==2)&&(comp==0)) {
			crps.setBackground(Color.green);
			comscore++;
			compscore.setText(Integer.toString(comscore));
		}
		else if((comp==2)&&(user==0)) {
			extrabutton.setBackground(Color.green);
			userscore++;
			yourscore.setText(Integer.toString(userscore));
		}
		else if(user>comp) {
			extrabutton.setBackground(Color.green);
			userscore++;
			yourscore.setText(Integer.toString(userscore));
		}
		else if(user<comp) {
			crps.setBackground(Color.green);
			comscore++;
			compscore.setText(Integer.toString(comscore));
		}			
	}
	
    public static void main(String[] args) {
    	ROCK_PAPER_SCISSOR tk=new ROCK_PAPER_SCISSOR();
	}
}
