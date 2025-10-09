package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ValleyGUI extends JFrame{  
    public static final int SIDE=20;

    public final int SIZE;
    private JButton ticTacButton;
    private JPanel  controlPanel;
    private PhotoValley photo;
    private Valley theValley;
   
    
    private ValleyGUI() {
        theValley=new Valley();
        SIZE=theValley.getSize();
        prepareElements();
        prepareActions();
    }
    
    private void prepareElements() {
        setTitle("Schelling Valley");
        photo=new PhotoValley(this);
        ticTacButton=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo,BorderLayout.NORTH);
        add(ticTacButton,BorderLayout.SOUTH);
        setSize(new Dimension(SIDE*SIZE+15,SIDE*SIZE+72)); 
        setResizable(false);
        photo.repaint();
    }

    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        ticTacButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ticTacButtonAction();
                }
            });

    }

    private void ticTacButtonAction() {
        theValley.ticTac();
        photo.repaint();
    }

    public Valley gettheValley(){
        return theValley;
    }
    
    public static void main(String[] args) {
        ValleyGUI cg=new ValleyGUI();
        cg.setVisible(true);
    }  
}

class PhotoValley extends JPanel{
    private ValleyGUI gui;

    public PhotoValley(ValleyGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.SIDE*gui.SIZE+10, gui.SIDE*gui.SIZE+10));         
    }


    public void paintComponent(Graphics g){
        Valley theValley=gui.gettheValley();
        super.paintComponent(g);
         
        for (int c=0;c<=theValley.getSize();c++){
            g.drawLine(c*gui.SIDE,0,c*gui.SIDE,theValley.getSize()*gui.SIDE);
        }
        for (int f=0;f<=theValley.getSize();f++){
            g.drawLine(0,f*gui.SIDE,theValley.getSize()*gui.SIDE,f*gui.SIDE);
        }       
        for (int f=0;f<theValley.getSize();f++){
            for(int c=0;c<theValley.getSize();c++){
                if (theValley.getUnit(f,c)!=null){
                    g.setColor(theValley.getUnit(f,c).getColor());
                    if (theValley.getUnit(f,c).shape()==Unit.SQUARE){                  
                        g.fillRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);   
                    }else {
                        g.fillOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                    }
                    if (theValley.getUnit(f,c).isAnimal()){
                        g.setColor(Color.red);
                        if (((Animal)theValley.getUnit(f,c)).getEnergy()>=50){
                            g.drawString("u",gui.SIDE*c+6,gui.SIDE*f+15);
                        } else {
                            g.drawString("~",gui.SIDE*c+6,gui.SIDE*f+17);
                        }
                    }    
                }
            }
        }
    }
}