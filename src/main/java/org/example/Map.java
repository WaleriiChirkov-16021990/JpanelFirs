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
    private SettingsWindow settingsWindow;

    public Map(GridLayout gridLayout) {
        setBackground(Color.black);
    }

    public Map() {
    }

    public Map(SettingsWindow settingsWindow) {
        this.settingsWindow = settingsWindow;
        setBackground(Color.black);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }

    public int getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(int panelWidth) {
        this.panelWidth = panelWidth;
    }

    public int getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(int panelHeight) {
        this.panelHeight = panelHeight;
    }

    public int getCellHeight() {
        return cellHeight;
    }

    public void setCellHeight(int cellHeight) {
        this.cellHeight = cellHeight;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }

    private void update(MouseEvent e) {
        int cellX = e.getX()/cellWidth;
        int cellY = e.getY()/cellHeight;
        System.out.printf("CellX: %d, CellY: %d\n", cellX,cellY);
        repaint();
    }

    void startNewGame(boolean mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %s; \n Size: x=%d y= %d;\n Win Length: %d; \n", mode, fSzX, fSzY, wLen);
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
        this.cellWidth = panelWidth/ this.settingsWindow.getFIELD_SIZE();
        this.cellHeight = panelHeight/ this.settingsWindow.getFIELD_SIZE();

        for (int i = 0; i < this.settingsWindow.getFIELD_SIZE(); i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int k = 0; k < this.settingsWindow.getFIELD_SIZE(); k++) {
            int x = k * cellWidth;
            g.drawLine(x,0, x,panelHeight);
        }
    }

//
//    private boolean checkLine(int x, int y, int vx, int vy, int len, int c) {
//        final int far_x = x + (len - 1) * vx;
//        final int far_y = y + (len - 1 ) * vy;
//        if(!isValidedCell(far_x, far_y)) return false;
//        for (int i = 0; i < len; i++) {
//            if(field[y + i * vy][x + i * vx] != c ) return false;
//        }
//        return true;
//    }
//
//    private boolean checkWin(int c){
//        for (int i = 0; i < fieldSizeX; i++) {
//            for (int j = 0; j < fieldSizeY; j++) {
//                if (checkLine(i, j, 1,0, winLength,c)) return true;
//                if (checkLine(i, j, 1,1, winLength,c)) return true;
//                if (checkLine(i, j, 0,1, winLength,c)) return true;
//                if (checkLine(i, j, 1,-1, winLength,c)) return true;
//            }
//        }
//        return false;
//    }

}
