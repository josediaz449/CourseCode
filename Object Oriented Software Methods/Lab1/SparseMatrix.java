package Lab1;

import java.util.ArrayList;

public class SparseMatrix {
   private int row;
   private int column;
   private double[][] elements;
   private ArrayList<Integer> rowPos;
   private ArrayList<Integer> colomnPos;
   public SparseMatrix(int row, int column){
      this.row=row;
      this.column=column;
      elements=new double[row][column];
      rowPos= new ArrayList<>();
      colomnPos= new ArrayList<>();
   }
   public void setElement(int row, int column, int element){
      elements[row][column]=element;
      rowPos.add(row);
      colomnPos.add(column);
   }
   public double getElement(int row, int column){
      return elements[row][column];
   }
   public SparseMatrix addMatrix(SparseMatrix otherMatrix){
      if(this.getRow()==otherMatrix.getRow()&&this.getColumn()==otherMatrix.getColumn()){
         for(int i=0;i<this.rowPos.size();i++){
            otherMatrix.elements[rowPos.get(i)][colomnPos.get(i)]= this.getElement(rowPos.get(i),colomnPos.get(i))+otherMatrix.getElement(rowPos.get(i),colomnPos.get(i));
         }
         return otherMatrix;
      }
      else {
         System.out.println("Matrices are different sizes, cannot add.");
         return otherMatrix;
      }
   }
   public SparseMatrix multiplyMatrix(Matrix otherMatrix){
      SparseMatrix newMatrix = new SparseMatrix(this.getRow(),otherMatrix.getColumn());
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
