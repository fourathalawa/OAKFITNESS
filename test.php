<?php

$firstnameerror = $lastnameerror = $phoneerror = $emailerror = $texterror = $imageerror  = "";
$firstname = $lastname = $email = $phone = $text = "";
// uploading imahe on submit
if ($_SERVER['REQUEST_METHOD'] == "POST") {
    if (empty($_POST["txtfName"])) {
        $firstnameerror = "first name is required";
    } else {
        $firstname = test_input($_POST["txtfName"]);
        if (!preg_match("/^[a-zA-z]*$/", $firstname)) {
            $firstnameerror = "Only alphabets and whitespace are allowed.";
        }
    }
    $lastname = $_POST['txtlName'];
    $email = $_POST['txtEmail'];
    $phone = $_POST['txtPhone'];
    $text = $_POST['txtMsg'];
    upload_image();
    $imageName = $_FILES['image']['name'];
    $lat = $_POST['lat'];
    $long = $_POST['long'];
}

function upload_image()
{
    $uploadTo = "image/";
    $allowedImageType = array('jpg', 'png', 'jpeg', 'gif');
    $imageName = $_FILES['image']['name'];
    $tempPath = $_FILES["image"]["tmp_name"];
    $imageSize = $_FILES["image"]["size"];
    $error = $_FILES["image"]["error"];

    $basename = basename($imageName);
    $originalPath = $uploadTo . $basename;
    $imageType = pathinfo($originalPath, PATHINFO_EXTENSION);
    if (!empty($imageName)) {

        if (in_array($imageType, $allowedImageType)) {
            // Upload file to server
            if (move_uploaded_file($tempPath, $originalPath)) {
                echo $imageName . " was uploaded successfully";
                // write here sql query to store image name in database

            } else {
                echo 'image Not uploaded ! try again';
            }
        } else {
            echo $imageType . " image type not allowed";
        }
    } else {
        echo "Please Select a image";
    }
}

