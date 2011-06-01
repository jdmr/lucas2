<%@ page import="app.ExamenFisico" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'examenFisico.label', default: 'Examen Fisico')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
                <script src="${resource(dir:'js/libs',file:'jquery-1.6.1.min.js')}"></script>
	</head>
	<body>
		<a href="#create-examenFisico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="lista"><g:message code="default.list.label.examenFisico" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-examenFisico" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${examenFisico}">
			<ul class="errors" role="alert">
				<g:eachError bean="${examenFisico}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="crea" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
                <script type="text/javascript">
                $(document).ready(function() {
                  $('input#peso').focus();
                });
                </script>
	</body>
</html>
