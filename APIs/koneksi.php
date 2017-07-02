<?php
	$server		= "localhost"; //sesuaikan alamat server anda
	$username		= "root"; //sesuaikan user web server anda
	$password	= ""; //sesuaikan password web server anda
	$database	= "app_blogvolley"; //sesuaikan database we server anda
	
	mysql_connect ($server, $username, $password) or die ("Koneksi gagal !");
	mysql_select_db($database) or die ("Database tidak ditemukan!");
?>