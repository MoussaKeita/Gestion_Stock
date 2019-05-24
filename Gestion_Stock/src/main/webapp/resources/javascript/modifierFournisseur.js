$(document).ready(function() {

					searchArticle(code);
	});

 function searchArticle(code){
	 if(code){
			var detailHtml="";
			$.getJSON("ajouterLigne", {
				code : code,
				ajax:true
			},
			function(data){
				if(data){
				
						   detailHtml +=
							 "<tr id='ligne" + data.article.code + "'>"+
						    
		 "<td><button class='btn btn-link' onclick='supprimerLigneCmd(" + data.article.code + ")'><i class='fa fa-trash-o'></i></button> </td>"+
					       "</tr>";	
					     $("#detailNouvelleCommande").append(detailHtml);
					  } 
			}
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



