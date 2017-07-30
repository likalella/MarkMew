import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tab_Panel extends JPanel implements ActionListener{

    private JTabbedPane pane;
    private int index;

    private JLabel save;
    private JLabel title;
    private JButton closeBtn;


    public Tab_Panel(JTabbedPane _pane, int _index){
        pane = _pane;
        index = _index;

        setOpaque(false);

        save = new JLabel("*", JLabel.LEFT);
        add(save);

        title = new JLabel(pane.getTitleAt(index), pane.getIconAt(index), JLabel.LEFT);
        add(title);

        Icon closeIcon = new Tab_CloseIcon();
        closeBtn = new JButton(closeIcon);
        closeBtn.setPreferredSize(new Dimension(closeIcon.getIconWidth(),
                closeIcon.getIconHeight()));
        closeBtn.addActionListener(this);
        closeBtn.setBackground(Color.WHITE);
        closeBtn.setOpaque(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setFocusPainted(false);

        add(closeBtn);

        pane.setTabComponentAt(index, this);
    }

    public void saved(){
        save.setText(" ");
    }

    public void unsaved(){
        save.setText("*");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index;
        if((index=pane.indexOfTabComponent(this)) != -1)
            pane.remove(index);
    }
}
