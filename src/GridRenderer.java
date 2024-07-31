import javax.swing.*;
import java.awt.*;

public class GridRenderer{
    int cellWidth;
    int cellHeight;

    int screenOffsetX;
    int screenOffsetY;

    public void DrawGridLines(Graphics g, Grid grid, Color col){
        g.setColor(col);
        for (int i = 0; i <= grid.width; i++){
            g.drawLine(i * cellWidth + screenOffsetX, screenOffsetY, i * cellWidth + screenOffsetX, grid.height * cellHeight + screenOffsetX);
        }
        for (int i = 0; i <= grid.height; i++){
            g.drawLine(screenOffsetX, i * cellHeight + screenOffsetY, grid.width * cellWidth + screenOffsetX, i * cellHeight + screenOffsetY);
        }
    }

    public void DrawGridBackground(Graphics g, Grid grid, Color col){
        g.setColor(col);
        g.fillRect(screenOffsetX, screenOffsetY, grid.width * cellWidth, grid.height * cellHeight);
    }

    public void HighlightCell(Graphics g, int x, int y, Color col){
        g.setColor(col);
        g.fillRect(x * cellWidth + screenOffsetX, y * cellHeight + screenOffsetY, cellWidth,  cellHeight);
    }

    public Point GetScreenToCell(Point screenPos){
        if (screenPos == null) return null;
        int x = (screenPos.x - screenOffsetX) / cellWidth;
        int y = (screenPos.y - screenOffsetY) / cellHeight;
        return new Point(x, y);
    }

    GridRenderer(int cellWidth, int cellHeight, int screenX, int screenY){
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        screenOffsetX = screenX;
        screenOffsetY = screenY;
    }
}