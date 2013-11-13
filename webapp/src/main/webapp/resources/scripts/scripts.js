/**
 * 
 */

function soma(componenteID) {
	var x = document.getElementById(componenteID);
	var total = parseInt(x.value);
	total = total + 1;
	x.value = total;
}

function subtrai(componenteID) {
	var componente = document.getElementById(componenteID);
	var total = parseInt(componente.value);
	if (total > 1) {
		total = total - 1;
	}
	componente.value = total;
}