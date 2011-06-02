
<%@ page import="app.Consulta" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consulta.label', default: 'Consulta')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-consulta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="nuevo"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-consulta" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>

						<g:sortableColumn property="descripcion" title="${message(code: 'consulta.descripcion.label', default: 'Descripcion')}" />

                                                <th><g:message code="consulta.paciente.label" default="Paciente" /></th>

                                                <th><g:message code="consulta.doctor.label" default="Doctor" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'consulta.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'consulta.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${consultas}" status="i" var="consulta">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="ver" id="${consulta.id}">${fieldValue(bean: consulta, field: "descripcion")}</g:link></td>

                                                <td>${fieldValue(bean: consulta, field: "paciente")}</td>

                                                <td>${fieldValue(bean: consulta, field: "doctor")}</td>
					
						<td><g:formatDate date="${consulta.dateCreated}" /></td>
					
						<td><g:formatDate date="${consulta.lastUpdated}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${totalDeConsultas}" />
			</div>
		</div>
	</body>
</html>
