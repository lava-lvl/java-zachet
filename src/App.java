import java.util.ArrayList;
import java.util.Scanner;



public class App {

    static int count = 0;
    static ArrayList<Bron> arr;
    static int price = 400;

    static ArrayList<String> films = new ArrayList<>();
    static ArrayList<String> sessions = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        arr = new ArrayList<>();

        films.add(0, "Batman");
        films.add(1, "Spiderman");
        films.add(2, "Ironman");

        sessions.add(0, "дневной");
        sessions.add(1, "вечерний");
        sessions.add(2, "ночной");



        System.out.println("Список команд:\n1 - сделать бронь места\n2 - вывести денежную сумму проданных билетов на все сеансы фильма\n3 - вывести денежную сумму проданных билетов на конкретный сеанс");

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введите номер команды: ");
            int com = in.nextInt();

            System.out.println("\nСписок фильмов: \n0 - Batman\n1 - Spiderman\n2 - Ironman");

            System.out.print("Выберите фильм: ");
            int titleN = in.nextInt();
            String titlee = films.get(titleN);
            

            if (com==1) {
                System.out.println("\nСписок сеансов: \n0 - дневной\n1 - вечерний\n2 - ночной");
                System.out.print("Выберите сеанс: ");
                int sessionN = in.nextInt();
                String sessione = sessions.get(sessionN);
                System.out.print("Выберите место: ");
                int seatN = in.nextInt();
                for (int j = 0; j < arr.size(); j++) {
                    String filmTitle = arr.get(j).getTitle();
                    String filmSession = arr.get(j).getSession();
                    int filmSeat = arr.get(j).getSeat();
                    while ((filmTitle==titlee)&(filmSession==sessione)) {
                        if ((filmSeat==seatN)) {
                            System.out.print("Это место уже занято. Выберите другое:");
                            seatN = in.nextInt();
                        } else {
                            break; 
                        }
                        
                    }
                }
                GenerateNewBron(count, titlee, sessione, seatN);
                System.out.println("Место забронено");
                count++;
            } else if (com==2) {
                int sum = 0;
                for (int j = 0; j < arr.size(); j++) {
                    String filmTitle = arr.get(j).getTitle();
                    if (filmTitle==titlee) {
                        sum++;
                    }
                }
                sum = sum*price;
                System.out.println("Зароботок за все сеансы фильма "+titlee+" : "+sum);
                sum = 0;


            } else if (com==3) {
                System.out.print("Выберите сеанс: ");
                int sessionN = in.nextInt();
                String sessionn = sessions.get(sessionN);

                int summ = 0;
                for (int j = 0; j < arr.size(); j++) {
                    String filmTitle = arr.get(j).getTitle();
                    String filmSession = arr.get(j).getSession();
                    if ((filmTitle==titlee)&(filmSession==sessionn)) {
                        summ++;
                    }
                }
                summ = summ*price;
                System.out.println("Зароботок за "+sessionn+" сеанс фильма "+titlee+" : "+summ);
                summ = 0;


            }
             else {
                System.out.println("Неверная команда.");
            }

        }

    }

    public static void GenerateNewBron(int countt, String titleF, String sessionF, int seatF) {
        int i = countt;
        countt++;
        arr.add(i, new Bron(titleF, sessionF, seatF));
    }




    
}
