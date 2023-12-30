Prueba Tecnica de Spring Boot

Todo el proyecto se encuentra en la rama master

#el usuario de git es: Saulo97
#el token para ese usuario:  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
#El API se encuentra desplegada en el siguiente enlace https://drone-api-72q3.onrender.com

#https://drone-api-72q3.onrender.com/DroneAPI/Drone/registerDrone endPoint para registrar un nuevo dron con la siguiente estructura:
{
    "serialNumber": "aaa",
    "model":Lightweight,
    "weightLimit":400,
    "batteryCapacity": 80,
    "state":"IDLE"
}
las propiedades "model" y "state" son solamente las definidas en los requerimientos del proyecto
es necesario registrar al menos un drone para continuar probando la aplicacion

#https://drone-api-72q3.onrender.com/DroneAPI/Medications/loadingDrone/{id} Endpoint para cargar un dron seleccionando su id por queryparams
la carga debe tener la siguiente estructura;
{
      "name": "medicina1",
      "weight":,
      "code": "AAA",
      "image": "www.url.com"
}


#https://drone-api-72q3.onrender.com/DroneAPI/Medications/findLoadByDroneId/{id} EndPoint para obtener la carga de un drone mediatne su id 

#https://drone-api-72q3.onrender.com/DroneAPI/Drone/getAvailablesDrones Endpoint para verificar los drones disponibles(state:IDLE)

#https://drone-api-72q3.onrender.com/DroneAPI/Drone/checkBatteryLevel/{id} Endpoint para verificar la bateria de un dron mediante su id
