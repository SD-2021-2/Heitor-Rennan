var Exerc1 = require('../models/exerc1.models');
var Exerc2 = require('../models/exerc2.models');
var Exerc3 = require('../models/exerc3.models');
var Exerc4 = require('../models/exerc4.models');
var Exerc5 = require('../models/exerc5.models');
var Exerc6 = require('../models/exerc6.models');
var Exerc7 = require('../models/exerc7.models');
var Exerc8 = require('../models/exerc8.models');


exports.exerc1 = async function (query) {

  try {
    console.log(query);
    var exerc1 = await Exerc1.findOne({ name: { $regex: new RegExp(query.name, "i") } });
    return exerc1;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}

exports.exerc2 = async function (query) {

  try {
    console.log(query);
    var exerc2 = await Exerc2.findOne(query);
    return exerc2;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}

exports.exerc3 = async function (query) {

  try {
    console.log(query);
    var exerc3 = await Exerc3.findOne(query);
    return exerc3;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}

exports.exerc4 = async function (query) {

  try {
    console.log(query);
    var exerc4 = await Exerc4.findOne(query);
    return exerc4;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}

exports.exerc5 = async function (query) {

  try {
    console.log(query);
    var exerc5 = await Exerc5.findOne(query);
    return exerc5;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}

exports.exerc6 = async function (query) {

  try {
    console.log(query);
    var exerc6 = await Exerc6.findOne(query);
    return exerc6;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}

exports.exerc7 = async function (query) {

  try {
    console.log(query);
    var exerc7 = await Exerc7.findOne(query);
    return exerc7;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}

exports.exerc8 = async function (query) {

  try {
    console.log(query);
    var exerc8 = await Exerc8.findOne(query);
    return exerc8;
  } catch (e) {
    // Log Errors
    throw Error('Error while creating user');
  }
}