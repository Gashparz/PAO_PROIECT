package pack.predescu.entities;

import java.io.Serializable;

public abstract class Angajat implements Comparable, Serializable {

    private String nume;
    private int varsta;
    private int vechime;
    private int contract;
    private int salariu;
    //protected int nrLucrari;//mecanici
    //protected int nrSubalterni;

    public Angajat(String nume, int varsta, int vechime, int contract) {
        this.nume = nume;
        this.varsta = varsta;
        this.vechime = vechime;
        this.contract = contract;
    }

    public Angajat() {

    }


    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public int getContract() {
        return contract;
    }

    public int getVechime() {
        return vechime;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void setVechime(int vechime) {
        this.vechime = vechime;
    }

    public void setContract(int contract) {
        this.contract = contract;
    }

    public abstract void descreireJob();

    @Override
    public int compareTo(Object o) {
        return this.vechime - ((Angajat) o).getVechime();
    }

    @Override
    public String toString() {
        return nume + ',' + varsta +"," + vechime +"," + contract;
    }

}
