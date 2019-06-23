public class Main {

    public static void main(String[] args) {
        int[][] array2D = new int[][]{
                {1, 2, 3, 3},
                {4, 5, 4, 6},
                {7, 8, 9, 9},
                {0, 1, 2, 3}

        };
        System.out.println(determinant(array2D));
    }

    public static int determinant(int[][] matrix){
        int length = matrix[0].length;

        switch (length){
            case 1:
                return matrix[0][0];
            case 2:
                return determinantOfTwo(matrix);
            case 3:
                return determinantOfThree(matrix);
            case 4:
                return determinantOfFour(matrix);
        }

        return 0;
    }

    public static int determinantOfTwo(int[][] matrix){
        return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
    }

    public static int determinantOfThree(int[][] matrix){
        return matrix[0][0]*determinantOfTwo(new int[][] {{matrix[1][1], matrix[1][2]}, {matrix[2][1], matrix[2][2]}}) -
               matrix[0][1]*determinantOfTwo(new int[][] {{matrix[1][0], matrix[1][2]}, {matrix[2][0], matrix[2][2]}}) +
               matrix[0][2]*determinantOfTwo(new int[][] {{matrix[1][0], matrix[1][1]}, {matrix[2][0], matrix[2][1]}});
    }

    public static int determinantOfFour(int[][] matrix){
        return matrix[0][0]*determinantOfThree(new int[][] {{matrix[1][1], matrix[1][2], matrix[1][3]}, {matrix[2][1], matrix[2][2],matrix[2][3]},{matrix[3][1], matrix[3][2],matrix[3][3]}}) -
               matrix[0][1]*determinantOfThree(new int[][] {{matrix[1][0], matrix[1][2], matrix[1][3]}, {matrix[2][0], matrix[2][2],matrix[2][3]},{matrix[3][0], matrix[3][2],matrix[3][3]}}) +
               matrix[0][2]*determinantOfThree(new int[][] {{matrix[1][0], matrix[1][1], matrix[1][3]}, {matrix[2][0], matrix[2][1],matrix[2][3]},{matrix[3][0], matrix[3][1],matrix[3][3]}}) -
               matrix[0][3]*determinantOfThree(new int[][] {{matrix[1][0], matrix[1][1], matrix[1][2]}, {matrix[2][0], matrix[2][1],matrix[2][2]},{matrix[3][0], matrix[3][1],matrix[3][2]}});
    }
}
