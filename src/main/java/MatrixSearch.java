import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        return searchMatrixUtil(matrix,target,0,m-1,0,n-1);
    }

    public boolean searchMatrixUtil(int[][] matrix, int target,
                                    int rowStart, int rowEnd, int columnStart, int columnEnd){

        int rowLength = (rowEnd-rowStart);
        int columnLength = (columnEnd-columnStart);
        if(rowLength<0 || columnLength<0) return false;

        if(rowLength>columnLength){
            if(matrix[rowEnd][columnStart]==target){
                return true;
            }

            if(matrix[rowEnd][columnStart]>target){
                return searchMatrixUtil(matrix,target,rowStart,rowEnd-1,columnStart,columnEnd);
            } else {
                return searchMatrixUtil(matrix,target,rowStart,rowEnd,columnStart+1,columnEnd);
            }

        } else {
            if(matrix[rowStart][columnEnd]==target){
                return true;
            }
            if(matrix[rowStart][columnEnd]>target){
                return searchMatrixUtil(matrix,target,rowStart,rowEnd,columnStart,columnEnd-1);
            } else {
                return searchMatrixUtil(matrix,target,rowStart+1,rowEnd,columnStart,columnEnd);
            }
        }

    }


    public static void main(String [] args){
        MatrixSearch matrixSearch = new MatrixSearch();

        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        for(int i = 0;i<50;i++)
            System.out.println(matrixSearch.searchMatrix(matrix,i) + ": " +i) ;
    }
}
