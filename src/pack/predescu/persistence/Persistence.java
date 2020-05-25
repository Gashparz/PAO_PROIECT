package pack.predescu.persistence;

import pack.predescu.DatabaseConnection;
import pack.predescu.entities.Director_General;
import pack.predescu.entities.Economist;
import pack.predescu.entities.Mecanic;
import pack.predescu.entities.Vanzator;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Persistence {
    private static Persistence instance = null;

    public Persistence() {
        //System.out.println("Constructor");
    }

    public static Persistence getInstance() {
        if (instance == null)
            instance = new Persistence();

        return instance;
    }

    private static final String INSERT_STATEMENT_VANZATOR = "INSERT INTO vanzator (nume, varsta, vechime, nrVanzari, contract, salariu) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_STATEMENT_ECONOMIST = "INSERT INTO economist (nume, varsta, vechime, contract, salariu) VALUES (?, ?, ?, ?, ?)";
    private static final String INSERT_STATEMENT_MECANIC = "INSERT INTO mecanic (nume, varsta, vechime, nrLucrari, contract, salariu) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String INSERT_STATEMENT_DIR_GNRL = "INSERT INTO director_general (nume, varsta, vechime, contract, salariu) VALUES (?, ?, ?, ?, ?)";

    public Vanzator saveVanzator(Vanzator vanzator) throws SQLException {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_VANZATOR)) {
            statement.setString(1, vanzator.getNume());
            statement.setInt(2, vanzator.getVarsta());
            statement.setInt(3, vanzator.getVechime());
            statement.setInt(4, vanzator.getNrVanzari());
            statement.setInt(5, vanzator.getContract());
            statement.setInt(6, vanzator.getSalariu());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when trying to insert a new user: " + e.getMessage());
            return new Vanzator();
        }
        return vanzator;
    }

    public Economist saveEconomist(Economist economist) throws SQLException {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_ECONOMIST)) {
            statement.setString(1, economist.getNume());
            statement.setInt(2, economist.getVarsta());
            statement.setInt(3, economist.getVechime());
            statement.setInt(4, economist.getContract());
            statement.setInt(5, economist.getSalariu());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Un nou economist a fost adaugat la db!");
            }
        } catch (SQLException e) {
            System.out.println("A aparut o eroare la inserarea unui Economist in db: " + e.getMessage());
            return new Economist();
        }
        return economist;
    }

    public Mecanic saveMecanic (Mecanic mecanic) throws SQLException {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_MECANIC)) {
            statement.setString(1, mecanic.getNume());
            statement.setInt(2, mecanic.getVarsta());
            statement.setInt(3, mecanic.getVechime());
            statement.setInt(4, mecanic.getNrLucrari());
            statement.setInt(5,  mecanic.getContract());
            statement.setInt(6, mecanic.getSalariu());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Un nou mecanic a fost adaugat la db!");
            }
        } catch (SQLException e) {
            System.out.println("A aparut o eroare la inserarea unui mecanic in db: " + e.getMessage());
            return new Mecanic();
        }
        return mecanic;
    }

    public Director_General saveDirGnrl(Director_General director_general) throws SQLException {
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(INSERT_STATEMENT_DIR_GNRL)) {
            statement.setString(1, director_general.getNume());
            statement.setInt(2, director_general.getVarsta());
            statement.setInt(3, director_general.getVechime());
            statement.setInt(4, director_general.getContract());
            statement.setInt(5, director_general.getSalariu());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Un nou director general a fost adaugat la db!");
            }
        } catch (SQLException e) {
            System.out.println("A aparut o eroare la inserarea unui director general in db: " + e.getMessage());
            return new Director_General();
        }
        return director_general;
    }


}
