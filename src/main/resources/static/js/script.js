function cadastrarFilme() {
    const data = {
        titulo: document.getElementById("titulo").value,
        sinopse: document.getElementById("sinopse").value,
        genero: document.getElementById("genero").value,
        anoLancamento: document.getElementById("anoLancamento").value
    };
    fetch("/filme/adicionar", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
            .then(response => {
                if (response.ok) {
                    alert("filme cadastrado");
                } else {
                    alert("filme não cadastrado");
                }
            });
}
function excluirFilme(id) {
    fetch('/filme/excluir/${id}', {
        method: "DELETE"
    })
            .then(response => {
                if (response.ok) {
                    alert("filme excluido");
                    window.location.reload();
                } else {
                    alert("filme não excluido");
                }
            });
}

