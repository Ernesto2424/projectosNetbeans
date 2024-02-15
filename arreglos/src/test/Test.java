package test;

public class Test {

    public static void main(String[] args) {
        int arr[] = new int[3];
        
        for(int i=0; i<arr.length; ++i){
            arr[i]=i;
        }
        
        for(int i=0; i<arr.length; ++i){
            System.out.println("i = " + i);
        }
        
        arr[2] = 15;
        System.out.println("arr2 = " + arr[2]);
    }
    
    
    
}
