package AStar;

/**
 * des: 格子
 * F = G + H
 * created by miapoeng on 2019/7/18 14:11
 */
public class Cell {

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 格子名称
     */
    private String name;

     /**
     * x坐标
     */
    private int x;

    /**
     * y坐标
     */
    private int y;

    /**
     * 父亲格子的名称
     */
    private String pName;

    /**
     * 是否是障碍
     */
    private boolean obstacle;

    /**
     * 进入的order
     */
    private int order;


    private int f;

    private int g;

    private int h;

    public String getName() {
        return this.x + "_" + this.y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getF() {
        return this.g + this.h;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public boolean isEndCell() {
        if (CellMgr.END_CELL.getX() == this.x && CellMgr.END_CELL.getY() == y) {
            return true;
        }
        return false;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "name='" + getName() + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", pName='" + pName + '\'' +
                ", obstacle=" + obstacle +
                ", order=" + order +
                ", f=" + f +
                ", g=" + g +
                ", h=" + h +
                '}';
    }
}
