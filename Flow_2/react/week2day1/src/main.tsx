import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Header from "./components/Header";
import NoMatch from "./routes/NoMatch";
import ListBook from "./routes/ListBooks";
import FindBook from "./routes/FindBook";
import AddBook from "./routes/AddBook";

ReactDOM.render(
	<React.StrictMode>
		<BrowserRouter>
			<Header />
			<Routes>
				<Route path="/" element={<App />} />
				<Route path="books" element={<ListBook />} />
				<Route path="find-books" element={<FindBook />} />
				<Route path="add-book" element={<AddBook />} />
				<Route path="*" element={<NoMatch />} />
			</Routes>
		</BrowserRouter>
	</React.StrictMode>,
	document.getElementById("root")
);
