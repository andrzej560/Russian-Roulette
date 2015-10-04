/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hello;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author Andrzej
 */
class Plotno extends Canvas implements CommandListener{
    Random rand = new Random();
    static int wynik;
    static int shot;
	static  int lethim;
	int play;
	String klik;

	public Plotno(){
		shot=7;
		lethim=0;
		wynik=0;
		play=1;
	}

  public String klik(int i){
      switch(i){
          case 1: klik="_ ";break;
          case 2: klik="_ _ ";break;
          case 3: klik="_ _ _ ";break;
          case 4: klik="_ _ _ _ ";break;
          case 5: klik="_ _ _ _ _ ";break;

          case 6: klik="_ _ _ _ _ _";break;

      }

      return klik;
  }
  
public void paint(Graphics g){

    g.setColor(47, 80, 200);
    wynik=rand.nextInt(shot)+1;

    g.fillRect(0, 0, getWidth(), getHeight());

    g.setColor(200, 200, 200);
    g.drawRect(0, 0, getWidth()+5, getHeight());
    g.setColor(254, 254, 254);

    g.setFont(Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE));
	g.setColor(80,200,40);
	g.drawString("Ruletka", getWidth()/2,20,Graphics.TOP | Graphics.HCENTER);
    g.setColor(255,255,255);


    if (shot==1){
      g.drawString("Pewna śmierć", getWidth()/2, getHeight()/2 - 25, Graphics.TOP | Graphics.HCENTER);
    }



    if (wynik==1 && lethim == 1){

        g.drawString("Śmierć frajerom!" +
                 "", getWidth()/2, getHeight()/2, Graphics.TOP | Graphics.HCENTER);
		play = 0;
        try
        {
        InputStream is = getClass().getResourceAsStream("sh.wav");
        Player p = Manager.createPlayer(is, "audio/X-wav");
        p.start();
         }
		 catch (IOException ioe) { System.out.println("NEW"); }
         catch (MediaException me) {System.out.println("OLD"); }
         }else if(lethim==1 && wynik!=1){
            try
         {
           InputStream is = getClass().getResourceAsStream("bz.wav");
          Player p = Manager.createPlayer(is, "audio/X-wav");
          p.start();
          }
         catch (IOException ioe) { System.out.println("NEW"); }
         catch (MediaException me) {System.out.println("OLD"); }
              }


      if (play==1){
			g.drawString("Szansa: " + (100/(shot-1))+" %", getWidth()/2, getHeight()/2 - 25, Graphics.TOP | Graphics.HCENTER);
			g.drawString(klik(shot-1), getWidth()/2, getHeight()/2+10, Graphics.TOP | Graphics.HCENTER);
      }

}

    public void commandAction(Command c, Displayable d) {
    }

	public void keyPressed( int key){
        int action=getGameAction(key);
        lethim=1;
        if(action==FIRE || action==UP || action==DOWN || action==LEFT || action==RIGHT){

        if (play==1){
			shot--;
            repaint();
            serviceRepaints();
        }
    }
}









}
