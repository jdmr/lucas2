
<%@ page import="app.Consulta" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consulta.label', default: 'Consulta')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-consulta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-consulta" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list consulta">
			
				<g:if test="${consultaInstance?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="consulta.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${consultaInstance}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaInstance?.examenFisico}">
				<li class="fieldcontain">
					<span id="examenFisico-label" class="property-label"><g:message code="consulta.examenFisico.label" default="Examen Fisico" /></span>
					
						<span class="property-value" aria-labelledby="examenFisico-label"><g:link controller="examenFisico" action="show" id="${consultaInstance?.examenFisico?.id}">${consultaInstance?.examenFisico?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaInstance?.sintomas}">
				<li class="fieldcontain">
					<span id="sintomas-label" class="property-label"><g:message code="consulta.sintomas.label" default="Sintomas" /></span>
					
						<g:each in="${consultaInstance.sintomas}" var="s">
						<span class="property-value" aria-labelledby="sintomas-label"><g:link controller="sintoma" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${consultaInstance?.diagnosticos}">
				<li class="fieldcontain">
					<span id="diagnosticos-label" class="property-label"><g:message code="consulta.diagnosticos.label" default="Diagnosticos" /></span>
					
						<g:each in="${consultaInstance.diagnosticos}" var="d">
						<span class="property-value" aria-labelledby="diagnosticos-label"><g:link controller="diagnostico" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${consultaInstance?.tratamientos}">
				<li class="fieldcontain">
					<span id="tratamientos-label" class="property-label"><g:message code="consulta.tratamientos.label" default="Tratamientos" /></span>
					
						<g:each in="${consultaInstance.tratamientos}" var="t">
						<span class="property-value" aria-labelledby="tratamientos-label"><g:link controller="tratamiento" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${consultaInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="consulta.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${consultaInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaInstance?.doctor}">
				<li class="fieldcontain">
					<span id="doctor-label" class="property-label"><g:message code="consulta.doctor.label" default="Doctor" /></span>
					
						<span class="property-value" aria-labelledby="doctor-label"><g:link controller="doctor" action="show" id="${consultaInstance?.doctor?.id}">${consultaInstance?.doctor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${consultaInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="consulta.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${consultaInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${consultaInstance?.id}" />
					<g:link class="edit" action="edit" id="${consultaInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
