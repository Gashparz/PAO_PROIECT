package pack.predescu.entities;

import pack.predescu.Salariu;

public class Economist extends Angajat implements Salariu {

    protected static int nrEconomisti=0;
    public Economist(String nume, int varsta, int vechime, int contract){
        super(nume, varsta, vechime, contract);
        nrEconomisti++;
    }

    public Economist() {

    }

    @Override
    public void descreireJob() {
        System.out.println(this.getNume() + " in varsta de " + this.getVarsta() + " cu vechimea in firma de " + this.getVechime() + " si salariul de "  + this.getSalariu()
                + " mai are " + this.getContract() + " acesta lucreaza ca: " + this.getClass().getSimpleName());
    }


    @Override
    public Integer CalculSalariu() {
        int salariu = 2000 + getVechime() * 100 ;
        setSalariu(salariu);
        return salariu;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
