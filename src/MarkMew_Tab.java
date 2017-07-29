import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MarkMew_Tab extends JPanel{
    private JTextPane textEditor;
    private JPanel mainPanel;

    private JTabbedPane parent;
    private String title;
    private int index;

    private boolean isSaved;
    private File file;

    FileReader fileReader;
    BufferedReader bufferedReader;

    MarkMew_Tab(JTabbedPane _parent, String _title){

        super();

        parent = _parent;
        title = _title;
        index = parent.getTabCount();

        isSaved = false;

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);

    }

    public void openFile(File _file){
        file = _file;

        try{
            fileReader = new FileReader(file);
        }
        catch(IOException e){
            e.printStackTrace();
        }



    }

    public String print11(){
        return "index : "+index+"\n";
    }

    public boolean getIsSaved(){
        return isSaved;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
