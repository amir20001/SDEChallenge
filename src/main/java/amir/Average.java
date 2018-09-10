package amir;

/**
 * MovingAverage
 *
 * Interface for a generic moving average structure.
 *
 */
public interface Average {

  /**
   *
   * @param number the number to be considered for averaging
   */
  void add(Number number);

  /**
   *
   * @return the average of the last N items added
   */
  double getAverage();
}
