/**Задание
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут 
повторяющиеся имена с разными телефонами, их необходимо считать, как 
одного человека с разными телефонами. Вывод должен быть отсортирован 
по убыванию числа телефонов.

Пример меню:
1) Добавить контакт
2) Вывести всех
3) Выход

Иванов 123432
Иванов 546457
Иванов 788354

Map<String, ArrayList> ---- {Иванов:[23145, 456745, 56787], 
    Петров:[4325, 45674]}*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class zadacha {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Добавить контакт");
            System.out.println("2) Вывести всех");
            System.out.println("3) Выход");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Введите имя контакта: ");
                String name = scanner.next();
                System.out.print("Введите номер телефона: ");
                String phone = scanner.next();

                if (!phoneBook.containsKey(name)) {
                    phoneBook.put(name, new ArrayList<String>());
                }
                phoneBook.get(name).add(phone);
            } else if (choice == 2) {
                if (phoneBook.isEmpty()) {
                    System.out.println("Телефонная книга пуста");
                } else {
                    // Получаем все записи и сортируем их по убыванию количества телефонов
                    ArrayList<HashMap.Entry<String, ArrayList<String>>> entries = new ArrayList<>(phoneBook.entrySet());
                    Collections.sort(entries, (entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

                    // Выводим записи в отсортированном порядке
                    for (HashMap.Entry<String, ArrayList<String>> entry : entries) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                }
            } else if (choice == 3) {
                break;
            }
        }
    }
}