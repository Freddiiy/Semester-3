import obj from "./utils/file2";
import {males, females} from "./utils/file2";
import "./App.css";
import {ReactNode} from "react";
const person = obj;
import {persons, IPersons} from "./utils/file2";

function App() {
	return (
		<>
			<MultiWelcome />
		</>
	);
}

function Welcome({name} : {name: string}) {
	return (
		<>
			<h1>Welcome {name}</h1>
		</>
	)
}

function WelcomePerson(person: IPersons) {
	return (
		<>
			<h1>Welcome {person.firstName} {person.lastName}</h1>
		</>
	)
}

function MultiWelcome() {
	return (
		<div>
			<Welcome name={"Sarah"} />
			<Welcome name={"Cahal"} />
			<Welcome name={"Edith"} />
			{persons.map((person) => (
				<WelcomePerson {...person} />
			))}
		</div>
	);
}




export default App;
