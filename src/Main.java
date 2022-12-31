import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Задача 1");
        bessie(10, 7, "Hello my name is Bessie and this is my essay");
        System.out.println("Задача2");
        System.out.println(split("()()()"));
        System.out.println(split("((()))"));
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));
        System.out.println("Задача3");
        System.out.println("toCamelCase(\"hello_edabit\") -> " + toCamelCase("hello_edabit"));
        System.out.println("toSnakeCase(\"helloEdabit\") -> " + toSnakeCase("helloEdabit"));
        System.out.println("toCamelCase(\"is_modal_open\") -> " + toCamelCase("is_modal_open"));
        System.out.println("toSnakeCase(\"getColor\") -> " + toSnakeCase("getColor"));
        System.out.println("Задача4");
        System.out.println("overTime([9, 17, 30, 1.5]) -> " + overTime(new double[]{9, 17, 30, 1.5}));
        System.out.println("overTime([16, 18, 30, 1.8]) -> " + overTime(new double[]{16, 18, 30, 1.8}));
        System.out.println("overTime([13.25, 15, 30, 1.5]) -> " + overTime(new double[]{13.25, 15, 30, 1.5}));
        System.out.println("Задача5");
        System.out.println("BMI(\"205 pounds\", \"73 inches\") -> " + BMI("205 pounds", "73 inches"));
        System.out.println("BMI(\"55 kilos\", \"1.65 meters\") -> " + BMI("55 kilos", "1.65 meters"));
        System.out.println("BMI(\"154 pounds\", \"2 meters\") -> " + BMI("154 pounds", "2 meters"));
        System.out.println("Задача6");
        System.out.println("bugger(39) -> " + bugger(39));
        System.out.println("bugger(999) -> " + bugger(999));
        System.out.println("bugger(4) -> " + bugger(4));
        System.out.println("Задача7");
        System.out.println("toStarShorthand(\"abbccc\") -> " + toStarShorthand("abbccc"));
        System.out.println("toStarShorthand(\"77777geff\") -> " + toStarShorthand("77777geff"));
        System.out.println("toStarShorthand(\"abc\") -> " + toStarShorthand("abc"));
        System.out.println("toStarShorthand(\"\") -> " + toStarShorthand(""));
        System.out.println("Задача8");
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and ham.\") -> " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("doesRhyme(\"Sam I am!\", \"Green eggs and HAM.\") -> " + doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.println("doesRhyme(\"You are off to the races\", \"a splendid day.\") -> " + doesRhyme("You are off to the races", "a splendid day."));
        System.out.println("doesRhyme(\"and frequently do?\", \"you gotta move.\") -> " + doesRhyme("and frequently do?", "you gotta move."));
        System.out.println("Задача9");
        System.out.println("trouble(451999277, 41177722899) -> " + trouble(451999277, 41177722899L));
        System.out.println("trouble(1222345, 12345) -> " + trouble(1222345, 12345));
        System.out.println("trouble(666789, 12345667) -> " + trouble(666789, 12345667));
        System.out.println("trouble(33789, 12345337) -> " + trouble(33789, 12345337));
        System.out.println("Задача10");
        System.out.println("countUniqueBooks(\"AZYWABBCATTTA\", 'A') -> " + countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.println("countUniqueBooks(\"$AA$BBCATT$C$$B$\", '$') -> " + countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.println("countUniqueBooks(\"ZZABCDEF\", 'Z') -> " + countUniqueBooks("ZZABCDEF", 'Z'));
    }

    /** Функция итерирует по всем словам и в зависимости от суммы результирующей строки и следующего слова определяет добавить ли слово в рез. строку или вывести и очистить её*/
    public static void bessie(int n, int k, String es){
        String[] words = es.split(" ");
        StringBuilder result = new StringBuilder();
        result.append(words[0]);
        for(int i = 1; i < n; i++){
            if(words[i].length() + result.length() <= k) {
                result.append(" " + words[i]);
            } else {
                System.out.println(result.toString());
                result = new StringBuilder();
                result.append(words[i]);
            }
        }
        System.out.println(result.toString());
    }

    /** Функция считает кол-во (), а затем повторно считывает их в массив посчитанной длины */
    public static ArrayList<String> split(String s) {
        String str = new String();
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                str += "(";
            }
            if (s.charAt(i) == ')') {
                count--;
                str += ")";
            }
            if (count == 0) {
                list.add(str);
                str = new String();
            }
        }
        return list;
    }

    /** Функция разбивает строку по '_' а затем собирает снова капитализируя каждое слово */
    public static String toCamelCase(String str){
        String[] words = str.split("_");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            if(i == 0)sb.append(words[i].toLowerCase());
            else sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
        }
        return sb.toString();
    }

    /** Функция разбивает строку по заглавным буквам и собирает снова с '_' в нижнем регистре */
    public static String toSnakeCase(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                sb.append("_" + str.substring(i, i + 1).toLowerCase());
            } else sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /** Функция считает кол-во часов обычной работы и кол-во часов сверхурочных, и по ним высчитывает итоговую стоимость */
    public static String overTime(double[] arr){
        double sum = 0;
        double EVENING = 17;
        double start = arr[0];
        double end = arr[1];
        double payment = arr[2];
        double bonus = arr[3];
        if(start > EVENING){
            sum += (end - start) * payment * bonus;
        } else if(end > EVENING){
            sum += (EVENING - start) * payment;
            sum += (end - EVENING) * payment * bonus;
        } else {
            sum += (end - start) * payment;
        }
        return "$" + sum;
    }

    /** Функция считывает вес и рост, и в зависимости от значений и входных величин возвращает BMI*/
    public static String BMI(String weight, String height) {
        double w = Double.parseDouble(weight.split(" ")[0]);
        double h = Double.parseDouble(height.split(" ")[0]);
        String weightType = weight.split(" ")[1].toLowerCase();
        String heightType = height.split(" ")[1].toLowerCase();
        if(weightType.equals("pounds"))w *= 0.453592;
        if(heightType.equals("inches"))h *= 0.0254;
        double imt = w / (h * h);
        if(imt <= 18.5)return String.format("%.1f", imt ) + " Underweight";
        else if(imt  <= 25)return String.format("%.1f", imt ) + " Normal weight";
        else return String.format("%.1f", imt ) + " Overweight";
    }

    /** Функция возвращает кол-во перемножений цифр числа */
    public static int bugger(int x){
        int counter = 0;
        int m = 1;
        while (x > 9){
            while(x > 0){
                m *= (x % 10);
                x /= 10;
            }
            x = m;
            m = 1;
            counter++;
        }
        return counter;
    }

    /** Подсчитывает кол-во повторений символов и выводит в виде AAAsdg -> A*3sdg */
    public static String toStarShorthand(String s){
        s += " ";
        StringBuilder sb = new StringBuilder();
        for (char lit: s.toCharArray()){
            int length = s.split(String.valueOf(lit)).length - 1;
            if(sb.indexOf(String.valueOf(lit)) == -1){
                sb.append(lit);
                if(length > 1) sb.append("*" + length);
            }
        }
        return sb.toString();
    }

    /** Проверяет рифмуются ли слова сравнивая гласные последних слов */
    public static boolean doesRhyme(String word1, String word2){
        String v = "aeiou";
        StringBuilder v1 = new StringBuilder();
        StringBuilder v2 = new StringBuilder();
        String words[] = word1.split(" ");
        for(char lit: words[words.length - 1].toLowerCase().toCharArray()){
            if(v.contains(String.valueOf(lit))){
                v1.append(lit);
            }
        }
        words = word2.split(" ");
        for(char lit: words[words.length - 1].toLowerCase().toCharArray()){
            if(v.contains(String.valueOf(lit))){
                v2.append(lit);
            }
        }
        return v1.toString().equals(v2.toString());
    }

    /** Фукнция ищет символ, повторяющийся три раза и затем ищет его во втором слове, где он должен повторятся дважды */
    public static boolean trouble(long num1, long num2){
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        for(int i = 0; i < str1.length() - 2; i++){
            if(str1.charAt(i) == str1.charAt(i + 1) && str1.charAt(i) == str1.charAt(i + 2)){
                for(int j = 0; j < str2.length() - 1; j++){
                    if(str2.charAt(j) == str2.charAt(j + 1) && str2.charAt(j) == str1.charAt(i)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** Функция считает кол-во уникальных символов в подстроках строки, которые начинаются и заканчиваются с char c */
    public static int countUniqueBooks(String str, char b){
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean inside = false;
        while (idx < str.length()){
            if(str.charAt(idx) == b){
                inside = !inside;
            } else if(inside && sb.indexOf(String.valueOf(str.charAt(idx))) == -1){
                sb.append(str.charAt(idx));
            }
            idx++;
        }
        return sb.toString().length();
    }
}