package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection conector () {
		Connection conexao = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/agenda?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "Projetointegrador@2023";
		
		try { 
			Class.forName(driver);
			conexao = DriverManager.getConnection(url, usuario, senha);
			
			if (conexao !=null) {
				System.out.println("\n-------------------");
				System.out.println("Conexão estabelecida!");
				System.out.println("\n-------------------");
			
			}	
			return conexao;
					
		}
		catch (Exception ex) {
			System.out.println(ex);
			System.out.println("Problemas na conexão:");
			return null;
	}

}
}
