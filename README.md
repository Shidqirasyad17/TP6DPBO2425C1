## JANJI
Saya Shidqi Rasyad Firjatulah dengan NIM 2408156 mengerjakan TP6 pada mata kuliah DPBO untuk keberkahannya saya menyatakan bahwa saya tidak melakukan kecurangan sebagaimana yang dispesifikasikan.


---

## Desain Program
### `Class APP`
Main class yang menjalankan program (menampilkan dan memulai game)
### `Class Logic`
Mengatur Logika permainan (gravitasi, pipa, tabrakan, skor, restart)
### `Class View`
Mengatur elemen-elemen game (burung, pipa, background, teks)
### `Class Player`
Menyimpan data burung(posisi, ukuran, kecepatan, dan gambar)
### `Class Pipe`
Menyimpan data pipa (posisi, ukuran, dan gambar)
---

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

![dokumentasitp5](https://github.com/user-attachments/assets/27de6679-e0bb-403a-ba59-6fec3f0a8c75)





