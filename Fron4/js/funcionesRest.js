
//*************************** D E S A R R O L L O **********************************************/

let uriClient="http://localhost:8080/api/Client";
let uriCar="http://localhost:8080/api/Car";
let uriGama="http://localhost:8080/api/Gama";
let uriMessage="http://localhost:8080/api/Message";
let uriReservation="http://localhost:8080/api/Reservation";
let uriScore="http://localhost:8080/api/Score";

//******************************* P R O D U C C I O N **********************************************/
/*
let uriClient="http://129.151.122.90:8080/api/Client";
let uriCar="http://129.151.122.90:8080/api/Car";
let uriGama="http://129.151.122.90:8080/api/Gama";
let uriMessage="http://129.151.122.90:8080/api/Message";
let uriReservation="http://129.151.122.90:8080/api/Reservation";
let uriScore="http://129.151.122.90:8080/api/Score";

//*************************************************************************************** */
//*******************  D E S P L I E G U E ***** C L I E N T E ****************************/
//*************************************************************************************** */

function consultAllClient(){
        $.ajax({
            url:uriClient+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                //console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTabla(respuesta)
            }
        });
}
function loadClient(){
        $.ajax({
                url:uriClient+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay clientes para mostrar');
                                return
                            } else {
                                    for(i=0;i<data.length;i++){
                                            $("#selectClient").append("<option type='number' value=" + data[i].idClient + ">" 
                                             + data[i].name + "</option>");
                                        } 
                           }
                }

        });
}
function saveClient() {
        let myData = {
          name: $("#name").val(),
          email: $("#email").val(),
          password: $("#password").val(),
          age: $("#age").val()
        };
        $.ajax({
                url:uriClient+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCampos();
                        consultAllClient();
                        alert("El nuevo Cliente, se ha guardado con exito!")
                }
        });
}
function clearItem(idItem){
        $.ajax({
                url:uriClient+"/"+idItem,
                type:"DELETE",
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCampos();
                        $("#resultadoConsulta").empty();
                        consultAllClient();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
let idCli;
function itemByID(idItem){
        $.ajax({
                url:uriClient+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        idCli = respuesta.idClient;
                        $("#id").val(respuesta.id).prop("hidden", true);
                        $("#name").val(respuesta.name);
                        $("#email").val(respuesta.email);
                        $("#password").val(respuesta.password);
                        $("#age").val(respuesta.age);                        
                }
        });
}
function updateInfo(){
        let myData = {
                idClient: idCli,
                name: $("#name").val(),
                email: $("#email").val(),
                password: $("#password").val(),
                age: $("#age").val(),
              };
        $.ajax({
                url:uriClient+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCampos();
                        consultAllClient();
                        $("#id").prop("hidden", false);
                        alert("El registro, se actualizó con exito!")
                }
        });
}
 
function mostrarTabla(items){
        let tableClient="<table class='table table-striped table-dark'>";
        tableClient+="<tr>";
        tableClient+="<th>NAME</th>";
        tableClient+="<th>EMAIL</th>";
        tableClient+="<th>AGE</th>";
        tableClient+="<th colspan='2'>ACTIONS</th>";
        tableClient+="</tr>";
        for(i=0;i<items.length;i++){
                tableClient+="<tr>";
                tableClient+="<td>"+items[i].name+"</td>";
                tableClient+="<td>"+items[i].email+"</td>";
                tableClient+="<td>"+items[i].age+"</td>";
                tableClient+="<td> <button onclick='clearItem("+items[i].idClient+")' class='btn btn-secondary'>Borrar</button>";
                tableClient+="<td> <button onclick='itemByID("+items[i].idClient+")' class='btn btn-secondary'>Editar</button>";
                tableClient+="</tr>";
        }
        tableClient+="</table>";
        $("#resultadoConsulta").append(tableClient);
}
function clearCampos() {
        $("#name").val("");
        $("#email").val("");
        $("#age").val("");
        $("#password").val("");
}
//*************************************************************************************** */
//*******************  D E S P L I E G U E ***** C A R R O S ******************************/
//*************************************************************************************** */

function consultAllCar(){
        $.ajax({
            url:uriCar+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaCarros(respuesta)
            }
        });
}
function loadCar(){
        $.ajax({
                url:uriCar+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay carros para mostrar');
                                return
                            } else {
                                    for(i=0;i<data.length;i++){
                                            $("#selectCar").append("<option type='number' value=" + data[i].idCar + ">" 
                                             + data[i].name + "</option>");
                                        } 
                           }
                }

        });
}
function saveCar() {
        let gama={idGama:$("#selectGama").val()}
        let myData = {
          name: $("#name").val(),
          brand: $("#brand").val(),
          year: $("#year").val(),
          description: $("#description").val(),
          gama: gama
        };
        //console.log(myData);
        $.ajax({
                url:uriCar+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposCar();
                        consultAllCar();
                        alert("El nuevo Carro, se ha guardado con exito!")
                }
        });
}
function clearItemCar(idItem){
        $.ajax({
                url:uriCar+"/"+idItem,
                type:"DELETE",
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposCar();
                        $("#resultadoConsulta").empty();
                        consultAllCar();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
let idCarro;
function itemByIDCar(idItem){
        $.ajax({
                url:uriCar+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        idCarro = respuesta.idCar;
                        $("#name").val(respuesta.name);
                        $("#brand").val(respuesta.brand);
                        $("#year").val(respuesta.year);
                        $("#description").val(respuesta.description)
                        $("#selectGama").val(respuesta.gama.idGama);                        
                }
        });
}
function updateInfoCar(){
        let gama={idGama:$("#selectGama").val()}
        let myData = {
                idCar: idCarro,
                name: $("#name").val(),
                brand: $("#brand").val(),
                year: $("#year").val(),
                description: $("#description").val(),
                gama: gama,
              };
        $.ajax({
                url:uriCar+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        console.log(respuesta.name)
                        $("#resultadoConsulta").empty();
                        clearCamposCar();
                        consultAllCar();
                        $("#id").prop("hidden", false);
                        alert("El registro, se actualizó con exito!")
                }
        });
}
function mostrarTablaCarros(items){
        let tableCar="<table class='table table-striped table-dark'>";
        tableCar+="<tr>";
        tableCar+="<th scope='col'>NAME</th>";
        tableCar+="<th>BRAND</th>";
        tableCar+="<th>YEAR</th>";
        tableCar+="<th>DESCRIPTION</th>";
        tableCar+="<th>GAMA</th>";
        tableCar+="<th colspan='2'>ACTIONS</th>";
        tableCar+="</tr>";
        for(i=0;i<items.length;i++){
                tableCar+="<tr>";
                tableCar+="<td>"+items[i].name+"</td>";
                tableCar+="<td>"+items[i].brand+"</td>";
                tableCar+="<td>"+items[i].year+"</td>";
                tableCar+="<td>"+items[i].description+"</td>";
                tableCar+="<td>"+items[i].gama.name+"</td>";
                tableCar+="<td> <button onclick='clearItemCar("+items[i].idCar+")' class='btn btn-secondary'>Borrar</button>";
                tableCar+="<td> <button onclick='itemByIDCar("+items[i].idCar+")' class='btn btn-secondary'>Editar</button>";
                tableCar+="</tr>";
        }
        tableCar+="</table>";
        $("#resultadoConsulta").append(tableCar);
}
function clearCamposCar() {
        $("#name").val("");
        $("#brand").val("");
        $("#year").val("");
        $("#description").val("");
        $("#selectGama").val(0);
}
//*************************************************************************************** */
//*******************  D E S P L I E G U E ***** G A M A S  ******************************/
//****************************************************************************************/
function consultAllGama(){
        $.ajax({
            url:uriGama+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaGama(respuesta);
            }
        });
}  
function gamaLoad(){
        $.ajax({
                url:uriGama+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay gamas para mostrar');
                                return
                            } else {
                                    for(i=0;i<data.length;i++){
                                            $("#selectGama").append("<option type='number' value=" + data[i].idGama + ">" 
                                             + data[i].name + "</option>");
                                        } 
                           }
                }

        });
}
function saveGama() {
        let myData = {
          name: $("#name").val(),
          description: $("#description").val(),
        };
        $.ajax({
                url:uriGama+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposGama();
                        consultAllGama();
                        alert("La nueva Gama, se ha guardado con exito!")
                }
        });
}
function clearItemGama(idItem){
        $.ajax({
                url:uriGama+"/"+idItem,
                type:"DELETE",
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposGama();
                        $("#resultadoConsulta").empty();
                        consultAllGama();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
let idGma;
function itemByIdGama(idItem){
        $.ajax({
                url:uriGama+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        idGma = respuesta.idGama;
                        $("#name").val(respuesta.name);
                        $("#description").val(respuesta.description);                   
                }
        });
}
function updateGama(){
        let myData = {
                idGama: idGma,
                name: $("#name").val(),
                description: $("#description").val(),
              };
        $.ajax({
                url:uriGama+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposGama();
                        consultAllGama();
                        alert("El registro, se actualizó con exito!")
                }
        });
}
function mostrarTablaGama(items){
        let tableGama="<table class='table table-striped table-dark'>";
        tableGama+="<tr>";
        tableGama+="<th>NOMBRE</th>";
        tableGama+="<th>DESCRIPTION</th>";
        tableGama+="<th>CARROS</th>";
        tableGama+="<th colspan='2'>ACTIONS</th>";
        tableGama+="</tr>";
        for(i=0;i<items.length;i++){
                tableGama+="<tr>";
                //console.log(items[i].gama.length)
                if(items[i].cars.length>0){
                        tableGama+="<td rowspan="+items[i].cars.length+">"+items[i].name+"</td>";
                        tableGama+="<td rowspan="+items[i].cars.length+">"+items[i].description+"</td>";
                }else{
                        tableGama+="<td>"+items[i].name+"</td>";
                        tableGama+="<td>"+items[i].description+"</td>";
                }
                //                console.log(items[i].gama.length)
                if(items[i].cars.length>0){
                        for(j=0;j<items[i].cars.length;j++){
                                tableGama+="<td>"+items[i].cars[j].name+"--"+items[i].cars[j].brand+"--"+items[i].cars[j].year+"--"+items[i].cars[j].description;
                                tableGama+="<td> <button onclick='clearItemGama("+items[i].idGama+")' class='btn btn-secondary'>Borrar</button>";
                                tableGama+="<td> <button onclick='itemByIdGama("+items[i].idGama+")' class='btn btn-secondary'>Editar</button></td>";
                                tableGama+="</tr>";
                        }
                }else{
                        for(j=0;j<1;j++){
                                let data=" ";
                                tableGama+="<td>"+data;
                                tableGama+="<td> <button onclick='clearItemGama("+items[i].idGama+")' class='btn btn-secondary'>Borrar</button>";
                                tableGama+="<td> <button onclick='itemByIdGama("+items[i].idGama+")' class='btn btn-secondary'>Editar</button></td>";
                                tableGama+="</tr>";
                        }

                }
                
                  
        }
        tableGama+="</table>";
        $("#resultadoConsulta").append(tableGama);
}
function clearCamposGama() {
        $("#name").val("");
        $("#description").val("");
}
//*****************************************************************************************/
//*******************  D E S P L I E G U E ***** M E N S A J E  ***************************/
//****************************************************************************************/
function consultAllMessage(){
        $.ajax({
            url:uriMessage+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaMessage(respuesta);
            }
        });
}
function saveMessage() {
        let client={idClient:$("#selectClient").val()}
        let car={idCar:$("#selectCar").val()}
        let myData = {
          messageText: $("#messageText").val(),
          client: client,
          car: car
        };
        //console.log(myData)
        $.ajax({
                url:uriMessage+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposMessage();
                        consultAllMessage();
                        alert("El nuevo Mensaje, se ha guardado con exito!")
                }
        });
}
let idMsg;
function itemByIDMessage(idItem){
        $.ajax({
                url:uriMessage+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        //console.log(respuesta)
                        idMsg = respuesta.idMessage;
                        $("#messageText").val(respuesta.messageText);
                        $("#selectCar").val(respuesta.client.idClient).prop("disabled", true);
                        $("#selectClient").val(respuesta.car.idCar).prop("disabled", true);                   
                }
        });
}
function clearItemMessage(idItem){
        $.ajax({
                url:uriMessage+"/"+idItem,
                type:"DELETE",
                //data:dataToSend,
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposMessage();
                        $("#resultadoConsulta").empty();
                        consultAllMessage();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
function updateInfoMsg(){
        let client={idClient:$("#selectClient").val()}
        let car={idCar:$("#selectCar").val()}
        let myData = {
          idMessage : idMsg,
          messageText: $("#messageText").val(),
          client: client,
          car: car
        };
        //console.log(myData)
        $.ajax({
                url:uriMessage+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposMessage();
                        consultAllMessage();
                        $("#selectClient").prop("disabled", false);
                        $("#selectCar").prop("disabled", false);
                        alert("El registro, se actualizó con exito!")
                }
        });
}
function mostrarTablaMessage(items){
        let tableMessage="<table class='table table-striped table-dark'>";
        tableMessage+="<tr>";
        tableMessage+="<th>MESSAGE</th>";
        tableMessage+="<th>CAR</th>";
        tableMessage+="<th>GAMA</th>";
        tableMessage+="<th>CLIENT</th>";
        tableMessage+="<th colspan='2'>ACTIONS</th>";
        tableMessage+="</tr>";
        for(i=0;i<items.length;i++){
                tableMessage+="<tr>";
                tableMessage+="<td>"+items[i].messageText+"</td>";
                tableMessage+="<td>"+items[i].car.name+"</td>";
                tableMessage+="<td>"+items[i].car.gama.name+"</td>";
                tableMessage+="<td>"+items[i].client.name+"</td>";
                tableMessage+="<td> <button onclick='clearItemMessage("+items[i].idMessage+")' class='btn btn-secondary'>Borrar</button>";
                tableMessage+="<td> <button onclick='itemByIDMessage("+items[i].idMessage+")' class='btn btn-secondary'>Editar</button></td>";  
        }
        tableMessage+="</table>";
        $("#resultadoConsulta").append(tableMessage);
}
function clearCamposMessage() {
        $("#messageText").val("");
        $("#selectClient").val(0);
        $("#selectCar").val(0);
}  
//*****************************************************************************************/
//*****************  D E S P L I E G U E ***** R E S E R V A T I O N **********************/
//****************************************************************************************/
function consultAllReservation(){
        $.ajax({
            url:uriReservation+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log(respuesta);
                $("#resultadoConsulta").empty();
                mostrarTablaReservation(respuesta);
            }
        });
}
function loadReservation(){
        $.ajax({
                url:uriReservation+"/all",
                type:"GET",
                datatype:"JSON",
                success:function(data){
                        if (data == null) {//Validación de datos nulos
                                alert('Disculpe, No hay reservas para mostrar');
                                return
                            } else {
                                    console.log(data)
                                    for(i=0;i<data.length;i++){
                                            $("#selectIdRes").append("<option type='number' value=" + data[i].idReservation + ">" 
                                             + data[i].idReservation + "</option>");
                                        } 
                           }
                }

        });
}
function saveReservation() {
        if(!dateIsOK()){ 
                alert("La fecha de entrega debe ser mayor que la fecha de inicio") 
                return false;
        }
        let client={idClient:$("#selectClient").val()}
        let car={idCar:$("#selectCar").val()}
        let myData = {
          startDate: $("#startDate").val(),
          devolutionDate: $("#devolutionDate").val(),
          status: $("#selectStatus").val(),
          client: client,
          car: car
        };
        console.log(myData)
        $.ajax({
                url:uriReservation+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                encode:true,
                success:function(respuesta){
                        clearCamposReservation();
                        consultAllReservation();
                        alert("La nueva Reservación, se ha guardado con exito!")
                }
        });
}
let idRes;
let start, devolution;
function itemByIDReservation(idItem){
        $.ajax({
                url:uriReservation+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        //console.log(respuesta)
                        idRes = respuesta.idReservation;
                        start = respuesta.startDate.split("T",1);
                        devolution = respuesta.devolutionDate.split("T",1);
                        $("#startDate").val(start.toString('yyyy-MM-dd'));
                        $("#devolutionDate").val(devolution.toString('yyyy-MM-dd'));
                        $("#selectStatus").val(respuesta.status).prop("disabled", false);
                        $("#selectClient").val(respuesta.client.idClient).prop("disabled", true);
                        $("#selectCar").val(respuesta.car.idCar).prop("disabled", true);                   
                }
        });
}
function clearItemReservation(idItem){
        $.ajax({
                url:uriReservation+"/"+idItem,
                type:"DELETE",
                //data:dataToSend,
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposReservation();
                        $("#resultadoConsulta").empty();
                        consultAllReservation();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}
function updateInfoRes(){
        if(!dateIsOK()){ 
                alert("La fecha de entrega debe ser mayor que la fecha de inicio") 
                return false;
        }
        let client={idClient:$("#selectClient").val()}
        let car={idCar:$("#selectCar").val()}
        let myData = {
          idReservation: idRes,
          startDate: $("#startDate").val(),
          devolutionDate : $("#devolutionDate").val(),
          status: $("#selectStatus").val(),
          client: client,
          car: car
        };
        console.log(myData)
        $.ajax({
                url:uriReservation+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposReservation();
                        consultAllReservation();
                        $("#selectClient").prop("disabled", false);
                        $("#selectCar").prop("disabled", false);
                        alert("El registro, se actualizó con exito!")
                } 
        });
} 
function dateIsOK(){
        start= $("#startDate").val();
        devolution = $("#devolutionDate").val();
        if (start>devolution){
                return false;
        }return true;
}
function mostrarTablaReservation(items){
        let tableReservation="<table class='table table-striped table-dark'>";
        tableReservation+="<tr>";
        tableReservation+="<th>ID</th>";
        tableReservation+="<th>STARTDATE</th>";
        tableReservation+="<th>DEVOLUTIONDATE</th>";
        tableReservation+="<th>STATUS</th>";
        tableReservation+="<th>CAR_NAME</th>";
        tableReservation+="<th>BRAND</th>";
        tableReservation+="<th>YEAR</th>";
        tableReservation+="<th>ID_CLIENT</th>";
        tableReservation+="<th>NAME_CLIENT</th>";
        tableReservation+="<th>EMAIL</th>";
        tableReservation+="<th>SCORE</th>";
        tableReservation+="<th colspan='2'>ACTIONS</th>";
        tableReservation+="</tr>";
        
        for(i=0;i<items.length;i++){
                        tableReservation+="<tr>";
                        tableReservation+="<td>"+items[i].idReservation+"</td>";
                        tableReservation+="<td>"+items[i].startDate+"</td>";
                        tableReservation+="<td>"+items[i].devolutionDate+"</td>";
                        tableReservation+="<td>"+items[i].status+"</td>";
                        tableReservation+="<td>"+items[i].car.name+"</td>";
                        tableReservation+="<td>"+items[i].car.brand+"</td>";
                        tableReservation+="<td>"+items[i].car.year+"</td>";
                        tableReservation+="<td>"+items[i].client.idClient+"</td>";
                        tableReservation+="<td>"+items[i].client.name+"</td>";
                        tableReservation+="<td>"+items[i].client.email+"</td>";
                        if(items[i].score==null){
                                tableReservation+="<td>"+items[i].score+"</td>";
                        }else{
                                tableReservation+="<td>"+items[i].score.score+"</td>";
                        }                       
                        tableReservation+="<td> <button onclick='clearItemReservation("+items[i].idReservation+")' class='btn btn-secondary'>Borrar</button>";
                        tableReservation+="<td> <button onclick='itemByIDReservation("+items[i].idReservation+")' class='btn btn-secondary'>Editar</button></td>";
        }
        tableReservation+="</table>";
        $("#resultadoConsulta").append(tableReservation);
}
function clearCamposReservation() {
        $("#startDate").val("");
        $("#devolutionDate").val("")
        $("#selectClient").val(0);
        $("#selectCar").val(0);
}
//*****************************************************************************************/
//*****************  D E S P L I E G U E ***** S C O R E **********************************/
//****************************************************************************************/
function consultAllScore(){
        $.ajax({
            url:uriScore+"/all",
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                $("#resultadoConsulta").empty();
                mostrarTablaScore(respuesta);
            }
        });
}
function saveScore() {
        let resv = $("#selectIdRes").val();
        console.log(typeof resv)
        reservation = {idReservation: parseInt(resv)};
        let myData = {
          score: parseInt($("#score").val()),
          message: $("#message").val(),
          reservation : reservation
        };
        console.log(myData)
        $.ajax({
                url:uriScore+"/save",
                type:"POST",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                //encode:true,
                success:function(respuesta){
                        clearCamposScore();
                        consultAllScore();
                        alert("El nuevo Mensaje, se ha guardado con exito!")
                }
        });
}

