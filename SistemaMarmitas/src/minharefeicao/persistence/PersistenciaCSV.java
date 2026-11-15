package minharefeicao.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import minharefeicao.entity.Assinatura;

public class PersistenciaCSV {
    public static void salvarAssinatura(Assinatura assinatura) {
        try {
            // Garante que a pasta data existe um nível acima da src
            File diretorio = new File("../data");
            if (!diretorio.exists()) {
                diretorio.mkdirs(); 
            }
            
            // Salva o arquivo dentro da pasta data
            FileWriter fw = new FileWriter("../data/assinaturas_db.csv", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(assinatura.toCSV());
            pw.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao salvar no CSV: " + e.getMessage());
        }
    }
}