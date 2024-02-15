/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author ernes
 */



public class figuras {
public static void fig1(int n){
  if(n > 0){
      fig1(n-1);
      for(int i = 0; i < n; i++){
        System.out.print("*");
      }
      System.out.println();
    }
  }

public static void fig2(int n){
    for (int i = 0; i <= n; i++) {
        
        for (int j = 0; j < n-(n-i); j++) {
            System.out.print("*");
        }
        System.out.println("");
    }
    
}

    public static void main(String[] args) {
        fig2(5);
    }

}
