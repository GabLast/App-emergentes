<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <h1 style="text-align: center;">Ingrese los datos del Movimiento: </h1>
    </br>
    <div class="container mt-2">
        <div class="row justify-content-md-center">
            <div class="col-6">
                <div class="card text-dark" style="padding: 20px; background-color: lightgray">
                    <form action="/movimiento/registrar" method="post"  enctype="application/x-www-form-urlencoded">
                        <#if articulos?has_content>
                            <div class="form-group mb-2">
                                <label for="exampleFormControlSelect1">Art&iacute;culo:</label>
                                <select class="form-select" id="exampleFormControlSelect1" name="idarticulo" required>
                                    <option selected>Seleccione</option>
                                    <#list articulos as arti>
                                        <option value="${arti.codigoArticulo}">
                                            ${arti.descripcion}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-group mb-2">
                                <label for="movi">Tipo de Movimiento:</label>
                                <select id="movi" class="form-select" aria-label="Default select example" name="tipoMovimiento" required>
                                    <option selected>Seleccione</option>
                                    <option value="ENTRADA">Entrada</option>
                                    <option value="SALIDA">Salida</option>
                                </select>
                            </div>
                            <div class="form-group mb-2">
                                <label for="cant">Cantidad:</label>
                                <input type="number" min="1" class="form-control" id="cant" name="cantidad" required>
                            </div>
                            <button type="submit" class="btn btn-primary btn-custom1 mt-2">Registrar</button>
                        <#else>
                            <h4 style="text-align: center;">No hay articulos registrados. Registrar articulos antes de continuar</h4>
                        </#if>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</#macro>
<@display_page/>