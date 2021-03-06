<%@ page import="app.Doctor" %>



<div class="fieldcontain ${hasErrors(bean: doctor, field: 'cedula', 'error')} required">
	<label for="cedula">
		<g:message code="doctor.cedula.label" default="Cedula" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="cedula" maxlength="64" required="" value="${doctor?.cedula}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctor, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="doctor.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" maxlength="64" required="" value="${doctor?.nombre}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctor, field: 'apellidoPaterno', 'error')} required">
	<label for="apellidoPaterno">
		<g:message code="doctor.apellidoPaterno.label" default="Apellido Paterno" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellidoPaterno" maxlength="64" required="" value="${doctor?.apellidoPaterno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctor, field: 'apellidoMaterno', 'error')} ">
	<label for="apellidoMaterno">
		<g:message code="doctor.apellidoMaterno.label" default="Apellido Materno" />
		
	</label>
	<g:textField name="apellidoMaterno" maxlength="64" value="${doctor?.apellidoMaterno}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctor, field: 'especialidades', 'error')} ">
	<label for="especialidades">
		<g:message code="doctor.especialidades.label" default="Especialidades" />
		
	</label>
	<g:textField name="especialidades" value="${doctor?.especialidades}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctor, field: 'correo', 'error')} ">
	<label for="correo">
		<g:message code="doctor.correo.label" default="Correo" />
		
	</label>
	<g:textField name="correo" maxlength="128" value="${doctor?.correo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctor, field: 'consulta', 'error')} ">
	<label for="consulta">
		<g:message code="doctor.consulta.label" default="Consulta" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${doctor?.consulta?}" var="c">
    <li><g:link controller="consulta" action="ver" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="consulta" action="nuevo" params="['doctor.id': doctor?.id]">${message(code: 'default.add.label', args: [message(code: 'consulta.label', default: 'Consulta')])}</g:link>
</li>
</ul>

</div>

