document.addEventListener('DOMContentLoaded', function() 
{
    const dropdownContent = document.getElementById('dropdown-content');
    const selecteddropdownItemText = document.getElementById('selecteddropdownItem');

    // Backend'den ayar verilerini al
    fetch('/api/settings')
        .then(response => response.json())
        .then(data => {
            const dropdownItems = data.dropdownItems;

            // Ana ayarları dinamik olarak ekle
            dropdownItems.forEach(item => {
                const dropdownItemDiv = document.createElement('div');
                dropdownItemDiv.classList.add('dropdown-item');
                dropdownItemDiv.textContent = item;
                //Note: Else-if yapısı değiştirilebilir mi araştır. Optimize edilebilir mi?
                dropdownItemDiv.addEventListener('click', function() 
                {
                    if (item === 'Envanter Ayarları') 
                        {
                        toggleSubDropdown(); // Alt menüyü aç/kapa
                    } 
                    else if (item === 'Uygulama Ayarları')
                    {
                        window.location.href = '/uygulama.html'; // Uygulama ayarları için özel yönlendirme
                    }
                    else if (item === 'Kullanıcı Ayarları')
                    {
                        window.location.href = '/kullanıcı.html'; // Kullanıcı ayarları için özel yönlendirme
                    }
                    else if (item === 'Güvenlik Ayarları')
                    {
                        window.location.href = '/güvenlik.html'; // Güvenlik ayarları için özel yönlendirme
                    }
                    else if (item === 'Gelişmiş Ayarlar')
                    {
                        window.location.href = '/gelişmiş.html'; // Gelişmiş ayarlar için özel yönlendirme
                    }
                    else 
                    {
                        window.location.href = '/'; // Diğer ayarlar için ana sayfaya yönlendir
                    }
                });
                dropdownContent.appendChild(dropdownItemDiv);
            });

            // Envanter Ayarları başlığı
            const subDropdownHeader = document.createElement('div');
            subDropdownHeader.classList.add('sub-dropdown-header');
            subDropdownHeader.textContent = 'Envanter Ayarları';

            const subDropdownContent = document.createElement('div');
            subDropdownContent.classList.add('sub-dropdown-content');
            subDropdownContent.style.display = 'none';  // Başlangıçta gizli

            // Envanter ayarları seçenekleri
            const inventorySettings = ['Envanter Sayısı', 'Envanter Ekle', 'Envanter Çıkar'];
            inventorySettings.forEach(setting => {
                const subDropdownItemDiv = document.createElement('div');
                subDropdownItemDiv.classList.add('sub-dropdown-item');
                subDropdownItemDiv.textContent = setting;

                subDropdownItemDiv.addEventListener('click', function() 
                {
                    if (setting === 'Envanter Sayısı') 
                        {
                        window.location.href = '/envanter.html'; // Envanter Sayısı için özel yönlendirme
                    }
                    else if (setting === 'Envanter Ekle')
                    {
                        window.location.href = '/envanter-ekle.html'; // Envanter Ekle için özel yönlendirme
                    }
                    else if (setting === 'Envanter Çıkar')
                    {
                        window.location.href = '/envanter-çıkar.html'; // Envanter Çıkar için özel yönlendirme
                    }
                    else 
                    {
                        window.location.href = '/'; // Diğer ayarlar için ana sayfaya yönlendir
                    }
                });

                subDropdownContent.appendChild(subDropdownItemDiv);
            });

            dropdownContent.appendChild(subDropdownHeader);
            dropdownContent.appendChild(subDropdownContent);

            // Dropdown başlığına tıklandığında panelin açılması/kapanması
            const dropdownHeader = document.querySelector('.dropdown-header');
            dropdownHeader.addEventListener('click', function() 
            {
                dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
            });

            // Envanter ayarları başlığına tıklandığında panelin açılması/kapanması
            subDropdownHeader.addEventListener('click', function() 
            {
                subDropdownContent.style.display = subDropdownContent.style.display === 'block' ? 'none' : 'block';
            });
        })
        .catch(error => console.error('Ayarlar alınırken hata oluştu:', error));
});

// Alt menüyü açıp kapatmak için fonksiyon
function toggleSubDropdown()
{
    const subDropdownContent = document.querySelector('.sub-dropdown-content');
    subDropdownContent.style.display = subDropdownContent.style.display === 'block' ? 'none' : 'block';
}
