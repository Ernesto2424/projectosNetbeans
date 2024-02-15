package test;

public class Test {

    public static void main(String[] args) {
       
        int arr[][] = new int[3][2];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("i-j "+arr[i][j]);
            }
        }
        
        
        
    }
    
    
    
}
