package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;
    public Map(GridLayout gridLayout) {
        setBackground(Color.black);
    }

    public Map() {
        setBackground(Color.black);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }

    private void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.printf("CellX: %d, CellY: %d\n", cellX,cellY);
        repaint();
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %d; \n Size: x=%d y= %d;\n Win Length: %d;", mode, fSzX, fSzY, wLen);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        g.setColor(Color.BLUE);
//        g.drawLine(0, 0, 100,100);
        this.panelWidth = getWidth();
        this.panelHeight = getHeight();
        this.cellWidth = panelWidth/3;
        this.cellHeight = panelHeight/3;

        for (int i = 0; i < 3; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int k = 0; k < 3; k++) {
            int x = k * cellWidth;
            g.drawLine(x,0, x,panelHeight);
        }
    }
}
