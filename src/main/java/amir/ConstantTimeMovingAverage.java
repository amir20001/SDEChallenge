package amir;

/**
 * ConstantTimeMovingAverage
 *
 * Not thread safe should not be used in a multi threaded manner
 */
public class ConstantTimeMovingAverage implements Average {

  private Number[] values;
  private int index;
  private double total;
  private double average;

  public ConstantTimeMovingAverage(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("invalid size: " + size + " must be a positive number");
    }
    values = new Number[size];
    index = 0;
    total = 0;
    average = 0;
  }

  /**
   *
   * @param number the number to be considered for averaging
   * @throws NullPointerException if the specified number is null
   */

  @Override
  public void add(Number number) {
    if (number == null) {
      throw new NullPointerException("expect non null number");
    }
    Number oldValue = values[index];
    values[index] = number;

    total = total + number.doubleValue();
    if (oldValue != null) {
      total = total - oldValue.doubleValue();
    }
    average = total / values.length;

    index++;
    if (index == values.length) {
      index = index - values.length;
    }
  }

  @Override
  public double getAverage() {
    return average;
  }
}
