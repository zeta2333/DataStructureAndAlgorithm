package pycro.usts.dataStructures.recursion;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-18 6:54 PM
 */
public class Maze {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //其他挡板
        map[3][1] = 1;
        map[3][2] = 1;
        //map[3][3] = 1;
        //map[3][4] = 1;
        //map[2][4] = 1;
        //map[5][2] = 1;
        //map[5][3] = 1;
        //map[5][4] = 1;
        //map[5][5] = 1;
        //map[6][5] = 1;

        //输出地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        //System.out.println(setWay(map, 1, 1));
        System.out.println(setWay2(map, 1, 1));
        //输出新的地图，小球走过并标识过的地图
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明
    //1.map表示地图
    //2.i,j表示起始位置(1,1)
    //3.如果小球能到map[6][5]，则说明通路找到
    //4.约定：当map[i][j]为0时，表示该点没有走过，1表示不能走，2表示可以走，3表示已经走过，但无法走通
    //5.在走迷宫时，需要确定一个策略：下->右->上->左

    /**
     * @param map 表示地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，则返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前的点还没走过
                //    按照策略：下右上左
                map[i][j] = 2;//假定该点可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j]不为0，可能是1,2,3
                return false;
            }
        }
    }

    //修改策略：上右下左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {//如果当前的点还没走过
                //    按照策略：下右上左
                map[i][j] = 2;//假定该点可以走通
                if (setWay2(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果map[i][j]不为0，可能是1,2,3
                return false;
            }
        }
    }
}
