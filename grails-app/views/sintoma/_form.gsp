<%@ page import="app.Sintoma" %>

<div class="fieldcontain ${hasErrors(bean: sintomaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="sintoma.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="64" required="" value="${sintoma?.nombre}"/>
</div>
