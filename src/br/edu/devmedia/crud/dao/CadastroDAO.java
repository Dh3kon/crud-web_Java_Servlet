package br.edu.devmedia.crud.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.edu.devmedia.crud.dto.CidadeDTO;
import br.edu.devmedia.crud.dto.PreferenciaMusicalDTO;
import br.edu.devmedia.crud.dto.UfDTO;
import br.edu.devmedia.crud.exception.PersistenciaException;
import br.edu.devmedia.crud.util.ConexaoUtil;

/**
 * Classe DAO de acesso a dados referente aos cadastrosda aplicação
 * @author KB-01
 *
 */
public class CadastroDAO {

	/**
	 * Método que retorna a lista de UFs
	 * @return
	 * @throws PersistenciaException
	 */
	public List<UfDTO> listarUFs() throws PersistenciaException {
		
		List<UfDTO> lista = new ArrayList<>();
		try {
			Connection conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_uf");
			
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UfDTO ufDTO = new UfDTO();
				ufDTO.setIdUF(resultSet.getInt(1));
				ufDTO.setSigla(resultSet.getString(2));
				ufDTO.setDescricao(resultSet.getString(3));
				
				lista.add(ufDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		}
		return lista;
	}
	
	/***
	 * Método que retorna a lista das preferências musicais
	 * @return
	 * @throws PersistenciaException
	 */
	
	public List<PreferenciaMusicalDTO> listarPreferencias() throws PersistenciaException {
		List<PreferenciaMusicalDTO> listaPreferencias = new ArrayList<>();
		try {
			Connection conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_preferencia");
			
			java.sql.PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				PreferenciaMusicalDTO preferenciaMusical = new PreferenciaMusicalDTO();
				preferenciaMusical.setIdPreferencia(resultSet.getInt(1));
				preferenciaMusical.setDescricao(resultSet.getString(2));
				
				listaPreferencias.add(preferenciaMusical);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return listaPreferencias;
	}
	
	/**
	 * Métoddo de consulta das cidades de acordo com o id do estado passado por parâmetro
	 * @param idEstado
	 * @return
	 * @throws PersistenciaException
	 */
	public List<CidadeDTO> consultarCidadesPorEstado(Integer idEstado) throws PersistenciaException {
		
		List<CidadeDTO> listaCidades = new ArrayList<>();
		try {
			Connection conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("select * from tb_cidade");
			sql.append(" where cod_estado = ?");
			
			PreparedStatement statement = (PreparedStatement) conexao.prepareStatement(sql.toString());
			statement.setInt(1, idEstado);
			
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CidadeDTO cidadeDTO = new CidadeDTO();
				cidadeDTO.setIdCidade(resultSet.getInt("id_cidade"));
				cidadeDTO.setDescricao(resultSet.getString("descricao"));
				
				UfDTO ufDTO = new UfDTO();
				ufDTO.setIdUF(resultSet.getInt("cod_estado"));
				
				cidadeDTO.setUf(ufDTO);
				
				listaCidades.add(cidadeDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		}
		
		return listaCidades;
	}
}
