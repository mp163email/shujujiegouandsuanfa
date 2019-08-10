package AStar;

import java.util.*;

/**
 * des: A*算法
 * 格子管理器
 * created by miapoeng on 2019/7/18 14:17
 */
public class CellMgr {

    public static final int MAX_ROW = 6;
    public static final int MAX_LINE = 8;
    public static final Cell BEGIN_CELL = new Cell(2, 3);
    public static final Cell END_CELL = new Cell(6, 3);
    public static final List<String> OBSTACLES = Arrays.asList("4_2", "4_3", "4_4");

    public static int inorder = 0;
    public static Map<String, Cell> openCellsMap = new LinkedHashMap<>();
    public static Map<String, Cell> closeCellsMap = new LinkedHashMap<>();
    public static Map<String, Cell> allellsMap = new LinkedHashMap<>();

    public static void main(String[] args) {

        initCells();

        while (!isContainEndCell()) {

            //找到最小F值的格子
            Cell minFCell = minFCell();

            //把最小格子从open放到close中
            operMinFCell(minFCell);

            //把开始格子周围的格子放到openlist中
            List<Cell> exsitsList = putRoundCells(minFCell);

            // 重新计算已经存在在open中的G值， 如果比原有的小，重新计算F, G, H三个值，并重新设置父亲
            reCalG (minFCell, exsitsList);

//            System.out.println("minFCell = " + minFCell);
//            System.out.println("opens=");
//            lookMap(openCellsMap);
//            System.out.println("closes=");
//            lookMap(closeCellsMap);
//            System.out.println("==============");
        }


        System.out.println("-------------------");
        Cell cell = allellsMap.get(END_CELL.getName());
        System.out.println(cell.getName());
        while (!isBeginCell(cell)) {
            System.out.println(cell.getpName());
            cell = allellsMap.get(cell.getpName());
        }

        System.out.println("=======finish===========");
    }

    public static boolean isBeginCell (Cell cell) {
        if (cell.getX() == BEGIN_CELL.getX() && cell.getY() == BEGIN_CELL.getY()) {
            return true;
        }
        return false;
    }

