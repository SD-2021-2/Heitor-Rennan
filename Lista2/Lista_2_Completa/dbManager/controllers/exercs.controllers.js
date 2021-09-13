const exercsService = require('../services/exercs.services')  

exports.exerc1 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc1 = await exercsService.exerc1(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc1);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}

exports.exerc2 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc2 = await exercsService.exerc2(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc2);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}

exports.exerc3 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc3 = await exercsService.exerc3(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc3);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}

exports.exerc4 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc4 = await exercsService.exerc4(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc4);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}

exports.exerc5 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc5 = await exercsService.exerc5(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc5);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}

exports.exerc6 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc6 = await exercsService.exerc6(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc6);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}

exports.exerc7 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc7 = await exercsService.exerc7(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc7);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}

exports.exerc8 = async function (data) {
  // Validate request parameters, queries using express-validator
  try {
    let exerc8 = await exercsService.exerc8(data);
    //return res.status(200).json({ status: 200, message: "OK" });
    return JSON.stringify(exerc8);
  } catch (e) {
    return res.status(400).json({ status: 400, message: e.message });
  }
}