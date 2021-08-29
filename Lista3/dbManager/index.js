const net = require('net');
require('./db');

const exercsController = require('./controllers/exercs.controllers');

const server = net.createServer();

server.on('connection', (socket)=> {
  console.log('Cliente ' + socket.remoteAddress + ' connected');
  socket.on('data', async (data)=> {
      //console.log('\nCliente ' + socket.remoteAddress + ":" + socket.remotePort + " req: " + data);
      let results = "";
      data = JSON.parse("" + data);
      if(data.exerc) {
        console.log("entrou no if");
        switch(data.exerc) {
          case 1: results = await exercsController.exerc1(data.data); break;
          default: socket.end('Out of bounds'); break;
        }
        console.log(results);
        socket.write(results);
      }
      else {
        socket.end('Bad Request');
      }
  });

  socket.on('close', ()=> {
      console.log('Communication Closed');
  });

  socket.on('error', (err)=> {
      console.log(err.message);
  });
});

server.listen(4000, ()=> {
  console.log('Server opened on port: ', server.address().port);
});