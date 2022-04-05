import "./App.css";
<<<<<<< HEAD
import {Counter} from "./components/Counter";
import Joke from "./components/Joke";
import {DadJoke} from "./components/Joke";

function App() {
  return (
      <>
          <Counter initCount={9} />
          <Joke />
          <DadJoke />
      </>
=======
import { act } from "react-dom/test-utils";
import { Counter } from "./components/Counter";
import { Joke } from "./components/Joke";

function App() {
  return (
    <>
      <Counter initCount={30} />
      <Joke />
    </>
>>>>>>> 0cc4d8f32e6959f18eb1510e4cedecf125ddab77
  );
}

export default App;
