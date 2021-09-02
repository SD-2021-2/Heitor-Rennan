const mongoose = require('mongoose');

const Exerc1Schema = new mongoose.Schema({
  nome: {
    type: String
  },
  cargo: {
    type: String
  },
  salario: {
    type: Number
  }
},
{
  collection: 'exerc1',
  timestamps: true
});

const Exerc1 = mongoose.model('Exerc1', Exerc1Schema);

module.exports = Exerc1;