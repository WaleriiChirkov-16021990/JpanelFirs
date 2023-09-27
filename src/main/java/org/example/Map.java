package org.example;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public Map(GridLayout gridLayout) {
        setBackground(Color.black);
    }

    public Map() {
        setBackground(Color.black);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d; \n Size: x=%d y= %d;\n Win Length: %d;", mode, fSzX, fSzY, wLen);
    }
}
