const express = require('express')
const axios = require('axios')
const cors = require('cors')
const app = express()
const port = 5000

app.use(cors())
app.get('/country/:country', (req, res) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");
    res.header("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");

    console.log(getCountryData(req.params.country))
    res.send(getCountryData(req.params.country));
    console.log(req.params.country);
})

async function getCountryData(requestCountry) {
    const country = axios.default.get(`http://restcountries.com/v3.1/alpha/${requestCountry}`)
        .then((response) => {
            if (response.status != 200) {
                throw new Error(`Country fail ${response.status}`)
            }
        })
    return country
}

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})