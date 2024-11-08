document.addEventListener('DOMContentLoaded', function() 
{
    // HTML'deki gerekli elementleri seç
    const userNameInput = document.getElementById('envanterAdi');
    const userKodInput = document.getElementById('envanterKodu');
    const userBarkodInput = document.getElementById('envanterBarkod');
    const userAdetInput = document.getElementById('envanterSayisi');
    // Butona basılınca Envanter verilerini gönder  
    document.getElementById('envanterEkleButton').addEventListener('click', function() 
    {
        fetch('/envanterEkle', {
            method: 'POST',
            headers: 
            {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                isim: userNameInput.value,
                kod: userKodInput.value,
                barkod: userBarkodInput.value,
                adet: userAdetInput.value
            }),
        })
        // Eğer işlem başarılı olursa, kullanıcıyı bilgilendir
        .then(response => response.json())
        .then(data => {
            alert('Envanter başarıyla eklendi.');
        })
    });

});