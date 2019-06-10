<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">
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
    
       <!-- DataTables CSS -->
    <link href="<%=request.getContextPath() %>/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=request.getContextPath() %>/resources/bower_components/datatables-responsive/css/dataTables.responsive.css" rel="stylesheet">

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
                        <h1 class="page-header"><fmt:message code="common.client.commande" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->                 
                </div>
                
                <div class="row">exportDetails
                     <div class="col-lg-12">
						  <ol class="breadcrumb">
						    <li><a href="<c:url value="/commandeClient/nouveau" />" ><i class="fa fa-plus">&nbsp;<fmt:message code="common.ajouter"/></i></a></li>
						 <c:url value="/commandeClient/export/" var ="export" />
						    <li><a href="${export }"><i class="fa fa-download">&nbsp;<fmt:message code="common.exporter"/></i></a></li>
						    <c:url value="/commandeClient/exportDetails/" var ="exportdet" />
						    <li><a href="${exportdet }"><i class="fa fa-download">&nbsp;<fmt:message code="common.importer"/></i></a></li>
						  </ol>
                     </div>
                </div>
                
        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="commande.list" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            
                                           <th><fmt:message code="common.code"/></th>
                                            <th><fmt:message code="common.client"/></th>
                                            <th><fmt:message code="common.date"/></th>
                                            <th><fmt:message code="common.total"/></th>
                                            <th><fmt:message code="common.actions"/></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${cmdClients }" var="cmd">
                                        <tr class="odd gradeX">
                                           
                                        <td>${cmd.getCode() }</td>
                                            <td>${cmd.getClient().getNom() }</td>
                                            <td>${cmd.getDateCommande() }</td>
                                            <td>${cmd.getTotalCommande()}</td>
                                            <td>  
                                              <textArea  id = "json${cmd.getCode() }" style="display: none;">${cmd.getLigneCommandeJson() } </textArea>                               
                                                <button class="btn btn-link" onclick="updateDetailCommande('${cmd.getCode() }');"><i class="fa fa-eye"></i></button>     
                                                        &nbsp;|&nbsp;
                                                   <c:url value="/commandeClient/modifier/${cmd.getCode() }" var="urlModif" />                                      
                                                <a href="${urlModif }"><i class="fa fa-edit"></i></a>
                                                        &nbsp;|&nbsp;
                                                 <a href="javascript:void(0);" data-toggle="modal" data-target="#modalcommande${cmd.getCode() }"><i class="fa fa-trash-o"></i></a>  
                                 <div class="modal fade" id="modalcommande${cmd.getCode() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
							                                <div class="modal-dialog">
							                                    <div class="modal-content">
							                                        <div class="modal-header">
							                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                                            <h4 class="modal-title" id="myModalLabel"><fmt:message code="common.confirm.suppression"/></h4>
							                                        </div>
							                                        <div class="modal-body">
							                                          <fmt:message code="fournisseur.confirm.suppression"/>
							                                        </div>
							                                        <div class="modal-footer">
							                                            <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message code="common.annuler"/></button>
							                                            <c:url value="/commandeClient/supprimer/${cmd.getCode() }" var="urlSuppression"/>
							                                            <a href="${urlSuppression }" class="btn btn-danger"><i class="fa fa-trash-o">&nbsp;<fmt:message code="common.confirmer"/></i></a>
							                                        </div>
							                                    </div>
							                                    <!-- /.modal-content -->
							                                </div>
							                                <!-- /.modal-dialog -->
							                            </div> 
							                            &nbsp;|&nbsp;
							                    <c:url value="/commandeClient/modifierBon/${cmd.getCode() }" var="urlModif" />                                      
                                             <a href="${urlModif }"><i class="fa fa-edit"></i></a>                                                                                             
                                            </td>
                                        </tr>
                                    </c:forEach>                                     
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                           
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
         
                <!-- /.row -->
                
            </div>
             <!-- detail commande fournisseur -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="common.detail" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            
                                            <th><fmt:message code="common.article"/></th>
                                            <th><fmt:message code="common.quantite"/></th>
                                            <th><fmt:message code="common.prixUnitaireTTC"/></th>
                                            <th><fmt:message code="common.total"/></th>                                           
                                        </tr>
                                    </thead>
                                    <tbody id="detailCommande">                          
	                                  	                                    
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                           
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
    
    <!-- DataTables JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bower_components/datatables-responsive/js/dataTables.responsive.js"></script>
           <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    
               <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/javascript/commandeFournisseur.js"></script>
        <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
                responsive: true
        });
    });
    </script>
    

</body>

</html>
