$(document).ready(function(){
	$("#tauxTVA").on("keyup",function(){
		//alert("hello general");
		tvaKeyUpFunction();
	});
	
});

tvaKeyUpFunction = function(){
	var prixUnitHT =$("#prixUnitaireHT").val();
	var tauxTva = $("#tauxTVA").val();
	
	var prixUnitTTC = parseFloat(parseFloat(prixUnitHT) * parseFloat(tauxTva) / 100 + parseFloat(prixUnitHT) );
	
	$("#prixUnitaireTTC").val(prixUnitTTC);
}