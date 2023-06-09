import java.util.Random;

public class HomeWork_1 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(2001);   // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        System.out.println(i);
    }
}

// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа