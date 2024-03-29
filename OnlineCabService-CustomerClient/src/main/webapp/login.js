/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch */

    //authentication
    function start() {
        const url = "http://localhost:8080/OnlineCabService-Service";
        const client_url = "http://localhost:8080/OnlineCabService-CustomerClient";
        
        var username = document.getElementById("customerUsername").value;
        var password = document.getElementById("customerPassword").value;
        
        const options = {
            method : "GET"
        };
        
        fetch(url + "/customer/" + username + "/" + password, options)
            .then((response) => response.json())
            .then((data) => {
                    if (data !== null) {
                        var customerID = data.customerID;
                        var customerNIC = data.customerNIC;
                        var customerUsername = data.customerUsername; 
                        var customerPassword = data.customerPassword;
                        var customerFirstName = data.customerFirstName;
                        var customerLastName = data.customerLastName;
                        var customerEmail = data.customerEmail;
                        var customerPhoneNumber = data.customerPhoneNumber;
                        var customerLoginStatus = data.customerLoginStatus;
                        var customerStatus = data.customerStatus;
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
