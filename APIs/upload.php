    <?php
	// Load file koneksi.php
	include "./config/koneksi.php";
	// Ambil Data yang Dikirim dari Form
	$id_file = $_POST['idhp'];
	$merk_file = $_POST['merk'];
	$tpe_file = $_POST['tipe'];
	$ket= $_POST['keterangan'];
	$tipe_file = $_FILES['gambar']['type'];
	$nama_file = $_FILES['gambar']['name'];
	$tmp_file = $_FILES['gambar']['tmp_name'];
	
	//Voice Masih Kosong
    
	
	// Set path folder tempat menyimpan gambarnya
	
	$path = "img/".$nama_file;
	//$path1 = "suara/".$voice;
	if($tipe_file == "image/jpeg" || $tipe_file == "image/png"){
		// Cek apakah tipe file yang diupload adalah JPG / JPEG / PNG  
		// Jika tipe file yang diupload JPG / JPEG / PNG, lakukan : 
		if($ukuran_file <= 2000000){
			// Cek apakah ukuran file yang diupload kurang dari sama dengan 1MB    
			// Jika ukuran file kurang dari sama dengan 1MB, lakukan :    
			// Proses upload    
			if(move_uploaded_file($tmp_file, $path))
			{ 
				// Cek apakah gambar berhasil diupload atau tidak      
				// Jika gambar berhasil diupload, Lakukan :        
				// Proses simpan ke Database      
				$query = "INSERT INTO hape(idhp, merk, tipe, keterangan, gambar) VALUES('".$id_file."','".$merk_file."','".$tpe_file."','".$ket."','".$nama_file."')";      
				$sql = mysqli_query($connect, $query); // Eksekusi/ Jalankan query dari variabel $query            
				if($sql){ 
					// Cek jika proses simpan ke database sukses atau tidak        
					// Jika Sukses, Lakukan :        
					header("location: index.php"); 
					// Redirectke halaman index.php      
					}
					else{
						// Jika Gagal, Lakukan :
						echo "Maaf, Terjadi kesalahan saat mencoba untuk menyimpan data ke database.";
						echo "<br><a href='form.php'>Kembali Ke Form</a>";
						}    
						}
						else{      
						// Jika gambar gagal diupload, Lakukan :      
							echo "Maaf, Gambar gagal untuk diupload.";   
							echo "<br><a href='form.php'>Kembali Ke Form</a>"; 
							}  
							}
							else{    
								// Jika ukuran file lebih dari 1MB, lakukan :    
								echo "Maaf, Ukuran gambar yang diupload tidak boleh lebih dari 1MB";    
								echo "<br><a href='form.php'>Kembali Ke Form</a>";  
								}
								}
								else{ 
								// Jika tipe file yang diupload bukan JPG / JPEG / PNG, lakukan :  
									echo "Maaf, Tipe gambar yang diupload harus JPG / JPEG / PNG.";  
									echo "<br><a href='form.php'>Kembali Ke Form</a>";
									}
									?>