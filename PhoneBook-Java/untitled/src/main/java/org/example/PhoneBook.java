package org.example;

import java.util.Scanner;

public class PhoneBook {
        public static void main(String[] args) {
            Person.initBD();
            Person.Searching();
        }
    }

    class Person {
        private String name;
        private String phone;
        private String email;
        private static Person[] persons = new Person[10];
        private Person[] personResults = new Person[10];
        private int countResults = 0;

        public void Searching()
        {
            Scanner in = new Scanner(System.in);
            for (int i = 0; i < 10; i++)
            {
                System.out.print("Для поиcка по имени введите 1, по номеру 2, email 3: ");
                String searchType = in.nextLine();
                System.out.print("Введите поисковое значение: ");
                String searchString = in.nextLine();
                countResults++;
                Person.findPerson(searchType, searchString);
                System.out.println("Если ваша работа окончена, то напишите слово - выход. Если нет, то любое другое слово :)");
                String exitWord = in.next();
                if (exitWord.equals("выход"))
                    break;
            }
            System.out.println("Наша система сохранила все ваши результаты в количестве " + operationsCounter + "\nКстати, вот они: ");
            for (int i = 0; i < countResults; i++)
            {
                System.out.println(personResults[i]);
            }
        }

        public Person(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }


        String getName() {
            return name;
        }

        String getPhone() {
            return phone;
        }

        String getEmail() {
            return email;
        }

        public static void initBD() {
            persons[0] = new Person("Юля", "89210000000", "Julia@yandex.com");
            persons[1] = new Person("Сергей", "777777", "borya@yandex.com");
            persons[2] = new Person("Друган", "23566777", "univer@yandex.com");
            persons[3] = new Person("EvilBoss", "456546546", "boss@yandex.com");
            persons[4] = new Person("Anna", "+79216661666", "mylove@yandex.com");
        }

        public String toString() {
            return "\n\nName: " + this.getName() + "\nPhone number: " + this.getPhone() + "\nEmail: " +
                    this.getEmail();
        }

        // поиск человека
        public static void findPerson(String searchType, String searchString) {

            switch (searchType) {
                case "1":
                    personResults[countResults] = findName(searchString, persons);
                    System.out.println(findName(searchString, persons));
                    break;
                case "2":
                    personResults[countResults] = findPhone(searchString, persons);
                    System.out.println(findPhone(searchString, persons));
                    break;
                case "3":
                    personResults[countResults] = findEmail(searchString, persons);
                    System.out.println(findEmail(searchString, persons));
                    break;
                default:
                    break;
            }
        }

        public static Person findName(String name, Person[] persons) {
            for (Person person : persons) {
                if (person == null) continue;
                if (person.getName().equals(name)) {
                    return person;
                }
            }
            System.out.println("нет такого человека");
            return null;
        }

        public static Person findPhone(String phone, Person[] Persons)
        {
            for (Person person : persons)
            {
                if (person.getPhone().equals(phone))
                {
                    return person;
                }
            }
            return null;
        }

        public static Person findEmail(String email, Person[] Persons)
        {
            for (Person person : persons)
            {
                if (person.getEmail().equals(email))
                {
                    return person;
                }
            }
            return null;
        }

    }

/*
Продумать обработку исключений для поиска по пустым значениям

*/
