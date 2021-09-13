const mongoose = require('mongoose');

const Exerc7Schema = new mongoose.Schema({
  nome: {
    type: String
  },
  idade: {
    type: Number
  },
  tempo_de_servico: {
    type: Number
  }
},
{
  collection: 'exerc7',
  timestamps: true
});

const Exerc7 = mongoose.model('Exerc7', Exerc7Schema);

module.exports = Exerc7;