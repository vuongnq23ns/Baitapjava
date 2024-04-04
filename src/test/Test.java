package test;
import model.*;
import view.*;
import javax.swing.*;

import control.Controller;


public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            View view = new View();
            new Controller(model, view);
            view.getFrame().setVisible(true);
        });
    }
}
