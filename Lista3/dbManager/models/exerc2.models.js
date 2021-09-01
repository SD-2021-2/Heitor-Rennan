const mongoose = require('mongoose');

const Exerc2Schema = new mongoose.Schema({
  name: {
    type: String
  },
  age: {
    type: Number
  },
  gender: {
    type: String
  }
},
{
  collection: 'exerc2',
  timestamps: true
});

const Exerc2 = mongoose.model('Exerc2', Exerc2Schema);

module.exports = Exerc2;