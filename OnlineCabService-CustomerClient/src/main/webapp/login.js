/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch */


    function start() {
        const url = "http://localhost:8080/OnlineCabService-Service";
        const client_url = "http://localhost:8080/OnlineCabService-CustomerClient";
        
        fetch(url + "/customer")
            .then((response) => response.json())
            .then((data) => {
                for (let key in data) {
                    for (let element in data[key]) {
                        console.log(data[key][element] + "outside if");
                        if(element === "username"){
                            console.log(data[key][element]);
                            let uname = data[key][element];
                            const a = document.getElementById("login");
                            a.onclick = function() {
                                let username = document.getElementById("exampleInputEmail").value;
                                if (username === uname) {
                                    window.location.replace(client_url + "/user_home.html");
                                }
                    };
                        }

                    }
            }
            })
            .catch((error) => {
                console.log(error);
            });

    }; 
    start();
