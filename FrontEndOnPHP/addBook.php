<?php
    
    if(isset($_POST['submit'])){ // button name
        sendPost();
    }

    function sendPost(){
        global $apiURL;
        
        if ( isset( $_POST['isbn'] ) ) {
            $isbn = $_POST['isbn'];
        }
        if ( isset( $_POST['name'] ) ) {
            $name = $_POST['name'];
        }
        if ( isset( $_POST['author'] ) ) {
            $author = $_POST['author'];
        }
        if ( isset( $_POST['categories'] ) ) {
            $categories = $_POST['categories'];
        }

        $data = array('isbn' => $isbn, 'name' => $name,'author' =>  $author);
        $data1 = json_encode($data);
        
        $options = array(
            'http' => array(
                'header'  => "Content-type: application/JSON\r\n",
                'method'  => 'POST',
                'content' => http_build_query($data)
            )
        );
        $context  = stream_context_create($options);
        
        // open the sesion
        $ch = curl_init();
        
        // define the URL
        curl_setopt($ch, CURLOPT_URL,$apiURL."/books");

        curl_setopt($ch, CURLOPT_POST, TRUE);
        // define parameters
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data1);
        //set the content type to application/json
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
        // save the answer
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        $remote_server_output = curl_exec ($ch);
        
        // close the session cURL
        $info = curl_getinfo($ch);
        curl_close ($ch);
        
        if (empty($info['http_code'])) {
            die("No HTTP code was returned");
        } else {
            // echo results
            echo "The server responded: <br />";
            echo $info['http_code'] ;
        }

    }
?>