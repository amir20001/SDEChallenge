package amir;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author groupby
 */
public class ConstantTimeMovingAverageTest {

  @Test(expected = IllegalArgumentException.class)
  public void testInitWithNegativeSize() {
    new ConstantTimeMovingAverage(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInitWithZeroSize() {
    new ConstantTimeMovingAverage(0);
  }

  @Test
  public void testAddSingleItem() {
    Average movingAverage = new ConstantTimeMovingAverage(1);
    movingAverage.add(3);
    assertEquals(3, movingAverage.getAverage(), .01);
  }

  @Test
  public void testAddTwoItemsToSize1() {
    Average movingAverage = new ConstantTimeMovingAverage(1);
    movingAverage.add(3);
    movingAverage.add(4);
    assertEquals(4, movingAverage.getAverage(), .01);
  }

  @Test
  public void testAddMultipleValuesToSize2() {
    Average movingAverage = new ConstantTimeMovingAverage(2);
    movingAverage.add(3);
    movingAverage.add(4);
    assertEquals(3.5, movingAverage.getAverage(), .01);
  }

  @Test
  public void testOneItemInLargerQueue() {
    Average movingAverage = new ConstantTimeMovingAverage(2);
    movingAverage.add(4);
    assertEquals(2, movingAverage.getAverage(), .01);
  }

  @Test
  public void testGetAvgOnEmptyList() {
    Average movingAverage = new ConstantTimeMovingAverage(2);
    assertEquals(0, movingAverage.getAverage(), .01);
  }

  @Test(expected = NullPointerException.class)
  public void testAddingNull() {
    Average movingAverage = new ConstantTimeMovingAverage(2);
    movingAverage.add(null);
    assertEquals(0, movingAverage.getAverage(), .01);
  }
}