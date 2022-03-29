import obj from "./utils/file2";
import {males, females} from "./utils/file2";
import "./App.css";
const person = obj;

function App() {
	console.log([...males, ...females]);
	const personArray = [...males, ...females];
	return (
		<>
			<h1>Person</h1>
			<p>{person.firstName}</p>
			<p>{person.email}</p>
			<p>{personArray}</p>
		</>
	);
}

export default App;
