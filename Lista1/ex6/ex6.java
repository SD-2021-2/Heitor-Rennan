import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex6 {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(6565);
		System.out.println("Waiting Connections");
		Socket socket;
		
		while(true){
			socket = null;
			socket = ss.accept(); 
			System.out.println("Conexao realizada");
			
			new Ex6(socket).start();
		}		
    }
}

class Ex6 extends Thread {

	Socket thread;
  
	Ex6 (Socket socket) throws IOException {
		thread = socket;
	}
  
	public void run() throws JSONException {
            try {
		
                InputStream inputStream = thread.getInputStream();
                BufferedReader mensagem = new BufferedReader(new InputStreamReader (inputStream));
	
		JSONObject json_obj = new JSONObject(mensagem.readLine());

		Funcionario funcionario = new Funcionario();

		funcionario.name = json_obj.getString("nome");
		funcionario.nvl = json_obj.getString("nivel");
		funcionario.salario = json_obj.getDouble("salario");
		funcionario.deps = json_obj.getInt("dependentes");
		
		json_obj.put("salario liquido", funcionario.salarioLiquido());

		PrintStream resposta = new PrintStream(thread.getOutputStream());
		resposta.println(json_obj.toString());

		thread.close();
		
                System.out.println("Conexao finalizada");
				
            }catch (IOException e) {
			System.out.println("Erro na Conexao");
            }
	}  
}

class Funcionario {
	String name;
	double salario;
	String nvl;
	int deps;
	
	String salarioLiquido(){

		switch(nvl){
			case "A":
				if(deps > 0)
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.92 + " reais");
				else
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.97 + " reais");
				
				
			case "B":
				if(deps > 0)
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.9 + " reais");
				else
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.95 + " reais");
				
				
			case "C":
				if(deps > 0)
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.85 + " reais");
				else
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.92 + " reais");
				
				
			case "D":
				if(deps > 0)
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.83+ " reais");
				else
					return ("Nome: " +name+ "\nNivel: " + nvl + "\nSalario Liquido: " + salario * 0.9 + " reais");
		}
		return "ERRO";
	}
}