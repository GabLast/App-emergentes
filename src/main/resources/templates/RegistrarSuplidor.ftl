<#include "base.ftl">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <h1 style="text-align: center;">Ingrese los datos del Suplidor: </h1>
    </br>
    <div class="container mt-2">
        <div class="row justify-content-md-center">
            <div class="col-6">
                <div class="card text-dark" style="padding: 20px; background-color: lightgray">
                    <form action="/registrar" method="post"  enctype="application/x-www-form-urlencoded">

                        <div class="form-group mb-2">
                            <label for="exampleFormControlSelect1">Articulo:</label>
                            <select class="form-control" id="exampleFormControlSelect1">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>

                        <div class="form-group mb-2">
                            <label for="tiemp">Tiempo Entrega:</label>
                            <input type="date" class="form-control" id="tiemp" name="tiemp">
                        </div>

                        <div class="form-group mb-2">
                            <label for="precio">Precio Compra:</label>
                            <input type="text" class="form-control" id="precio" name="precio">
                        </div>

                        <button type="submit" class="btn btn-primary mt-2">Registrar Suplidor</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    </body>
</#macro>
<@display_page/>