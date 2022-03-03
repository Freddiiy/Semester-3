function fetchData() {
    fetch('https://swapi.co/api/people/999999999999')
        .then(res => res.json())
        .then(data => console.log(data.name))
        .catch(err => console.log("UPPS"));
}

fetchData();