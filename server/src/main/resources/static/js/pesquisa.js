// Função para carregar produtos com base na pesquisa
function loadProducts(query = '') {
    // Envia o valor da pesquisa para o backend
    fetch(`${apiUrl}?search=${encodeURIComponent(query)}`)
        .then(response => response.json())
        .then(data => {
            const productTable = document.getElementById('productTable');
            productTable.innerHTML = '';  // Limpa a tabela antes de adicionar novos produtos
            data.forEach(produto => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${produto.codigo}</td>
                    <td>${produto.nome}</td>
                    <td>${produto.quantidade}</td>
                    <td>R$ ${produto.precoUnitario.toFixed(2)}</td>
                    <td>${produto.localizacao}</td>
                    <td>${produto.unidadeMedida}</td>
                    <td>
                        <button class="btn btn-edit" onclick="editProduct(${produto.codigo})">Editar</button>
                        <button class="btn btn-delete" onclick="deleteProduct(${produto.codigo})">Excluir</button>
                    </td>
                `;
                productTable.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar os produtos:', error);
        });
}

// Adiciona um evento ao campo de pesquisa para detectar mudanças no valor
document.getElementById('searchInput').addEventListener('input', function() {
    const query = this.value;  // Pega o valor digitado no campo de pesquisa
    loadProducts(query);  // Carrega os produtos com a pesquisa
});

// Carrega todos os produtos inicialmente
loadProducts();
