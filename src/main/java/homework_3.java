// Задание:
//        Пусть дан произвольный список целых чисел.
//        1) Нужно удалить из него чётные числа
//        2) Найти минимальное значение
//        3) Найти максимальное значение
//        4) Найти среднее значение

import java.util.*;

public class homework_3 {
    public static void main(String[] args) {

// Создание произвольного списка из 50 целых чисел:

        Integer[] integers = new Integer[50];
        Random random = new Random();

        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt(50);
        }

        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(integers));
        System.out.println("Начальный список чисел: ");
        System.out.println(integerArrayList);

        System.out.println("-------------------------------------------------");

// Удаление чётных чисел (Вариант №1) :
        for (Iterator<Integer> iterator = integerArrayList.iterator(); iterator.hasNext();) {
            if (0 == (iterator.next() & 1)) {
                iterator.remove();
            }
        }
        System.out.println("Список не четных чисел: ");
        System.out.println(integerArrayList);

// Удаление чётных чисел (Вариант №2) :
//       for (int i = integerArrayList.size(); i-- > 0;) {
//           if (integerArrayList.get(i) % 2 == 0) {
//               integerArrayList.remove(i);
//           }
//       }
//       System.out.println(integerArrayList.toString());

//        2) Нахождение минимального значения:
        Collections.sort(integerArrayList);   // сортирую список чисел по возрастанию

        int min = integerArrayList.get(0);
        System.out.println("Минимальное значение: " + min);

//        3) Нахождение максимального значения:
        int max = integerArrayList.get(integerArrayList.size() - 1);
        System.out.println("Максимальное значение: " + max);

//        4) Нахождение среднего значения
        double sum = 0;
        for (int i: integerArrayList) {
            sum += i;
        }
        double avg = sum / integerArrayList.size();
        System.out.println("Среднее значение: " + avg);
    }
}
