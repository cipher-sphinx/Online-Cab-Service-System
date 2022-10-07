/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch */

    //authentication
    function start() {
        const url = "http://localhost:8080/OnlineCabService-Service";
        const client_url = "http://localhost:8080/OnlineCabService/AdminClient";
        
        var username = document.getElementById("adminUsername").value;
        var password = document.getElementById("adminPassword").value;
        
        const options = {
            method : "GET"
        };
        
        fetch(url + "/admin/" + username + "/" + password, options)
            .then((response) => response.json())
            .then((data) => {
                    if (data !== null) {
                        var adminID = data.adminID;
                        var adminNIC = data.adminNIC;
                        var adminUsername = data.adminUsername; 
                        var adminPassword = data.adminPassword;
                        var adminFirstName = data.adminFirstName;
                        var adminLastName = data.adminLastName;
                        var adminEmail = data.adminEmail;
                        var adminPhoneNumber = data.adminPhoneNumber;
                        var adminLoginStatus = data.adminLoginStatus;
                    } else {
                        alert("Invalid login!");
                    }
            })
            .catch((error) => {
                console.log(error);
            });
            
            saveTheCookie(username);

    }; 
    
    function saveTheCookie(value) {
    var today = new Date(); // Actual date
    var expire = new Date(); // Expiration of the cookie

    var cookie_name = "username_form"; // Name for the cookie to be recognized
    var number_of_days = 10; // Number of days for the cookie to be valid (10 in this case)

    expire.setTime( today.getTime() + 60 * 60 * 1000 * 24 * number_of_days ); // Current time + (60 sec * 60 min * 1000 milisecs * 24 hours * number_of_days)

    document.cookie = cookie_name + "=" + escape(value) + "; expires=" + expire.toGMTString();
    };
    
    
    function getTheCookie() {
    var cookie_name = "username_form";
    var return_value = null;

    var pos_start = document.cookie.indexOf(" " + cookie_name + "=");
    if (pos_start == -1) document.cookie.indexOf(cookie_name + "=");

    if (pos_start != -1) { // Cookie already set, read it
        pos_start++; // Start reading 1 character after
        var pos_end = document.cookie.indexOf(";", pos_start); // Find ";" after the start position

        if (pos_end == -1) pos_end = document.cookie.length;
        return_value = unescape( document.cookie.substring(pos_start, pos_end) );
    }

    return return_value; // null if cookie doesn't exist, string otherwise
    };
    
    start();
