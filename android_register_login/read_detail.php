<?php
 require_once 'koneksi.php';
if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $nim = $_POST['nim'];

   

    $sql = "SELECT * FROM mahasiswa WHERE nim='$nim' ";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['read'] = array();

    if( mysqli_num_rows($response) > 0 ) {
        
        if ($row = mysqli_fetch_assoc($response)) {
 $index['nim'] = $row['nim'];
				$index['nama'] = $row['nama'];
				$index['jeniskelamin'] = $row['jeniskelamin'];
            $index['tempatlahir'] = $row['tempatlahir'];
            $index['tanggallahir'] = $row['tanggallahir'];
				$index['programstudi'] = $row['programstudi'];
				$index['kelas'] = $row['kelas'];
                $index['password'] = $row['password'];
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