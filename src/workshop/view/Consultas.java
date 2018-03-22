package workshop.view;

import workshop.controllers.ControllerFunc_J7;
import workshop.controllers.ControllerFunc_J8;
import workshop.model.Departamento;
import workshop.model.Funcionario;

import java.util.List;
import java.util.Map;

public class Consultas {

    public static void main(String[] args) throws Exception{
        ControllerFunc_J7 control_J7 = new ControllerFunc_J7();
        List<Funcionario> funcionarios = control_J7.filtroDeDepartamento(Departamento.ADMINISTRATIVO.get());
        System.out.println(funcionarios);
    }
}
