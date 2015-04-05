/*
 * Adam Morris
 * 010858274
 * Project3
 */

import java.util.Comparator;

public interface List extends Iterable {

   void addLast(Object item);

   void insert(int index, Object item);

   Object get(int index);

   int indexOf(Object item);

   Object removeAt(int index);

   boolean remove(Object item);

   void clear();

   int getCount();

   void sort(Comparator comp);
}
