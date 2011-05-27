<%@ page import="app.ExamenFisico" %>



<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'peso', 'error')} required">
	<label for="peso">
		<g:message code="examenFisico.peso.label" default="Peso" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="peso" required="" value="${fieldValue(bean: examenFisicoInstance, field: 'peso')}" min="0.000" step="0.001" />
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'talla', 'error')} required">
	<label for="talla">
		<g:message code="examenFisico.talla.label" default="Talla" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="talla" required="" value="${fieldValue(bean: examenFisicoInstance, field: 'talla')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'respiraciones', 'error')} required">
	<label for="respiraciones">
		<g:message code="examenFisico.respiraciones.label" default="Respiraciones" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="respiraciones" required="" value="${fieldValue(bean: examenFisicoInstance, field: 'respiraciones')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'pulso', 'error')} required">
	<label for="pulso">
		<g:message code="examenFisico.pulso.label" default="Pulso" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pulso" required="" value="${fieldValue(bean: examenFisicoInstance, field: 'pulso')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'presionSistolica', 'error')} required">
	<label for="presionSistolica">
		<g:message code="examenFisico.presionSistolica.label" default="Presion Sistolica" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="presionSistolica" required="" value="${fieldValue(bean: examenFisicoInstance, field: 'presionSistolica')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'presionDiastolica', 'error')} required">
	<label for="presionDiastolica">
		<g:message code="examenFisico.presionDiastolica.label" default="Presion Diastolica" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="presionDiastolica" required="" value="${fieldValue(bean: examenFisicoInstance, field: 'presionDiastolica')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'consulta', 'error')} required">
	<label for="consulta">
		<g:message code="examenFisico.consulta.label" default="Consulta" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="consulta" name="consulta.id" from="${app.Consulta.list()}" optionKey="id" required="" value="${examenFisicoInstance?.consulta?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisicoInstance, field: 'paciente', 'error')} required">
	<label for="paciente">
		<g:message code="examenFisico.paciente.label" default="Paciente" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="paciente" name="paciente.id" from="${app.Paciente.list()}" optionKey="id" required="" value="${examenFisicoInstance?.paciente?.id}" class="many-to-one"/>
</div>

