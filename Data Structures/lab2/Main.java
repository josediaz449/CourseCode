package lab2;

public class Main {
	
	 public int linearSearch(int[] a1, int[] a2) {
         int result = 0;
         for(int i = 0; i<a2.length;i++){
             for(int j = 0; j<a1.length;j++){
                 if(a2[i] == (a1[j])){
                     result+=1;
                     break;
                 }
             }
         }
         return result;

	 }
	 
	 public int binarySearch(int[] a1, int[] a2) {
         int result = 0;
         
         for(int i = 0; i<a2.length;i++){
             int mid = a1.length/2;
             int currentLength = a1.length;
             while(currentLength>1) {
            	 if(a2[i]>a1[mid]) {
            		 currentLength= currentLength/2;
            		 mid = mid + mid/2;
            	 }
            	 else if(a2[i]<a1[mid]) {
            		 currentLength = currentLength/2;
            		 mid = mid - mid/2;
            	 }
            	 else {
            		result+=1; 
            		break;
            	 }
             }
         }
         return result;

	 }
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		int[] a1 = new int[]{1,  1, 2, 3, 3};
		int[] a2 = new int[]{1, 2, 4};
		System.out.println(main.linearSearch(a1, a2));
		System.out.println(main.binarySearch(a1, a2));

	}

}
