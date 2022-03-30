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
