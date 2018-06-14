package Model;

import GUI.Game;
import IO.Swing_Factory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class KeyListener extends KeyAdapter
{
    // Var
    private JLabel player;
    private JLabel box;
    private JLabel point;
    private JFrame frame;

    public KeyListener(JLabel player, JLabel box, JLabel point, JFrame jFrame) 
    {
        this.player = player;
        this.box = box;
        this.point = point;
        this.frame = jFrame;
    }
    
    // Listener
    @Override
    public void keyPressed(final KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP :
            {
                up();
                break;
            }
            case KeyEvent.VK_DOWN :
            {
                down();
                break;
            }
            case KeyEvent.VK_LEFT :
            {
                left();
                break;
            }
            case KeyEvent.VK_RIGHT :
            {
                right();
                break;
            }       
            case KeyEvent.VK_N :
            {
                Swing_Factory.show_Swing(new Game(), frame);
            }
        }
    }
            
    public  void right()
    {
        int x = this.player.getX() + 70;
        int y = this.player.getY();
        
        if(x < 280 )
        {
            if(x == this.box.getX() && y == this.box.getY())
            {
                if(x < 210)
                {
                    moveTo(this.player, x, y);   
                    moveTo(this.box, x + 70, y);    
                    check_Win();
                }
            }
            else
            {
                moveTo(this.player, x, y);  
            }              
        }
    }
    
    public  void left()
    {
        int x = this.player.getX() - 70;
        int y = this.player.getY();
        
        if(x >= 0)
        {
            if(x == this.box.getX() && y == this.box.getY())
            {
                if(x >= 70)
                {
                    moveTo(this.player, x, y);   
                    moveTo(this.box, x - 70, y);    
                    check_Win();
                }
            }
            else
            {
                moveTo(this.player, x, y);  
            }      
        }
    }
    
    public  void up()
    {
        int x = this.player.getX();
        int y = this.player.getY() - 70;
        
        if(y >= 0)
        {
            if(x == this.box.getX() && y == this.box.getY())
            {
                if(y >= 70)
                {
                    moveTo(this.box, x, y - 70);
                    moveTo(this.player, x, y);
                    check_Win();
                }
            }
            else
            {
                moveTo(this.player, x, y);
            }           
        }
    }

    public  void down()
    {
        int x = this.player.getX();
        int y = this.player.getY() + 70;
        
        if(y < 280)
        {
            if(x == this.box.getX() && y == this.box.getY())
            {
                if(y < 210)
                {
                    moveTo(this.box, x, y + 70);
                    moveTo(this.player, x, y);
                    check_Win();
                }
            }
            else
            {
                moveTo(this.player, x, y);
            }             
        }
    }    
    
    public void moveTo(JLabel label, int x, int y)
    {
        label.setLocation(x, y);
    }
    
    public void check_Win()
    {
        if(this.box.getX() == 210 && this.box.getY() == 210)
        {
            JOptionPane.showMessageDialog(null, "You Win !! Press N for new game");
        }
    }
}
