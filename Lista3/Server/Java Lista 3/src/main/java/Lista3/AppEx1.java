package Lista3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEx1 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocketCliente = new ServerSocket(6565);
                Socket socketCliente;

		System.out.println("Servidor iniciado");
		
		while(true){
			socketCliente = null;
			socketCliente = serverSocketCliente.accept(); 
			System.out.println("Socket conectado!");
			
			new Ex1(socketCliente).start();
		}	
        }
}


class Ex1 extends Thread {

	Socket socketCliente;
        
	Ex1 (Socket socket) throws IOException {
		socketCliente = socket;
	}
  
	
	public void run() {
		try {
			InputStream inputStream = socketCliente.getInputStream();
                        BufferedReader textoRecebidoParaJsonDoCliente = new BufferedReader(new InputStreamReader (inputStream));
			JSONObject json = new JSONObject(textoRecebidoParaJsonDoCliente.readLine());
                        
                        Socket socketManagerDB = new Socket("127.0.0.1", 4000);
                        System.out.println("Conectado ao DB Manager!");
                        
                        JSONObject dataObj = new JSONObject();
                        
                        dataObj.put("exerc", 1);
                        dataObj.put("data", json); 
                        
                        try (OutputStreamWriter outS = new OutputStreamWriter(
                            socketManagerDB.getOutputStream(), StandardCharsets.UTF_8)) {
                            outS.write(dataObj.toString());
                        }
                        
                        System.out.println("Passou");
                        
                        InputStream inputStreamDB = socketManagerDB.getInputStream();
                        
                        System.out.println("Passou");
                        
                        Thread.sleep(4000L);
                        
                        BufferedReader textoRecebidoDB = new BufferedReader(new InputStreamReader (inputStreamDB));
                        
                        System.out.println(textoRecebidoDB.readLine());
                        
                        JSONObject jsonDB = new JSONObject(textoRecebidoDB.readLine());
                        
                        Thread.sleep(4000L);
                        
                        Funcionario funcionario = new Funcionario();

			funcionario.name = jsonDB.getString("nome");
			funcionario.funcao = jsonDB.getString("cargo");
			funcionario.salario = jsonDB.getDouble("salario");
                        
                        jsonDB.put("reajuste", funcionario.reajuste());
                        
                        PrintStream retornoClient = new PrintStream(socketCliente.getOutputStream());
			retornoClient.println(json.toString());
                        
                        socketManagerDB.close();  
			socketCliente.close();		
			System.out.println("Conexao finalizada!");
		
		}catch (IOException e){
                    System.out.println("Erro na conexao!");
                    
                } catch (JSONException e) {
		   System.out.println("Erro no JSON!");
		
                } catch (InterruptedException ex) {
                Logger.getLogger(Ex1.class.getName()).log(Level.SEVERE, null, ex);
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
}
