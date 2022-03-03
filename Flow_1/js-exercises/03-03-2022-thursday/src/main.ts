import './style.css'
import { Country } from './country';
import e from 'cors';

const countries = document.querySelector<HTMLElement>("#svg2");
const countryName = document.querySelector<HTMLElement>("#countryName");
const population = document.querySelector<HTMLElement>("#population");
const area = document.querySelector<HTMLElement>("#area");
const border = document.querySelector<HTMLElement>("#border");

const target = {
  current: null as any,
  prev: null as any
}

if (countries != null) {
  countries.onclick = (e: MouseEvent) => {

    target.prev = target.current;
    target.current = e.target;
   
    if (target.prev != null) {
      target.prev.style.fill = "#c0c0c0"
    }
    target.current.style.fill = "red";

    getDataFromBackend(target.current.id)
      .then(country => {
        console.log(country[0].name.common)
        if (countryName != null) countryName.innerText = `Country: ${country[0].name.common}`;
        if (population != null) population.innerText = `Population: ${country[0].population}`;
        if (area != null) area.innerText = `Area: ${country[0].area}`;
        if (border != null) border.innerText = `Border: ${country[0].borders}`;

      })
  }
}


async function getDataFromBackend(country: string) {
  const response = await fetch(`http://localhost:8080/api/country/${country}`);
  const countryRes: Country[] = await response.json();
  return countryRes;
}

