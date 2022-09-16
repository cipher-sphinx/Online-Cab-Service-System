/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch */


    function home() {

        const url = "http://localhost:8080/OnlineCabService-Service";
        const client_url = "http://localhost:8080/OnlineCabService-CustomerClient";
        
        fetch(url + "/street")
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                for (let key in data) {
                    for (let element in data[key]) {
                        console.log(data[key][element]);
                    }
            }
            })
            .catch((error) => {
                console.log(error);
            });

    }; 
    
    home();
    

