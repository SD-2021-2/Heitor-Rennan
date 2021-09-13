const mongoose = require('mongoose');

mongoose.connect('mongodb+srv://admin:fTZE43EPWKBvc5bu@sd-2021.8i3wq.mongodb.net/sd2021?retryWrites=true&w=majority', {
  useNewUrlParser: true,
  useUnifiedTopology: true
}).then(() => {
  console.log("Connected with MongoDB!");
}).catch((error) => {
  console.log(error);
  console.log("Error: Cannot Connect to MongoDB!!!");
});