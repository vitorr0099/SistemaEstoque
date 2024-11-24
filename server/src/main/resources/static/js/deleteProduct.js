function deleteProduto(codigo) {
    // Confirmação antes de excluir
    const confirmDelete = confirm("Tem certeza que deseja excluir este produto?");
    if (confirmDelete) {
        // Envia requisição DELETE para o back-end
        fetch(`${apiUrl}/${codigo}`, {
            method: 'DELETE',
        })
        .then(response => {
            if (response.ok) {
                alert('Produto excluído com sucesso!');
                // Recarregar os produtos para refletir a exclusão 
                loadProducts();
            } else {
                alert('Erro ao excluir o produto.');
            }
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Erro ao excluir o produto.');
           


        });
    }
}
