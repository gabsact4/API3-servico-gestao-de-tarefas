import { Link } from "react-router-dom";

export default function Navbar() {
    return (
        <nav>
            <Link to="/">Home</Link> |{" "}
            <Link to="/dashboard">Dashboard</Link> |{" "}
            <Link to="/bolsa">Bolsa</Link>
            <Link to="/pessoas">Pessoas</Link>
            <Link to="/sair">Sair</Link>
        </nav>
    );
}
