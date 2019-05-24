$(document).ready(function() {
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
			$("#clientNotSelectedMsgBlock").hide("slow", function() {$("#clientNotSelectedMsgBlock").hide()});
			creerCommande($("#listfournisseurs option:selected").val());
		    }
	});
	$("#btnEnregistrerCommande").on("click", function(){
		$.getJSON("enregistrerCommande", function(data){
			if(data){
				window.location(data);
				//console.log(data);
			}
			
		});
		
	});

	$("#notFoundMsgBlock").hide();
	$("#clientNotSelectedMsgBlock").hide();
	$("#unexpectedErrorMsgBlock").hide();
	
});

function updateDetailCommande(code) {
	var merde = $.parseJSON($("#json" + code).text()); // return lignes de commande client by idCommande
	var detailHtml = "";
	if(merde) {
		
		for(var index = 0; index < merde.length; index++) {
			var total = merde[index].quantite * merde[index].prixUnitaireTTC;
			 detailHtml +=
				"<tr>"+
			       "<td>" + merde[index].article.code + "</td>"+
			       "<td>" + merde[index].quantite + "</td>"+
			       "<td>" + merde[index].prixUnitaireTTC + "</td>"+
			       "<td>" + total + "</td>"+
		       "</tr>";		 
		}
		$("#detailCommande").html(detailHtml);
	}	
}
function verifierFournisseur(){
    var id = $("#listfournisseurs option:selected").val();
    if(id){
   	 if(id==="-1"){
   		$("#clientNotSelectedMsgBlock").show("slow", function() {$("#clientNotSelectedMsgBlock").show()});
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
   			 console.log("Le client a été mis à jours avec succès");
   		  });
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
							 "<tr id='ligne" + data.article.code + "'>"+
						       "<td>" + data.article.code + "</td>"+
						       "<td id='quantite" + data.article.code + "' >" + data.quantite + "</td>"+
						       "<td>" + data.prixUnitaireTTC + "</td>"+
						       "<td id='total" + data.article.code + "'>" + total + "</td>"+
		 "<td><button class='btn btn-link' onclick='supprimerLigneCmd(" + data.article.code + ")'><i class='fa fa-trash-o'></i></button> </td>"+
					       "</tr>";	
					     $("#detailNouvelleCommande").append(detailHtml);
					  }
					$("#notFoundMsgBlock").hide("slow", function() {$("#notFoundMsgBlock").hide()});
					$("#code_search").val("");
				  }
			}).fail(function(){
				$("#notFoundMsgBlock").show("slow", function() {$("#notFoundMsgBlock").show()});
			   });
			}
         }
		 
function supprimerLigneCmd(code){
	if($("#ligne" + code).length > 0){
		$.getJSON("supprimerLigne",{
			  code : code ,
			  ajax : true
		},
		function(data){
			if(data){
				$("#ligne" + code).hide("slow", function(){$("#ligne" + code).remove()});
			}
		});
	}
	
}



