import { FaBell, FaUserCircle } from "react-icons/fa";
import { logout } from "../utils/auth";
import { useNavigate } from "react-router-dom";

import "../styles/navbar.css";

function Navbar() {

    const navigate = useNavigate();

    const handleLogout = () => {

        logout();

        navigate("/login");
    };

    return (

        <div className="navbar-custom">

            <div>

                <h4>Smart Interview Management System</h4>

            </div>

            <div className="navbar-right">

                <FaBell size={20} />

                <FaUserCircle size={28} />

                <button
                    className="btn btn-danger btn-sm"
                    onClick={handleLogout}
                >
                    Logout
                </button>

            </div>

        </div>

    );
}

export default Navbar;