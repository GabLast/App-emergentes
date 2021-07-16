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
                <div class="modal-dialog modal-dialog-scrollable" role="document" style="max-height: 600px;">
                    <div class="modal-content">
                        <div class="modal-header" style="background: #080808;color:rgb(255, 255, 255)">
                            <h5 class="modal-title">Suplidores</h5>
                        </div>
                        <div class="modal-body" id="commentbody">
                            <div class="table-responsive" style="height: 400px">
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark text-center">
                                    <tr>
                                        <th scope="col">C&oacute;digo Suplidor</th>
                                        <th scope="col">C&oacute;digo Art&iacute;culo</th>
                                        <th scope="col">Tiempo Entrega</th>
                                        <th scope="col">Precio de Compra</th>
                                    </tr>
                                    </thead>
                                    <tbody class="text-center table-bordered">
                                    <#if suplidores?has_content>
                                        <#list suplidores as sup>
                                            <tr>
                                                <form method="POST" action="#">
                                                    <td>${sup.codigoSuplidor}</td>
                                                    <td>${sup.codigoArticulo}</td>
                                                    <td>${sup.tiempoEntrega}</td>
                                                    <td>${sup.precioCompra}</td>
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