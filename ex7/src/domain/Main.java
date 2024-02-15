/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Personal
 */
class Main {

    static List<Integer> lista = new ArrayList<>();
    static List<Integer> lista2 = new ArrayList<>();

    public static void inorder(Nodo root) {
        if (root == null) {
            return;
        }

        inorder(root.izq);
        lista.add(root.key);
        System.out.print(root.key + " ");
        inorder(root.der);
    }

    public static void postorder(Nodo root) {
        if (root == null) {
            return;
        }

        postorder(root.izq);
        postorder(root.der);
        lista2.add(root.key);
        System.out.print(root.key + " ");
    }

    public static Nodo construir(int start, int end,
            int[] postorder, AtomicInteger pIndex,
            Map<Integer, Integer> map) {
        // caso base
        if (start > end) {
            return null;
        }

        Nodo root = new Nodo(postorder[pIndex.getAndDecrement()]);

        int index = map.get(root.key);

        root.der = construir(index + 1, end, postorder, pIndex, map);

        root.izq = construir(start, index - 1, postorder, pIndex, map);

        // devuelve el nodo raíz
        return root;
    }

    public static Nodo construir(int[] inorder, int[] postorder) {

        int n = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        AtomicInteger pIndex = new AtomicInteger(n - 1);
        return construir(0, n - 1, postorder, pIndex, map);
    }

    public static void main(String[] args) {

//        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
//        int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1 };
//        int[] inorder = { 9,3,1,0,4,2,7,6,8,5 };
//        int[] postorder = { 9,1,4,0,3,6,7,5,8,2};
        int[] inorder = {17, 9, 10, 13, 14, 18, 6, 24, 20, 26, 29, 32, 34, 36, 40};
        int[] postorder = {6, 10, 9, 14, 17, 18, 13, 24, 29, 26, 34, 40, 36, 32, 20};

        try {
            Nodo root = construir(inorder, postorder);

            System.out.print("Inorder: ");
            inorder(root);
            System.out.print("\nPostorder: ");
            postorder(root);
            System.out.println("");
            int[] arrInorder = new int[lista.size()];
            int[] arrPostorder = new int[lista2.size()];
            for (int i = 0; i < lista.size(); ++i) {
                arrInorder[i] = lista.get(i);
                arrPostorder[i] = lista2.get(i);

            }
        } catch (Exception e) {
            System.out.println("Error en las listas proporcionadas");
        }

    }
}
