package pack.predescu;

import pack.predescu.entities.Director_General;
import pack.predescu.entities.Economist;
import pack.predescu.entities.Mecanic;
import pack.predescu.entities.Vanzator;
import pack.predescu.persistence.PersistenceOld;
import pack.predescu.service.ServiceClass;
import pack.predescu.service.AngajatService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleApp {
    Scanner scanner = new Scanner(System.in);
    private Scanner s = new Scanner(System.in);
    ServiceClass app = new ServiceClass();

    PersistenceOld persistenta = PersistenceOld.getInstance();
    AngajatService angajatService = new AngajatService();

    Vanzator vanzator = new Vanzator();
    Economist economist = new Economist();
    Director_General director_general = new Director_General();
    Mecanic mecanic = new Mecanic();

    ConsoleApp() throws IOException, SQLException {
    }

    public static void main(String[] args) throws IOException, SQLException {

        DatabaseConnection db_instance = DatabaseConnection.getInstance();

        String schema = db_instance.getConnection().toString();
        System.out.println(schema);

        ConsoleApp mainApp = new ConsoleApp();

        PersistenceOld.CreateFiles();
        mainApp.readCSV();

        AngajatService angajatService = new AngajatService();
//        System.out.println(angajatService.countVanzatori());
//        System.out.println(angajatService.countEconomisti());
//        System.out.println(angajatService.countMecanic());


        while (true) {
            mainApp.showMenu();
            int opt = mainApp.readOption();
            mainApp.execute(opt);
        }
    }

    private void showMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Adauga angajati");
        System.out.println("2. Afisarea ordonata dupa vechime crescator");
        System.out.println("3. Update -uri");
        System.out.println("4. afisarea salariilor");
        System.out.println("5. stergerea unui angajat");
        System.out.println("6. totalul salariului din firma");
        System.out.println("7. Cel mai batran angajat");
        System.out.println("8. Probleme contractuale");
        System.out.println("9. Program training");
        System.out.println("10. Crestere salariala in functie de ziua onomastica");
        System.out.println("11. CSV writing in exit");

        System.out.println("0. exit");
    }

    private int readOption() {
        int option = readInt();
        if (option >= 0 && option <= 20) {
            return option;
        } else System.out.println("Invalid option. Try again");
        return readOption();
    }

    private void execute(int option) throws IOException, SQLException {
        switch (option) {
            case 1:
                addAngajat();
                break;
            case 2:
//                app.afiseazaAngajati_ord();
                angajatService.printOrdVechime();
                app.logs("sort_angajat");
                break;
            case 3:
                afis_Ierarhie();
                app.logs("afis_ierarhie");
                break;
            case 4:
                app.afisare_Salariu();
                app.logs("afisare_salariu");
                break;
            case 5:
                stergereByChoice();
                app.logs("stergere");
                break;
            case 6:
                app.total_Salariu();
                app.logs("total_salariu");
                break;
            case 7:
//                app.displayOldest();
                angajatService.oldest();
                app.logs("display_oldest");
                break;
            case 8:
                app.contractRenewal();
                app.logs("contract_renewal");
                break;
            case 9:
                app.training();
                app.logs("training");
                break;
            case 10:
                creste_salariu();
                app.logs("crestere_salariu");
                break;
            case 11:
                app.logs("persistence_writing_menu");
                writingMenu();
                break;
            case 0:
                System.exit(0);
        }
    }

    private int readInt() {
        String line = s.nextLine();
        if (line.matches("^\\d+$")) {
            return Integer.parseInt(line);
        } else System.out.println("Nu e ok");
        return -1;
    }

    private void addAngajat() throws SQLException {
        System.out.println("1 pentru vanzator");
        System.out.println("2 pentru director de vanzari");
        System.out.println("3 pentru un economist");
        System.out.println("4 pentru director financiar");
        System.out.println("5 pentru un mecanic");
        System.out.println("6 pentru un inginer");
        System.out.println("7 pentru un director general");
        int flag = readInt();
        if (flag == 1) {
            app.add_Vnz();
            app.logs("adaugare_de_vanzator");
        }
        if (flag == 2) {
            app.add_DirVnz();
            app.logs("adaugare_de_director_de_vanzari");
        }
        if (flag == 3) {
            app.add_Ecn();
            app.logs("adaugare_de_economist");
        }
        if (flag == 4) {
            app.add_DirEcn();
            app.logs("adaugare_de_director_economic");
        }
        if (flag == 5) {
            app.add_Mecanic();
            app.logs("adaugare_de_mecanic");
        }
        if (flag == 6) {
            app.add_Inginer();
            app.logs("adaugare_de_inginer");
        }
        if (flag == 7) {
            app.add_DirGnrl();
            app.logs("adaugare_de_director_general");
        }
    }

    private void writingMenu() throws IOException {
        System.out.println("1. pentru scrierea in fisier al unui vanzator ");
        System.out.println("2. pentru scrierea in fisier al unui economist ");
        System.out.println("3. pentru scrierea in fisier al unui mecanic ");
        System.out.println("4. pentru scrierea in fisier al unui director general ");
        int flag = readInt();
        if (flag == 1) {
            PersistenceOld.scriere(vanzator, app);
            app.logs("persistence_writing_vanzator");
        }
        if (flag == 2) {
            PersistenceOld.scriere(economist, app);
            app.logs("persistence_writing_economist");
        }
        if (flag == 3) {
            PersistenceOld.scriere(mecanic, app);
            app.logs("persistence_writing_mecanic");
        }
        if (flag == 4) {
            PersistenceOld.scriere(director_general, app);
            app.logs("persistence_writing_dir_gnrl");
        }
    }

    private void readCSV() throws IOException, SQLException {
        app.logs("citire_csv_vanzatori");
        PersistenceOld.citire(vanzator, app);
        app.logs("citire_csv_economist");
        PersistenceOld.citire(economist, app);
        app.logs("citire_csv_mecanic");
        PersistenceOld.citire(mecanic, app);
        app.logs("citire_csv_dir_gnrl");
        PersistenceOld.citire(director_general, app);
    }

    private void afis_Ierarhie() {
        System.out.println("1 pentru vanzator - schimba nr de vanzari");
        System.out.println("2 pentru un mecanic - schimba nr de lucrari");
        System.out.println("3 pentru un director general - schimba contractul");
        System.out.println("4 pentru un economist - schimba varsta");
        app.logs("Am facut update uri");
        int flag = readInt();
        if(flag==1)
        {
            System.out.println("Numele vanzatorului:");
            angajatService.updateVanzator(scanner.nextLine());
        }
        if(flag==2)
        {
            System.out.println("Numele mecaninului:");
            angajatService.updateMecanic(scanner.nextLine());
        }
        if(flag==3)
        {
            System.out.println("Numele direcotrul general:");
            angajatService.updateDir(scanner.nextLine());
        }
        if(flag==4)
        {
            System.out.println("Numele economistului:");
            angajatService.updateEcn(scanner.nextLine());
        }
        app.ierarhie_mecanici();
    }

    private void stergereByChoice() {
        System.out.println("1 pentru vanzator");
        System.out.println("2 pentru un economist");
        System.out.println("3 pentru un mecanic");
        System.out.println("4 pentru un director");
        int flag = readInt();
        if(flag==1) {
            System.out.println("Scrie-ti numele vanzatorului pe care doriti sa il stergeti!");
            angajatService.deleteVanzator(scanner.nextLine());
        }
        if(flag==2) {
            System.out.println("Scrie-ti numele economistului pe care doriti sa il stergeti!");
            angajatService.deleteEconomist(scanner.nextLine());
        }
        if(flag==3) {
            System.out.println("Scrie-ti numele mecanicului pe care doriti sa il stergeti!");
            angajatService.deleteMecanic(scanner.nextLine());
        }
        if(flag==4)
            System.out.println("Scrie-ti numele directorului pe care doriti sa il stergeti!");
            angajatService.deleteDir(scanner.nextLine());
    }

    private void creste_salariu() {
        System.out.println("Cu cat vreti sa se mareasca salariul unui angajat de ziua lui onomastica?");
        int suma = readInt();
        app.crestereSalariala(suma);
    }
}

