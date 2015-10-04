package hello;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.media.MediaException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

public class HelloMIDlet extends MIDlet implements CommandListener{

	Alert alt;
	TextBox txt;
	Command cmd;
	Command cmd2;
	static  Display display;     // The display for this MIDlet
	static Plotno p = new Plotno();
	static int x;
	TextBox txts = new TextBox("INFO", "Andrzej Kowol - 18.10.2010 - Nie róbcie tego w domu!", 70,0);

    public HelloMIDlet() throws IOException, MediaException {


        txt = new TextBox("Nodoby", "tekst",20,0);
        alt = new Alert("Andrzej rządzi");
        cmd = new Command("Exit", Command.SCREEN,1);
        cmd2 = new Command("Info", Command.SCREEN,1);
        p.addCommand(cmd);
        p.addCommand(cmd2);
        p.setCommandListener(this);
       
        try
        {
        InputStream is = getClass().getResourceAsStream("rel.wav");
        Player ps = Manager.createPlayer(is, "audio/X-wav");
        ps.start();
        }
        catch (IOException ioe) { System.out.println("NEW"); }
        catch (MediaException me) {System.out.println("OLD"); }
    }
    

    public void startApp() {
        display = Display.getDisplay(this);
      display.setCurrent(p);AlertType.ERROR.playSound(display);
        
    }
	
    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable s) {
		
		if (c==cmd){
           System.out.println("Dude");
            destroyApp(false);
            notifyDestroyed();
		}

		if (c==cmd2){
           display.setCurrent(txts);
		}
    }

}
