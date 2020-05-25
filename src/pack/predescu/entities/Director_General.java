package pack.predescu.entities;

import pack.predescu.Salariu;

public class Director_General extends Angajat implements Salariu {

    public Director_General(String nume, int varsta, int vechime, int contract) {

        super(nume, varsta, vechime, contract);
    }

    public Director_General() {

    }

    @Override
    public void descreireJob() {
        System.out.println(this.getNume() + " in varsta de " + this.getVarsta() + " cu vechimea in firma de " + this.getVechime() + " si salariul de "  + this.getSalariu()
                + " mai are " + this.getContract() + " acesta lucreaza ca: " + this.getClass().getSimpleName());
    }

    @Override
    public Integer CalculSalariu() {
        int salariu = 5000 + (50 * 10 - 10) * 10 ;
        setSalariu(salariu);
        return salariu;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
