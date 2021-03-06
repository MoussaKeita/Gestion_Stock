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
                        <h1 class="page-header"><fmt:message code="commande.client.nouveau" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
	                <div class="alert alert-danger" id="clientNotSelectedMsgBlock">
	                     <fmt:message code="commande.fournisseur.select.fournisseur.msg.error"/>
	                </div>
		               <div class="alert alert-danger" id="notFoundMsgBlock">
		                     <fmt:message code="commandeFournisseur.article.not.found"/>
		                </div>
		             <div class="alert alert-danger" id="unexpectedErrorMsgBlock">
	                     <fmt:message code="commande.fournisseur.select.fournisseur.unexpected.error"/>
	                </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="common.info" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <!--  <c:url value="/commandefournisseur/enregistrer" var="urlEnregistrer"/> -->
                      <form  action="/mvc/commandeClient/" method="post" enctype="multipart/form-data" role="form">
                          <div class="form-row">
	                          <div class="col-md-4 mb-3">
		                                 <label><fmt:message code="common.code"/></label>
		                                   <input class="form-control" placeholder="Code" id="codeCommande" value="${codecmd }" disabled/>
		                              </div>
		                              
		                              <div class="col-md-4 mb-3">
		                                 <label><fmt:message code="common.date"/></label>
		                                   <input  class="form-control" placeholder="Date Commande" id="dateCommande" value="${dateCmd }" disabled />
		                              </div>
		                              
		                              <div class="col-md-4 mb-3">
		                              <label><fmt:message code="common.client"/></label>
		                                 <select class="form-control" id="listClients">
		                                 
		                                 <option value="-1"><fmt:message code="commande.client.select.client" /></option>
		                                     <c:forEach items="${clients }" var="client">
		                                           <option value="${client.getId() }">${client.getNom() }</option>
		                                     </c:forEach>
		                                          
		                                 </select>
		                              </div>	
                          </div>   
                          <br /><br /><br /><br />                                   		
	                           <div class="panel-footer">
                                            <button type="submit" id="btnEnregistrerCommande" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregistrer"/></i></button>    
                                        <!--   <a href="<c:url value="/enregistrerCommande/"/>" class="btn btn-primary"><i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.enregistrer"/></i></a> -->
                                          <a href="<c:url value="/commandeClient/"/>" class="btn btn-danger"><i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler"/></i></a>                                         	                           
                                    </div>																																																																	
                          
                          </form>
                  
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                
                <!-- /.row -->
            </div>
            
             <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="common.detail" />
                        </div>
                       
                        <!-- /.panel-heading -->
                        <div class="panel-body">
	                        <div class="form-row">
	                            <div class="col-md-4 mb-3">
			                        <label><fmt:message code="common.article"/></label>
			                         <input class="form-control" type="text" id="code_search" placeholder="saisir un code article" />
			                        
			                        </div>
			                       
	                        </div>
	                        <br /><br /><br /><br /> 
                            <div class="dataTable_wrapper">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            
                                            <th><fmt:message code="common.article"/></th>
                                            <th><fmt:message code="common.quantite"/></th>
                                            <th><fmt:message code="common.prixUnitaireTTC"/></th>
                                            <th><fmt:message code="common.total"/></th>   
                                            <th><fmt:message code="common.actions"/></th>                                         
                                        </tr>
                                    </thead>
                                    <tbody id="detailNouvelleCommande">
                                    <tr>
                                    </tr>
	                                  	                                    
                                    </tbody>
                                </table>
                            </div>
                              
                            <!-- /.table-responsive -->
                           
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
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
    <script src="<%=request.getContextPath() %>/resources/javascript/commandeClient.js"></script>

</body>

</html>
