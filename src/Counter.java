/**
 * @author Amit lavi
 */
public class Counter {
    private int value;

    /**
     * Instantiates a new Counter.
     *
     * @param num the num
     */
    public Counter(int num) {
        this.value = num;
    }

    /**
     * Increase the counter.
     *
     * @param number the number
     */
// add number to current count.
    public void increase(int number) {
        this.value += number;

    }

    /**
     * Decrease the counter.
     *
     * @param number the number
     */
// subtract number from current count.
    public void decrease(int number) {
        this.value -= number;
    }

    /**
     * return the value in counter.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }
}