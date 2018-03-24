package workshop.controllers;

import workshop.model.Funcionario;

import java.util.Comparator;

public class ComparadorFuncionarios implements Comparator<Funcionario>{
    @Override
    public int compare(Funcionario f1, Funcionario f2) {

      return   Double.compare(f1.getSalario(), f2.getSalario());
    }
}
