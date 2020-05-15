import java.awt.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.util.concurrent.TimeUnit;

public class AlienArmy {

    //The army has 5 rows of aliens
    Alien rowOne[] = new Alien[11];
    Alien rowTwo[] = new Alien[11];
    Alien rowThree[] = new Alien[11];
    Alien rowFour[] = new Alien[11];
    Alien rowFive[] = new Alien[11];

    //The direction the army is moving in
    boolean movingRight = true;

    //The number of pixels to move at a time
    int moveDistance = 5;
    int ymoveDistance = 15;

    //A container to store details of the current alien shots
    Vector alienShots = new Vector();    

    private Ship ship;

    private SpaceInvaders spaceInvaders;

    private Image alienImage = null;//new javax.swing.ImageIcon ("alien10.jpg").getImage();; //insert jpg file here
    private Image alienImage2 = null;//new javax.swing.ImageIcon ("alien20.jpg").getImage();;
    private Image alienImage3 = null;//new javax.swing.ImageIcon ("alien30.jpg").getImage();;
	
    public AlienArmy(Ship s, SpaceInvaders si, Image ai, Image ai2, Image ai3) {
        ship = s;
	     spaceInvaders = si;
	     alienImage = ai;
        alienImage2 = ai2;
        alienImage3 = ai3;
      //  Image alienImage2 = ai2;
      //  Image alienImage3 = ai3;

//	alienImage = new javax.swing.ImageIcon("alienFull.jpg").getImage();

	
        createArmy();
	setStartingPositions();
    }

    /**
     * In this method we initialise the 3 rows of aliens
     * that make up the army.
     */
    private void createArmy() {

	   for (int i = 0; i < 11; i++) {
            rowOne[i] = new Alien(alienImage3, spaceInvaders);
            rowTwo[i] = new Alien(alienImage2, spaceInvaders);
            rowThree[i] = new Alien(alienImage2, spaceInvaders);//Finally set the third row
            rowFour[i] = new Alien(alienImage, spaceInvaders);
            rowFive[i] = new Alien(alienImage, spaceInvaders);
            
	}	
    }

    /**
     * Set where our alien army will start attacking from
     */
   private void setStartingPositions() {

       int rowHeight = 120;//Set the height of the top row
	    int leftStart = 50;//Sets the furtherest position to the left
	    for (int i = 0; i < 11; i++) {
         rowOne[i].setPosition(leftStart, rowHeight);
	      leftStart += 40;
	    }
	   rowHeight += 50;//Ready for the next row
	   leftStart = 50;//Reset the left position
	   for (int i = 0; i < 11; i++) {
            rowTwo[i].setPosition(leftStart, rowHeight);
	         leftStart += 40;
	   }
	   rowHeight += 50;//Ready for the third row
	   leftStart = 50;//Reset the left position
	   for (int i = 0; i < 11; i++) {
            rowThree[i].setPosition(leftStart, rowHeight);
	         leftStart += 40;
	   }	
	   rowHeight += 50;//Ready for the third row
	   leftStart = 50;//Reset the left position
	   for (int i = 0; i < 11; i++) {
            rowFour[i].setPosition(leftStart, rowHeight);
	         leftStart += 40;
      }
	   rowHeight += 50;//Ready for the third row
	   leftStart = 50;//Reset the left position
	   for (int i = 0; i < 11; i++) {
            rowFive[i].setPosition(leftStart, rowHeight);
	         leftStart += 40;
	   }
      leftStart = 50;	   
	}	
    
