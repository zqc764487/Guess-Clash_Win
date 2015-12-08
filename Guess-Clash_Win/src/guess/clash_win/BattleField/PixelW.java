/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess.clash_win.BattleField;
import javax.swing.ImageIcon;  
import javax.swing.JLabel;
import guess.clash_win.Pixel;
import javax.swing.Icon;

/**
 *
 * @author Qichang_Zheng
 */
public class PixelW extends JLabel{
    
    private static final long serialVersionUID = 1L;  
    private Pixel pixel;  
    private boolean isFaceUp;
    
    
    public PixelW(Pixel p)  
    {  
        super();  
        this.pixel=p;  
//        setBounds(0,0,MainWindow.POKERWIDTH, MainWindow.POKERHEIGHT);  
    }
    
    public void setFaceUp(boolean aFaceUp)  
    {  
        this.isFaceUp = aFaceUp;
    }
}
