import {
    FaHome,
    FaUsers,
    FaBriefcase,
    FaCalendarAlt,
    FaStar,
    FaUserCog,
    FaSignOutAlt
} from "react-icons/fa";

import { NavLink } from "react-router-dom";

import "../styles/sidebar.css";

function Sidebar() {

    return (

        <div className="sidebar">

            <div className="logo">

                <h3>SIMS</h3>

                <p>Interview Portal</p>

            </div>

            <NavLink to="/dashboard" className="menu-item">
                <FaHome />
                <span>Dashboard</span>
            </NavLink>

            <NavLink to="/candidates" className="menu-item">
                <FaUsers />
                <span>Candidates</span>
            </NavLink>

            <NavLink to="/jobs" className="menu-item">
                <FaBriefcase />
                <span>Jobs</span>
            </NavLink>

            <NavLink to="/interviews" className="menu-item">
                <FaCalendarAlt />
                <span>Interviews</span>
            </NavLink>

            <NavLink to="/feedback" className="menu-item">
                <FaStar />
                <span>Feedback</span>
            </NavLink>

            <NavLink to="/users" className="menu-item">
                <FaUserCog />
                <span>Users</span>
            </NavLink>

            <NavLink to="/login" className="menu-item logout">

                <FaSignOutAlt />

                <span>Logout</span>

            </NavLink>

        </div>

    );

}

export default Sidebar;