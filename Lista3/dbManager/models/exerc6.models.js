const mongoose = require('mongoose');

const Exerc6Schema = new mongoose.Schema({
  nome: {
    type: String
  },
  nivel: {
    type: String
  },
  salario: {
    type: Number
  },
  dependentes: {
    type: Number
  }
},
{
  collection: 'exerc6',
  timestamps: true
});

const Exerc6 = mongoose.model('Exerc6', Exerc6Schema);

module.exports = Exerc6;