const button = document.getElementById("loadBtn");
const list = document.getElementById("characters");

if (!button || !list) {
    console.error("No se encontraron los elementos del DOM");
}

button.addEventListener("click", () => {

    fetch("/api/characters")
        .then(res => res.json())
        .then(data => {

            console.log("RESPUESTA:", data);

            const characters = Array.isArray(data)
                ? data
                : data.content;

            if (!characters) {
                throw new Error("Formato de respuesta inválido");
            }

            list.innerHTML = "";

            characters.forEach(c => {
                const li = document.createElement("li");
                li.textContent = `${c.name} - ${c.species} (${c.status})`;
                list.appendChild(li);
            });

        })
        .catch(err => console.error("Error cargando personajes:", err));
});
