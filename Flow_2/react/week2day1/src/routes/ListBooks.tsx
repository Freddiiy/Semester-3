import {useEffect, useState} from "react";
import {Outlet} from "react-router-dom";
import {IBook} from "../utils/bookFacade";
import {getBooks} from "../utils/bookFacade";

export default function ListBook() {
	const [books, setBooks] = useState<IBook[]>();

	useEffect(() => {
		async function fetchBooks() {
			const fetchedBooks = await getBooks();
			setBooks(fetchedBooks);
			console.log(books);
		}
		fetchBooks();
	}, [books]);
	return (
		<>
			<h1>ListBooks</h1>
			<ul>
				{books ? (
					books.map((book) => {
						<>
							<Book key={book.id} book={book} />
						</>;
					})
				) : (
					<h1>No books</h1>
				)}
			</ul>

			<h1>test</h1>

			<Outlet />
		</>
	);
}

function Book({book}: {book: IBook}) {
	return (
		<li>
			<h3>{book.title}</h3>
			<p>{book.info}</p>
			<p>{book.id}</p>
		</li>
	);
}
