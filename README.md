# event.management

 Verilerinizi yönetmek için bir model olarak bir User ve Event sınıfı oluşturunuz.\
 Authorization işlemi (login) yaptırınız.\
Aşağıda User classının sahip olması gereken fiedler mevcuttur.\
name\
email password(encryption)\

Aşağıda Event classının sahip olması gereken fiedler mevcuttur.\
etkinlik adı başlangıç tarihi bitiş tarihi\
kota\
katılımcı sayısı

User ile Event classları ilişkilendirilecektir. Bu modeller için ekleme,\
listeleme, güncelleme ve silme operasyonlarını içeren bir spring boot restful api örneği beklenmektedir.\
Controllerin API isteğine JSON Objesi olarak dönmesi gerekmektedir. \
İsteğe karşılık HTTP status kodlarının ayrıca eklenmesi beklenmektedir. \
(Örn. Başarılı bir işlem için OK kodu olan 200 dönülebilir.) OOP yapısına uygun olarak geliştirilmelidir.
