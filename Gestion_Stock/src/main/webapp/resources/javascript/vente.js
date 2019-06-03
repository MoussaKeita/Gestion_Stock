$(document).ready(function() {
$("#code_search").on("keypress",function(e){
		if(e.which=='13'){
			var code = $("#code_search").val();
				//if(verifierCommande() && code){
				//	searchArticle(code);
				//}
		}
	});
		
	$("#listClients").on("change", function(e){
		if(verifierCommande()){//si le fournisseur a été bien choisi//
			$("#clientNotSelectedMsgBlock").hide("slow", function() {$("#clientNotSelectedMsgBlock").hide()});
			creerVente($("#listClients option:selected").val());
		    }
	});
	$("#btnEnregistrerVente").on("click", function(){
		$.getJSON("enregistrerVente", function(data){
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


function verifierCommande(){
    var code = $("#listClients option:selected").val();
    if(code){
   	 if(code==="-1"){
   		$("#clientNotSelectedMsgBlock").show("slow", function() {$("#clientNotSelectedMsgBlock").show()});
   		 return false;
   	   }
   	 return true;
    }
}
function creerVente(code){
	if(code){
		 $.getJSON("creerVente",{
   			 code:code,
   			 ajax: true
   			 
   		 },
   		 function(data){
   			 console.log("La commande a été mise à jours avec succès");
   		  });
	}
}
