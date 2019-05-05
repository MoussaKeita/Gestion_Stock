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
                        <h1 class="page-header"><fmt:message key="article.nouveau" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                       <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <fmt:message key="article.nouveau" />
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                         <c:url value="/article/enregistrer" var="urlEnregistrer"/>
                          <f:form modelAttribute="article" action="${urlEnregistrer }" method="post" enctype="multipart/form-data" role="form">
                            <!-- <f:hidden path="code"/>-->
                             <f:hidden path="photo"/>

	                          <div class="form-group">
	                                 <label><fmt:message key="common.code"/></label>
	                                   <f:input path="code" class="form-control" placeholder="codeArticle"/>
	                              </div>
	                              <div class="form-group">
	                                 <label><fmt:message key="common.libelle"/></label>
	                                   <f:input path="libelle" class="form-control" placeholder="Designation"/>
	                              </div>
	                             <div class="form-group">
	                                 <label><fmt:message key="common.prixUnitaireHT"/></label>
	                                   <f:input path="prixUnitaireHT" class="form-control" placeholder="PrixUnitaireHT"/>
	                              </div>
	                              <div class="form-group">
	                                 <label><fmt:message key="common.prixUnitaireTTC"/></label>
	                                   <f:input path="prixUnitaireTTC" class="form-control" placeholder="PrixUnitaireTTC"/>
	                              </div>
	                              <div class="form-group">
	                                 <label><fmt:message key="common.tauxTVA"/></label>
	                                   <f:input path="tauxTVA" class="form-control" placeholder="TauxTVA"/>
	                              </div>
	                              <div class="form-group">
	                                 <label><fmt:message key="common.category"/></label>
	                                   <f:select path="category.id" class="form-control" items="${categories }" itemLabel="code" itemValue="id"/>
	                              </div>
			                            <div class="form-group">
		                                 <label><fmt:message key="common.photo"/></label>
		                                   <input type="file" name="file"/>
		                              </div>
	                           <div class="panel-footer">
                                          <button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message key="common.enregistrer"/></i></button>
                                          <a href="<c:url value="/article/"/>" class="btn btn-danger"><i class="fa fa-arrow-left">&nbsp;<fmt:message key="common.annuler"/></i></a>                                         	                           
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

</body>

</html>
