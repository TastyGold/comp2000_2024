public class Grid {
    int width;
    int height;

    public boolean IsInBounds(int x, int y){
        return x >= 0
            && y >= 0
            && x < width
            && y < height;
    }

    Grid(int w, int h){
        width = w;
        height = h;
    }
}
