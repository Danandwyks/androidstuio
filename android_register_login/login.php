<?php 

	require_once 'koneksi.php';
 
	if ($_SERVER['REQUEST_METHOD']=='POST') {


		// $nim = "1702059";
		// $password = "12";
		$nim = $_POST['nim'];
		$password = $_POST['password'];
 $sql = mysqli_query($conn, "SELECT * FROM mahasiswa WHERE nim='$nim' AND password='$password'") or die(mysqli_error($conn)); 
$result = array();
		$result['login'] = array();
 if(mysqli_num_rows($sql) > 0){  

			$row = mysqli_fetch_assoc($sql);

			if ( mysqli_num_rows($sql) > 0 ) {
				$index['nim'] = $row['nim'];
				$index['nama'] = $row['nama'];
				$index['jeniskelamin'] = $row['jeniskelamin'];
				$index['programstudi'] = $row['programstudi'];
				$index['tahunmasuk'] = $row['tahunmasuk'];
				$index['status'] = $row['status'];
				$index['kelas'] = $row['kelas'];
                $index['password'] = $row['password'];

				array_push($result['login'], $index);

				$result['success'] = "1";
				$result['message'] = "success";
				echo json_encode($result);

				mysqli_close($conn);

			} else {

				$result['success'] = "0";
				$result['message'] = "error";
				echo json_encode($result);

				mysqli_close($conn);
				
			}

		}

	}

?>