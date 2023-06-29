package Seminar_4;

import java.util.ArrayList;
import java.util.Scanner;

public class homework_4 {
    public static void main(String[] args) {
        ArrayList<String>[] db = createDB();
        db = workWithDB(db);
        printDB(db);
    }

    public static ArrayList<String>[] createDB() {
        ArrayList[] db = new ArrayList[6];
        db[0] = new ArrayList<String>(); // surname
        db[1] = new ArrayList<String>(); // name
        db[2] = new ArrayList<String>(); // parentName
        db[3] = new ArrayList<String>(); // age
        db[4] = new ArrayList<String>(); // sex
        db[5] = new ArrayList<String>(); // id
        return db;
    }

    public static ArrayList<String>[] workWithDB(ArrayList<String>[] db) {
        System.out.println("Введите данные в базу данных в формате: Фамилия Имя Отчество возраст пол, или q - для выхода из режима ввода данных");
        int id = 0;
        Scanner scanner = new Scanner(System.in);
        String str;
        while (true) {
            str = scanner.nextLine();
            if (str.equals("q")) {
                break;
            }
            String[] person = str.split(" ");
            insertPerson(db, person, id);
            id++;
        }
        System.out.println("Введите необходимый режим сортировки:");
        System.out.println("age - по возрасту");
        System.out.println("sex - по полу");
        System.out.println("init - по начальному порядку ввода данных");
        System.out.println("q - для выхода из режима выбора сортировки и отображения полученного результата");
        while (true) {
            str = scanner.nextLine();
            if (str.equals("q")) {
                System.out.println("Вы завершили сортировку данных");
                return db;
            }
            db = sortByField(db, str);
            System.out.println("Введите по какому полю сортировать далее или введите q - чтобы распечатать данные и завершить работу:");
        }
    }

    public static String getInput() {
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        scanner.close();
        return str;
    }

    public static void insertPerson(ArrayList<String>[] db, String[] person, int id) {
        for (int i = 0; i < person.length; i++) db[i].add(person[i]);
        db[5].add(String.format("%s", id));
    }

    public static void printDB(ArrayList<String>[] db) {
        ArrayList<String> surnames = db[0];
        ArrayList<String> names = db[1];
        ArrayList<String> parentNames = db[2];
        ArrayList<String> age = db[3];
        ArrayList<String> sex = db[4];
        ArrayList<String> id = db[5];
        for (int i = 0; i < surnames.size(); i++) {
            System.out.printf("%s %s.%s. %s %s\n",
                    surnames.get(Integer.parseInt(id.get(i))),
                    names.get(Integer.parseInt(id.get(i))).toUpperCase().charAt(0),
                    parentNames.get(Integer.parseInt(id.get(i))).toUpperCase().charAt(0),
                    age.get(Integer.parseInt(id.get(i))),
                    sex.get(Integer.parseInt(id.get(i))));
        }
    }

    public static ArrayList<String>[] sortByField(ArrayList<String>[] db, String fieldName) {
        Integer[] field = new Integer[db[5].size()];
        Integer[] id = new Integer[db[5].size()];
        ArrayList<String> sortedId = new ArrayList<>();
        switch (fieldName) {
            case "age":
                field = convertFieldToInt(db[3]);
                id = convertFieldToInt(db[5]);
                id = bubbleSort(id, field);
                sortedId = convertFieldToStr(id);
                db[5] = sortedId;
                break;
            case "sex":
                field = convertSexToInt(db[4]);
                id = convertFieldToInt(db[5]);
                id = bubbleSort(id, field);
                sortedId = convertFieldToStr(id);
                db[5] = sortedId;
                break;
            case "init":
                for (int i = 0; i < db[0].size(); i++) {
                    sortedId.add(String.valueOf(i));
                    db[5] = sortedId;
                }
                break;
            default:
                break;
        }
        return db;
    }


    public static Integer[] convertFieldToInt(ArrayList<String> field) {
        Integer[] intField = new Integer[field.size()];
        for (int i = 0; i < field.size(); i++) intField[i] = Integer.parseInt(field.get(i));
        return intField;
    }

    public static ArrayList<String> convertFieldToStr(Integer[] field) {
        ArrayList<String> strField = new ArrayList<>();
        for (Integer integer : field) strField.add(String.valueOf(integer));
        return strField;
    }

    public static Integer[] convertSexToInt(ArrayList<String> sex) {
        Integer[] sexAsInt = new Integer[sex.size()];
        for (int i = 0; i < sex.size(); i++) {
            if (sex.get(i).equals("м")) sexAsInt[i] = 0;
            else if (sex.get(i).equals("ж")) sexAsInt[i] = 1;
            else sexAsInt[i] = 2;
        }
        return sexAsInt;
    }

    public static ArrayList<String> convertIntToSex(Integer[] sexAsInt) {
        ArrayList<String> sex = new ArrayList<>();
        for (int i = 0; i < sexAsInt.length; i++) {
            if (sexAsInt[i] == 0) sex.add("м");
            else if (sexAsInt[i] == 1) sex.add("ж");
            else sex.add("не определен");
        }
        return sex;
    }

    public static Integer[] bubbleSort(Integer[] id, Integer[] sortField) {
        for (int i = sortField.length; i >= 0; i--) {
            int temp;
            for (int j = 1; j < i; j++) {
                if (sortField[id[j - 1]] > sortField[id[j]]) {
                    temp = id[j - 1];
                    id[j - 1] = id[j];
                    id[j] = temp;
                }
            }
        }
        return id;
    }
}