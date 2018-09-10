package amir;

/**
 * LazyMovingAverage
 *
 * Not thread safe should not be used in a multi threaded manner
 */

public class LazyMovingAverage implements Average {

  private Number[] values;
  private int index;

  public LazyMovingAverage(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("invalid size: " + size + " must be a positive number");
    }
    values = new Number[size];
    index = 0;
  }

  @Override
  public void add(Number number) {
    values[index] = number;
    index++;

    // could use a modulus operator instead but could eventually run into a overflow exception
    if (index == values.length) {
      index = index - values.length;
    }
  }

  @Override
  public double getAverage() {
    double total = 0;

    for (int i = 0; i < values.length; i++) {
      if (values[i] == null) {
        continue;
      }
      total = total + values[i].doubleValue();
    }
    return total / values.length;
  }
}
