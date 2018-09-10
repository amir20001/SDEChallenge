package amir;

/**
 * Average
 *
 * Interface for a generic moving average structure.
 *
 * This interface uses the number class to allow for all numeric values to be passed in.
 * Alternatively if we want all the type to be the same we could type the interface
 */

public interface Average<T> {

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
