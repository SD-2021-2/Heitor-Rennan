const mongoose = require('mongoose');

const Exerc3Schema = new mongoose.Schema({
  nome: {
    type: String
  },
  n1: {
    type: Number
  },
  n2: {
    type: Number
  },
  n3: {
    type: Number
  }
},
{
  collection: 'exerc3',
  timestamps: true
});

const Exerc3 = mongoose.model('Exerc3', Exerc3Schema);

module.exports = Exerc3;