<?php 

	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
		$nim = $_POST['nim'];
		$nama = $_POST['nama'];
		$jk = $_POST['jeniskelamin'];
		$ps = $_POST['programstudi'];
		$tgllahir = $_POST['tanggallahir'];
		$thnmasuk = $_POST['tahunmasuk'];
		$stat = $_POST['status'];
		$kls = $_POST['kelas'];
		$pass = $_POST['password'];

		require_once 'koneksi.php';

		$sql = "INSERT INTO mahasiswa (nim, nama, jeniskelamin, program_studi, tanggallahir, tahunmasuk, status, kelas, password) VALUES('$nim', '$nama', '$jk', '$ps', '$tgllahir', '$thnmasuk', '$stat', '$kls', '$pass')";

		if ( mysqli_query($conn, $sql) ) {
			$result["success"] = "1";
			$result["message"] = "success";

			echo json_encode($result);
			mysqli_close($conn);

		} else {
			$result["success"] = "0";
			$result["message"] = "error";

			echo json_encode($result);
			mysqli_close($conn);
			
		}
	}

 ?>