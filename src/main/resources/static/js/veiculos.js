document.getElementById("tipo").addEventListener("change", function () {
    const tipo = this.value;
    document.getElementById("campos-carro").style.display = tipo === "carro" ? "block" : "none";
    document.getElementById("campos-moto").style.display = tipo === "moto" ? "block" : "none";
});

document.addEventListener("DOMContentLoaded", function () {
    $('#tabelaVeiculos').DataTable({
        language: {
            url: "//cdn.datatables.net/plug-ins/1.13.5/i18n/pt-BR.json"
        }
    });
});

