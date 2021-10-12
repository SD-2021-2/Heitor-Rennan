var zmq = require("zeromq"),
  sock = zmq.socket("pub");

sock.bindSync("tcp://127.0.0.1:3000");
console.log("Publisher bound to port 3000");

setInterval(function() {
  console.log("sending a multipart message envelope");
  let pessoa = {
    cargo: "operador",
    salario: 2000,
    nome: "Jorge",
    idade: 48,
    sexo: "M",
    n1: 5.5,
    n2: 6,
    n3: 9,
    altura: 1.72,
    nivel: "B",
    deps: 2,
    tempo: 30,
    saldo: 500,
    numero: 5,
    naipe: 1
  }
  sock.send([Math.floor((Math.random() * 9) + 1), JSON.stringify(pessoa)]);
}, 500);