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