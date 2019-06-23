public class Main_v2 {
    public static void main(String[] args) {
        int[][] array2D = new int[][]{
                        {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 1},
                        {1, 2, 8, -3, 2},
                        {9, 8, 2, 6, 3},
                        {2, 1, 4, 5, 1}


        };
        //testing
//        int[][] shieeet = deleteColumnAndRow(array2D,1,2);
//        for (int i=0;i<shieeet.length;i++){
//            for (int j=0;j<shieeet.length;j++){
//                System.out.print(shieeet[i][j] +", ");
//            }
//            System.out.println();
//        }


//        {1, 2, 3, 3},
//        {4, 5, 4, 6},
//        {7, 8, 9, 9},
//        {0, 1, 2, 3}


        System.out.println(determinant(array2D));
    }

    public static int determinant(int[][] matrix){
        int length = matrix[0].length;
        int determinant =0;

        if (length == 1){
            return matrix[0][0];
        }else if (length == 2){
            return determinantOfTwo(matrix);
        }

        if (length >2){
            for (int i=0;i<length;i++){
                     determinant += Math.pow(-1,i)*matrix[0][i]*determinant(deleteColumnAndRow(matrix,0,i));
            }
            return determinant;

        }else if (length == 2){
            return determinantOfTwo(matrix);
        }

       return -1337;
    }

    public static int determinantOfTwo(int[][] matrix){
        return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
    }

    public static int[][] deleteColumnAndRow(int[][] matrix,int row, int column){

        //marking unnecessary elements as Integer.MIN_VALUE
        int[][] editedArray = new int[matrix.length][matrix.length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix.length;j++){
                if (i==row || j==column){
                    editedArray[i][j] = Integer.MIN_VALUE;
                }else{
                    editedArray[i][j] = matrix[i][j];
                }
            }
        }

        //removing unnecessary rows and columns
        int[][]returnedArray = new int[editedArray.length-1][editedArray.length-1];
        int numberOfRow =0;
        int numberOfColumn =0;

        //skipping if necessary first row/column
        int ii=0;
        int jj=0;

        if (row==0){
             ii=1;
        }

        if (column==0){
            jj=1;
        }

        for (int i=ii;i<editedArray.length;i++){

            //if there are unnecsesery rows not on borders of array, skip them
            if (row!=0 && row!=editedArray.length-1){
                if (editedArray[i][0] == Integer.MIN_VALUE){
                    numberOfRow--;
                }
            }

            for (int j=jj;j<editedArray.length;j++){
                if (editedArray[i][j] != Integer.MIN_VALUE){
                    returnedArray[numberOfRow ][numberOfColumn] = editedArray[i][j];
                    numberOfColumn++;
                }
            }
            numberOfRow++;
            numberOfColumn=0;
        }

        return returnedArray;
    }
}
