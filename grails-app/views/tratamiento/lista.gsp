
<%@ page import="app.Tratamiento" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tratamiento.label', default: 'Tratamiento')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-tratamiento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="nuevo"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-tratamiento" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'tratamiento.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="medicina" title="${message(code: 'tratamiento.medicina.label', default: 'Medicina')}" />
					
						<g:sortableColumn property="dosis" title="${message(code: 'tratamiento.dosis.label', default: 'Dosis')}" />
					
						<g:sortableColumn property="frecuencia" title="${message(code: 'tratamiento.frecuencia.label', default: 'Frecuencia')}" />
					
						<g:sortableColumn property="inicia" title="${message(code: 'tratamiento.inicia.label', default: 'Inicia')}" />
					
						<g:sortableColumn property="termina" title="${message(code: 'tratamiento.termina.label', default: 'Termina')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${tratamientos}" status="i" var="tratamiento">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="ver" id="${tratamiento.id}">${fieldValue(bean: tratamiento, field: "descripcion")}</g:link></td>
					
						<td>${fieldValue(bean: tratamiento, field: "medicina")}</td>
					
						<td>${fieldValue(bean: tratamiento, field: "dosis")}</td>
					
						<td>${fieldValue(bean: tratamiento, field: "frecuencia")}</td>
					
						<td><g:formatDate date="${tratamiento.inicia}" /></td>
					
						<td><g:formatDate date="${tratamiento.termina}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${totalDeTratamientos}" />
			</div>
		</div>
	</body>
</html>
