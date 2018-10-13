/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import java.util.*;
import java.lang.*;
import java.io.IOException;
public class Main
{
	public static void main(String[] args) {
	    Main obj = new Main();
        Matrix matrix = obj.getInput();
        List<SubMatrixSum> subMatrices = obj.findAllSubMatrices(matrix);
        System.out.println("Total SubMatrices: " + subMatrices.size());
        SubMatrixSum subMatrixSum = subMatrices.stream().sorted((s1, s2) -> s2.sum.compareTo(s1.sum)).findFirst().get();

        System.out.println(subMatrixSum);

    }
    private List<SubMatrixSum> findAllSubMatrices(Matrix arr) {
        List<SubMatrixSum> subs = new ArrayList<>();
        int row = 0, column;

        while (row < arr.matrix.length - arr.subMatrixSize + 1) {
            column = 0;
            while (column < arr.matrix[0].length - arr.subMatrixSize + 1) {
                int[][] sub = new int[arr.subMatrixSize][arr.subMatrixSize];
                int sum = 0;
                if (row == 0 || row == arr.matrix.length || column == 0 || column == arr.matrix[0].length) {
                    for (int i = 0, mi = row; i < arr.subMatrixSize; i++, mi++) {
                        for (int j = 0, mj = column; j < arr.subMatrixSize; j++, mj++) {
                            sub[i][j] = arr.matrix[mi][mj];
                            sum += sub[i][j];
                        }
                    }
                    subs.add(new SubMatrixSum(sub, sum));
                }
                column++;
            }
            row++;
        }

        return subs;
    }


private Matrix getInput() {
    try{
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the width of the array");
        int width = sc.nextInt();
        System.out.println("enter the height of the array");
        int height = sc.nextInt();
        int arr [][]  = new int[width][height];
        System.out.println("Input Matrix with numbers from 0 to 9");
        
       for(int i =0;i<width; i++){
            for(int j=0;j<height;j++){
                 System.out.println("Enter element for array[" + (i + 1) + "," + (j + 1) + "] : ");
                 
                 int number = sc.nextInt();
                 if(number>0 && number<10){
                     arr[i][j] = number;
                 }else{
                     System.out.println("number must be in the 0 to 9");
                 }
            }

        }
        
        
      
          System.out.println("You have entered : ");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

         System.out.println("Input maximum width of square submatrix:");
         int sm = sc.nextInt();
        if (sm > width || sm > height) {
                    throw new RuntimeException("Invalid input");
            }
            
                return new Matrix(arr, sm);
            
    }catch (Exception e) {
       
    }
        return null;
}



}

class SubMatrixSum {
    int[][] subMatrix;
    Integer sum;

    public SubMatrixSum(int[][] subMatrix, Integer sum) {
        super();
        this.subMatrix = subMatrix;
        this.sum = sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix: \n");
        for (int i = 0; i < subMatrix.length; i++) {
            for (int j = 0; j < subMatrix[i].length; j++) {
                sb.append(subMatrix[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append("Sum: " + sum);
        return sb.toString();
    }
}

class Matrix {
    int[][] matrix;
    int subMatrixSize;

    public Matrix(int[][] matrix, int subMatrixSize) {
        super();
        this.matrix = matrix;
        this.subMatrixSize = subMatrixSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}


