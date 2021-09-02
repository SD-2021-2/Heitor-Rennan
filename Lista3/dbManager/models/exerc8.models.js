const mongoose = require('mongoose');

const Exerc8Schema = new mongoose.Schema({
  nome: {
    type: String
  },
  saldo: {
    type: Number
  }
},
{
  collection: 'exerc8',
  timestamps: true
});

const Exerc8 = mongoose.model('Exerc8', Exerc8Schema);

module.exports = Exerc8;