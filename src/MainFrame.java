import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame {
    private JPanel panel_main;
    private JPanel panel_bottom;
    private JTabbedPane tabbedPane;
    private JSplitPane splitPane;
    private JLabel stateLabel;
    private JEditorPane webView;

    MainFrame(){

        componentSetting();

        JFrame frame = new JFrame("MarkMew");
        frame.setSize(1000,600);
        frame.setContentPane(panel_main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new MarkMew_MenuBar(this));
        frame.setVisible(true);


    }

    private void componentSetting(){

        // splitPane setting
        splitPane.setDividerLocation(0.5);
        splitPane.setResizeWeight(0.5);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);

        // state bar setting
        panel_bottom.setBorder(BorderFactory.createEmptyBorder(4,6,4,6));
        stateLabel.setText("Hello, MarkMew!");

        for(int i=0; i<5; i++)
            tabbedPane.addTab("MarkMew"+(i+1), new MarkMew_Tab(tabbedPane, "MarkMew"+(i+1)));

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                webView.setText("current : "+tabbedPane.getSelectedIndex() + "\n" + ((MarkMew_Tab)tabbedPane.getComponentAt(tabbedPane.getSelectedIndex())).print11()  );
            }
        });

    }


    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public JLabel getStateLabel() {
        return stateLabel;
    }

    public JEditorPane getWebView(){
        return webView;
    }
}
