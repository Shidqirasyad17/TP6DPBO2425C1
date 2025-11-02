## JANJI
Saya Shidqi Rasyad Firjatulah dengan NIM 2408156 mengerjakan TP6 pada mata kuliah DPBO untuk keberkahannya saya menyatakan bahwa saya tidak melakukan kecurangan sebagaimana yang dispesifikasikan.


---

## Desain Program
### `Class APP`
Main class yang menjalankan program (menampilkan dan memulai game)
 - Pengatur awal program
 - Menginisialisasi semua komponen utama
 - penghubung logic dan view
### `Class Logic`
Mengatur Logika permainan, meliputi:
 - Mengatur gravitasi dan gerakan burung.
 - Membuat dan menggerakan pipa
 - Mengecek tabrakan antara burung dan pipa.
 - Mengatur skor saat melewati pipa.
 - Mengatur kondisi Game Over dan restart.
### `Class View`
Mengatur tampilan visual permainan.
Fungsinya:
- menggambar background, burung, pipa, dan skor ke layar.
- Menampilkan teks "Game Over" dan "R For Restart" saat kalah.
### `Class Player`
Merepresentasikan burung/player.
Menyimpan:
 - Posisi player
 - Ukuran player
 - Kecepatan jatuh
 - GambarBurung
### `Class Pipe`
Merepresentasikan pipa.
Menyimpan:
 - Posisi pipa
 - Ukuran pipa
 - Gambar pipa
 - Pergerakan Pipa
## Alur
1. Program dijalankan (App.java)
2. Inisialisasi game
   - load gambar
   - Buat objek player & pipa
   - jalankan timer loop
4. Loop game 
   - tambahkan gravitas
   - gerakan pipa ke kiri
   - cek tabrakan/jatuh
   - tambah skor bila melewati pipa
    
5. Cek tabrakan/jatuh:
   Jika burung tabrakan Game Over "R for restart". Jika tekan tombol R reset posisi dan skor, jalankan ulang game

# Dokumentasi
https://github.com/user-attachments/assets/6b1dfe40-5fd8-474c-acbd-7df513a753b3





