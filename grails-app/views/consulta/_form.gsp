<%@ page import="app.Consulta" %>



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
	<label for="sintomas">
		<g:message code="consulta.sintomas.label" default="Sintomas" />
		
	</label>
	<g:select name="sintomas" from="${app.Sintoma.list()}" multiple="multiple" optionKey="id" size="5" value="${consultaInstance?.sintomas*.id}" class="many-to-many"/>
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

