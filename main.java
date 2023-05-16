package DZ_6;

// Подумать над структурой класса Ноутбук для магазина техники — выделить поля и
// методы. Реализовать в Java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий (или
// критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
// Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объём ЖД
// 3 - Операционная система
// 4 - Цвет …
// Далее нужно запросить минимальные и максимальные значения для указанных
// критериев — сохранить параметры фильтрации можно также в Map.
// Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
// условиям.
// Доп задание
// Отсортировать ноутбуки получившегося множества. На выбор:
// По возрастанию имени ноутбука в алфавитном порядке
// По цене по убыванию



import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        // System.out.println(notebooks);
        System.out.println("Все ноутбуки");
        for (Notebook n : notebooks) {
            n.printNotebookes(n);
        }
        getResult(getCriterias());

    }


    public static LinkedList<Integer> getCriterias() {
        LinkedList<Integer> criterias = new LinkedList<>();
        int choise = getInt("Выберите критерий для показа:\n1 - ОЗУ\n2 - Объём ЖД\n3 - Операционная система\n4 - Цвет");
        criterias.add(choise);
        int i = 0;
        while (i < 3) {
            choise = getInt(
                    "Нужны дополнительные критерии?\n1 - ОЗУ\n2 - Объём ЖД\n3 - Операционная система\n4 - Цвет\n5 - Нет");
            if (choise == 5)
                i = 3;
            criterias.add(choise);
        }
        return criterias;
    }


    public static void getResult(LinkedList<Integer> criterias) {
        int min, max;
        for (int i = 0; i < criterias.size(); i++) {
            switch (criterias.get(i)) {
                case 1:
                    min = getInt("Введите мин диапазон ОЗУ от 4 до 32:");
                    max = getInt("Введите мах диапазон ОЗУ от 4 до 32:");
                    showNotebooks = getRamCriterias(min, max);
                     showResult();
                    break;
                case 2:
                    min = getInt("Введите мин диапазон памяти от 100 до 2000:");
                    max = getInt("Введите мах диапазон памяти от 100 до 2000:");
                    showNotebooks = getMemoriesCriterias(min, max);
                     showResult();
                    break;
                case 3:
                    System.out.println("Выберите систему: Windows, Linux");
                    String oS = scan.next();
                    showNotebooks = getOSCriteries(oS);
                      showResult();
                    break;
                case 4:
                    System.out.println("Выберите цвет: White, Black, grey");
                    String color = scan.next();
                    showNotebooks = getColorCriteries(color);
                      showResult();
                    break;

                default:
                    break;
            }
        }
    }


    public static HashSet<Notebook> getRamCriterias(int min, int max) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.ram >= min && notebook.ram <= max)
                    showNotebooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : notebooks) {
                if (notebook.ram >= min && notebook.ram <= max)
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }


    public static HashSet<Notebook> getMemoriesCriterias(int min, int max) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.memory >= min && notebook.memory <= max)
                    showNotebooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : notebooks) {
                if (notebook.memory >= min && notebook.memory <= max)
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }


    public static HashSet<Notebook> getOSCriteries(String osString) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.os.equals(osString))
                    showNotebooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : showNotebooks) {
                if (notebook.os.equals(osString))
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }

 
    public static HashSet<Notebook> getColorCriteries(String color) {
        HashSet<Notebook> newNoteBooks = new HashSet<>();
        if (showNotebooks.isEmpty()) {
            for (Notebook notebook : notebooks) {
                if (notebook.color.equals(color))
                    newNoteBooks.add(notebook);
            }
            return showNotebooks;
        } else {
            for (Notebook notebook : showNotebooks) {
                if (notebook.color.equals(color))
                    newNoteBooks.add(notebook);
            }
            return newNoteBooks;
        }
    }

 
    public static void showResult() {
        for (Notebook n : showNotebooks) {
            n.printNotebookes(n);
        }
    }


    public static HashSet<Notebook> setsNotebook() {
        Notebook notebook1 = new Notebook("notebook1", 4, 100, "Windows", "White");
        Notebook notebook2 = new Notebook("notebook2", 4, 100, "Linux", "Black");
        Notebook notebook3 = new Notebook("notebook3", 4, 100, "Windows", "Black");
        Notebook notebook4 = new Notebook("notebook4", 8, 200, "Linux", "White");
        Notebook notebook5 = new Notebook("notebook5", 8, 200, "Linux", "Grey");
        Notebook notebook6 = new Notebook("notebook6", 16, 500, "Windows", "Grey");
        Notebook notebook7 = new Notebook("notebook7", 16, 500, "Windows", "White");
        Notebook notebook8 = new Notebook("notebook8", 16, 500, "Linux", "Grey");
        Notebook notebook9 = new Notebook("notebook9", 32, 1000, "Windows", "Black");
        Notebook notebook10 = new Notebook("notebook10", 32, 2000, "Windows", "White");
        HashSet<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5, notebook6, notebook7, notebook8, notebook9, notebook10));
        return notebooks;
    }


    public static HashSet<Notebook> showNotebooks = new HashSet<>();

    public static HashSet<Notebook> notebooks = setsNotebook();

    public static String encoding = System.getProperty("console.encoding", "cp866");
    public static Scanner scan = new Scanner(System.in, encoding);

    public static int getInt(String text) {
        System.out.println(text);
        return scan.nextInt();
    }
}