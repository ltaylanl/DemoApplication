document.addEventListener('DOMContentLoaded', function() {
    // Envanter verilerini çek
    fetch('/envanterler')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('envanter-table-body');

            data.forEach(item => {
                const row = document.createElement('tr');

                const isimCell = document.createElement('td');
                isimCell.textContent = item.isim;
                row.appendChild(isimCell);

                const kodCell = document.createElement('td');
                kodCell.textContent = item.kod;
                row.appendChild(kodCell);

                const barkodCell = document.createElement('td');
                barkodCell.textContent = item.barkod;
                row.appendChild(barkodCell);

                const adetCell = document.createElement('td');
                adetCell.textContent = item.adet;
                row.appendChild(adetCell);

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Envanter verisi alınırken hata oluştu:', error));
});
