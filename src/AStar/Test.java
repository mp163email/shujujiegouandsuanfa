package AStar;

import java.util.ArrayList;
import java.util.List;

/**
 * des:
 * created by miapoeng on 2019/7/19 10:03
 */
public class Test {
    public static void main(String[] args) {
        List<Cell> list = new ArrayList<>();
        for (int i = 1; i < 10; i ++) {
            Cell cell = new Cell(i, i);
            list.add(cell);
        }

        for (Cell cell : list) {
            cell.setX(cell.getX() * 10);
            cell.setY(cell.getY() * 10);
        }
        System.out.println(list);
    }
}
