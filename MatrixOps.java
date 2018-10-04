public class MatrixOps{
	public static double[][] multiply(double[][] matrix1, double[][] matrix2){
		
		int rowA = matrix1.length;
		int rowB = matrix2.length;
		int colA = matrix1[0].length;
		int colB = matrix2[0].length;
		
		
		double[][] matrix3 = new double[matrix1.length][matrix2[0].length];
		
		
		if ( colA != rowB ) {

		    System.out.println("Does not work");
		    
		    return null;

		  }
		
		for(int i = 0; i < rowA; i++){

			for(int j = 0; j < colB; j++){

				for(int k = 0; k < colA; k++){

					matrix3[i][j] = matrix3[i][j] + (matrix1[i][k] * matrix2[k][j]);
				}
			}
		}
		
		return matrix3;
	}
}