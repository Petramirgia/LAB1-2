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
class Team{
    public int length;
    String name, city;
    int place;
    double win;
}
public class InfoAboutTeamWM {
    static Scanner sc;

    public static Team[] fillTeams(int count){
        Team[] teams = new Team[count];
        for (int i = 0; i < teams.length; i++) {
            teams[i] = new Team();
            System.out.println("Name => ");
            teams[i].name = sc.nextLine();
            System.out.println("City => ");
            teams[i].city = sc.nextLine();
            System.out.println("Place => ");
            teams[i].place = sc.nextInt();
            System.out.println("Win=> ");
            teams[i].win = sc.nextDouble();
            sc.nextLine();
        }
        return teams;
    }

    public static void printInfoTeams(Team[] teams) {
        for (int i = 0; i < teams.length; i++) {
            System.out.println("Name: " + teams[i].name + "\t" + "City: " + teams[i].city + "\t" +
                    "Place: " + teams[i].place + "\t" + "Win: " + teams[i].win);
        }
    }

    public static void printInfoTeams(Team teams) {
        System.out.println("Name" + teams.name + "\t" + teams.win + "wins");
    }

    public static int NomMax(Team[] teams) {
        int nommax = 0;
        double max = teams[nommax].win;
        for (int i = 0; i < teams.length; i++)
            if (teams[i].win > max) {
                max = teams[i].win;
                nommax = i;
            }
        return nommax;
    }

    public static void sortPlace(Team[] team) {
        for (int i = 0; i < team.length - 1; i++)
            for (int j = 0; j < team.length - 1 - i; j++)
                if (team[j].place < team[j + 1].place) {
                    Team rab = team[j]; // rab – рабочая переменная для перестановки
                    team[j] = team[j + 1];
                    team[j + 1] = rab;
                }
    }

    public static double avgWins(Team[] teams) {
        double s = 0;
        for (int i = 0; i < teams.length; i++) {
            s += teams[i].win;
        }
        double sr = s / teams.length;
        return sr;
    }

    public static void printavg(Team[] teams, double avgWins) {
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].win > avgWins) {
                printInfoTeams(teams[i]);
            }
        }
    }
    public static int findTeamByName(Team[] teams, String searchName){
        String nameSearch = sc.nextLine();
        int searchIndex = -1;
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].name.equals(nameSearch)) {
                searchIndex = i;
            }
        }
        return searchIndex;
    }
    public static void reTeam(Team teams) {
        System.out.println("Какое поле хотите изменить");
        System.out.println("name, city, place, win");
        String pole = sc.nextLine();
        switch (pole) {
            case "name": {
                System.out.println("Введите новое имя");
                String newName = sc.nextLine();
                teams.name = newName;
                break;
            }
            case "city": {
                System.out.println("Введите новый город");
                String newCity = sc.nextLine();
                teams.city = newCity;
                break;
            }
            case "place": {
                System.out.println("Введите новое место в лиге");
                int newMes = sc.nextInt();
                teams.place = newMes;
                break;
            }
            case "win": {
                System.out.println("Введите новое количество побед");
                double newWin = sc.nextDouble();
                teams.win = (int) newWin;
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Count => ");
        sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        Team[] teams = new Team[count];
        teams = fillTeams(count);
        printInfoTeams(teams);
        int Nommax = NomMax(teams);
        System.out.println("Команда с самым большим количеством побед: ");
        printInfoTeams(teams[Nommax]);
        sortPlace(teams);
        System.out.println("\nОтсортированный список:");
        printInfoTeams(teams);
        double AvgWins = avgWins(teams);
        System.out.println("Среднее значение: ");
        System.out.println("avgWins =" + AvgWins);
        System.out.println("\nКоманды, с количеством побед больше средней");
        printavg(teams, AvgWins);
        System.out.println("Enter name");
        String searchName = sc.nextLine();
        int searchIndex = findTeamByName(teams, searchName);
        if(searchIndex!=1){
            System.out.println("Найдена команда => ");
            printInfoTeams(teams[searchIndex]);
            reTeam(teams[searchIndex]);
            System.out.println("Отредактированная информация о команде:");
            printInfoTeams(teams[searchIndex]);
        }
        else{
            System.out.println("Ничего не найдено");
        }
    }

}



