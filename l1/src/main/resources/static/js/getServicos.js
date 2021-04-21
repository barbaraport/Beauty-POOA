window.onload = () => {

	axios.get('/idadeClientes')
		.then(function(response) {
			
			let idadeTodos = document.getElementById("idadePublico");
			idadeTodos.innerHTML = "Todos os seus clientes: " + response.data[0] + " anos.";
			
			let idadeMulheres = document.getElementById("idadeFeminino");
			idadeMulheres.innerHTML = "Todos os seus clientes que são mulheres: " + response.data[1] + " anos.";
			
			let idadeHomens = document.getElementById("idadeMasculino");
			idadeHomens.innerHTML = "Todos os seus clientes que são homens: " + response.data[2] + " anos.";
			
		})
		.catch(function(error) {
			console.log(error);
		})
		.then(function() {
			console.log("pronto!");
		});

}