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