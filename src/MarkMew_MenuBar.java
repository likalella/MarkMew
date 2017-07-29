import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MarkMew_MenuBar extends JMenuBar {

    private MainFrame frame;

    MarkMew_MenuBar(MainFrame frame){
        super();

        this.frame = frame;

        // File Menu
        menu_File = new JMenu("File");
        this.add(menu_File);

        item_New = new JMenuItem("New");
        item_Open = new JMenuItem("Open");
        item_Save = new JMenuItem("Save");
        item_Save_As = new JMenuItem("Save As");
        item_Close = new JMenuItem("Close");
        item_Exit = new JMenuItem("Exit");

        item_Export = new JMenu("Export...");
        item_Export_html = new JMenuItem("HTML");
        item_Export_txt = new JMenuItem("Text File");
        item_Export.add(item_Export_html);
        item_Export.add(item_Export_txt);

        menu_File.add(item_New);
        menu_File.add(item_Open);
        menu_File.add(item_Close);
        menu_File.addSeparator();
        menu_File.add(item_Save);
        menu_File.add(item_Save_As);
        menu_File.addSeparator();
        menu_File.add(item_Export);
        menu_File.addSeparator();
        menu_File.add(item_Exit);

        // Edit Menu
        menu_Edit = new JMenu("Edit");
        this.add(menu_Edit);

        item_Undo = new JMenuItem("Undo");
        item_Redo = new JMenuItem("Redo");
        item_Cut = new JMenuItem("Cut");
        item_Copy = new JMenuItem("Copy");
        item_Paste = new JMenuItem("Paste");
        item_Delete = new JMenuItem("Delete");
        item_Find = new JMenuItem("Find");
        item_Select_All = new JMenuItem("Select All");

        menu_Edit.add(item_Undo);
        menu_Edit.add(item_Redo);
        menu_Edit.addSeparator();
        menu_Edit.add(item_Cut);
        menu_Edit.add(item_Copy);
        menu_Edit.add(item_Paste);
        menu_Edit.add(item_Delete);
        menu_Edit.addSeparator();
        menu_Edit.add(item_Find);
        menu_Edit.add(item_Select_All);

        setComponentListener();
    }

    private void setComponentListener(){

        JTabbedPane tabbedPane = frame.getTabbedPane();
        JLabel      stateLabel = frame.getStateLabel();

        item_New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.add("Untitled", new MarkMew_Tab(tabbedPane, "Untitled"));
                stateLabel.setText("New tab is added");
            }
        });

        item_Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MarkMew_Tab tab = (MarkMew_Tab) tabbedPane.getSelectedComponent();
                if(!tab.getIsSaved()){
                    // ask whether save or not
                }

                // remove tab
                tabbedPane.remove(tabbedPane.getSelectedIndex());

                // update indexing
                int count = tabbedPane.getTabCount();
                for(int i=0; i<count; i++){
                    ((MarkMew_Tab)tabbedPane.getComponentAt(i)).setIndex(i);
                }

                stateLabel.setText("Select tab is removed");
            }
        });

    }


    private JMenu menu_File;
    private JMenu menu_Edit;

    private JMenu item_Export;

    private JMenuItem item_New;
    private JMenuItem item_Open;
    private JMenuItem item_Save;
    private JMenuItem item_Save_As;
    private JMenuItem item_Close;
    private JMenuItem item_Export_html;
    private JMenuItem item_Export_txt;
    private JMenuItem item_Exit;

    private JMenuItem item_Undo;
    private JMenuItem item_Redo;
    private JMenuItem item_Cut;
    private JMenuItem item_Copy;
    private JMenuItem item_Paste;
    private JMenuItem item_Delete;
    private JMenuItem item_Find;
    private JMenuItem item_Select_All;

}
