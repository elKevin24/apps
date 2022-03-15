/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//var listaconte = new Array();
async function retencion_node(cont) {
//console.log("hola"+cont);
    var settings = {
        "url": "https://srvnjs.santotomasport.com.gt:3000/retencion/" + cont + "",
        "method": "GET",
        "timeout": 0
    };

    $.ajax(settings).done(function (response) {
       
console.log(cont+" "+ response);
        if (response === 'R') {
//            document.getElementById(cont).innerHTML = '<label style="display: none;">2</label><img src="img/bullet-red.png" data-bs-toggle="tooltip" data-bs-placement="top" title="Retenido">';
            $("#"+cont+"").attr("src","img/bullet-red.png");
            $("#"+cont+"").attr("title","Retenido");
            $("#"+cont+"").attr("aria-label","Retenido");
            $("#"+cont+"").attr("data-bs-original-title","Retenido");
                  
        }
        if (response === 'L') {
//            document.getElementById(cont).innerHTML = '<label style="display: none;">3</label><img src="img/bullet-green.png" data-bs-toggle="tooltip" data-bs-placement="top" title="Sin Retencion">';                 
        $("#"+cont+"").attr("src","img/bullet-green.png");
            $("#"+cont+"").attr("title","Sin Retenciones");
            $("#"+cont+"").attr("aria-label","Sin Retenciones");
            $("#"+cont+"").attr("data-bs-original-title","Sin Retenciones");
        
        }
        
    });
    

}
