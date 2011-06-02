<%@ page import="app.Consulta" %>


<div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'paciente', 'error')} required">
	<label for="paciente">
		<g:message code="consulta.paciente.label" default="Paciente" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="paciente" name="paciente.id" from="${app.Paciente.list()}" optionKey="id" required="" value="${consultaInstance?.paciente?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'doctor', 'error')} required">
	<label for="doctor">
		<g:message code="consulta.doctor.label" default="Doctor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doctor" name="doctor.id" from="${app.Doctor.list()}" optionKey="id" required="" value="${consultaInstance?.doctor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'descripcion', 'error')} ">
	<label for="descripcion">
		<g:message code="consulta.descripcion.label" default="Descripcion" />
		
	</label>
	<g:textArea name="descripcion" cols="40" rows="5" maxlength="700" value="${consultaInstance?.descripcion}"/>
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
	<g:select name="tratamientos" from="${app.Tratamiento.list()}" multiple="multiple" optionKey="id" size="5" value="${consultaInstance?.tratamientos*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: consultaInstance, field: 'examenFisicos', 'error')} ">
	<label for="examenFisicos">
		<g:message code="consulta.examenFisicos.label" default="Examen Fisicos" />
		
	</label>
	<g:select name="examenFisicos" from="${app.ExamenFisico.list()}" multiple="multiple" optionKey="id" size="5" value="${consultaInstance?.examenFisicos*.id}" class="many-to-many"/>
</div>



