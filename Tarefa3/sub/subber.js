var zmq = require("zeromq"),
  sock = zmq.socket("sub");

sock.connect("tcp://127.0.0.1:3000");
sock.subscribe("1");
sock.subscribe("2");
sock.subscribe("3");
sock.subscribe("4");
sock.subscribe("5");
sock.subscribe("6");
sock.subscribe("7");
sock.subscribe("8");
sock.subscribe("9");

console.log("Subscriber connected to port 3000");

sock.on("message", function(topic, message) {
  let ex = topic.toString("utf-8") * 1;
  let data = JSON.parse(message.toString("utf-8"));
  let results;

  switch(ex) {
    case 1: results = exerc1(data); break;
    case 2: results = exerc2(data); break;
    case 3: results = exerc3(data); break;
    case 4: results = exerc4(data); break;
    case 5: results = exerc5(data); break;
    case 6: results = exerc6(data); break;
    case 7: results = exerc7(data); break;
    case 8: results = exerc8(data); break;
    case 9: results = exerc9(data); break;
    default: console.log("Out of bounds"); break;
  }

  console.log(results);
});

function exerc1(data) {
  let cargo = data.cargo;
  let salario = data.salario;
  let nome = data.nome;

  if(cargo == 'operador') salario += salario * 0.2;
  else if(cargo == 'programador') salario += salario * 0.18;

  return "Cargo: " + cargo + " Novo salario: " + salario;
}

function exerc2(data) {
  let nome = data.nome;
  let sexo = data.sexo;
  let idade = data.idade;

  if((sexo == "M" && idade >= 18) || (sexo == "F" && idade >= 21)) return "Maior de idade";
  else return "Não atingiu maior idade";
}

function exerc3(data) {
  let n1 = data.n1;
  let n2 = data.n2;
  let n3 = data.n3;

  let media = (n1 + n2) / 2;

  if(media >= 7 || (media > 3 && (media + n3) / 2 >= 5)) return "Aprovado"
  else "Reprovado"
}

function exerc4(data) {
  let altura = data.altura;
  let sexo = data.sexo;

  let peso;

  if(sexo == "M") peso = (72.7 * altura) - 58;
  else if(sexo == "F") peso = (62.1 * altura) - 44.7;

  return "Seu peso ideal: " + peso;
}

function exerc5(data) {
  let idade = data.idade;

  if(idade >= 18) return "Adulto";
  else if(idade >= 14) return "Juvenil B";
  else if(idade >= 11) return "Juvenil A";
  else if(idade >= 8) return "Infantil B";
  else if(idade >= 5) return "Infantil A";
  else return "Idade Inválida";
}

function exerc6(data) {
  let nome = data.nome;
  let nivel = data.nivel;
  let salario = data.salario;
  let deps = data.deps;

  if(nivel == 'A') {
    if(deps > 0) salario -= salario * 0.08;
    else salario -= salario * 0.03;
  } 
  else if(nivel == 'B') {
    if(deps > 0) salario -= salario * 0.10
    else salario -= salario * 0.05
  }    
  else if(nivel == 'C') {
    if(deps > 0) salario -= salario * 0.15
    else salario -= salario * 0.08
  }    
  else if(nivel == 'D') {
    if(deps > 0) salario -= salario * 0.17
    else salario -= salario * 0.10
  }

  return nome + " " + nivel + " " + salario;
}

function exerc7(data) {
  let idade = data.idade;
  let tempo = data.tempo;

  if(idade >= 65 && tempo >= 30) return "Pode aposentar";
  else return "Não pode aposentar";
}

function exerc8(data) {
  let saldo = data.saldo;
  
  if(saldo <= 200) return "Saldo Médio " + saldo + " e nenhum crédito";
  else if(saldo <= 400) return "Saldo Médio " + saldo + " e valor do crédito " + saldo * 0.2;
  else if(saldo <= 600) return "Saldo Médio " + saldo + " e valor do crédito " + saldo * 0.3;
  else return "Saldo Médio " + saldo + " e valor do crédito " + saldo * 0.4;
}

function exerc9(data) {
  let numero = data.numero;
  let naipe = data.naipe;

  let nome = "Sua Carta: ";

  switch(numero){
    case 1 : nome = nome.concat("As de "); break;
    case 2 : nome = nome.concat("Dois de "); break;
    case 3 : nome = nome.concat("Tres de "); break;
    case 4 : nome = nome.concat("Quatro de "); break;
    case 5 : nome = nome.concat("Cinco de "); break;
    case 6 : nome = nome.concat("Seis de "); break;
    case 7 : nome = nome.concat("Sete de "); break;
    case 8 : nome = nome.concat("Oito de "); break;
    case 9 : nome = nome.concat("Nove de "); break;
    case 10 : nome = nome.concat("Dez de "); break;
    case 11 : nome = nome.concat("Valete de "); break;
    case 12 : nome = nome.concat("Dama de "); break;
    case 13 : nome = nome.concat("Rei de "); break;
  }

  switch(naipe){
    case 1 : nome = nome.concat("Ouros"); break;
    case 2 : nome = nome.concat("Paus"); break;
    case 3 : nome = nome.concat("Copas"); break;
    case 4 : nome = nome.concat("Espadas"); break;
  }

  return nome;
}