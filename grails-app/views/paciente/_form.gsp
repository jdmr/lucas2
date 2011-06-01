<%@ page import="app.Paciente" %>



<div class="fieldcontain ${hasErrors(bean: paciente, field: 'expediente', 'error')} required">
	<label for="expediente">
		<g:message code="paciente.expediente.label" default="Expediente" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="expediente" maxlength="64" required="" value="${paciente?.expediente}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: paciente, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="paciente.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="64" required="" value="${paciente?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: paciente, field: 'apellidoPaterno', 'error')} required">
	<label for="apellidoPaterno">
		<g:message code="paciente.apellidoPaterno.label" default="Apellido Paterno" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoPaterno" maxlength="64" required="" value="${paciente?.apellidoPaterno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: paciente, field: 'apellidoMaterno', 'error')} required">
	<label for="apellidoMaterno">
		<g:message code="paciente.apellidoMaterno.label" default="Apellido Materno" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoMaterno" maxlength="64" required="" value="${paciente?.apellidoMaterno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: paciente, field: 'fechaNacimiento', 'error')} required">
	<label for="fechaNacimiento">
		<g:message code="paciente.fechaNacimiento.label" default="Fecha Nacimiento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fechaNacimiento" precision="day" value="${paciente?.fechaNacimiento}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: paciente, field: 'esHombre', 'error')} ">
	<label for="esHombre">
		<g:message code="paciente.esHombre.label" default="Es Hombre" />
		
	</label>
	<g:checkBox name="esHombre" value="${paciente?.esHombre}" />
</div>

<div class="fieldcontain ${hasErrors(bean: paciente, field: 'correo', 'error')} ">
	<label for="correo">
		<g:message code="paciente.correo.label" default="Correo" />
		
	</label>
	<g:textField name="correo" maxlength="128" value="${paciente?.correo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: paciente, field: 'consulta', 'error')} ">
	<label for="consulta">
		<g:message code="paciente.consulta.label" default="Consulta" />

	</label>

<ul class="one-to-many">
<g:each in="${paciente?.consulta?}" var="c">
    <li><g:link controller="consulta" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="consulta" action="create" params="['paciente.id': paciente?.id]">${message(code: 'default.add.label', args: [message(code: 'paciente.consulta.label', default: 'Consulta')])}</g:link>
</li>
</ul>

</div>