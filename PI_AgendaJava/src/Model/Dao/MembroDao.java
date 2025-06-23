package Model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Factory.Conexao;
import Model.Membro;

public class MembroDao {

	public void inserir(Membro membro) throws SQLException {
		Connection con = Conexao.conector();
		PreparedStatement prepStmt = null;

		try {
			prepStmt = con.prepareStatement("INSERT INTO membro VALUES (DEFAULT, ?, ?, ?)");
			prepStmt.setString(1, membro.getNome());
			prepStmt.setString(2, membro.getTelefone());
			prepStmt.setString(3, membro.getEmail());
			prepStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao inserir o dado: " + e.getMessage());
		} finally {

			if (prepStmt != null) {
				prepStmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public void deletar(Membro membro) throws SQLException {
		Connection con = Conexao.conector();
		PreparedStatement prepStmt = null;

		try {
			prepStmt = con.prepareStatement("DELETE FROM membro where id = ?");
			prepStmt.setInt(1, membro.getId());
			prepStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Erro ao excluir o membro: " + e.getMessage());
		} finally {

			if (prepStmt != null) {
				prepStmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public void atualizar(Membro membro) throws SQLException {
		Connection con = Conexao.conector();
		PreparedStatement prepStmt = null;

		try {
			prepStmt = con.prepareStatement("update membro set nome =?, telefone =?, email =? where id = ?");

			prepStmt.setString(1, membro.getNome());
			prepStmt.setString(2, membro.getTelefone());
			prepStmt.setString(3, membro.getEmail());
			prepStmt.setInt(4, membro.getId());
			prepStmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Erro ao atualizar os dados do membro!");
		} finally {

			if (prepStmt != null) {
				prepStmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public List<Membro> listarDados() throws SQLException {
		Connection con = Conexao.conector();
		PreparedStatement prepStmt = null;
		ResultSet rs = null;

		List<Membro> listaDeMembros = new ArrayList<>();

		try {
			prepStmt = con.prepareStatement("select * from membro");
			rs = prepStmt.executeQuery();
			while (rs.next()) {
				Membro membroObj = new Membro();
				membroObj.setId(rs.getInt("id"));
				membroObj.setNome(rs.getString("nome"));
				membroObj.setTelefone(rs.getString("telefone"));
				membroObj.setEmail(rs.getString("email"));
				listaDeMembros.add(membroObj);

			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {

			if (rs != null) {
				rs.close();
			}

			if (prepStmt != null) {
				prepStmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return listaDeMembros;
	}

}
