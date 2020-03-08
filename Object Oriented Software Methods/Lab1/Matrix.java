package Lab1;

public class Matrix {
   private int row;
   private int column;
   private double[][] elements;
   public Matrix(int row, int column){
      this.row=row;
      this.column=column;
      elements=new double[row][column];
   }
   public void setElement(int row, int column, int element){
      elements[row][column]=element;
   }
   public double getElement(int row, int column){
      return elements[row][column];
   }
   public Matrix addMatrix(Matrix otherMatrix){
      Matrix newMatrix = new Matrix(this.getRow(),this.getColumn());
      if(this.getRow()==otherMatrix.getRow()&&this.getColumn()==otherMatrix.getColumn()){
         for(int i=0;i<this.getRow();i++){
            for(int j =0; j<this.getColumn();j++){
               newMatrix.elements[i][j]= this.getElement(i,j)+otherMatrix.getElement(i,j);
            }
         }
         return newMatrix;
      }
      else {
         System.out.println("Matrices are different sizes, cannot add.");
         return newMatrix;
      }
   }
   public Matrix multiplyMatrix(Matrix otherMatrix){
      Matrix newMatrix = new Matrix(this.getRow(),otherMatrix.getColumn());
      if(this.getColumn()==otherMatrix.getRow()){
         for(int i = 0;i<newMatrix.getRow();i++){
            for (int j =0;j<newMatrix.getColumn();j++){
               int element =0;
               for(int n =0;n<this.getColumn();n++){
                  element+=this.getElement(i,n)*otherMatrix.getElement(n,j);
               }
               newMatrix.elements[i][j] = element;
            }
         }
         return newMatrix;
      }
      else {
         System.out.println("Cannot multiply, not correct sizes");
         return newMatrix;
      }
   }
   public int getRow() {
      return row;
   }
   public int getColumn() {
      return column;
   }
}
