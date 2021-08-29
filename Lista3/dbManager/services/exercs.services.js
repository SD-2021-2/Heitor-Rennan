var Exerc1 = require('../models/exerc1.models');

exports.exerc1 = async function (query) {

  try {
    console.log(query);
    var exerc1 = await Exerc1.findOne(query);
    return exerc1;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}