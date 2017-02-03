package br.edu.devmedia.crud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.edu.devmedia.crud.dto.UsuarioDTO;
import br.edu.devmedia.crud.exception.PersistenciaException;
import br.edu.devmedia.crud.util.ConexaoUtil;

public class UsuarioDAO {

	public boolean validarUsuario(UsuarioDTO usuarioDTO) throws PersistenciaException {
		
		try {
			Connection conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_usuario");
			sql.append(" where usuario = ? and senha = ?");
			
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql.toString());
			statement.setString(1, usuarioDTO.getUsuario());
			statement.setString(2, usuarioDTO.getSenha());
			ResultSet resultSet = statement.executeQuery();
			return resultSet.next();
			
			/*while (resultSet.next()) {
				System.out.println("ID: " + resultSet.getInt("id_usuario"));
				System.out.println("Usuário: " + resultSet.getString("usuario"));
				System.out.println("Senha: " + resultSet.getString("senha"));
			}*/
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		}
	}
}
