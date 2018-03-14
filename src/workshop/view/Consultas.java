package workshop.view;

import workshop.controllers.ControllerFuncionarios;

public class Consultas {

    public static void main(String[] args) throws Exception{
        ControllerFuncionarios control = new ControllerFuncionarios();

        control.filtroDeIdade(10);
    }
}
