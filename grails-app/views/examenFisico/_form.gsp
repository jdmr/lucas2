<%@ page import="app.ExamenFisico" %>



<div class="fieldcontain ${hasErrors(bean: examenFisico, field: 'peso', 'error')} required">
	<label for="peso">
		<g:message code="examenFisico.peso.label" default="Peso" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="peso" required="" value="${fieldValue(bean: examenFisico, field: 'peso')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisico, field: 'talla', 'error')} required">
	<label for="talla">
		<g:message code="examenFisico.talla.label" default="Talla" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="talla" required="" value="${fieldValue(bean: examenFisico, field: 'talla')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisico, field: 'respiraciones', 'error')} required">
	<label for="respiraciones">
		<g:message code="examenFisico.respiraciones.label" default="Respiraciones" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="respiraciones" required="" value="${fieldValue(bean: examenFisico, field: 'respiraciones')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisico, field: 'pulso', 'error')} required">
	<label for="pulso">
		<g:message code="examenFisico.pulso.label" default="Pulso" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pulso" required="" value="${fieldValue(bean: examenFisico, field: 'pulso')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisico, field: 'presionSistolica', 'error')} required">
	<label for="presionSistolica">
		<g:message code="examenFisico.presionSistolica.label" default="Presion Sistolica" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="presionSistolica" required="" value="${fieldValue(bean: examenFisico, field: 'presionSistolica')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: examenFisico, field: 'presionDiastolica', 'error')} required">
	<label for="presionDiastolica">
		<g:message code="examenFisico.presionDiastolica.label" default="Presion Diastolica" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="presionDiastolica" required="" value="${fieldValue(bean: examenFisico, field: 'presionDiastolica')}"/>
</div>
