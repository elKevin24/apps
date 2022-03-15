/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



async function retencionode1(cont) {

    var settings = {
        "url": "https://srvnjs.santotomasport.com.gt:3000/retencion/" + cont + "",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
       

        console.log(response);
         
    });
    
    return cont;
}