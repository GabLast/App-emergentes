<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <div class="row">
        <div class="col-md-8 offset-2">
            <div class="container-fluid">
                <div class="modal-dialog modal-dialog-scrollable" role="document" style="max-height: 600px; width: 800px">
                    <div class="modal-content">
                        <div class="modal-header" style="background: #080808;color:rgb(255, 255, 255)">
                            <h5 class="modal-title">&Oacute;rdenes</h5>
                        </div>
                        <div class="modal-body" id="commentbody">
                            <div class="table-responsive" style="height: 400px; width: 100%">
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark text-center">
                                    <tr>
                                        <th scope="col">C&oacute;digo &Oacute;rden</th>
                                        <th scope="col">C&oacute;digo Art&iacute;culo</th>
                                        <th scope="col">C&oacute;digo Suplidor</th>
                                        <th scope="col">Fecha de &Oacute;rden</th>
                                        <th scope="col">Fecha Requerida</th>
                                        <th scope="col">Precio de Compra</th>
                                        <th scope="col">Cantidad Ordenada</th>
                                        <th scope="col">Monto total</th>
                                        <th scope="col">Unidad de Compra</th>
                                    </tr>
                                    </thead>
                                    <tbody class="text-center table-bordered">
                                    <#if ordenes?has_content>
                                        <#list ordenes as art>
                                            <tr>
                                                <form method="POST" action="#">
                                                    <td>${art.codigoOrdenCompra}</td>
                                                    <td>${art.codigoArticulo}</td>
                                                    <td>${art.codigoSuplidor}</td>
                                                    <td>${art.fechaOrden?datetime}</td>
                                                    <td>${art.fechaRequerida?datetime}</td>
                                                    <td>${art.precioCompra}</td>
                                                    <td>${art.cantidadOrdenada}</td>
                                                    <td>${art.montoTotal}</td>
                                                    <td>${art.unidadCompra}</td>
                                                </form>
                                            </tr>
                                        </#list>
                                    </#if>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    </body>
</#macro>
<@display_page/>