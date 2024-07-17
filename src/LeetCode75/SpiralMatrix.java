package LeetCode75;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int colBegin = 0;
        int colEnd = matrix[0].length -1;
        int rowBegin = 0;
        int rowEnd = matrix.length -1;

        List<Integer> list = new ArrayList<>();

        if (matrix.length == 0 && matrix[0].length == 0) {
            return list;
        }

        while(colBegin <= colEnd && rowBegin <= rowEnd) {
            for(int i = colBegin; i <= colEnd; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int i = rowBegin; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    list.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    list.add(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        SpiralMatrix sm = new SpiralMatrix();
        List<Integer> list = sm.spiralOrder(matrix);
        System.out.println(list);
    }
}
