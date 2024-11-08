document.addEventListener('DOMContentLoaded', function() 
{
    // Kullanıcı verilerini çek
    fetch('/kullanıcı')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('kullanıcı-table-body');
            const row = document.createElement('tr');

            // Tek bir kişinin bilgilerini gösterelim
            const isimCell = document.createElement('td');
            isimCell.textContent = data[0].ad;
            row.appendChild(isimCell);

            const soyisimCell = document.createElement('td');
            soyisimCell.textContent = data[0].soyad;
            row.appendChild(soyisimCell);

            const sicilCell = document.createElement('td');
            sicilCell.textContent = data[0].sicil;
            row.appendChild(sicilCell);

            tableBody.appendChild(row);

            // Modal'ı ve butonları seç
            var modal = document.getElementById("myModal");
            var btn = document.getElementById("duzenleButton");
            var span = document.getElementsByClassName("close")[0];

            // Düzenle butonuna tıklandığında modal'ı aç
            btn.onclick = function() 
            {
                modal.style.display = "block";
                document.getElementById('adInput').value = data[0].ad;
                document.getElementById('soyadInput').value = data[0].soyad;
                document.getElementById('sicilInput').value = data[0].sicil;

                modal.style.top = "50%";
                modal.style.left = "50%";
                modal.style.transform = "translate(-50%, -50%)";
            };

            // Güncelle butonuna tıklandığında verileri log'a yazdır ve modal'ı kapat
            document.getElementById('guncelleButton').addEventListener('click', function() 
            {
                const updatedAd = document.getElementById('adInput').value;
                const updatedSoyad = document.getElementById('soyadInput').value;
                const updatedSicil = document.getElementById('sicilInput').value;

                console.log("Güncellenen Veriler:");
                console.log("Ad: " + updatedAd);
                console.log("Soyad: " + updatedSoyad);
                console.log("Sicil No: " + updatedSicil);
                alert("Güncelleme Başarılı!");

                // Modal'ı kapat
                modal.style.display = "none";
            });

            // Modal'dan çıkmak için çarpıya tıkla
            span.onclick = function() 
            {
                modal.style.display = "none";
            };

            // Modal dışında bir yere tıklandığında kapat
            window.onclick = function(event) 
            {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            };
        })
        .catch(error => console.error('Kullanıcı verisi alınırken hata oluştu:', error));
});
