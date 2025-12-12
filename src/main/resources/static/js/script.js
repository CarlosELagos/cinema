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
                    window.location.href = "/listador";
                } else {
                    alert("filme não cadastrado");
                }
            });
}
function excluirFilme(id) {
    fetch(`/filme/excluir/${id}`, {
        method: "DELETE"
    })
            .then(response => {
                if (response.ok) {
                    alert("filme excluido");
                    window.location.reload();
                } else {
                    alert("filme não excluido");
                }
            })
            .catch(error => {
                console.error("Erro: ", error);
                alert("falha na comunicação");
            });
}

function adicionarAnalise() {
    const filmeId = document.getElementById("filmeId").value;
    const data = {
        detalhes: document.getElementById("detalhes").value,
        nota: document.getElementById("nota").value,
        filme: {id: filmeId}
    };
    fetch("/analise/adicionar", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
            .then(response => {
                if (response.ok) {
                    alert("Comentario aceito!");
                    carregarAnalises(filmeId);
                    document.getElementById("detalhes").value = "";
                    document.getElementById("nota").value = "";
                } else {
                    alert("comentario não aceito!");
                }
            });
}
function carregarAnalises(filmeId) {
    fetch(`/analise/pesquisa/${filmeId}`)
            .then(response => response.json())
            .then(lista => {
                const ul = document.getElementById("listaAnalises");
                ul.innerHTML = "";
                lista.forEach(reg => {
                    ul.innerHTML += `<li>Comentario: ${reg.detalhes} | Nota: ${reg.nota}</li>`;
                });
            });
}

window.onload = () => {
    const filmeId = document.getElementById("filmeId").value;
    carregarAnalises(filmeId);
};

function atualizarFilme(id) {
    const atual = {
        titulo: document.getElementById("titulo").value,
        sinopse: document.getElementById("sinopse").value,
        genero: document.getElementById("genero").value,
        anoLancamento: document.getElementById("anoLancamento").value
    };
    fetch(`/filme/atualizar/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(atual)
    })
            .then (response => {
                if(response.ok){
                   alert("Atualizado!"); 
                   window.location.href = "/listador";
                } else {
                    alert("não atualizado")
                };
                
            });
}
