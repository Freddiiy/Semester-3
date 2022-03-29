import "./App.css";
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
  );
}

export default App;
