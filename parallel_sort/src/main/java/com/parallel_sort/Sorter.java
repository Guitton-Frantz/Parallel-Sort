package com.parallel_sort;

/**
 * Sorter class that implements Runnable
 */
public class Sorter implements Runnable {
    /**
     * Input Left
     */
    private MoniteurProdCons inputLeft;
    /**
     * Input Right
     */
    private MoniteurProdCons inputRight;
    /**
     * Output Left
     */
    private MoniteurProdCons outputLeft;
    /**
     * Output Right
     */
    private MoniteurProdCons outputRight;
    /**
     * Max value
     *
     */
    private double maxValue;
    /**
     * Min value
     */
    private double minValue;
    /**
     * Size of the array
     */
    private int n;

    /**
     * 
     * @param inputLeft
     * @param inputRight
     * @param outputLeft
     * @param outputRight
     */
    public Sorter(MoniteurProdCons inputLeft, MoniteurProdCons inputRight, MoniteurProdCons outputLeft,
            MoniteurProdCons outputRight, int n) {
        this.inputLeft = inputLeft;
        this.inputRight = inputRight;
        this.outputLeft = outputLeft;
        this.outputRight = outputRight;
        this.n = n;
        this.maxValue = Double.POSITIVE_INFINITY;
        this.minValue = Double.POSITIVE_INFINITY;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {

            double leftInput = inputLeft.cons();
            outputRight.prod(maxValue);
            maxValue = leftInput;
            if (maxValue < minValue) {
                double tmp = maxValue;
                maxValue = minValue;
                minValue = tmp;
            }
            // System.out.println("i: " + i + " Max value: " + maxValue + " Min value: " +
            // minValue);
        }

        for (int i = 0; i < n; i++) {
            // System.out.println("Max value: " + maxValue + " Min value: " + minValue);

            double rightInput = inputRight.cons();
            outputLeft.prod(minValue);
            minValue = rightInput;
            if (maxValue < minValue) {
                double tmp = maxValue;
                maxValue = minValue;
                minValue = tmp;
            }
        }
    }

}
