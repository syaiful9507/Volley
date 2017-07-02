    <html>
	<head> 
	<title>Insert Data</title>
	</head>
	<body>  
	<h1>Insert Data</h1>  
<form method="post" enctype="multipart/form-data" action="upload.php"> 
 <table border = '1' cellspacing = '1' cellpadding = '10'>
 <tr>
  <td> Id  </td>
  <td width = '5' align = 'center'> : </td>
  <td> <input type = 'text' name = 'idhp' /> </td>
  </tr>
 <tr>
  <td> Merk </td>
  <td align = 'center'> : </td>
  <td> <input type = 'text' name = 'merk' /> </td>
  </tr>
 <tr>
  <td> Tipe </td>
  <td width = '5' align = 'center'> : </td>
  <td> <input type = 'text' name = 'tipe' /> </td>
  </tr>
  <tr>
 <td> Keterangan</td>
  <td width = '5' align = 'center'> : </td>
  <td> <textarea name = 'keterangan' ></textarea> </td>
  </tr>
  <tr>
  <td> Gambar </td>
  <td align = 'center'> : </td>
  <td> <input type = 'file' name = 'gambar' /> </td>
  </tr> 
 
 <tr>
 <td colspan = '3' align = 'center'>
 <input type="submit" value="Simpan"> 
 </td>
 </tr>
</table>
</form>
	</body>
	</html>