import javax.swing.*;

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

        new MarkMew_Tab(tabbedPane, "Untitled");

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
