package HW3;
/*Please solve Exercise 4.1 on page 170.
Exercise 4.1. When sorting a collection of objects that implements the Comparable type,
the sorting method compares and rearranges the objects. Explain the role of polymorphism
in this situation.
To be very clear: define your own Comparable interface and your own generic sort method
Then repeat the process for the java.util.Comparator interface.*/
public interface Comparable<E> {
   int compareTo(E other);
}
