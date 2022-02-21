/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
async function consultaDictamenManifiesto(cont) {

    var settings = {
        "url": "https://srvnjs.santotomasport.com.gt:3000/consultaDictamenManifiestoweb/pManifiesto/"+cont+"",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
        console.log(response.valor.no_manifiesto);
        console.log(response);
        document.getElementById("MENSAJE").innerHTML = response.mensaje;
        document.getElementById("estatus_dictamen").innerHTML = response.valor.estatus_dictamen;
        document.getElementById("fecha_estado").innerHTML = response.valor.fecha_estado;
        document.getElementById("estatus").innerHTML = response.valor.estatus;
        
        return response;
    });

    return cont;
}

