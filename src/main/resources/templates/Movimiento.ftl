<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <div class="row">
        <div class="col-md-6">
            <div class="container-fluid">
                <div class="modal-dialog modal-dialog-scrollable" role="document" style="max-height: 600px;">
                    <div class="modal-content">
                        <div class="modal-header" style="background: #080808;color:rgb(255, 255, 255)">
                            <h5 class="modal-title">Movimientos</h5>
                        </div>
                        <div class="modal-body" id="commentbody">
                            <div class="table-responsive" style="height: 400px">
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark text-center">
                                    <tr>
                                        <th scope="col">C&oacute;digo Movimiento</th>
                                        <th scope="col">C&oacute;digo Art&iacute;culo</th>
                                        <th scope="col">Tipo de Movimiento</th>
                                        <th scope="col">Cantidad</th>
                                        <th scope="col">Fecha</th>
                                    </tr>
                                    </thead>
                                    <tbody class="text-center table-bordered">
                                    <#if movimientos?has_content>
                                        <#list movimientos as mov>
                                            <tr>
                                                <form method="POST" action="#">
                                                    <td>${mov.codigoMovimiento}</td>
                                                    <td>${mov.codigoArticulo}</td>
                                                    <td>${mov.tipoMovimiento}</td>
                                                    <td>${mov.cantidad}</td>
                                                    <td>${mov.fechaMovimiento}</td>
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