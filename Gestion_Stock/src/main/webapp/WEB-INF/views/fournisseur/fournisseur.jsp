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
                        <h1 class="page-header"><fmt:message code="common.fournisseur" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->                 
                </div>
                
                <div class="row">
                     <div class="col-lg-12">
						  <ol class="breadcrumb">
						    <li><a href="<c:url value="/fournisseur/nouveau" />" ><i class="fa fa-plus">&nbsp;<fmt:message code="common.ajouter"/></i></a></li>
						    <li><a href="#"><i class="fa fa-download">&nbsp;<fmt:message code="common.exporter"/></i></a></li>
		<!--				    <li><a href="#"><i class="fa fa-upload">&nbsp;<fmt:message code="common.importer"/></i></a></li>		-->

						  </ol>
                     </div>
                </div>
                
        <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message code="fournisseur.List" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">
                                <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th><fmt:message code="common.photo"/></th>
                                            <th><fmt:message code="common.nom"/></th>
                                            <th><fmt:message code="common.prenom"/></th>
                                            <th><fmt:message code="common.adresse"/></th>
                                            <th><fmt:message code="common.tel"/></th>
                                            <th><fmt:message code="common.raisonSociale"/></th>
                                            <th><fmt:message code="common.email"/></th>
                                            <th><fmt:message code="common.actions"/></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${fournisseurs }" var="fournisseur">
                                        <tr class="odd gradeX">
                                            <td class="center"><img src="${fournisseur.getPhoto() }" width="50px" height="50px"/></td>
                                            <td>${fournisseur.getNom() }</td>
                                            <td>${fournisseur.getPrenom() }</td>
                                            <td>${fournisseur.getAdresse() }</td>
                                            <td>${fournisseur.getTel() }</td>
                                            <td>${fournisseur.getRaisonSociale() }</td>
                                            <td>${fournisseur.getEmail() }</td>
                                            <td>  
                                                   <c:url value="/fournisseur/modifier/${fournisseur.getId() }" var="urlModif" />                                      
                                                  <a href="${urlModif }"><i class="fa fa-edit">&nbsp;<fmt:message code="common.modifier"/></i></a>
                                                        &nbsp;|&nbsp;
                                                 <a href="javascript:void(0);" data-toggle="modal" data-target="#modalfournisseur${fournisseur.getId() }"><i class="fa fa-trash-o">&nbsp;<fmt:message code="common.supprimer"/></i></a>  
                                 <div class="modal fade" id="modalfournisseur${fournisseur.getId() }" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
							                                            <c:url value="/fournisseur/supprimer/${fournisseur.getId() }" var="urlSuppression"/>
							                                            <a href="${urlSuppression }" class="btn btn-danger"><i class="fa fa-trash-o">&nbsp;<fmt:message code="common.confirmer"/></i></a>
							                                        </div>
							                                    </div>
							                                    <!-- /.modal-content -->
							                                </div>
							                                <!-- /.modal-dialog -->
							                            </div>                                                                                              
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
