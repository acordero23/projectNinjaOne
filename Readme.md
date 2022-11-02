Starting the Application

In the project there is a collection to import with examples of the endpoints.

Run the BootloaderApplication class

Go to http://localhost:8080/token to generate the token

In the header of each enpoint the generated token must be assigned, the duration of the same has a time of 20 minutes

Endpoint Device

POST
http://localhost:8080/device/add
{
    "systemName": "PruebaDevice",
    "type": "PruebaDevice",
    "cost": 5.00
}

GET
http://localhost:8080/device/3

DELETE
http://localhost:8080/device/delete
{
    "deviceId": 4
}

PUT
http://localhost:8080/device/update
{
    "deviceId": 4,
    "systemName": "PruebaDeviceUpdate",
    "type": "PruebaDeviceUpdate",
    "cost": 10.00
}

Endpoint Service
POST
http://localhost:8080/service/add
{
    "serviceName": "servicePrueba1",
    "deviceName": "Windows Server",
    "cost": 5.00
}

DELETE
http://localhost:8080/service/delete
{
    "serviceCostId": 7
}

Endpoint Client
POST
http://localhost:8080/client/add
{
    "clientName": "Alejandro Cordero",
    "identification": "0931114631",
    "services" : [
        {
            "serviceName": "Each Device",
            "quantity": 5
        },
        {
            "serviceName": "Antivirus Windows",
            "quantity": 2
        },
        {
            "serviceName": "Antivirus Mac",
            "quantity": 3
        },
        {
            "serviceName": "Backup",
            "quantity": 5
        },
        {
            "serviceName": "Screen Share",
            "quantity": 5
        }
    ]
}