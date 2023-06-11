//Пункты реализовать в методе main
//*Пункты реализовать в разных методах

import java.util.Random;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        //1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        int i = getInt(2000);
        //2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        int n = bit(i);
        //3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
        int[] m1 = multiples(i, n);
        //4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
        int[] m2 = notMultiples(i, n);
    }

    private static int getInt(int inputNumber) {    // 1. Метод "выбрасывания" случайного целого числа в диапазоне от 0 до заданного числа
        int randomNumber = new Random().nextInt(inputNumber);
        System.out.println(randomNumber);
        return randomNumber;
    }

    private static int bit(int x) {    // 2. Метод подсчета номера старшего значащего бита выпавшего числа
        int maxBit = 1;
        if (x >= maxBit << 16) maxBit <<= 16;
        if (x >= maxBit << 8) maxBit <<= 8;
        if (x >= maxBit << 4) maxBit <<= 4;
        if (x >= maxBit << 2) maxBit <<= 2;
        if (x >= maxBit << 1) maxBit <<= 1;
        System.out.println(maxBit);
        return maxBit;
    }

    private static int[] multiples(int i, int n) {   //3. Метод нахождения всех кратных n чисел в диапазоне от i до Short.MAX_VALUE (32767)
        int size = 0;
        int index = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) if (j % n == 0) size++;
        int[] array = new int[size];
        while (i < Short.MAX_VALUE) {
            if (i % n == 0) {
                array[index] = i;
                index++;
            }
            i++;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }


    private static int[] notMultiples(int i, int n) {    //3. Метод нахождения НЕ кратных n чисел в диапазоне от Short.MIN_VALUE(-32768) ДО i
        int size = 0;
        int index = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) if (j % n != 0) size++;
        int[] array = new int[size];
        int k = Short.MIN_VALUE;
        while (k < i) {
            if (k % n != 0) {
                array[index] = k;
                index++;
            }
            k++;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}




