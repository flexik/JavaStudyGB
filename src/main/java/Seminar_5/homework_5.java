package Seminar_5;

// Задание:
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

public class homework_5 {
    public static void main(String[] args) {
        HashMap<String, String> phonebook = new HashMap<>();
        addContacts(phonebook, "Elena", "+78737892387");
        addContacts(phonebook, "Alexander", "+85939878922");
        addContacts(phonebook, "Elena", "+93458992255");
        addContacts(phonebook, "Elizaveta", "+78745377321");
        addContacts(phonebook, "Elena", "+95673444666");
        print(phonebook);
    }

    public static void addContacts(HashMap<String, String> book, String contact, String phone) {
        book.merge(contact, phone, (ph1, ph2) -> ph1 + ", " + ph2);
    }

    public static void print(HashMap<String, String> book) {
        ArrayList<Map.Entry<String, String>> list = new ArrayList<>(book.entrySet());
        list.sort((o1, o2) -> o2.getValue().length() - o1.getValue().length());
        for (Map.Entry<String, String> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
