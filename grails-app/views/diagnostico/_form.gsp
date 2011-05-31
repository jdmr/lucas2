<%@ page import="app.Diagnostico" %>



<div class="fieldcontain ${hasErrors(bean: diagnostico, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="diagnostico.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="128" required="" value="${diagnostico?.nombre}"/>
</div>

