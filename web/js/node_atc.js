/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



async function atc(cont) {

    var settings = {
        "url": "https://srvnjs.santotomasport.com.gt:3000/atc1/" + cont + "",
        "method": "GET",
        "timeout": 0,
    };

    $.ajax(settings).done(function (response) {

        // listaconte1.push(cont);       


//        console.log(response);
//            listaconte1.push([cont, response]);
        if (response === 'R') {
            //console.log(listaconte1[i][0]);
            try {
//                console.log("entro R");
                // console.log(listaconte[i]);
                document.getElementById(cont + "atc").innerHTML = '<img src="img/bullet-green.png" data-bs-toggle="tooltip" data-bs-placement="top" title="Registrado">';
                $("#" + cont + "atc").attr("src", "img/bullet-green.png");
                $("#" + cont + "atc").attr("title", "Registrado");
                $("#" + cont + "atc").attr("aria-label", "Registrado");
                $("#" + cont + "atc").attr("data-bs-original-title", "Registrado");
                // declaraciones para try

            } catch (e) {
                console.log(e);
            }

        } else if (response === 'sin respuesta de sat') {

            try {
                // console.log(listaconte[i]);
//                document.getElementById(cont + "atc").innerHTML = '<img src="img/Bullet-grey.png" data-bs-toggle="tooltip" data-bs-placement="top" title="sin respuesta de sat">';
                $("#" + cont + "atc").attr("src", "img/Bullet-grey.png");
                $("#" + cont + "atc").attr("title", "sin respuesta de sat");
                $("#" + cont + "atc").attr("aria-label", "sin respuesta de sat");
                $("#" + cont + "atc").attr("data-bs-original-title", "sin respuesta de sat");

            } catch (e) {
                console.log(e);
            }

        } else {
            try {
                // console.log(listaconte[i]);
//                document.getElementById(cont + "atc").innerHTML = '<img src="img/Bullet-grey.png" data-bs-toggle="tooltip" data-bs-placement="top" title="' + response + '">';
                $("#" + cont + "atc").attr("src", "img/bullet-yellow.png");
                $("#" + cont + "atc").attr("title", response);
                $("#" + cont + "atc").attr("aria-label", response);
                $("#" + cont + "atc").attr("data-bs-original-title", response);

            } catch (e) {
                console.log(e);
            }

        }



    });


}