    /**
     * open中是否包含了结束的格子
     * @return
     */
    public static boolean isContainEndCell () {
        for(String key : openCellsMap.keySet()) {
            Cell cell = openCellsMap.get(key);
            if (cell.getX() == END_CELL.getX() && cell.getY() == END_CELL.getY()) {
                if (cell.getpName() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 重新计算已经存在在open中的G值， 如果比原有的小，重新计算F, G, H三个值，并重新设置父亲
     * @param parentCell
     */
    public static void reCalG(Cell parentCell, List<Cell> exsitsList) {
        if (exsitsList != null && exsitsList.size() >= 0) {
            for (Cell cell : exsitsList) {
                int g = calcG(parentCell, cell);
                if (g < cell.getG()) {
                    cell.setpName(parentCell.getName());
                    cell.setG(g);
                    cell.setF(cell.getG() + cell.getH());
                }
            }
        }
    }

    /**
     * 获取进入的序号
     * @return
     */
    public static int getInOrder () {
        return inorder++;
    }

    /**
     * 处理最小F值的格子
     * @param minFCell
     */
    public static void operMinFCell (Cell minFCell) {
        //从open中移除
        openCellsMap.remove(minFCell.getName());
        //加入到close中
        closeCellsMap.put(minFCell.getName(), minFCell);
    }

    /**
     * 寻找open中最小F的Cell
     */
    public static Cell minFCell() {

        if (openCellsMap.size() <= 0) {
            return BEGIN_CELL;
        }

        int minF = Integer.MAX_VALUE;
        for (String key : openCellsMap.keySet()) {
            Cell cell = openCellsMap.get(key);
            if (cell.getF() < minF) {
                minF = cell.getF();
            }
        }
        List<Cell> minList = new ArrayList<>();
        for (String key : openCellsMap.keySet()) {
            Cell cell = openCellsMap.get(key);
            if (cell.getF() == minF) {
                minList.add(cell);
            }
        }
        if (minList.size() <= 0) {
            return null;
        }
        int maxOrder = Integer.MIN_VALUE;
        Cell minCell = null;
        for (Cell cell : minList) {
            if (cell.getOrder() > maxOrder) {
                maxOrder = cell.getOrder();
                minCell = cell;
            }
        }
        return minCell;
    }

    /**
     * 初始化格子
     */
    public static void initCells () {
        for (int i = 0; i < MAX_LINE; i++) {
            for (int j = 0; j < MAX_ROW; j++) {
                Cell cell = new Cell(i, j);
                if (OBSTACLES.contains(getKey(i, j))) {
                    cell.setObstacle(true);
                }
                allellsMap.put(cell.getName(), cell);
            }
        }
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_LINE; j++) {
//                System.out.println(allellsMap.get(getKey(i, j)));
            }
        }
    }

    /**
     * 把某个格子周围的格子放到open里面
     * @param cell
     * @return 返回已有的格子列表
     */
    public static List<Cell> putRoundCells (Cell cell) {
        List<Cell> exsitList = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();
        //生成左侧3个
        int leftX = x - 1;
        for (int leftY = y + 1; leftY >= y - 1; leftY--) {
            Cell leftCell = allellsMap.get(getKey(leftX, leftY));
            if (leftCell != null) {
                setCell(leftCell, cell, exsitList);
            }
        }
        //生成中间3个
        int midX = x;
        for (int midY = y + 1; midY >= y - 1; midY--) {
            Cell midCell = allellsMap.get(getKey(midX, midY));
            if (midCell != null) {
                if (midCell.getName().equals(cell.getName())) {
                    continue;
                }
                setCell(midCell, cell, exsitList);
            }
        }
        //生成右边3个
        int rightX = x + 1;
        for (int rightY = y + 1; rightY >= y - 1; rightY--) {
            Cell rightCell = allellsMap.get(getKey(rightX, rightY));
            if (rightCell != null) {
                setCell(rightCell, cell, exsitList);
            }
        }
        return exsitList;
    }

    /**
     * 设置格子
     * open中没有，放入，并设置父格子
     * @param newCell
     * @param parentCell
     * @param exsitList
     */
    public static void setCell (Cell newCell, Cell parentCell, List<Cell> exsitList) {
        if (newCell.isObstacle() == true) {
            return;
        }
        if (closeCellsMap.containsKey(newCell.getName())) {
            return;
        }
        if (openCellsMap.containsKey(newCell.getName())) {
            exsitList.add(newCell);
        } else {
            // F = G + H
            int g = calcG(parentCell, newCell);
            int h = calcH(newCell);
            int f = g + h;
            newCell.setF(f);
            newCell.setH(h);
            newCell.setG(g);
            newCell.setpName(parentCell.getName());
            newCell.setOrder(getInOrder());
            openCellsMap.put(newCell.getName(), newCell);
        }
    }

    /**
     * 计算G值
     * 某个格子到他父亲格子的和
     * @param parentCell
     * @param otherCell
     * @return
     */
    public static int calcG (Cell parentCell, Cell otherCell) {
        if (isStraight(parentCell, otherCell)) {
            return parentCell.getG() + 10;
        } else {
            return parentCell.getG() + 14;
        }
    }

    /**
     * 计算H值
     * 某一个格子到终点的距离
     * @param oneCell
     * @return
     */
    public static int calcH (Cell oneCell) {
        int y = Math.abs(END_CELL.getY() - oneCell.getY());
        int x = Math.abs(END_CELL.getX() - oneCell.getX());
        return (x + y) * 10;
    }

    /**
     * 判断相邻的两个cell，是直相邻还是斜相邻
     * @param oneCell
     * @param otherCell
     * @return
     */
    public static boolean isStraight (Cell oneCell, Cell otherCell) {
        if (oneCell.getX() == otherCell.getX()) {
            if ((otherCell.getY() == oneCell.getY() + 1) || (otherCell.getY() == oneCell.getY() - 1)) {
                return true;
            }
        }
        if (oneCell.getY() == otherCell.getY()) {
            if ((otherCell.getX() == oneCell.getX() - 1) || (otherCell.getX() == oneCell.getX() + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取key
     * @param x
     * @param y
     * @return
     */
    public static String getKey (int x, int y) {
        return x + "_" + y;
    }

    /**
     * 查看Map
     * @param map
     */
    public static void lookMap (Map<String,Cell> map) {
        for (String key : map.keySet()) {
            Cell cell = map.get(key);
            System.out.println(cell);
        }
    }

    /**
     * 查看List
     * @param list
     */
    public static void lookList (List<Cell> list) {
        for (Cell cell : list) {
            System.out.println(cell);
        }
    }
}