let idScr;
function itemByIdScore(idItem){
        $.ajax({
                url:uriScore+"/"+idItem,
                type:"GET",
                dataType:"JSON",
                success:function(respuesta){
                        //console.log(respuesta)
                        idScr = respuesta.idScore;
                        $("#selectIdRes").val(respuesta.reservation.idReservation);
                        $("#score").val(respuesta.score);
                        $("#message").val(respuesta.message);                   
                }
        });
}

function updateInfoScore(){
        let reservation={idReservation:$("#selectIdRes").val()}
        let myData = {
          idScore : idScr,
          score: $("#score").val(),
          message: $("#message").val(),
          reservation,
        };
        //console.log(myData)
        $.ajax({
                url:uriScore+"/update",
                type:"PUT",
                data:JSON.stringify(myData),
                datatype:"JSON",
                contentType:"application/JSON; charset=utf-8",
                success:function(respuesta){
                        $("#resultadoConsulta").empty();
                        clearCamposScore();
                        consultAllScore();
                        alert("El registro, se actualizó con exito!")
                }
        });
}

function clearItemScore(idItem){
        $.ajax({
                url:uriScore+"/"+idItem,
                type:"DELETE",
                contentType:"application/JSON",
                dataType:"JSON",
                success:function(respuesta){
                        clearCamposScore();
                        $("#resultadoConsulta").empty();
                        consultAllScore();
                        alert("El registro se ha eliminado con Exito!")
                }
        });
}

