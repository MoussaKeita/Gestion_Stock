<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="javascript:void(0);">Gestion de Stock </a>
</div>
<!-- /.navbar-header -->

<ul class="nav navbar-top-links navbar-right">
	
		
	<!-- /.dropdown -->
	<li class="dropdown"><a class="dropdown-toggle"
		data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
			<i class="fa fa-caret-down"></i>
	</a>
		<ul class="dropdown-menu dropdown-user">
			<li class="divider"></li>
			<c:url value = "/changelocale/fr" var = "frUrl" />
			<c:url value = "/changelocale/en" var = "enUrl" />
			<li><a href="${frUrl}"><i class="fa fa-globe fa-fw"></i> <fmt:message code="locale.fr" /></a></li>
			<li><a href="${enUrl}"><i class="fa fa-globe fa-fw"></i> <fmt:message code="locale.en" /> </a></li>
			<li class="divider"></li>
			<c:url value = "/j_spring_security_logout" var = "logout" />
			<li><a href="${logout }"><i class="fa fa-sign-out fa-fw"></i><fmt:message code="common.logout" /></a></li>
		</ul> <!-- /.dropdown-user --></li>
	<!-- /.dropdown -->
</ul>
<!-- /.navbar-top-links -->