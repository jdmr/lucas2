<%@ page import="app.Tratamiento" %>



<div class="fieldcontain ${hasErrors(bean: tratamiento, field: 'descripcion', 'error')} ">
  <label for="descripcion">
    <g:message code="tratamiento.descripcion.label" default="Descripcion" />

  </label>
  <g:textArea name="descripcion" cols="40" rows="5" maxlength="700" value="${tratamiento?.descripcion}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tratamiento, field: 'medicina', 'error')} ">
  <label for="medicina">
    <g:message code="tratamiento.medicina.label" default="Medicina" />

  </label>
  <g:textField name="medicina" maxlength="128" value="${tratamiento?.medicina}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tratamiento, field: 'dosis', 'error')} ">
  <label for="dosis">
    <g:message code="tratamiento.dosis.label" default="Dosis" />

  </label>
  <g:textField name="dosis" maxlength="128" value="${tratamiento?.dosis}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tratamiento, field: 'frecuencia', 'error')} ">
  <label for="frecuencia">
    <g:message code="tratamiento.frecuencia.label" default="Frecuencia" />

  </label>
  <g:textField name="frecuencia" maxlength="128" value="${tratamiento?.frecuencia}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tratamiento, field: 'inicia', 'error')} ">
  <label for="inicia">
    <g:message code="tratamiento.inicia.label" default="Inicia" />

  </label>
  <g:datePicker name="inicia" precision="day" value="${tratamiento?.inicia}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: tratamiento, field: 'termina', 'error')} ">
  <label for="termina">
    <g:message code="tratamiento.termina.label" default="Termina" />

  </label>
  <g:datePicker name="termina" precision="day" value="${tratamiento?.termina}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: tratamiento, field: 'consulta', 'error')} required">
  <label for="consulta">
    <g:message code="tratamiento.consulta.label" default="Consulta" />
    <span class="required-indicator">*</span>
  </label>
  <g:select id="consulta" name="consulta.id" from="${app.Consulta.list()}" optionKey="id" required="" value="${tratamiento?.consulta?.id}" class="many-to-one"/>
</div>
