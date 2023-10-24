package com.parallel_sort;

public class MoniteurProdCons {
    double tampon;
    boolean estVide = true;

    synchronized void prod(double m) {
        if (!estVide) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        tampon = m;
        estVide = false;
        notify();
    }

    synchronized double cons() {
        if (estVide) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        double result = tampon;
        estVide = true;
        notify();
        return result;
    }

}
