$(document).ready(function(){
	$("#code_search").on("keypress",function(e){
		if(e.which=='13'){
			var code = $("#code_search").val()
				if(verifierFournisseur() && code){
					rechercherArticle(code);
				}
		}
	});
	
	$("#listfournisseurs").on("change", function(e){
		if(verifierFournisseur()){//si le fournisseur a été bien choisi//
			creerCommande($("#listfournisseurs option:selected").val());
		    }
	});
});

function verifierFournisseur(){
    var id = $("#listfournisseurs option:selected").val();
    if(id){
   	 if(id=="-1"){
   		 alert("veuilleez selectionner un fournisseur");
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
   				 $("#codeCommande").text(data.code);
   				 $("#dateCommande").text(data.dateCommande);
   			 }
   		  }
   		);
	}
}

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
 
 function rechercherArticle(code){
		if(code){
			var detailHtml="";
			$.getJSON("detailArticle", {
				code : code,
				ajax:true
			},
			function(data){
				if(data){
					 detailHtml+=
					"<tr>"+
				       "<td>" + data.code + "</td>"+
				       "<td>1</td>"+
				       "<td>" + data.prixUnitaireTTC + "</td>"+
				       "<td>0</td>"+
			       "</tr>";		
				$("#detailNouvelleCommande").append(detailHtml);
				  }else{
					  alert("article not found");
				  }
				}
		
				);
		}
  }
}