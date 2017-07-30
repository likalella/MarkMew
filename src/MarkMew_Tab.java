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

    private Tab_Panel tabPanel;

    MarkMew_Tab(JTabbedPane _parent, String _title){

        super();

        parent = _parent;
        title = _title;

        isSaved = false;
        file = null;

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);

        parent.add(title, this);
        index = parent.indexOfComponent(this);

        tabPanel = new Tab_Panel(parent, index);
    }

    public void openFile(File _file){
        file = _file;

        try{
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            String text = "";
            while((line = bufferedReader.readLine())!=null)
                text += line + "\n";

            textEditor.setText(text);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }



    public boolean compareFile(File f){
        if(file==null) return false;
        return file.equals(f);
    }

    public boolean getIsSaved(){
        return isSaved;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
