package pack.predescu.service;

import pack.predescu.entities.*;
import pack.predescu.persistence.Persistence;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;

public class ServiceClass {

    private static int index;

    Persistence persistence = Persistence.getInstance();

    private Scanner s = new Scanner(System.in);
    private LinkedList<Angajat> angajati = new LinkedList<>();
    private ArrayList<Vanzator> vanzatori;
    private ArrayList<Economist> economisti;
    private ArrayList<Mecanic> mecanici;
    private ArrayList<Director_Vanzari> dir_vnzri;
    private ArrayList<Director_Economic> dir_econms;
    private ArrayList<Inginer> ingineri;
    private ArrayList<Director_General> directorGenerals;
    private LinkedHashSet<Integer> salarii;
    private LinkedHashSet<Angajat> training;


    public LinkedHashSet<Integer> getSalarii() {
        return salarii;
    }

    public ArrayList<Vanzator> getVanzatori() {
        return vanzatori;
    }

    public ArrayList<Economist> getEconomisti() {
        return economisti;
    }

    public ArrayList<Mecanic> getMecanici() {
        return mecanici;
    }

    public ArrayList<Director_Vanzari> getDir_vnzri() {
        return dir_vnzri;
    }

    public ArrayList<Director_Economic> getDir_econms() {
        return dir_econms;
    }

    public ArrayList<Inginer> getIngineri() {
        return ingineri;
    }

    public LinkedList<Angajat> getAngajati() {
        return angajati;
    }

    public ArrayList<Director_General> getDirectorGenerals() {
        return directorGenerals;
    }

    public LinkedHashSet<Angajat> getTraining() {
        return training;
    }

    private BufferedWriter logsWriter;

    public ServiceClass() throws IOException {
        this.vanzatori = new ArrayList<Vanzator>();
        this.economisti = new ArrayList<Economist>();
        this.mecanici = new ArrayList<Mecanic>();
        this.dir_vnzri = new ArrayList<Director_Vanzari>();
        this.dir_econms = new ArrayList<Director_Economic>();
        this.ingineri = new ArrayList<Inginer>();
        this.directorGenerals = new ArrayList<>();
        this.salarii = new LinkedHashSet<>();
        this.training = new LinkedHashSet<>();


        this.logsWriter = Files.newBufferedWriter(Paths.get("audit.csv"));

    }

    public void addVnz(String name, int age, int vechime, int vanzari, int contract) throws SQLException {

        if (name == null || name.trim().isEmpty()) {
            throw new ArithmeticException("Nu este bine scris numele!");
        }
        if (age < 18) {
            throw new ArithmeticException("Nu se poate angaja la firma daca nu are 18 ani");
        }
        if (vechime < 0) {
            throw new ArithmeticException("Vechimea nu poate fi mai mica ca 0");
        }
        if (vanzari < 0) {
            throw new ArithmeticException("Numarul de vanzari nu poate fi mai mic ca 0");
        }
        if (contract < 0) {
            throw new ArithmeticException("Contractul nu poate fi mai mic ca 0");
        }
        Vanzator vnz = new Vanzator(name, age, vechime, vanzari, contract);
        int salariu = vnz.CalculSalariu();
        persistence.saveVanzator(vnz);


        this.salarii.add(salariu);
        angajati.add(vnz);
        this.vanzatori.add(vnz);
        index++;
    }//

    public void addDirVnz(String name, int age, int vechime, int contract) {

        if (name == null || name.trim().isEmpty()) {
            throw new ArithmeticException("Nu este bine scris numele!");
        }
        if (age < 18) {
            throw new ArithmeticException("Nu se poate angaja la firma daca nu are 18 ani");
        }
        if (vechime < 0) {
            throw new ArithmeticException("Vechimea nu poate fi mai mica ca 0");
        }
        if (contract < 0) {
            throw new ArithmeticException("Contractul nu poate fi mai mic ca 0");
        }
        Director_Vanzari dir_vnz = new Director_Vanzari(name, age, vechime, contract);
        int salariu = dir_vnz.CalculSalariu();
        this.salarii.add(salariu);
        angajati.add(dir_vnz);
        this.dir_vnzri.add(dir_vnz);
        index++;
    }//

