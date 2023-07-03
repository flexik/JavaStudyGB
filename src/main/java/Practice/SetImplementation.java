package Practice;

import java.util.HashMap;
import java.util.Iterator;

//класс, имитирующий Hashset, хранящий int'ы
public class SetImplementation {
    public static void main(String[] args) {
        MySet set = new MySet();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
        System.out.println(set.add(4));
        System.out.println(set.add(5));
        System.out.println(set.add(4));
        System.out.println(set.add(2));
        System.out.println(set.getElByIndex(2));
        System.out.println("---------------");

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(set.isEmpty());
        System.out.println(set.contains(2));
        System.out.println("---------------");
        System.out.println(set.remove(1));
        System.out.println(set.remove(1));
        System.out.println(set.remove(4));
        System.out.println(set.remove(5));
        System.out.println(set.remove(4));
        System.out.println(set.remove(2));
        System.out.println("---------------");
        System.out.println(set.isEmpty());
        System.out.println(set.contains(2));
        System.out.println("---------------");
    }
}

class MySet {
    private final HashMap<Integer, Object> myList = new HashMap<>();
    private static final Object OBJECT = new Object();



    public boolean add(int el) {         // метод, добавляющий элемент в список (true - добавлен, false - не добавлен)
        return myList.put(el, OBJECT) == null;
    }


    public boolean remove(int el) {      // метод, удаляющий элемент из списка (true - удален, false - не удален)
        return myList.remove(el) != null;
    }


    public boolean isEmpty() {    // метод, проверяющий на пустоту списка (true - пусто, false - не пусто)
        return myList.isEmpty();
    }


    public boolean contains(int el) {   // метод, проверяющий на наличие элемента в списке (true - есть, false - нет)
        return myList.containsKey(el);
    }


    public int getElByIndex(int index) {
        Object[] a = myList.keySet().toArray();
        return (int) a[index];
    }


    public Iterator<Integer> iterator() {
        return myList.keySet().iterator();
    }
}