package com.parallel_sort;

public class Bouchon extends MoniteurProdCons {
    @Override
    synchronized void prod(double m) {
    }

    @Override
    synchronized double cons() {
        return Double.POSITIVE_INFINITY;
    }
}