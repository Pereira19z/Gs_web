function fetchWaterData() {
    const location = document.getElementById('location').value;
    fetch(`/api/water-quality?location=${location}`)
        .then(response => response.json())
        .then(data => {
            const waterDataDiv = document.getElementById('waterData');
            waterDataDiv.innerHTML = `
                <h2>Dados de Qualidade da Água</h2>
                <p>Localização: ${location}</p>
                <p>pH: ${data.ph}</p>
                <p>Turbidez: ${data.turbidez}</p>
                <p>Oxigênio Dissolvido: ${data.oxigenio}</p>
                <p>Nitratos: ${data.nitratos}</p>
                <p>Fosfatos: ${data.fosfatos}</p>
                <p>Coliformes Totais: ${data.coliformes}</p>
            `;
        })
        .catch(error => console.error('Erro ao buscar os dados:', error));
}
