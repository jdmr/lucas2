<%@ page import="app.Consulta" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'consulta.label', default: 'Consulta')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'token-input.css')}" type="text/css">
	    <!-- JavaScript at the bottom for fast page loading -->
        <!-- Grab Google CDNs jQuery, with a protocol relative URL; fall back to local if offline -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="${resource(dir:'js/libs',file:'jquery-1.6.1.min.js')}">\x3C/script>')</script>	
        <script src="${resource(dir: 'js', file: 'jquery.tokeninput.js')}" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<a href="#edit-consulta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-consulta" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
			<g:form method="post" >
				<g:hiddenField name="id" value="${consultaInstance?.id}" />
				<g:hiddenField name="version" value="${consultaInstance?.version}" />
				<fieldset class="form">
                    <div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'descripcion', 'error')} ">
                        <label for="descripcion">
                            <g:message code="consulta.descripcion.label" default="Descripcion" />
                            
                        </label>
                        <g:textArea name="descripcion" cols="40" rows="5" maxlength="700" value="${consultaInstance?.descripcion}"/>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'examenFisico', 'error')} ">
                        <label for="examenFisico">
                            <g:message code="consulta.examenFisico.label" default="Examen Fisico" />
                            
                        </label>
                        <g:select id="examenFisico" name="examenFisico.id" from="${app.ExamenFisico.list()}" optionKey="id" value="${consultaInstance?.examenFisico?.id}" class="many-to-one" noSelection="['null': '']"/>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'sintomas', 'error')} ">
                        <div style="float:left;width:25%;padding-right:8px;">
                            <label for="sintomas" style="width:100%" >
                                <g:message code="consulta.sintomas.label" default="Sintomas" />
                            </label>
                        </div>
                        <g:textField name="sintomas" value="${sintomas}" />
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'diagnosticos', 'error')} ">
                        <label for="diagnosticos">
                            <g:message code="consulta.diagnosticos.label" default="Diagnosticos" />
                            
                        </label>
                        <g:select name="diagnosticos" from="${app.Diagnostico.list()}" multiple="multiple" optionKey="id" size="5" value="${consultaInstance?.diagnosticos*.id}" class="many-to-many"/>
                    </div>

                    <div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'tratamientos', 'error')} ">
                        <label for="tratamientos">
                            <g:message code="consulta.tratamientos.label" default="Tratamientos" />
                            
                        </label>
                        
                    <ul class="one-to-many">
                    <g:each in="${consultaInstance?.tratamientos?}" var="t">
                        <li><g:link controller="tratamiento" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
                    </g:each>
                    <li class="add">
                    <g:link controller="tratamiento" action="create" params="['consulta.id': consultaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'tratamiento.label', default: 'Tratamiento')])}</g:link>
                    </li>
                    </ul>

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
					<g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
        <script type="text/javascript">
            $(document).ready(function() {
                    $('#sintomas').tokenInput(
                        '${request.contextPath}/consulta/sintomas', {
                        allowNewItems: true
                    });
            });
        </script>
	</body>
</html>
