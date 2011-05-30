
<%@ page import="app.Paciente" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'paciente.label', default: 'Paciente')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-paciente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="nuevo"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-paciente" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="expediente" title="${message(code: 'paciente.expediente.label', default: 'Expediente')}" />
					
						<g:sortableColumn property="nombre" title="${message(code: 'paciente.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="apellidoPaterno" title="${message(code: 'paciente.apellidoPaterno.label', default: 'Apellido Paterno')}" />
					
						<g:sortableColumn property="apellidoMaterno" title="${message(code: 'paciente.apellidoMaterno.label', default: 'Apellido Materno')}" />
					
						<g:sortableColumn property="fechaNacimiento" title="${message(code: 'paciente.fechaNacimiento.label', default: 'Fecha Nacimiento')}" />
					
						<g:sortableColumn property="esHombre" title="${message(code: 'paciente.esHombre.label', default: 'Es Hombre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pacientes}" status="i" var="paciente">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="ver" id="${paciente.id}">${fieldValue(bean: paciente, field: "expediente")}</g:link></td>
					
						<td>${fieldValue(bean: paciente, field: "nombre")}</td>
					
						<td>${fieldValue(bean: paciente, field: "apellidoPaterno")}</td>
					
						<td>${fieldValue(bean: paciente, field: "apellidoMaterno")}</td>
					
						<td><g:formatDate date="${paciente.fechaNacimiento}" /></td>
					
						<td><g:formatBoolean boolean="${paciente.esHombre}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${totalDePacientes}" />
			</div>
		</div>
	</body>
</html>
