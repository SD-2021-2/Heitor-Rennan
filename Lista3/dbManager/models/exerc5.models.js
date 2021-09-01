const mongoose = require('mongoose');

const Exerc5Schema = new mongoose.Schema({
  age: {
    type: Number
  },
  categoria: {
    type: String
  }
},
{
  collection: 'exerc5',
  timestamps: true
});

const Exerc5 = mongoose.model('Exerc5', Exerc5Schema);

module.exports = Exerc5;