function mostrarTablaScore(items){
        let tableScore="<table class='table table-striped table-dark'>";
        tableScore+="<tr>";
        tableScore+="<th>SCORE</th>";
        tableScore+="<th>MESSAGE</th>";
        tableScore+="<th>RESERVATION</th>";
        tableScore+="<th>CLIENT</th>";
        tableScore+="<th>CAR</th>";
        tableScore+="<th colspan='2'>ACTIONS</th>";
        tableScore+="</tr>";
        for(i=0;i<items.length;i++){
                tableScore+="<tr>";
                tableScore+="<td>"+items[i].score+"</td>";
                tableScore+="<td>"+items[i].message+"</td>";
                tableScore+="<td>"+items[i].reservation.startDate+" <b>//</b> "+items[i].reservation.devolutionDate+"</td>";
                tableScore+="<td>"+items[i].reservation.client.name+"</td>";
                tableScore+="<td>"+items[i].reservation.car.name+"</td>";
                tableScore+="<td> <button onclick='clearItemScore("+items[i].idScore+")' class='btn btn-secondary'>Borrar</button>";
                tableScore+="<td> <button onclick='itemByIdScore("+items[i].idScore+")' class='btn btn-secondary'>Editar</button></td>";  
        }
        tableScore+="</table>";
        $("#resultadoConsulta").append(tableScore);
}
function clearCamposScore() {
        $("#selectIdRes").val(0);
        $("#score").val(6);
        $("#message").val("")
        
}