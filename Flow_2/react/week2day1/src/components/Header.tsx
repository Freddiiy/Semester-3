import {ReactNode} from "react";
import {NavLink} from "react-router-dom";

export default function Header() {
	const links = ["/", "Books", "Find Book", "Add Book"];

	function LinkComponent({
		children,
		href,
	}: {
		children: ReactNode;
		href: string;
	}) {
		href = href.replace(" ", "-").toLowerCase();
		return (
			<ul>
				<NavLink
					style={({isActive}) => ({
						display: "block",
						margin: "1rem 0",
						color: isActive ? "red" : "",
					})}
					to={href}
				>
					{children}
				</NavLink>
			</ul>
		);
	}
	return (
		<>
			<ul style={{display: "flex"}}>
				{links.map((link) => (
					<LinkComponent key={link} href={link}>
						<h3>{link == "/" ? "Home" : link}</h3>
					</LinkComponent>
				))}
			</ul>
		</>
	);
}
