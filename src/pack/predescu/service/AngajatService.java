package pack.predescu.service;

import pack.predescu.DatabaseConnection;
import pack.predescu.persistence.Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AngajatService {


    Persistence persistence = Persistence.getInstance();

    private static final String COUNT_VANZATOR = "SELECT COUNT(*) FROM `vanzator` ";
    private static final String COUNT_ECONOMIST = "SELECT COUNT(*) FROM `economist`";
    private static final String COUNT_MECANIC = "SELECT COUNT(*) FROM `mecanic`";
    private static final String COUNT_DIR = "SELECT COUNT(*) FROM `director_general`";
    private static final String DELETE_VANZATOR = "DELETE FROM `vanzator` WHERE `nume` = ?";
    private static final String DELETE_ECONOMIST = "DELETE FROM `economist` WHERE `nume` = ?";
    private static final String DELETE_MECANIC = "DELETE FROM `mecanic` WHERE `nume` = ?";
    private static final String DELETE_DIR = "DELETE FROM `director_general` WHERE `nume` = ?";
    private static final String ORDER_BY_VECHIME = "SELECT vechime, nume FROM `vanzator` UNION SELECT vechime, nume FROM" +
            " `economist` UNION SELECT vechime, nume FROM `mecanic` ORDER BY `vechime`";
    private static final String OLDEST = "SELECT varsta, nume FROM `vanzator` UNION SELECT varsta, nume FROM" +
            " `economist` UNION SELECT varsta, nume FROM `mecanic` ORDER BY `varsta` DESC";
    private static final String UPDATE_NR_LUCRARI = "UPDATE mecanic SET nrLucrari = ? WHERE nume = ?";
    private static final String UPDATE_NR_VANZARI = "UPDATE vanzator SET nrVanzari = ? WHERE nume = ?";
    private static final String UPDATE_CONTRACT_DIR = "UPDATE director_general SET contract = ? WHERE nume = ?";
    private static final String UPDATE_VARSTA_ECN = "UPDATE economist SET varsta =? WHERE nume = ?";

    Scanner scanner = new Scanner(System.in);

    public void updateEcn(String name) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_VARSTA_ECN)) {
            System.out.println("In ce doriti sa schimati:");
            statement.setInt(1, scanner.nextInt());
            statement.setString(2, name);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Schimbare inregistrata!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateDir(String name) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_CONTRACT_DIR)) {
            System.out.println("In ce doriti sa schimati:");
            statement.setInt(1, scanner.nextInt());
            statement.setString(2, name);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Schimbare inregistrata!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMecanic(String name) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_NR_LUCRARI)) {
            System.out.println("In ce doriti sa schimati:");
            statement.setInt(1, scanner.nextInt());
            statement.setString(2, name);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Schimbare inregistrata!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateVanzator(String name) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(UPDATE_NR_VANZARI)) {
            System.out.println("In ce doriti sa schimati:");
            statement.setInt(1, scanner.nextInt());
            statement.setString(2, name);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Schimbare inregistrata!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int countVanzatori() throws SQLException {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(COUNT_VANZATOR)) {
            ResultSet result = statement.executeQuery();
            result.next();
            int count = result.getInt(1);
            return count;
        }
    }
    public int countEconomisti() throws SQLException {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(COUNT_ECONOMIST)) {
            ResultSet result = statement.executeQuery();
            result.next();
            int count = result.getInt(1);
            return count;
        }
    }
    public int countMecanic() throws SQLException {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(COUNT_MECANIC)) {
            ResultSet result = statement.executeQuery();
            result.next();
            int count = result.getInt(1);
            return count;
        }
    }
    public int countDirector() throws SQLException {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(COUNT_DIR)) {
            ResultSet result = statement.executeQuery();
            result.next();
            int count = result.getInt(1);
            return count;
        }
    }
    public void printOrdVechime() throws SQLException {
        int nr_angajati = countEconomisti() + countVanzatori() + countMecanic() + countDirector();
        if(nr_angajati != 0)
        {
            try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(ORDER_BY_VECHIME)) {
                ResultSet result = statement.executeQuery();
                while (result.next()) {
                    System.out.println(result.getString("nume") + " cu vechimea de: " + result.getInt("vechime"));
                }
            }
        }
    }
    public void oldest() throws SQLException {
        int nr_angajati = countEconomisti() + countVanzatori() + countMecanic() + countDirector();
        if(nr_angajati != 0)
        {
            try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(OLDEST)) {
                ResultSet result = statement.executeQuery();
                result.next();
                System.out.println(result.getString("nume") + " cu varsta de: " + result.getInt("varsta"));
                }
            }
        }
    public void deleteVanzator(String nume) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_VANZATOR)) {
            statement.setString(1, nume);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Vanzatorul a fost sters cu succes!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Nu am gasit acest vanzator!");
    }

    public void deleteEconomist(String nume) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_ECONOMIST)) {
            statement.setString(1, nume);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Economistul a fost sters cu succes!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Nu am gasit acest economistul!");
    }

    public void deleteMecanic(String nume) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_MECANIC)) {
            statement.setString(1, nume);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Mecanicul a fost sters cu succes!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Nu am gasit acest mecanic!");
    }
    public void deleteDir(String nume) {
        try(PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(DELETE_DIR)) {
            statement.setString(1, nume);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Directorul a fost sters cu succes!");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Nu am gasit acest director!");
    }
}
