<?php 
    $apiURL = "http://localhost:8090";

    function getAllBooks(  ){
    
        $curl = curl_init();
        global $apiURL;

        curl_setopt_array($curl, array(
            CURLOPT_URL => $apiURL."/books",
            CURLOPT_RETURNTRANSFER => true,
            CURLOPT_TIMEOUT => 30,
            CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
            CURLOPT_CUSTOMREQUEST => "GET",
            CURLOPT_HTTPHEADER => array("cache-control: no-cache"),
        ));

        $response = curl_exec($curl);
        $data = json_decode($response,true);
        
        $libros = $data["_embedded"]["bookList"];
        
        $err = curl_error($curl);
        curl_close($curl);
        return $libros;
    }

 
?>