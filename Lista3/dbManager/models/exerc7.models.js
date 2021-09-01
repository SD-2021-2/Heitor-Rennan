const mongoose = require('mongoose');

const Exerc7Schema = new mongoose.Schema({
  name: {
    type: String
  },
  age: {
    type: String
  },
  service_time: {
    type: Number
  }
},
{
  collection: 'exerc7',
  timestamps: true
});

const Exerc7 = mongoose.model('Exerc7', Exerc7Schema);

module.exports = Exerc7;