$(document).ready(function(){
	$("#code_search").on("keypress",function(e){
		if(e.which=='13'){
			var code = $("#code_search").val();
				if(verifierFournisseur() && code){
					searchArticle(code);
				}
		}
	});
	
	$("#listfournisseurs").on("change", function(e){
		if(verifierFournisseur()){//si le fournisseur a été bien choisi//
			creerCommande($("#listfournisseurs option:selected").val());
		    }
	});
});

function updateDetailCommande(code){	
	var merde = $.parseJSON($("#json" + code).text());
	 var detailHtml="";
 if(merde){
	 for(var index=0 ; index < merde.length ; index++){
		 detailHtml +=
				"<tr>"+
			       "<td>" + merde[index].article.code + "</td>"+
			       "<td>" + merde[index].quantite + "</td>"+
			       "<td>" + merde[index].prixUnitaireTTC + "</td>"+
			       "<td>0</td>"+
		       "</tr>";		 
	 }
	 $("#detailCommande").html(detailHtml);
   }
}

function verifierFournisseur(){
    var id = $("#listfournisseurs option:selected").val();
    if(id){
   	 if(id==="-1"){
   		 alert("veuillez selectionner un fournisseur");
   		 return false;
   	   }
   	 return true;
    }
}

function creerCommande(id){
	if(id){
		 $.getJSON("creerCommande",{
   			 id:id,
   			 ajax: true
   			 
   		 },
   		 function(data){
   			 if(data){
   				 $("#codeCommande").text(data);
   				//$("#dateCommande").text(data.dateCommande);
   			 }
   		  }
   		);
	}
}

 function searchArticle(code){
		if(code){
			var detailHtml="";
			$.getJSON("ajouterLigne", {
				code : code,
				ajax:true
			},
			function(data){
				if(data){
					var total = data.quantite * data.prixUnitaireTTC;
					if($("#quantite" + data.article.code).length > 0 && $("#total" + data.article.code).length > 0){
						$("#quantite" + data.article.code).text(data.quantite);
						$("#total" + data.article.code).text(total);
					}else{
						   detailHtml +=
							 "<tr>"+
						       "<td>" + data.article.code + "</td>"+
						       "<td id='quantite" + data.article.code + "' >" + data.quantite + "</td>"+
						       "<td>" + data.prixUnitaireTTC + "</td>"+
						       "<td id='total" + data.article.code + "'>" + total + "</td>"+
					       "</tr>";	
					     $("#detailNouvelleCommande").append(detailHtml);
					  }
				  }else{
					  alert("article not found");
				  }
			}
		
				);
			}
 }
