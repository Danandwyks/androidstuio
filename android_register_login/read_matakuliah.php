<?php
 require_once 'koneksi.php';
if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $nim = $_POST['nim'];
    $sql = "SELECT * FROM nilaiakademik WHERE nim='$nim' ";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['read'] = array();

    if( mysqli_num_rows($response) > 0 ) {
        
        if ($row = mysqli_fetch_assoc($response)) {
						
 $index['id'] = $row['id'];
 $index['nim'] = $row['nim'];
				$index['nama'] = $row['nama'];
				$index['uts'] = $row['uts'];
            $index['uas'] = $row['uas'];
            $index['tugas'] = $row['tugas'];
				$index['kuis'] = $row['kuis'];
				$index['akhir'] = $row['akhir'];
                $index['huruf'] = $row['huruf'];
				  $index['kodemk'] = $row['kodemk'];
            $index['namamk'] = $row['namamk'];
				$index['sks'] = $row['sks'];
				$index['tahunakademik'] = $row['tahunakademik'];
                $index['prodi'] = $row['prodi'];
				  $index['dosen'] = $row['dosen'];
            $index['kelas'] = $row['kelas'];
				$index['status'] = $row['status'];
				$index['statusmk'] = $row['statusmk'];
            array_push($result['read'], $index);
            
             $result["success"] = "1";
             echo json_encode($result);
        }
 
   }
 
 }else {
 
     $result["success"] = "0";
     $result["message"] = "Error!";
     echo json_encode($result);
 
     mysqli_close($conn);
 }
 
 ?>