    public void addEcn(String name, int age, int vechime, int contract) throws SQLException {

        if (name == null || name.trim().isEmpty()) {
            throw new ArithmeticException("Nu este bine scris numele!");
        }
        if (age < 18) {
            throw new ArithmeticException("Nu se poate angaja la firma daca nu are 18 ani");
        }
        if (vechime < 0) {
            throw new ArithmeticException("Vechimea nu poate fi mai mica ca 0");
        }
        if (contract < 0) {
            throw new ArithmeticException("Contractul nu poate fi mai mic ca 0");
        }
        Economist ecn = new Economist(name, age, vechime, contract);
        int salariu = ecn.CalculSalariu();
        persistence.saveEconomist(ecn);


        this.salarii.add(salariu);
        angajati.add(ecn);
        this.economisti.add(ecn);
        index++;
    }//

    public void addDirEcn(String name, int age, int vechime, int contract) {

        if (name == null || name.trim().isEmpty()) {
            throw new ArithmeticException("Nu este bine scris numele!");
        }
        if (age < 18) {
            throw new ArithmeticException("Nu se poate angaja la firma daca nu are 18 ani");
        }
        if (vechime < 0) {
            throw new ArithmeticException("Vechimea nu poate fi mai mica ca 0");
        }
        if (contract < 0) {
            throw new ArithmeticException("Contractul nu poate fi mai mic ca 0");
        }
        Director_Economic dir_ecn = new Director_Economic(name, age, vechime, contract);
        int salariu = dir_ecn.CalculSalariu();
        this.salarii.add(salariu);
        angajati.add(dir_ecn);
        this.dir_econms.add(dir_ecn);
        index++;
    }//

    public void addMecanic(String name, int age, int vechime, int nrLucrari, int contract) throws SQLException {

        if (name == null || name.trim().isEmpty()) {
            throw new ArithmeticException("Nu este bine scris numele!");
        }
        if (age < 18) {
            throw new ArithmeticException("Nu se poate angaja la firma daca nu are 18 ani");
        }
        if (vechime < 0) {
            throw new ArithmeticException("Vechimea nu poate fi mai mica ca 0");
        }
        if (nrLucrari < 0) {
            throw new ArithmeticException("Numarul de lucrari nu poate fi mai mic ca 0");
        }
        if (contract < 0) {
            throw new ArithmeticException("Contractul nu poate fi mai mic ca 0");
        }
        Mecanic mcn = new Mecanic(name, age, vechime, nrLucrari, contract);
        int salariu = mcn.CalculSalariu();
        persistence.saveMecanic(mcn);


        this.salarii.add(salariu);
        angajati.add(mcn);
        this.mecanici.add(mcn);
        index++;
    }//

    public void addInginer(String name, int age, int vechime, int contract) {

        if (name == null || name.trim().isEmpty()) {
            throw new ArithmeticException("Nu este bine scris numele!");
        }
        if (age < 18) {
            throw new ArithmeticException("Nu se poate angaja la firma daca nu are 18 ani");
        }
        if (vechime < 0) {
            throw new ArithmeticException("Vechimea nu poate fi mai mica ca 0");
        }
        if (contract < 0) {
            throw new ArithmeticException("Contractul nu poate fi mai mic ca 0");
        }
        Inginer ign = new Inginer(name, age, vechime, contract);
        int salariu = ign.CalculSalariu();
        this.salarii.add(salariu);
        angajati.add(ign);
        this.ingineri.add(ign);
        index++;
    }

    public void addDirGnrl(String name, int age, int vechime, int contract) throws SQLException {

        if (name == null || name.trim().isEmpty()) {
            throw new ArithmeticException("Nu este bine scris numele!");
        }
        if (age < 18) {
            throw new ArithmeticException("Nu se poate angaja la firma daca nu are 18 ani");
        }
        if (vechime < 0) {
            throw new ArithmeticException("Vechimea nu poate fi mai mica ca 0");
        }
        if (contract < 0) {
            throw new ArithmeticException("Contractul nu poate fi mai mic ca 0");
        }
        Director_General dirgnrl = new Director_General(name, age, vechime, contract);
        int salariu = dirgnrl.CalculSalariu();
        persistence.saveDirGnrl(dirgnrl);

        index++;
        angajati.add(dirgnrl);
        this.directorGenerals.add(dirgnrl);
        this.salarii.add(salariu);
    }

