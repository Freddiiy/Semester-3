import { useContext, useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import { act } from "react-dom/test-utils";
import { Counter } from "./components/Counter";
import { Joke } from "./components/Joke";

function App() {
  return (
    <>
      <Counter initCount={30} />
      <Joke />
    </>
  );
}

export default App;
