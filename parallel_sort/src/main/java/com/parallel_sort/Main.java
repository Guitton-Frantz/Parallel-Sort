package com.parallel_sort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MoniteurProdCons in = new MoniteurProdCons();
        MoniteurProdCons out = new MoniteurProdCons();
        MoniteurProdCons outputLeft = out;
        MoniteurProdCons inputLeft = in;
        MoniteurProdCons outputRight;
        MoniteurProdCons inputRight;
        int n = 101;

        for (int i = 0; i < n / 2; i++) {
            outputRight = new MoniteurProdCons();
            inputRight = new MoniteurProdCons();
            if (i == n / 2 - 1) {
                outputRight = new Bouchon();
                inputRight = new Bouchon();
            }
            new Thread(new Sorter(inputLeft, inputRight, outputLeft, outputRight, n)).start();
            inputLeft = outputRight;
            outputLeft = inputRight;
        }

        for (int i = 0; i < n; i++) {
            double val = Math.random() * 100;
            in.prod(val);
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Double> list = new ArrayList<>();
            list.add(out.cons());
            System.out.println("Result: " + list);
        }
    }
}