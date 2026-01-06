const grid = document.getElementById("charactersGrid")
const searchInput = document.getElementById("searchInput")

let characters = [];

fetch("http://localhost:8080/api/characters")
    .then(res => res.json())
    .then(data => {
        characters = data;
        renderCharacters(characters);
    })
.catch(error => console.error("Error cargando personajes", err));

function renderCharacters(list) {
    grid.innerHTML = "";

    list.forEach(char => {
        const card = document.createElement("div");
        card.className = "card";

        card.innerHTML = `
        <img src ="${char.image}" alt="${char.name}" />
        <div class="card-content">
        <h3>${char.name}</h3>
        <p>${char.species}</p>
        <p>${char.status}</p>
        </div>
        `;

        grid.appendChild(card);
    });
}

searchInput.addEventListener("input", (e) => {
    const text = e.target.value.toLowerCase();

    const filtered = characters.filter (c => c.name.toLowerCase().includes(text)
    );

    renderCharacters(filtered);
})