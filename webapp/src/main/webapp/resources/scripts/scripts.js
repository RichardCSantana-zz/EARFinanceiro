/**
 * 
 */

function mascaraNumeroParcelas(componente) {
	var texto = componente.value.replace(/\D/g, "");
	var total = parseInt(texto);
	if (total < 1 || texto.trim().length == 0) {
		texto = 1;
	}
	componente.value = texto;
}

function mascaraData(componente) {
	var texto = componente.value.replace(/\D/g, "");
	texto = texto.replace(/^(\d{2})(\d{2})(\d)/, "$1/$2/$3");
	componente.value = texto;
}

function mascaraMonetaria(componente) {
	var texto = componente.value.replace(/\D/g, "");
	texto = texto.replace(".", "");
	var tamanho = texto.length - 2;
	texto = texto.substr(0, tamanho) + "." + texto.substr(tamanho, 2);
	if (texto.charAt(0) == '.') {
		texto = "0" + texto;
	}
	if (texto.charAt(0) == 0
			&& (texto.charAt(1) != '.' || texto.charAt(1) == 0)) {
		texto = texto.substr(1, texto.length);
	}
	componente.value = texto;
}

function soma(componenteID) {
	var componente = document.getElementById(componenteID);
	var total = parseInt(componente.value);
	total = total + 1;
	componente.value = total;
}

function subtrai(componenteID) {
	var componente = document.getElementById(componenteID);
	var total = parseInt(componente.value);
	if (total > 1) {
		total = total - 1;
	}
	componente.value = total;
}