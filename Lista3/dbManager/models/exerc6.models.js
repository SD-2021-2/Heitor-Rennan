const mongoose = require('mongoose');

const Exerc6Schema = new mongoose.Schema({
  name: {
    type: String
  },
  level: {
    type: String
  },
  salary: {
    type: Number
  },
  dependencies: {
    type: Number
  }
},
{
  collection: 'exerc6',
  timestamps: true
});

const Exerc6 = mongoose.model('Exerc6', Exerc6Schema);

module.exports = Exerc6;