// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} Пример на выходе: select * from students where city = 'Newton'
// select * from students where {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

//// 1 способ - c помощью StringBuilder и HashMap:

//import java.util.HashMap;
//import java.util.Map;
//
//public class homework_2 {
//    public static void main(String[] args) {
//        Map<String, String> hashmap = new HashMap<String,String>();        // {country=Russia, city=Moscow, name=Ivanov, age=null}
//        hashmap.put("name","Ivanov");
//        hashmap.put("country","Russia");
//        hashmap.put("city","Moscow");
//        hashmap.put("age",null);
//        System.out.println(getQuery(hashmap));
//
//    }
//    private static String getQuery(Map<String, String> params){
//        StringBuilder result = new StringBuilder("select * from students where ");
//        for (Map.Entry<String,String> pair : params.entrySet())        // select * from students where country = 'Russia' and city = 'Moscow' and name = 'Ivanov' and
//        {
//            if (pair.getValue() != null)
//            {
//                result.append(pair.getKey() +" = '" + pair.getValue()+"' and ");
//            }
//        }
//        result.delete(result.toString().length()-5,result.toString().length());
//        return result.toString();
//    }
//}


//// 2 способ - с помощью StringBuilder и String:
//public class homework_2 {
//    public static void main(String[] args) {
//        create_sql_filter();
//    }
//
//    public static void create_sql_filter() {
//        String query = "select * from students where ";
//        String filterData = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
//        filterData = filterData.replace("{", "");   // убираем скобки
//        filterData = filterData.replace("}", "");
//        String[] queryArray = filterData.replaceAll(":", " = ").split(",");   // ["name" = "Ivanov",  "country" = "Russia",  "city" = "Moscow",  "age" = "null"]
//        StringBuilder sb = new StringBuilder();
//        sb.append(query);
//        for (int i = 0; i < queryArray.length; i++) {
//            if (!queryArray[i].contains("null"))
//                sb.append(queryArray[i].replaceFirst("\"", "").replaceFirst("\"", ""));
//            if (i < queryArray.length - 2) sb.append(" and");
//        }
//        System.out.println(sb);
//    }
//
//}


//Дополнительные задания
//Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]

//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

//public class homework_2 {
//    public static void main(String[] args) {
//        String json = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
//        String[] string = json.split(",");
//        int count = 0;
//        int count2 = 1;
//        int count3 = 2;
//
//        for (int i = 0; i < string.length; i++) {
//            if (count == 9){break;}         // длина массива = 9
//            String surname = string[count].replaceAll("\"", "").substring(9).replaceAll(":", "");
//            String grade = string[count2].replaceAll("\"", "").substring(7);
//            String lesson = string[count3].replaceAll("\"", "").replaceAll("}", "").substring(8).replaceAll("]", "");
//
//            count = count + 3;
//            count2 = count2 + 3;
//            count3 = count3 + 3;
//
//            StringBuilder result = new StringBuilder();
//            result.append("Студент ").append(surname).append(" получил ").append(grade).append(" по предмету ").append(lesson).append(".");
//            System.out.println(result.toString());
//        }
//    }
//}


//// *Сравнить время выполнения замены символа "а" на "А" любой строки содержащей > 1000 символов средствами String и StringBuilder.

//public class homework_2 {
//    public static void main(String[] args) {
//        String data = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris fringilla, velit sed placerat efficitur, nunc ipsum ullamcorper augue, a vehicula urna ex in massa. Nulla facilisi. Aliquam molestie volutpat arcu. Quisque quis quam fringilla, maximus ipsum nec, viverra metus. Proin venenatis elementum turpis pretium aliquam. Phasellus et dignissim nisl, non faucibus sem. Fusce bibendum, nisl nec feugiat auctor, magna orci pellentesque justo, sit amet ultricies turpis eros quis mi. Integer nec mi quis quam lobortis lobortis. Morbi viverra fringilla nisi, condimentum ornare elit rhoncus auctor. Proin eget tellus metus. Sed vel dignissim eros. Nulla ac felis iaculis, dapibus quam sit amet, auctor velit. Morbi scelerisque in justo nec imperdiet. Praesent nec ligula dolor. Cras et consectetur felis.\n" +
//                "In hac habitasse platea dictumst. Morbi gravida, nunc quis interdum dictum, nibh ante placerat purus, ac facilisis mi nulla nec velit. Proin fermentum, leo hendrerit accumsan sodales, orci laoreet.";
//
//        long before = System.currentTimeMillis();
//        test1(data);  // 1й способ - метод String'a "replace"
//        long result1 = System.currentTimeMillis() - before;
//        System.out.print("Время метода String'a replace = " + result1 + "ms");
//
//        System.out.println("-------------------------------------------------");
//
//        long before2 = System.currentTimeMillis();
//        test2(data);
//        long result2 = System.currentTimeMillis() - before2;
//        System.out.print("Время метода StringBuilder'a = " + result2 + "ms");
//    }
//
//    public static String test1(String x) {
//        x = x.replaceAll("a", "A");
//        System.out.println(x);
//        return x;
//    }
//
//
//    // 2й способ - метода StringBuilder'a "append"
//
//    public static StringBuilder test2(String data) {
//        StringBuilder sb = new StringBuilder(data);
//        for (int i = 0; i < sb.length(); i++) {
//            if (sb.charAt(i) == 'a') {
//                sb.setCharAt(i, 'A');
//            }
//        }
//        System.out.println(sb.toString());
//        return sb;
//    }
//
//}


