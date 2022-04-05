<<<<<<< HEAD
import {useEffect, useState} from "react";
import axios from "axios";

export interface IChuckNorrisJoke {
    categories?: any[];
    createdAt?:  Date;
    iconURL?:    string;
    id?:         string;
    updatedAt?:  Date;
    url?:        string;
    value?:      string;
}

export interface DadJoke {
    id?:     string;
    joke?:   string;
    status?: number;
}


export default function Joke() {
    const [joke, setJoke] = useState<IChuckNorrisJoke>();

    async function fetchJoke() {
        const response = await axios.get<IChuckNorrisJoke>("https://api.chucknorris.io/jokes/random");
        const joke = await response.data;

        setJoke(joke);
    }

    return (
        <>
            {joke ? <ChuckNorrisJoke joke={joke} /> : <h2>Waiting for joke</h2>}
            <button onClick={fetchJoke}>Get new joke</button>
        </>
    )
}

function ChuckNorrisJoke({joke} : {joke: IChuckNorrisJoke}) {
    return (
        <>
            <img src={joke.iconURL} alt={""}/>
            <h2>{joke.value}</h2>
        </>
    )
}

export function DadJoke() {
    const [dadJoke, setDadJoke] = useState<DadJoke>();

    useEffect(() => {
        async function fetchJoke() {
            const options = {
                headers: {
                    accepts: "application/json;"
                }
            }
            const response = await axios.get<DadJoke>("https://icanhazdadjoke.com/", options);
            const dadJoke = await response.data;
            setDadJoke(dadJoke)
        }

        setInterval(fetchJoke, 10000);

    });
    return (
        <>
        {dadJoke ? (<h2>{dadJoke.joke}</h2>) : <h2>fetching joke</h2>}
        </>
    )
}
=======
import { useEffect, useState } from "react";
import axios from "axios";

export interface IJoke {
  categories: any[];
  created_at: string;
  icon_url: string;
  id: string;
  updated_at: string;
  url: string;
  value: string;
}

export function Joke() {
  const [joke, setJoke] = useState<IJoke | undefined>();
  const [error, setError] = useState<string>();

  async function fetchJoke() {
    try {
      const response = await axios.get<IJoke>(
        "https://api.chucknorris.io/jokes/random"
      );
      const joke = await response.data;

      if (joke === undefined) return;
      setJoke(joke);
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      {joke !== undefined ? <JokeComponent joke={joke} /> : ""}
      <button onClick={fetchJoke}>Get new joke</button>
    </>
  );
}

function JokeComponent({ joke }: { joke: IJoke }) {
  return (
    <>
      <img src={joke.icon_url} alt={""} />
      <h1>{joke.value}</h1>
    </>
  );
}
>>>>>>> 0cc4d8f32e6959f18eb1510e4cedecf125ddab77
