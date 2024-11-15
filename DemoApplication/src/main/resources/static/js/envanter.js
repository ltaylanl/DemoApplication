document.addEventListener('DOMContentLoaded', function() {
    // Envanter tablosunu sıralama
    const isimHeader = document.getElementById('isimHeader');
    const adetHeader = document.getElementById('adetHeader');
    let isimSortOrder = 'asc';
    let adetSortOrder = 'asc';

    isimHeader.addEventListener('click', function() {
        sortTable('isim', isimSortOrder);
        isimSortOrder = isimSortOrder === 'asc' ? 'desc' : 'asc';
    });

    adetHeader.addEventListener('click', function() {
        sortTable('adet', adetSortOrder);
        adetSortOrder = adetSortOrder === 'asc' ? 'desc' : 'asc';
    });

    function sortTable(column, order) {
        const table = document.getElementById('envanterTableBody');
        const rows = Array.from(table.rows);
        
        rows.sort((a, b) => {
            const cellA = a.querySelector(`[data-column="${column}"]`).textContent;
            const cellB = b.querySelector(`[data-column="${column}"]`).textContent;

            if (column === 'adet') {
                return order === 'asc' ? cellA - cellB : cellB - cellA;
            } else {
                return order === 'asc' ? cellA.localeCompare(cellB) : cellB.localeCompare(cellA);
            }
        });

        rows.forEach(row => table.appendChild(row));
    }
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

                const barkodCell = document.createElement('td');
                const barkodImg = document.createElement('img');
                barkodImg.src = `/generateBarcode?code=${item.kod}`; // Barkod API'sine kod parametresi ile istek gönderiliyor
                barkodImg.alt = 'Barkod';
                barkodImg.classList.add('barkod-image'); // Stil için sınıf ekleyebilirsiniz
                barkodCell.appendChild(barkodImg);
                row.appendChild(barkodCell);

                const adetCell = document.createElement('td');
                adetCell.textContent = item.adet;
                row.appendChild(adetCell);

                tableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Envanter verisi alınırken hata oluştu:', error));
});
