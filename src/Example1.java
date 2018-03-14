import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanderson on 13/03/18.
 */
public class Example1 {

    public static void main(String args[]) {


        List<Funcionario> funcionarios = new ArrayList<>();
        Funcionario func;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("example.data"));
            while (br.ready()) {
                String linha = br.readLine();
                String[] dados = linha.split(";");
                String nome = dados[0];
                String cargo = dados[1];
                int idade = Integer.parseInt(dados[2]);
                int salario = Integer.parseInt(dados[3]);
                func = new Funcionario(nome, cargo, idade, salario);
                funcionarios.add(func);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //mostra o nome dos funcionários que possuem mais de 30 anos
        for (Funcionario f: funcionarios) {
            if(f.getIdade()>30)
                System.out.println(f.getNome());
        }


    }
}