    public void add_Vnz() throws SQLException {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Age: ");
        String ageString = s.nextLine();
        System.out.print("vechime: ");
        String vechimeString = s.nextLine();
        System.out.print("Vanzari: ");
        String vanzariString = s.nextLine();
        System.out.print("Contract: ");
        String contractString = s.nextLine();
        if (ageString.matches("^\\d+$")) {
            addVnz(name, Integer.parseInt(ageString), Integer.parseInt(vechimeString), Integer.parseInt(vanzariString), Integer.parseInt(contractString));
        }
    }//

    public void add_DirVnz() {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Age: ");
        String ageString = s.nextLine();
        System.out.print("vechime: ");
        String vechimeString = s.nextLine();
        System.out.print("Contract: ");
        String contractString = s.nextLine();
        if (ageString.matches("^\\d+$")) {
            addDirVnz(name, Integer.parseInt(ageString), Integer.parseInt(vechimeString), Integer.parseInt(contractString));
        }
    }//

    public void add_Ecn() throws SQLException {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Age: ");
        String ageString = s.nextLine();
        System.out.print("vechime: ");
        String vechimeString = s.nextLine();
        System.out.print("Contract: ");
        String contractString = s.nextLine();
        if (ageString.matches("^\\d+$")) {
            addEcn(name, Integer.parseInt(ageString), Integer.parseInt(vechimeString), Integer.parseInt(contractString));
        }
    }//

    public void add_DirEcn() {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Age: ");
        String ageString = s.nextLine();
        System.out.print("vechime: ");
        String vechimeString = s.nextLine();
        System.out.print("Contract: ");
        String contractString = s.nextLine();
        if (ageString.matches("^\\d+$")) {
            addDirEcn(name, Integer.parseInt(ageString), Integer.parseInt(vechimeString), Integer.parseInt(contractString));
        }
    }//

    public void add_Mecanic() throws SQLException {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Age: ");
        String ageString = s.nextLine();
        System.out.print("vechime: ");
        String vechimeString = s.nextLine();
        System.out.print("Lucrari: ");
        String lucrariString = s.nextLine();
        System.out.print("Contract: ");
        String contractString = s.nextLine();
        if (ageString.matches("^\\d+$")) {
            addMecanic(name, Integer.parseInt(ageString), Integer.parseInt(vechimeString), Integer.parseInt(lucrariString), Integer.parseInt(contractString));
        }
    }

    public void add_Inginer() {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Age: ");
        String ageString = s.nextLine();
        System.out.print("vechime: ");
        String vechimeString = s.nextLine();
        System.out.print("Contract: ");
        String contractString = s.nextLine();
        if (ageString.matches("^\\d+$")) {
            addInginer(name, Integer.parseInt(ageString), Integer.parseInt(vechimeString), Integer.parseInt(contractString));
        }
    }

    public void add_DirGnrl() throws SQLException {
        System.out.print("Name: ");
        String name = s.nextLine();
        System.out.print("Age: ");
        String ageString = s.nextLine();
        System.out.print("vechime: ");
        String vechimeString = s.nextLine();
        System.out.print("Contract: ");
        String contractString = s.nextLine();
        if (ageString.matches("^\\d+$")) {
            addDirGnrl(name, Integer.parseInt(ageString), Integer.parseInt(vechimeString), Integer.parseInt(contractString));
        }
    }

    public void afiseazaAngajati_ord() {
        Collections.sort(angajati);
        for (Angajat ang : angajati) {
            ang.descreireJob();
        }
    }

    public void ierarhie_vanzatori() {
        for (Director_Vanzari director_vanzari : this.getDir_vnzri())
            System.out.println("--" + director_vanzari.getNume() + " si are in subordine pe:");
        for (Vanzator vanzator : this.getVanzatori())
            System.out.println("--" + vanzator.getNume());
    }

