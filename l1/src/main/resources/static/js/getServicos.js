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
			let idadeTodos = document.getElementById("idadePublico");
			idadeTodos.innerHTML = "Verifique se possui clientes o suficiente e tente novamente.";
		})
		.then(function() {
			console.log("pronto!");
		});

	axios.get('/produtosConsumidos')
		.then(function(response) {

			let produtoTodos = document.getElementById("produtoGeral");
			produtoTodos.innerHTML = "Todos os seus clientes: " + response.data[0][0] + ". Quantidade: " + response.data[0][1] + " vendas.";

			let produtoMulheres = document.getElementById("produtoMulheres");
			produtoMulheres.innerHTML = "Todos os seus clientes que são mulheres: " + response.data[1][0] + ". Quantidade: " + response.data[1][1] + " vendas.";

			let produtoHomens = document.getElementById("produtoHomens");
			produtoHomens.innerHTML = "Todos os seus clientes que são homens: " + response.data[2][0] + ". Quantidade: " + response.data[2][1] + " vendas.";

		})
		.catch(function(error) {
			let produtoTodos = document.getElementById("produtoGeral");
			produtoTodos.innerHTML = "Verifique se possui clientes o suficiente. Caso possua, verifique se eles consumiram algum produto e tente novamente.";
		})
		.then(function() {
			console.log("pronto!");
		});
}