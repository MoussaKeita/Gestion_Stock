$(document).ready(function(){
	$("#qteSortie").on("keyup",function(){		
		tvaKeyUpFunction();
	});
	
});

tvaKeyUpFunction = function(){
	var livre =$("#qteLivre").val();
	var sortie= $("#qteSortie").val();
	
	var Reste = parseInt(parseInt(livre) - parseInt(sortie) );
	
	$("#qteRestante").val(Reste);
}