    public void ierarhie_economisti() {
        for (Director_Economic director_economic : this.getDir_econms())
            System.out.println("--" + director_economic.getNume() + " si are in subordine pe:");
        for (Economist economist : this.getEconomisti())
            System.out.println("--" + economist.getNume());
    }

    public void ierarhie_mecanici() {
        for (Inginer inginer : this.getIngineri())
            System.out.println("--" + inginer.getNume() + " si are in subordine pe:");
        for (Mecanic mecanic : this.getMecanici())
            System.out.println("--" + mecanic.getNume());
    }

    public void afisare_Salariu() {
        for (Integer salar : salarii) {
            System.out.println(salar + " ");
        }
    }

    public void total_Salariu() {
        int salar_tot = 0;
        for (Integer salar : salarii) {
            salar_tot += salar;
        }
        System.out.println(salar_tot);
    }

    public void stergere() {
        for (Angajat angajat : this.getAngajati())
            salarii.remove(index);
    }

    public void stergereChoice(int flag) {
        if (flag == 1) //vanzator
            for (Angajat angajat : this.getAngajati())
                if (angajat instanceof Vanzator) {
                    this.getAngajati().remove(angajat);
                    this.getVanzatori().remove(angajat);
                    break;
                }
        if (flag == 2) //economist
            for (Angajat angajat : this.getAngajati())
                if (angajat instanceof Economist) {
                    this.getAngajati().remove(angajat);
                    this.getEconomisti().remove(angajat);
                    break;
                }
        if (flag == 3) //mecanic
            for (Angajat angajat : this.getAngajati())
                if (angajat instanceof Vanzator) {
                    this.getAngajati().remove(angajat);
                    this.getMecanici().remove(angajat);
                    break;
                }
    }

    public void displayOldest() {
        int oldest = this.getAngajati().get(0).getVarsta();
        String className = this.getAngajati().get(0).getClass().getSimpleName();
        String angajatName = this.getAngajati().get(0).getNume();
        if (this.getAngajati().isEmpty()) {
            System.out.println("Nu mai ai angajati\n");
            return;
        }
        for (Angajat angajat : this.getAngajati()) {
            if (angajat.getVarsta() > oldest) {
                oldest = angajat.getVarsta();
                className = angajat.getClass().getSimpleName();
                angajatName = angajat.getNume();
            }
        }
        System.out.println("Cel mai batran angajat este: " + angajatName + " care lucreaza ca: " + className + " si are " + oldest);
    }

    public void contractRenewal() {
        if (this.getAngajati().isEmpty()) {
            System.out.println("Your vehicle deposit is empty!\n");
            return;
        }
        for (Angajat angajat : this.getAngajati()) {
            int contractlen = angajat.getContract();
            if (contractlen < 3)
                System.out.println(angajat.getNume() + " are nevoie de un contract nou deoarece mai are doar:" + contractlen + " luni");
        }
    }

    public void training() {
        for (Angajat angajat : this.getAngajati()) {
            if (angajat instanceof Economist) {
                if (angajat.getVechime() < 2) {
                    System.out.println(angajat.getNume() + " are nevoie de training!");
                    this.training.add(angajat);
                }
            } else if (angajat instanceof Inginer) {
                if (angajat.getVechime() < 2) {
                    System.out.println(angajat.getNume() + " are nevoie de training!");
                    this.training.add(angajat);
                }
            }
        }
    }

    public void crestereSalariala(int suma) {
        for (Angajat angajat : this.getAngajati()) {
            String s1 = "Andrei";
            int salariu = angajat.getSalariu();
            if (angajat.getNume().equals(s1))
                angajat.setSalariu(salariu + suma);
            if (angajat.getNume().equals("Maria"))
                angajat.setSalariu(salariu + suma);
            if (angajat.getNume().equals("Ion")) // Si alte nume de sfant
                angajat.setSalariu(salariu + suma);
        }
    }

    public void logs(String action_name) {
        Date timestamp = new Date();
        String printLogs = action_name + ", " + timestamp;
        try {
            logsWriter.write(printLogs);
            logsWriter.newLine();
            logsWriter.flush();
        } catch (IOException e) {
            System.out.println("Nu merge auditul");
        }
    }

}
