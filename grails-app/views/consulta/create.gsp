<%@ page import="app.Consulta" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consulta.label', default: 'Consulta')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-consulta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-consulta" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${consultaInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${consultaInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="save" >
				<fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'descripcion', 'error')} ">
                        <label for="descripcion">
                            <g:message code="consulta.descripcion.label" default="Descripcion" />
                            
                        </label>
                        <g:textArea name="descripcion" cols="40" rows="5" maxlength="700" value="${consultaInstance?.descripcion}"/>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'doctor', 'error')} required">
                        <label for="doctor">
                            <g:message code="consulta.doctor.label" default="Doctor" />
                            <span class="required-indicator">*</span>
                        </label>
                        <g:select id="doctor" name="doctor.id" from="${app.Doctor.list()}" optionKey="id" required="" value="${consultaInstance?.doctor?.id}" class="many-to-one"/>
                    </div>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
