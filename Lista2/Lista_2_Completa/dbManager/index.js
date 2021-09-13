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
          case 2: results = await exercsController.exerc2(data.data); break;
          case 3: results = await exercsController.exerc3(data.data); break;
          case 4: results = await exercsController.exerc4(data.data); break;
          case 5: results = await exercsController.exerc5(data.data); break;
          case 6: results = await exercsController.exerc6(data.data); break;
          case 7: results = await exercsController.exerc7(data.data); break;
          case 8: results = await exercsController.exerc8(data.data); break;
          default: socket.end('Out of bounds'); break;
        }
        console.log(results);
        socket.write(results);
        socket.end();
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