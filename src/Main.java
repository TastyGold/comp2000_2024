import javax.swing.*;
import java.awt.*;

public class Main extends JFrame 
{

    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Canvas extends JPanel{

        Grid mainGrid = new Grid(20, 20);
        GridRenderer gridRenderer = new GridRenderer(35,35,10,10);

        public Canvas(){
            setPreferredSize(new Dimension(720, 720));
        }

        @Override
        public void paint(Graphics g){
            Point mouseScreenPos = getMousePosition();
            Point mouseGridPos = gridRenderer.GetScreenToCell(mouseScreenPos);

            gridRenderer.DrawGridBackground(g, mainGrid, Color.white);
            if (mouseGridPos != null && mainGrid.IsInBounds(mouseGridPos.x, mouseGridPos.y)){
                gridRenderer.HighlightCell(g, mouseGridPos.x, mouseGridPos.y, Color.gray);
            }
            gridRenderer.DrawGridLines(g, mainGrid, Color.black);

            repaint();
        }
    }

    private Main(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }
}