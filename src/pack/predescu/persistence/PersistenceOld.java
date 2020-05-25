package pack.predescu.persistence;

import org.jetbrains.annotations.NotNull;
import pack.predescu.entities.Director_General;
import pack.predescu.entities.Economist;
import pack.predescu.entities.Mecanic;
import pack.predescu.entities.Vanzator;
import pack.predescu.service.ServiceClass;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

public class PersistenceOld {
    private static PersistenceOld service = null;

    private final static String VANZATOR_PATH = "vanzator.csv";
    private final static String ECONOMIST_PATH = "economist.csv";
    private final static String MECANIC_PATH = "mecanic.csv";
    private final static String DIRGNRL_PATH = "dir.csv";

    public PersistenceOld() {
        //System.out.println("Constructor");
    }

    public static PersistenceOld getInstance() {
        if (service == null)
            service = new PersistenceOld();
        return service;
    }

    public static void CreateFiles() {
        try {
            File vanzatorFile = new File(VANZATOR_PATH);
            File economistFile = new File(ECONOMIST_PATH);
            File mecanicFile = new File(MECANIC_PATH);
            File dirgnrlFile = new File(DIRGNRL_PATH);
            if (vanzatorFile.createNewFile())
                System.out.println("File created " + vanzatorFile.getName());
            else
                System.out.println("File already exists " + vanzatorFile.getName());
            if (economistFile.createNewFile())
                System.out.println("File created " + economistFile.getName());
            else
                System.out.println("File already exists " + economistFile.getName());
            if (mecanicFile.createNewFile())
                System.out.println("File created " + mecanicFile.getName());
            else
                System.out.println("File already exists " + mecanicFile.getName());
            if (dirgnrlFile.createNewFile())
                System.out.println("File created " + dirgnrlFile.getName());
            else
                System.out.println("File already exists " + dirgnrlFile.getName());
        } catch (IOException e) {
            System.out.println("Creating files error");
            e.printStackTrace();
        }
    }
//de facut cate 1
    public static <T> void scriere(T angajat, @NotNull ServiceClass service) throws IOException {
        List<Vanzator> vanzatorList = new ArrayList<>(service.getVanzatori());
        List<Economist> economistList = new ArrayList<>(service.getEconomisti());
        List<Mecanic> mecanicList = new ArrayList<>(service.getMecanici());
        List<Director_General> director_generals = new ArrayList<>(service.getDirectorGenerals());
        if (angajat instanceof Vanzator) {
            try (BufferedWriter vanzatorWriter = new BufferedWriter(new FileWriter(VANZATOR_PATH))) {
                for (Vanzator vanzator : vanzatorList) {
                    vanzatorWriter.write(String.valueOf(vanzator));
                    vanzatorWriter.newLine();
                    vanzatorWriter.flush();
                }
            } catch (IOException e) {
                System.out.println("File Writing error!");
            }
        }
        if (angajat instanceof Economist) {
            try (BufferedWriter economistWriter = new BufferedWriter(new FileWriter(ECONOMIST_PATH))) {
                for (Economist economist : economistList) {
                    economistWriter.write(String.valueOf(economist));
                    economistWriter.newLine();
                    economistWriter.flush();
                }
            }
        }
        if (angajat instanceof Mecanic) {
            try (BufferedWriter mecanicWriter = new BufferedWriter(new FileWriter(MECANIC_PATH))) {
                for (Mecanic mecanic : mecanicList) {
                    mecanicWriter.write(String.valueOf(mecanic));
                    mecanicWriter.newLine();
                    mecanicWriter.flush();
                }
            }
        }
        if (angajat instanceof Director_General) {
            try (BufferedWriter dir_gnrlWriter = new BufferedWriter(new FileWriter(DIRGNRL_PATH))) {
                for (Director_General director_general : director_generals) {
                    dir_gnrlWriter.write(String.valueOf(director_general));
                    dir_gnrlWriter.newLine();
                    dir_gnrlWriter.flush();
                }
            }
        }
    }

    public static <T> void citire(T angajat, ServiceClass service) throws IOException, SQLException {


        if (angajat instanceof Vanzator) {
            try (BufferedReader vanzatorReader = new BufferedReader(new FileReader(VANZATOR_PATH))) {
                String currentLine = "";
                while ((currentLine = vanzatorReader.readLine()) != null) {
                    String[] dataFieldsVanzator = currentLine.split(",");
                    service.addVnz(dataFieldsVanzator[0], Integer.parseInt(dataFieldsVanzator[1]), Integer.parseInt(dataFieldsVanzator[2]), Integer.parseInt(dataFieldsVanzator[3]), Integer.parseInt(dataFieldsVanzator[4]));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (angajat instanceof Economist) {
            try (BufferedReader economistReader = new BufferedReader(new FileReader(ECONOMIST_PATH))) {
                String currentLine = "";
                while ((currentLine = economistReader.readLine()) != null) {
                    String[] dataFieldsVanzator = currentLine.split(",");
                    service.addEcn(dataFieldsVanzator[0], Integer.parseInt(dataFieldsVanzator[1]), Integer.parseInt(dataFieldsVanzator[2]), Integer.parseInt(dataFieldsVanzator[3]));
                }
            }
        }
        if (angajat instanceof Mecanic) {
            try (BufferedReader mecanicReader = new BufferedReader(new FileReader(MECANIC_PATH))) {
                String currentLine = "";
                while ((currentLine = mecanicReader.readLine()) != null) {
                    String[] dataFieldsVanzator = currentLine.split(",");
                    service.addMecanic(dataFieldsVanzator[0], Integer.parseInt(dataFieldsVanzator[1]), Integer.parseInt(dataFieldsVanzator[2]), Integer.parseInt(dataFieldsVanzator[3]), Integer.parseInt(dataFieldsVanzator[4]));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (angajat instanceof Director_General) {
            try (BufferedReader dir_gnrlReader = new BufferedReader(new FileReader(DIRGNRL_PATH))) {
                String currentLine = "";
                while ((currentLine = dir_gnrlReader.readLine()) != null) {
                    String[] dataFieldsVanzator = currentLine.split(",");
                    service.addDirGnrl(dataFieldsVanzator[0], Integer.parseInt(dataFieldsVanzator[1]), Integer.parseInt(dataFieldsVanzator[2]), Integer.parseInt(dataFieldsVanzator[3]));
                }
            }
        }
    }
}