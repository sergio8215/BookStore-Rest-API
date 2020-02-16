<?php
    include "utils.php";
?>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/222bff7f1c.js" crossorigin="anonymous"></script>


    <title>BookStore XYZ</title>
  </head>
  <body>
    <div class="container"> 
        <div class="row">
            <div class="col-md-6 offset-md-3 text-center mt-5">
                <h1>Welcome to the book store XYZ</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 text-center mt-5">
                <p>
                    <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#listBooks" aria-expanded="false" aria-controls="listBooks">
                        See all books
                    </button>
                </p>
            </div>
            <div class="col-md-6 text-center mt-5">
                <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#addbook" aria-expanded="false" aria-controls="addbook">
                    Add new book
                </button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-center mt-5">
                <div class="collapse" id="listBooks">
                    <div class="card card-body">
                        <?php 
                            $libros = getAllBooks();
                            if ( isset($libros) ){

                                echo "<table class='table'>";
                                echo "<thead>";
                                    echo "<tr>";
                                    echo "<th scope='col' class='text-center'>ID</th>";
                                    echo "<th scope='col' class='text-center'>ISBN</th>";
                                    echo "<th scope='col' class='text-center'>Name</th>";
                                    echo "<th scope='col' class='text-center'>Author</th>";
                                    echo "<th scope='col' class='text-center'>Categories</th>";
                                    echo "<th scope='col' class='text-center'>Delete</th>";
                                    echo "</tr>";
                                echo "</thead>";
                                echo "<tbody>";

                                foreach ( $libros as $libro ) {
                                    echo "<tr>";
                                        echo "<th scope='row' class='text-center'>".$libro['id']."</th>";
                                        echo "<td class='text-center'>".$libro['isbn']."</td>";
                                        echo "<td class='text-center'>".$libro['name']."</td>";
                                        echo "<td class='text-center'>".$libro['author']."</td>";
                                        echo "<td class='text-center'>-</td>";
                                        echo "<td class='text-center'><a href='?delete=".$libro['_links']['self']['href']."'><i class='fas fa-minus-circle' style='color:#e00707;'></i></a></td>";
                                    echo "</tr>";     
                                }

                                echo "</tbody>";
                                echo "</table>";
                            }  
                                
                        ?>
                    </div>
                </div>
            </div>
            <div class="col-md-12 text-center mt-5">
                <div class="collapse" id="addbook">
                    <div class="card card-body">
                        <form method="post" action="">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                <label for="isbn">ISBN</label>
                                <input type="text" class="form-control" id="isbn" name="isbn">
                                </div>
                                <div class="form-group col-md-6">
                                <label for="name">Name</label>
                                <input type="text" class="form-control" id="name" name="name">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                <label for="author">Author</label>
                                <input type="text" class="form-control" id="author" name="author">
                                </div>
                                <div class="form-group col-md-6">
                                <label for="categories">Categories (Separated by coma)</label>
                                <input type="text" class="form-control" id="categories" name="categories">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary" name="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
    

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>