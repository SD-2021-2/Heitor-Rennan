import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex4 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6565);
		Socket socket;
                
                System.out.println("Waiting Connections");
		
		while(true){
			socket = null;
			socket = serverSocket.accept(); 
			System.out.println("Conexao realizada!");
			
			new Ex4(socket).start();
		}		
    }
}

class Ex4 extends Thread {

	Socket thread;
  
	Ex4 (Socket socket) throws IOException {
		thread = socket;
	}
  
    @Override
	public void run() {
            try {
				InputStream inputStream = thread.getInputStream();
                BufferedReader mensagem = new BufferedReader(new InputStreamReader (inputStream));
	
				JSONObject json_obj = new JSONObject(mensagem.readLine());

				Pessoa pessoa = new Pessoa();

				pessoa.height = json_obj.getDouble("altura");
				pessoa.gender = json_obj.getString("sexo");
		
				json_obj.put("peso", pessoa.pesoParaSaude());

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

class Pessoa {
	double height;
	String gender;
	
	String pesoParaSaude(){
		
		double peso;
		if(gender.equals("Masculino")){
			peso = (72.7*height)-58;
			return String.format("Seu peso ideal: %.2f", peso);
		}else if(gender.equals("Feminino")){
			peso = (62.1*height)-44.7;
			return String.format("Seu peso ideal: %.2f", peso);
		} else {
                    return "Sexo inexistente";
                }
		
	}
}