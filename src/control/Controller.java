package control;
import model.*;
import view.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        
        // Thêm sự kiện cho nút Open
        view.getOpenButton().addActionListener(this::onOpen);
        
        // Thêm sự kiện cho nút Save
        view.getSaveButton().addActionListener(this::onSave);
    }

    private void onOpen(ActionEvent e) {
        if (view.getFileChooser().showOpenDialog(view.getFrame()) == JFileChooser.APPROVE_OPTION) {
            try {
                model.loadFromFile(view.getFileChooser().getSelectedFile().toPath());
                view.getTextArea().setText(model.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void onSave(ActionEvent e) {
        if (view.getFileChooser().showSaveDialog(view.getFrame()) == JFileChooser.APPROVE_OPTION) {
            try {
                model.setText(view.getTextArea().getText());
                model.saveToFile(view.getFileChooser().getSelectedFile().toPath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