    private int alienshottimer = 5000; //milliseconds
    /**
     * In this method we move the alien army.
     */
    public void moveArmy() {
	
        if (movingRight) {
            //We are moving right
	    
            //First step: Check if the alien furthest to the right has hit the edge
	    for (int i = 10; i >= 0; i--) {//Notice how this loop counts down
                if (!rowOne[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowOne[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
			movingRight = false;


                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);
                        }
                        
                        return;//Return from this method, don't bother checking the rest.
			
		    }
		}
                if (!rowTwo[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowTwo[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
			movingRight = false;


                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);                            
                        }
                        
                        return;//Return from this method, don't bother checking the rest.
			
		    }		   
		    
		}
                if (!rowThree[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowThree[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
			movingRight = false;


                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);                            
                        }
                        
                        return;//Return from this method, don't bother checking the rest.
			
		    }		  
		    
		}
                if (!rowFour[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowFour[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
			movingRight = false;


                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);                            
                        }
                        
                        return;//Return from this method, don't bother checking the rest.      		
	    }
   }	
                if (!rowFive[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowFive[i].getXPos() > (SpaceInvaders.WIDTH-Alien.ALIEN_WIDTH-15)) {
                        //Change direction
			movingRight = false;


                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);                            
                        }
                        
                        return;//Return from this method, don't bother checking the rest.    
	    }
   }  
   }
            //Second step: Move everyone to the right
            for (int i = 0; i < 11; i++) {
                rowOne[i].setPosition(rowOne[i].getXPos()+moveDistance, rowOne[i].getYPos());
                rowTwo[i].setPosition(rowTwo[i].getXPos()+moveDistance, rowTwo[i].getYPos());
                rowThree[i].setPosition(rowThree[i].getXPos()+moveDistance, rowThree[i].getYPos());
                rowFour[i].setPosition(rowFour[i].getXPos()+moveDistance, rowFour[i].getYPos());
                rowFive[i].setPosition(rowFive[i].getXPos()+moveDistance, rowFive[i].getYPos());
                
            } 	


	    

	} else {
            //We are moving left
	    
            //First step: Check if the alien furthest to the left has hit the edge
	    for (int i = 0; i < 11; i++) {//Notice how this loop counts down
                if (!rowOne[i].hasBeenHit()) {

                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowOne[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
			movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
		    }
		    
		}
                if (!rowTwo[i].hasBeenHit()) {
			
                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowTwo[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
			movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
		    }		    
		    
		}
                if (!rowThree[i].hasBeenHit()) {
			
                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowThree[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
			movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
		    }	
		    
		}
                if (!rowFour[i].hasBeenHit()) {
			
                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowFour[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
			movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
		    }	
		    
		}
                if (!rowFive[i].hasBeenHit()) {
			
                    //If the alien has not been hit - then it is the edge
		    //Now check if the alien if at the edge
		    if (rowFive[i].getXPos() < Alien.ALIEN_WIDTH) {
                        //Change direction
			movingRight = true;

                        //Set the new lower y positions
                        for (int y = 0; y < 11; y++) {
                            rowOne[y].setPosition(rowOne[y].getXPos(), rowOne[y].getYPos()+ymoveDistance);
                            rowTwo[y].setPosition(rowTwo[y].getXPos(), rowTwo[y].getYPos()+ymoveDistance);
                            rowThree[y].setPosition(rowThree[y].getXPos(), rowThree[y].getYPos()+ymoveDistance);
                            rowFour[y].setPosition(rowFour[y].getXPos(), rowFour[y].getYPos()+ymoveDistance);
                            rowFive[y].setPosition(rowFive[y].getXPos(), rowFive[y].getYPos()+ymoveDistance);
                        }

                        return;//Return from this method, don't bother checking the rest.		
		    }	
		    
		}		
	    }
		
            //Second step: Move everyone to the left
            for (int i = 0; i < 11; i++) {
                rowOne[i].setPosition(rowOne[i].getXPos()-moveDistance, rowOne[i].getYPos());
                rowTwo[i].setPosition(rowTwo[i].getXPos()-moveDistance, rowTwo[i].getYPos());
                rowThree[i].setPosition(rowThree[i].getXPos()-moveDistance, rowThree[i].getYPos());
                rowFour[i].setPosition(rowFour[i].getXPos()-moveDistance, rowFour[i].getYPos());
                rowFive[i].setPosition(rowFive[i].getXPos()-moveDistance, rowFive[i].getYPos());
                
            }	    

	}
	//Start some random alien firing!
	Random generator = new Random();
   int rnd = generator.nextInt(11);
	//if (!rowOne[rnd1].hasBeenHit()) {
	  //  AlienShot as = new AlienShot(rowOne[rnd1].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowOne[rnd1].getYPos(), ship);
    //        alienShots.addElement(as);
	//}
	// if (!rowOne[rnd2].hasBeenHit()) {	
	//    AlienShot as = new AlienShot(rowTwo[rnd2].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowTwo[rnd2].getYPos(), ship);
    //        alienShots.addElement(as);
	//}

	
    
	if (!rowFive[rnd].hasBeenHit()) {	
    	    AlienShot as = new AlienShot(rowFive[rnd].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowFive[rnd].getYPos(), ship);
          alienShots.addElement(as);
       
	 }
	else if (!rowFour[rnd].hasBeenHit()) {	
    	    AlienShot as = new AlienShot(rowFour[rnd].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowFour[rnd].getYPos(), ship);
            alienShots.addElement(as);
	}
   else if (!rowThree[rnd].hasBeenHit()) {	
    	    AlienShot as = new AlienShot(rowThree[rnd].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowThree[rnd].getYPos(), ship);
          alienShots.addElement(as);
   }
   else if (!rowTwo[rnd].hasBeenHit()) {	
    	    AlienShot as = new AlienShot(rowTwo[rnd].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowTwo[rnd].getYPos(), ship);
          alienShots.addElement(as);
   }
   else if (!rowOne[rnd].hasBeenHit()) {	
    	    AlienShot as = new AlienShot(rowOne[rnd].getXPos()+(int)(Alien.ALIEN_WIDTH/2), rowOne[rnd].getYPos(), ship);
          alienShots.addElement(as);
   }
 }
    /**
     *
     */
   public void drawArmy(Graphics g) {
        //Draw the first row
	      for (int i = 0; i < 11; i++) {
               rowOne[i].drawAlien(g);//Draw the first row
               rowTwo[i].drawAlien(g);//Draw the second row
               rowThree[i].drawAlien(g);//Draw the third row
               rowFour[i].drawAlien(g);
               rowFive[i].drawAlien(g);
	} 
        //Now we need to draw any of the shots the aliens have fired
	Vector tmp = new Vector();
	for (int i = 0; i < alienShots.size(); i++) {
            AlienShot as = (AlienShot)alienShots.elementAt(i);
	    //Need to remove old shots at this point!
	    if (as.getShotState()) {
                //This is NOT an old shot
		tmp.addElement(as);
	    }
	    
	    as.drawShot(g);
	    
	    
	}
	alienShots = tmp;
    }

    /**
     * This is where the collision detection takes place
     */
    public boolean checkShot(int x, int y) {
        for (int i = 0; i < 11; i++) {
            if (rowOne[i].hitAlien(x, y)) {
		spaceInvaders.hitAlienScore();
                return true;
	    }
            if (rowTwo[i].hitAlien(x, y)) {
		spaceInvaders.hitAlienScore();		    
                return true;
	    }
            if (rowThree[i].hitAlien(x, y)) {
		spaceInvaders.hitAlienScore();		    
                return true;
	    }
            if (rowFour[i].hitAlien(x, y)) {
		spaceInvaders.hitAlienScore();		    
                return true;
	    }
            if (rowFive[i].hitAlien(x, y)) {
		spaceInvaders.hitAlienScore();		    
                return true;
	    }	    
	}
	return false;
    }

}