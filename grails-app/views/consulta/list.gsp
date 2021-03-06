
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
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
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
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'consulta.dateCreated.label', default: 'Date Created')}" />
					
						<th><g:message code="consulta.doctor.label" default="Doctor" /></th>
					
						<g:sortableColumn property="lastUpdated" title="${message(code: 'consulta.lastUpdated.label', default: 'Last Updated')}" />
					
						<th><g:message code="consulta.paciente.label" default="Paciente" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${consultaInstanceList}" status="i" var="consultaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${consultaInstance.id}">${fieldValue(bean: consultaInstance, field: "descripcion")}</g:link></td>
					
						<td><g:formatDate date="${consultaInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: consultaInstance, field: "doctor")}</td>
					
						<td><g:formatDate date="${consultaInstance.lastUpdated}" /></td>
					
						<td>${fieldValue(bean: consultaInstance, field: "paciente")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${consultaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
