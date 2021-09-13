const mongoose = require('mongoose');

const Exerc4Schema = new mongoose.Schema({
  nome: {
    type: String
  },
  altura: {
    type: Number
  },
  sexo: {
    type: String
  },
},
{
  collection: 'exerc4',
  timestamps: true
});

const Exerc4 = mongoose.model('Exerc4', Exerc4Schema);

module.exports = Exerc4;