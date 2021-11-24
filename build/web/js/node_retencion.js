/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var listaconte = new Array();
async function retencionode(cont) {

    var settings = {
        "url": "http://172.20.10.107:8082/retencion/" + cont + "",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
       

        if (response == 'R') {
            //console.log(response);
            listaconte.push(cont);
            //console.log(cont);
            //console.log(listaconte);                    
        }
    });
    
    return listaconte;
}


function retencionode2(cont) {

    var settings = {
        "url": "http://172.20.10.107:8082/retencion/" + cont + "",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {
        //console.log(response);
    });
}

function array() {

  console.log(listaconte);
  for (var i = 0; i < listaconte.length; i++) {

        try {
            // console.log(listaconte[i]);
            document.getElementById(listaconte[i]).innerHTML = '<label style="display: none;">2</label><img src="img/bullet-red.png" data-bs-toggle="tooltip" data-bs-placement="top" title="Retenido">';
            // declaraciones para try

        } catch (e) {
            // pasar el objeto exception al controlador de errores (es decir, su propia función)
        }
    }
}
