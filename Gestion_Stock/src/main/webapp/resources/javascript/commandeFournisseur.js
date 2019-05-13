function updateDetailCommande(code){
	var json = $.parseJSON($("#json" + code).text());
	var detailHtml="";
	if(json){
		for(index=0 ; index < json.length ; index++){
			var detailHtml="";
			"<tr>"+
		       "<td>" + json[index].article.code + "</td>"+
		       "<td>" + json[index].quantite + "</td>"+
		       "<td>" + json[index].prixUnitaire + "</td>"+
		       "<td>0</td>"+
		       "<td></td>"+
	       "</tr>";		
		}
		$("#detailCommande").html(detailHtml);
	}
}