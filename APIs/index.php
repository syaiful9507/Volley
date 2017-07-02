    <html><head>  
	<title>Data</title>
	</head>
	<body><h1>List Data</h1>
	<hr><a href="form.php">Tambah</a>
	<br><br>
	<table border="1" cellpadding="8"><tr> 
	<th>ID</th>
	<th>Merk</th>
	<th>Tipe</th> 
	<th>Keterangan</th> 
	<th>Gambar</th>

	</tr>
	<?php
	// Load file koneksi.php
	include "koneksi.php";
	$query = "SELECT * FROM hape"; 
	// Tampilkan semua data gambar
	$sql = mysqli_query($connect, $query);
	// Eksekusi/Jalankan query dari variabel 
	$row = mysqli_num_rows($sql);
	// Ambil jumlah data dari hasil eksekusi
	if($row > 0){ 
	// Jika jumlah data lebih dari 0 (Berarti jika data ada)  
	while($data = mysqli_fetch_array($sql)){
		// Ambil semua data dari hasil eksekusi
		echo "<tr>";  
		echo "<td>".$data['idhp']."</td>"; 
		echo "<td>".$data['merk']."</td>";
		echo "<td>".$data['tipe']."</td>";
		echo "<td>".$data['keterangan']."</td>";
		echo "<td><img src='img/".$data['gambar']."' width='100' height='100'></td>";
		echo "</tr>";  }}else{ // Jika data tidak ada 
		echo "<tr><td colspan='4'>Data tidak ada</td></tr>";}
		?></table></body></html>