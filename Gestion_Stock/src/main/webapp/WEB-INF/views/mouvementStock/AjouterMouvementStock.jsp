<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Application Gestion de Stock</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!--  
        <style type="text/css">
            fmt {
                font: normal 12px courier !important;
            }
        </style>
    -->
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

        <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
        <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message code="common.MouvementStock" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="mouvementStock.nouveau" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                         <c:url value="/stock/enregistrer" var="urlEnregistrer"/>
                  <f:form modelAttribute="stock" action="${urlEnregistrer }" method="post" enctype="multipart/form-data" role="form">
                  <h1> <fmt:message code="common.entrerStock"/></h1>
                           <div class="form-row">
	                          
		                              
		                              <div class="col-md-4 mb-3">
		                                 <label><fmt:message code="common.date"/></label>
		                                  <f:input path="date" type="date"  class="form-control" id="qteLivre" placeholder="date" />
		                              </div>
		                              
		                              <div class="col-md-4 mb-3">
		                                 <label><fmt:message code="common.quantiteLivre"/></label>
		                                   <f:input path="quantiteLivre"  class="form-control" id="qteSortie" placeholder="quantiteLivre" />
		                              </div>    
		                                               
		                            <div class="col-md-4 mb-3">
	                                 <label><fmt:message code="commande.article.select.article"/></label>
	                                   <f:select path="article.code" class="form-control" items="${articles }" itemLabel="libelle" itemValue="code"/>
	                              </div>

		                              <div class="col-md-4 mb-3">
	                                 <label><fmt:message code="commande.fournisseur.select.fournisseur"/></label>
	                                   <f:select path="fournisseur.id" class="form-control" items="${fournisseurs }" itemLabel="nom" itemValue="id"/>
	                              </div>	
                          </div> 
                     
	                        <br /><br /><br /><br /> <br /><br /><br /><br /> 
	                           <div class="panel-footer">
                                          <button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregistrer"/></i></button>
                                          <a href="<c:url value="/stock/"/>" class="btn btn-danger"><i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler"/></i></a>                                         	                           
                                    </div>
                          <br /><br /><br />
                      <h1><fmt:message code="common.sortieStock"/></h1>
                             <div class="form-row">
	                          
		                              
		                              <div class="col-md-4 mb-3">
		                               <label><fmt:message code="common.quantiteSortie"/></label>
		                                  <f:input path="quantiteSortie"  class="form-control" id="qteSortie" placeholder="quantiteSortie" />
		                              </div>
		                                
		                               <div class="col-md-4 mb-3">
		                              <label><fmt:message code="common.article"/></label>
		                                 <select class="form-control" id="listfournisseurs">
		                                 
		                                 <option value="-1"><fmt:message code="commande.article.select.article" /></option>
		                                     <c:forEach items="${articles }" var="article">
		                                           <option value="${article.getCode() }">${article.getLibelle() }</option>
		                                     </c:forEach>
		                                          
		                                 </select>
		                              </div>	
                          </div> 
                          </f:form>
                  
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    
     <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/javascript/stock.js"></script>


</body>

</html>
