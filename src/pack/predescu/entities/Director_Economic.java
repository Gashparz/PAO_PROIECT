package pack.predescu.entities;

import pack.predescu.Salariu;

public class Director_Economic extends Economist implements Salariu {

    private int nrSubalterni;
    public Director_Economic(String nume, int varsta, int vechime, int contract) {
        super(nume, varsta, vechime, contract);
        nrEconomisti--;
        this.nrSubalterni = nrEconomisti;
    }

    @Override
    public void descreireJob() {
        System.out.println(this.getNume() + " in varsta de " + this.getVarsta() + " cu vechimea in firma de " + this.getVechime() + " si salariul de "  + this.getSalariu()
                + " mai are " + this.getContract() + " acesta lucreaza ca: " + this.getClass().getSimpleName() + " si are un numar de: " + this.nrSubalterni + " subalterni");
    }

    @Override
    public Integer CalculSalariu() {
        int salariu = 2000 + (nrSubalterni * 300);
        setSalariu(salariu);
        return salariu;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}