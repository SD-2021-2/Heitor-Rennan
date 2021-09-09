const mongoose = require('mongoose');

const Exerc5Schema = new mongoose.Schema({
  nome: {
    type: String
  },
  idade: {
    type: Number
  }
},
{
  collection: 'exerc5',
  timestamps: true
});

const Exerc5 = mongoose.model('Exerc5', Exerc5Schema);

module.exports = Exerc5;