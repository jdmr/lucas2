
<%@ page import="app.ExamenFisico" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'examenFisico.label', default: 'Examen Fisico')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-examenFisico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="nuevo"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-examenFisico" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label.examenFisico" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="peso" title="${message(code: 'examenFisico.peso.label', default: 'Peso')}" />
					
						<g:sortableColumn property="talla" title="${message(code: 'examenFisico.talla.label', default: 'Talla')}" />
					
						<g:sortableColumn property="respiraciones" title="${message(code: 'examenFisico.respiraciones.label', default: 'Respiraciones')}" />
					
						<g:sortableColumn property="pulso" title="${message(code: 'examenFisico.pulso.label', default: 'Pulso')}" />
					
						<g:sortableColumn property="presionSistolica" title="${message(code: 'examenFisico.presionSistolica.label', default: 'Presion Sistolica')}" />
					
						<g:sortableColumn property="presionDiastolica" title="${message(code: 'examenFisico.presionDiastolica.label', default: 'Presion Diastolica')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${examenFisicos}" status="i" var="examenFisico">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="ver" id="${examenFisico.id}">${fieldValue(bean: examenFisico, field: "peso")}</g:link></td>
					
						<td>${fieldValue(bean: examenFisico, field: "talla")}</td>
					
						<td>${fieldValue(bean: examenFisico, field: "respiraciones")}</td>
					
						<td>${fieldValue(bean: examenFisico, field: "pulso")}</td>
					
						<td>${fieldValue(bean: examenFisico, field: "presionSistolica")}</td>
					
						<td>${fieldValue(bean: examenFisico, field: "presionDiastolica")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${totalDeExamenFisicos}" />
			</div>
		</div>
	</body>
</html>
