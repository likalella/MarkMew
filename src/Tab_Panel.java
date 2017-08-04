import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tab_Panel extends JPanel implements ActionListener {

    private JTabbedPane pane;
    private MarkMew_Tab panel;
    private int index;

    private JLabel save;
    private JLabel title;
    private JButton closeBtn;


    public Tab_Panel(JTabbedPane _pane, MarkMew_Tab _panel, int _index) {
        pane = _pane;
        index = _index;
        panel = _panel;

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

    public void setTitle(String name) {
        title.setText(name);
    }

    public void saved() {
        save.setText(" ");
    }

    public void unsaved() {
        save.setText("*");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index;
        if ((index = pane.indexOfTabComponent(this)) != -1) {

            if ((panel.hasFile() && save.getText().equals("*")) || (!panel.hasFile() && panel.hasContent())) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Content has modified, save changes?",
                        "Save Changed?",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {

                    if(panel.hasFile()) {
                        panel.saveFile(null);
                        pane.remove(index);
                        return;
                    }

                    String[] filter_desc = new String[]{"Markdown File (*.md)", "Text File (*.txt)"};
                    String[] filter_ext = new String[]{"md", "txt"};

                    JFileChooser saveDialog = new JFileChooser();
                    saveDialog.setAcceptAllFileFilterUsed(false);
                    for (int i = 0; i < filter_desc.length; i++)
                        saveDialog.addChoosableFileFilter(new FileNameExtensionFilter(filter_desc[i], filter_ext[i]));

                    if (saveDialog.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

                        if (saveDialog.getSelectedFile().exists()) {
                            int confirm = JOptionPane.showConfirmDialog(null,
                                    "Do you want to overwrite the file?",
                                    "File Duplication",
                                    JOptionPane.YES_NO_OPTION);

                            if (confirm != JOptionPane.YES_OPTION) return;
                        }

                        // get file path
                        String path = saveDialog.getSelectedFile().getAbsolutePath();
                        String extension = ((FileNameExtensionFilter) saveDialog.getFileFilter()).getExtensions()[0];
                        if (!path.endsWith(extension))
                            path += "." + extension;

                        ((MarkMew_Tab) pane.getSelectedComponent()).saveFile(path);
                    }
                }

            }

            pane.remove(index);
        }
    }
}

