<%@page import="br.edu.devmedia.crud.dto.PreferenciaMusicalDTO"%>
<%@page import="br.edu.devmedia.crud.dto.UfDTO"%>
<%@page import="br.edu.devmedia.crud.dto.CidadeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/global.css" type="text/css"/>
<script type="text/javascript">
	function init() {
		document.getElementById('uf').value = value=${param.idEstado != null ? param.idEstado : '0'};
	}
	function popularComboCidades(comboEstados) {
		var idEstado = comboEstados.options[comboEstados.selectedIndex].value;
		location.href = 'main?acao=montagemCadastro&getCidades=true&idEstado=' + idEstado;
	}
</script>
<title>Cadastros</title>
</head>
<body onload="init()">

	<jsp:include page="cabecalho.jsp"></jsp:include>
	
	<h1>Cadastros</h1>
	<div class="main">
		<form action="main?acao=cadastroPessoa" method="post">
			<div class="erroDiv" style="display: ${msgErro != null ? 'block' : 'none'}">
				${msgErro != null ? msgErro : '' }
			</div>
			<fieldset>
				<legend>Cadastros de Pessoas</legend>
					<table cellpadding="5">
						<tr>
							<td>Nome*</td>
							<td><input type="text" id="nome" maxlength="45" value="${param.nome}"/></td>
						</tr>
						<tr>
							<td>CPF*</td>
							<td><input type="text" id="cpf" maxlength="11"/></td>
						</tr>
						<tr>	
							<td>Data Nascimento</td>
							<td><input type="text" id="dtNasc" maxlength="10"/></td>
						</tr>
						<tr>	
							<td>Sexo*</td>
							<td>
								<input type="radio" id="sexo" value="M" checked="checked"/>Masculino
								<input type="radio" id="sexo" value="F"/>Feminino
							</td>
						</tr>
						<tr>
							<td>Preferências</td>
							<td>
							<%
								List<PreferenciaMusicalDTO> preferencias = (List<PreferenciaMusicalDTO>)session.getAttribute("listaPreferencias");
								for (PreferenciaMusicalDTO preferencia : preferencias) {
							%>
								<input type="checkbox" id="gostos" value="<%=preferencia.getIdPreferencia()%>" /><%=preferencia.getDescricao() %>
							<%
								}
							%>
							</td>
						</tr>
						<tr>
							<td>Mini-biografia</td>
							<td>
								<textarea rows="5" cols="35" name="mini-bio"></textarea>
							</td>
						</tr>
				</table>
			<fieldset>
				<legend>Endereço</legend>
				<table cellpadding="5">
					<tr>
						<td>UF*</td>
						<td>
							<select name="uf" id="uf" onchange="popularComboCidades(this)" >
								<option value="0">Selecione...</option>
							<%
								List<UfDTO> listaUF = (List<UfDTO>) session.getAttribute("listaUF");
								for (UfDTO uf : listaUF) {
							%>
								<option value="<%=uf.getIdUF()%>"><%=uf.getDescricao() %></option>
							<%
								}
							%>
							</select>
						</td>
					</tr>
					<tr>
						<td>Cidade*</td>
						<td>
							<select name="cidade">
								<option value="0">Selecione...</option>
								<%
									List<CidadeDTO> listaCidades = (List<CidadeDTO>) request.getAttribute("listaCidades");
									if (listaCidades != null) {
										for(CidadeDTO cidade : listaCidades) {
										%>
										<option value="<%=cidade.getIdCidade() %>">
											<%= cidade.getDescricao()%>
										</option>
								<%
										}
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<td>Logradouro*</td>
						<td><input type="text" name="logradouro"/></td>
					</tr>
				</table>
			</fieldset>
			</fieldset>
				<span>* Campos obrigatórios</span>
			<input type="reset" value="Limpar"></input>
			<input type="submit" value="Cadastrar"></input>
		</form>
	</div>
	
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>