conn = new Mongo();

db = conn.getDB("BankMicroServices");

var clients =
      [
        {
          "idCliente": 1,
          "nombre": "Luis",
          "apellido": "Benavides Perez",
          "dni": "12345678",
          "tipoCliente": "Personal"
        },
        {
          "idCliente": 2,
          "nombre": "Manuel",
          "apellido": "Benites Cardenas",
          "dni": "98765432",
          "tipoCliente": "Empresarial"
        },
        {
          "idCliente": 3,
          "nombre": "Jose",
          "apellido": "Cardenas Torres",
          "dni": "89078906",
          "tipoCliente": "Persona VIP"
        },
        {
          "idCliente": 4,
          "nombre": "Pedro",
          "apellido": "Cubas Santos",
          "dni": "78656478",
          "tipoCliente": "PYME"
        },
        {
          "idCliente": 5,
          "nombre": "Rosalia",
          "apellido": "Arcos Matos",
          "dni": "28719672",
          "tipoCliente": "Corporativo"
        }
      ];

db.Clients.insert(clients);

db.Clients.aggregate([
  {
    $addFields:{
            "_id":"$idCliente"
    }
  },
  {
    $project:{
            "idCliente":0
    }
  },
  {
    $out:"Clients"
  }
]);
