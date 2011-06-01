
<%@ page import="app.Tratamiento" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tratamiento.label', default: 'Tratamiento')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-tratamiento" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="lista"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="nuevo"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-tratamiento" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list tratamiento">
			
				<g:if test="${tratamiento?.descripcion}">
				<li class="fieldcontain">
					<span id="descripcion-label" class="property-label"><g:message code="tratamiento.descripcion.label" default="Descripcion" /></span>
					
						<span class="property-value" aria-labelledby="descripcion-label"><g:fieldValue bean="${tratamiento}" field="descripcion"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.medicina}">
				<li class="fieldcontain">
					<span id="medicina-label" class="property-label"><g:message code="tratamiento.medicina.label" default="Medicina" /></span>
					
						<span class="property-value" aria-labelledby="medicina-label"><g:fieldValue bean="${tratamiento}" field="medicina"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.dosis}">
				<li class="fieldcontain">
					<span id="dosis-label" class="property-label"><g:message code="tratamiento.dosis.label" default="Dosis" /></span>
					
						<span class="property-value" aria-labelledby="dosis-label"><g:fieldValue bean="${tratamiento}" field="dosis"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.frecuencia}">
				<li class="fieldcontain">
					<span id="frecuencia-label" class="property-label"><g:message code="tratamiento.frecuencia.label" default="Frecuencia" /></span>
					
						<span class="property-value" aria-labelledby="frecuencia-label"><g:fieldValue bean="${tratamiento}" field="frecuencia"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.inicia}">
				<li class="fieldcontain">
					<span id="inicia-label" class="property-label"><g:message code="tratamiento.inicia.label" default="Inicia" /></span>
					
						<span class="property-value" aria-labelledby="inicia-label"><g:formatDate date="${tratamiento?.inicia}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.termina}">
				<li class="fieldcontain">
					<span id="termina-label" class="property-label"><g:message code="tratamiento.termina.label" default="Termina" /></span>
					
						<span class="property-value" aria-labelledby="termina-label"><g:formatDate date="${tratamiento?.termina}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.consulta}">
				<li class="fieldcontain">
					<span id="consulta-label" class="property-label"><g:message code="tratamiento.consulta.label" default="Consulta" /></span>
					
						<span class="property-value" aria-labelledby="consulta-label"><g:link controller="consulta" action="show" id="${tratamiento?.consulta?.id}">${tratamiento?.consulta?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="tratamiento.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${tratamiento?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${tratamiento?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="tratamiento.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${tratamiento?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tratamiento?.id}" />
					<g:link class="edit" action="edita" id="${tratamiento?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="elimina" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
