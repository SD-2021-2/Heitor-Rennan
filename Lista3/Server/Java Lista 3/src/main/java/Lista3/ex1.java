package Lista3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex1 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6565);
		Socket socket;
		
		System.out.println("Servdor iniciado");
		
		while(true){
			socket = null;
			socket = serverSocket.accept(); 
			System.out.println("Socket conectado!");
			
			new Ex1(socket).start();
		}		
    }
}

class Ex1 extends Thread {

	Socket thread;
  
	Ex1 (Socket socket) throws IOException {
		thread = socket;
	}
  
	
	public void run() {
		try {
			InputStream inputStream = thread.getInputStream();
            BufferedReader textoRecebidoParaJson = new BufferedReader(new InputStreamReader (inputStream));
			JSONObject json = new JSONObject(textoRecebidoParaJson.readLine());

			Funcionario funcionario = new Funcionario();

			funcionario.name = json.getString("nome");
			funcionario.funcao = json.getString("cargo");
			funcionario.salario = json.getDouble("salario");
			
			json.put("reajuste", funcionario.reajuste());

			PrintStream retornoClient = new PrintStream(thread.getOutputStream());
			retornoClient.println(json.toString());

			thread.close();		
			System.out.println("Conexao finalizada!");
		
		}catch (IOException e) {
			System.out.println("Erro na conexao!");
		} catch (JSONException e) {
			System.out.println("Erro na conexao!");
		}
	}  
}

class Funcionario {
	String name;
	String funcao;
	double salario;
	
	String reajuste(){
		String retornoParaClient;
		
		if(funcao.equals("operador"))
			retornoParaClient = " Novo salario " +salario * 1.2;
		else if(funcao.equals("programador"))
			retornoParaClient = " Novo salario " +salario * 1.18;
		else
			retornoParaClient = " Sem reajuste";

		return "Funcionario " + name + " " + retornoParaClient;
	}
}