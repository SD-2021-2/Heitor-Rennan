import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex8 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6565);
		Socket socket;
                
                System.out.println("Waiting Connections");
		
		while(true){
                    
                    socket = null;
                    socket = serverSocket.accept(); 
                    System.out.println("Conexao realizada!");	
                    new Ex8(socket).start();
		
                }		
    }
        
}

class Ex8 extends Thread {

	Socket thread;
  
	Ex8 (Socket socket) throws IOException {
		thread = socket;
	}
  
	public void run()  {
            try {
		
                InputStream inputStream = thread.getInputStream();
                BufferedReader mensagem = new BufferedReader(new InputStreamReader (inputStream));
		JSONObject json_obj = new JSONObject(mensagem.readLine());

		ClienteParaCredito cliente = new ClienteParaCredito();
                cliente.saldo = json_obj.getDouble("saldo");
		
		json_obj.put("credito", cliente.creditoDisponivel());

		PrintStream resposta = new PrintStream(thread.getOutputStream());
                resposta.println(json_obj.toString());
		thread.close();
		
                System.out.println("Conexao finalizada!");
				
			}catch (IOException e) {
				System.out.println("Erro na conexao!");
			} catch (JSONException e) {
				System.out.println("Erro na conexao!");
			}
	}  
}

class ClienteParaCredito {
	double saldo;
	
	String creditoDisponivel(){
		if(saldo <= 200)
                    return "Saldo Medio: " + saldo + " e Nenhum Credito";
		else if(saldo <= 400)
                    return "Saldo Medio: " + saldo + " e Valor do Credito: " + saldo * 0.2;
		else if(saldo <= 600)
                    return "Saldo Medio: " + saldo + " e Valor do Credito: " + saldo* 0.3;
		else
                    return "Saldo Medio: " + saldo + " e Valor do Credito: " + saldo * 0.4;
		
	}
}