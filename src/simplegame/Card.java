/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplegame;

/**
 *
 * @author jhon
 */
import javax.swing.ImageIcon;

class Card {
    
    private int rank=0;
    private ImageIcon img;
    

    // Constructor to set suit and rank.
    // Cannot reset once set.
    public Card ( int r) {
	rank = r;
    }

    
    
    public int getRank () {
	return rank;
    }
    public ImageIcon getimage(){
    
        if(rank==1){
        img=new ImageIcon("images\\7.png");
        }
        if(rank==2){
        img=new ImageIcon("images\\8.png");
        }
        if(rank==3){
        img=new ImageIcon("images\\9.png");
        }
       
        return img;
    }}
