const mongoose = require('mongoose');

const Exerc1Schema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    unique: true,
    index: true
  },
  type: {
    type: String,
    required: true
  }
},
{
  collection: 'exerc1',
  timestamps: true
});

const Exerc1 = mongoose.model('Exerc1', Exerc1Schema);

module.exports = Exerc1;