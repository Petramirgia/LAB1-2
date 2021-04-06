/*Разработать класс для хранения информации о футбольных командах:
Название, город, место_в_лиге, количество_побед
и реализовать алгоритм работы с массивом данных объектов, в котором
требуется:
– определить команду с самым большим количеством побед;
– определить команды с количеством побед больше среднего;
– упорядочить массив по убыванию мест в лиге;
– организовать поиск по названию команды, исправление одного из полей
и вывод полной информации о команде после редактирован*/
package footballteam;
import java.util.Scanner;
class Football{
    String name, city;
    int mes;
    int win;
}
public class InfoAboutTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Count=> ");
        int count = sc.nextInt();
        sc.nextLine();
        Football[] team = new Football[count];
        for (int i = 0; i < team.length; i++) {
            sc.nextLine();
            team[i] = new Football();
            System.out.println("Name => ");
            team[i].name = sc.nextLine();
            System.out.println("City => ");
            team[i].city = sc.nextLine();
            System.out.println("Mes => ");
            team[i].mes = sc.nextInt();
            System.out.println("Count vin => ");
            team[i].win = (int) sc.nextDouble();
        }
        for (int i = 0; i < team.length; i++) {
            System.out.println("Name = " + team[i].name + "\t" + "City = " + team[i].city +"\t" +
                    "Mes = " + team[i].mes + "\t" + "Count vin = " + team[i].win);
        }
        int indexm = 0;
        int mess = team[indexm].mes;
        for (int i = 1; i < team.length; i++) {
            if (team[i].win > mess) {
                indexm = i;
                mess = team[i].mes;
            }
        }
        System.out.println("\nКоманда с наибольшим количеством побед :");
        System.out.println("Name = " + team[indexm].name + "\t" + "City = " + team[indexm].city +"\t" +
                "Mes = " + team[indexm].mes + "\t" + "Count vin = " + team[indexm].win);
        for (int i = 0; i < team.length - 1; i++) {
            for (int j = 0; j < team.length - 1 - i; j++)
                if (team[j].mes < team[j + 1].mes) {
                    Football rab = team[j]; // rab – рабочая переменная для перестановки
                    team[j] = team[j + 1];
                    team[j + 1] = rab;
                }
        }
        System.out.println("\nОтсортированный список по месту:");
        for (int i = 0; i < team.length; i++) {
            System.out.println("Name = " + team[i].name + "\t" + "City = " + team[i].city + "\t" +
                    "Mes = " + team[i].mes + "\t" + "Count vin = " + team[i].win);
        }

        double s = 0;
        for (int i = 0; i < team.length; i++)
            s += team[i].win;
        double sr = s / team.length;
        System.out.println("Средняя =" + sr);
        System.out.println("\nКоманды, с победой больше средней");
        for (int i = 0; i < team.length; i++) {
            if (team[i].win > sr) ;
            System.out.println("Name = " + team[i].name + "\t" + "City = " + team[i].city + "\t" +
                    "Mes = " + team[i].mes + "\t" + "Count vin = " + team[i].win);
        }
        sc.nextLine();
        for (int i = 0; i < team.length - 1; i++) {
            for (int j = 0; j < team.length - 1 - i; j++) {
                if (team[j].mes > team[j + 1].mes) {
                    Football rab = team[j];
                    team[j] = team[j + 1];
                    team[j + 1] = rab;
                }
            }
        }
        System.out.println("Type searchName");
        String nameSearch = sc.nextLine();
        int nom = -1;
        for (int i = 0; i < count; i++) {
            if (team[i].name.equals(nameSearch)) {
                nom = i;
            }
        }
        if (nom != -1) {
            System.out.println("Какое поле хотите изменить");
            System.out.println("name, city, mes, vin");
            String pole = sc.nextLine();
            switch (pole) {
                case "name": {
                    System.out.println("Введите новое имя");
                    String newName = sc.nextLine();
                    team[nom].name = newName;
                    break;
                }
                case "city": {
                    System.out.println("Введите новый город");
                    String newCity = sc.nextLine();
                    team[nom].name = newCity;
                    break;
                }
                case "mes": {
                    System.out.println("Введите новое место в лиге");
                    int newMes = sc.nextInt();
                    team[nom].mes = newMes;
                    break;
                }
                case "vin": {
                    System.out.println("Введите новое количество побед");
                    double newVin = sc.nextDouble();
                    team[nom].win = (int) newVin;
                    break;
                }
            }
            System.out.println("Отредактированная информация о команде: ");
            System.out.println("Name = " + team[indexm].name + "\t" + "City = " + team[indexm].city + "\t" +
                    "Mes = " + team[indexm].mes + "\t" + "Count vin =" + team[indexm].win);
        } else {
            System.out.println("Такого поля нет");
        }
    }
}