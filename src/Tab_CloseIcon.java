import javax.swing.*;
import java.awt.*;

public class Tab_CloseIcon implements Icon {

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.red);
//        g.drawRect(0,0,17,17);
        g.drawLine(5,5, getIconWidth()-6, getIconHeight()-6);
        g.drawLine(getIconWidth()-6, 5, 5,getIconHeight()-6);

//        g.drawLine(0,0, getIconWidth()-5, getIconHeight()-5);
//        g.drawLine(getIconWidth()-5, 0,0,getIconHeight()-5);
    }

    @Override
    public int getIconWidth() {
        return 17;
    }

    @Override
    public int getIconHeight() {
        return 17;
    }
}