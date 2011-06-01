
<%@ page import="app.ExamenFisico" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'examenFisico.label', default: 'Examen Fisico')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-examenFisico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="lista"><g:message code="default.list.label.examenFisico" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="nuevo"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-examenFisico" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list examenFisico">
			
				<g:if test="${examenFisico?.peso}">
				<li class="fieldcontain">
					<span id="peso-label" class="property-label"><g:message code="examenFisico.peso.label" default="Peso" /></span>
					
						<span class="property-value" aria-labelledby="peso-label"><g:fieldValue bean="${examenFisico}" field="peso"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${examenFisico?.talla}">
				<li class="fieldcontain">
					<span id="talla-label" class="property-label"><g:message code="examenFisico.talla.label" default="Talla" /></span>
					
						<span class="property-value" aria-labelledby="talla-label"><g:fieldValue bean="${examenFisico}" field="talla"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${examenFisico?.respiraciones}">
				<li class="fieldcontain">
					<span id="respiraciones-label" class="property-label"><g:message code="examenFisico.respiraciones.label" default="Respiraciones" /></span>
					
						<span class="property-value" aria-labelledby="respiraciones-label"><g:fieldValue bean="${examenFisico}" field="respiraciones"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${examenFisico?.pulso}">
				<li class="fieldcontain">
					<span id="pulso-label" class="property-label"><g:message code="examenFisico.pulso.label" default="Pulso" /></span>
					
						<span class="property-value" aria-labelledby="pulso-label"><g:fieldValue bean="${examenFisico}" field="pulso"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${examenFisico?.presionSistolica}">
				<li class="fieldcontain">
					<span id="presionSistolica-label" class="property-label"><g:message code="examenFisico.presionSistolica.label" default="Presion Sistolica" /></span>
					
						<span class="property-value" aria-labelledby="presionSistolica-label"><g:fieldValue bean="${examenFisico}" field="presionSistolica"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${examenFisico?.presionDiastolica}">
				<li class="fieldcontain">
					<span id="presionDiastolica-label" class="property-label"><g:message code="examenFisico.presionDiastolica.label" default="Presion Diastolica" /></span>
					
						<span class="property-value" aria-labelledby="presionDiastolica-label"><g:fieldValue bean="${examenFisico}" field="presionDiastolica"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${examenFisico?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="examenFisico.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${examenFisico?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${examenFisico?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="examenFisico.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${examenFisico?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${examenfisico?.id}" />
					<g:link class="edit" action="edita" id="${examenFisico?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="elimina" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
