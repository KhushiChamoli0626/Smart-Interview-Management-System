/*import { useEffect, useState } from "react";
import { FaUsers, FaUserTie, FaBriefcase, FaCalendarCheck, FaComments } from "react-icons/fa";
import { getDashboardStats } from "../services/dashboardService";
import PieChartComponent from "../components/PieChartComponent";
import BarChartComponent from "../components/BarChartComponent";
import DashboardCard from "../components/DashboardCard";

import "../styles/dashboard.css";

function Dashboard() {

    const [stats, setStats] = useState({});

    useEffect(() => {

        loadDashboard();

    }, []);

    async function loadDashboard() {

        try {

            const response = await getDashboardStats();

            setStats(response.data);

        } catch (error) {

            console.log(error);

        }

    }

    return (

        <div>

            <h2 className="mb-4">
                Dashboard
            </h2>

            <div className="row">

                <DashboardCard
                   title="Users"
                   value={stats.totalUsers}
                   icon={<FaUsers />}
                   color="#2563EB"
                />

                <DashboardCard
                   title="Candidates"
                   value={stats.totalCandidates}
                   icon={<FaUserTie />}
                   color="#10B981"
                />

                <DashboardCard
                   title="Jobs"
                   value={stats.totalJobs}
                   icon={<FaBriefcase />}
                   color="#8B5CF6"
                />

                <DashboardCard
                   title="Interviews"
                   value={stats.totalInterviews}
                   icon={<FaCalendarCheck />}
                   color="#F59E0B"
                />

                <DashboardCard
                   title="Feedback"
                   value={stats.totalFeedbacks}
                   icon={<FaComments />}
                   color="#EF4444"
                />

            </div>

            <div className="row">

                <div className="col-lg-6 mb-4">

                    <PieChartComponent stats={stats} />

                </div>

                <div className="col-lg-6 mb-4">

                    <BarChartComponent stats={stats} />

                </div>

            </div>

        </div>

    );

}

function DashboardCard({ title, value, icon }) {

    return (

        <div className="col-lg-3 col-md-6 mb-4">

            <div className="dashboard-card">

                <div>

                    <h6>{title}</h6>

                    <h2>{value ?? 0}</h2>

                </div>

                <div className="dashboard-icon">

                    {icon}

                </div>

            </div>

        </div>

    );

}

export default Dashboard; */

import QuickActions from "../components/QuickActions";
import { useEffect, useState } from "react";
import {
    FaUsers,
    FaUserTie,
    FaBriefcase,
    FaCalendarCheck,
    FaComments,
    FaChartLine,
    FaBullseye
} from "react-icons/fa";

import DashboardCard from "../components/DashboardCard";
import PieChartComponent from "../components/PieChartComponent";
import BarChartComponent from "../components/BarChartComponent";

import { getDashboardStats } from "../services/dashboardService";

import "../styles/dashboard.css";

function Dashboard() {

    const [stats, setStats] = useState({});

    useEffect(() => {
        loadDashboard();
    }, []);

    async function loadDashboard() {
        try {
            const response = await getDashboardStats();
            setStats(response.data);
        } catch (error) {
            console.error(error);
        }
    }

    return (

        <div className="dashboard-container">

            {/* ================= HERO SECTION ================= */}

            <div className="welcome-banner">

                <div>

                    <h2>Welcome back, Khushi 👋</h2>

                    <p>
                        Smart Interview Management System
                    </p>

                    <span>
                        Monitor recruitment activities, hiring progress and interview analytics in one place.
                    </span>

                </div>

                <div className="today-date">

                    {new Date().toLocaleDateString("en-IN", {
                        weekday: "long",
                        day: "numeric",
                        month: "long",
                        year: "numeric"
                    })}

                </div>

            </div>


            {/* ================= KPI CARDS ================= */}

            <div className="row g-4 mt-2">

                <DashboardCard
                    title="Total Users"
                    value={stats.totalUsers}
                    icon={<FaUsers />}
                    color="#2563EB"
                />

                <DashboardCard
                    title="Candidates"
                    value={stats.totalCandidates}
                    icon={<FaUserTie />}
                    color="#10B981"
                />

                <DashboardCard
                    title="Jobs"
                    value={stats.totalJobs}
                    icon={<FaBriefcase />}
                    color="#8B5CF6"
                />

                <DashboardCard
                    title="Interviews"
                    value={stats.totalInterviews}
                    icon={<FaCalendarCheck />}
                    color="#F59E0B"
                />

            </div>


            {/* ================= ANALYTICS SECTION ================= */}

            <div className="analytics-section mt-4">

                <div className="analytics-header">

                    <div>

                        <h3>Recruitment Analytics</h3>

                        <p>
                            Candidate status & interview insights
                        </p>

                    </div>

                </div>

                <div className="row mt-4">

                    <div className="col-lg-6 mb-4">

                        <PieChartComponent stats={stats} />

                    </div>

                    <div className="col-lg-6 mb-4">

                        <BarChartComponent stats={stats} />

                    </div>

                </div>

            </div>

            <div className="row mt-4">

                <div className="col-lg-6">

                    <QuickActions />

                </div>

                <div className="col-lg-6">

                    {/* Next we'll add Recent Activity here */}

                </div>

            </div>


            {/* ================= INSIGHTS ================= */}

            <div className="row mt-4">

                <div className="col-lg-4 mb-4">

                    <div className="insight-card">

                        <FaComments className="insight-icon" />

                        <h6>Average Feedback Score</h6>

                        <h2>
                            {stats.averageOverallScore
                                ? stats.averageOverallScore.toFixed(1)
                                : "0.0"}
                        </h2>

                    </div>

                </div>

                <div className="col-lg-4 mb-4">

                    <div className="insight-card">

                        <FaChartLine className="insight-icon" />

                        <h6>Scheduled Interviews</h6>

                        <h2>{stats.scheduledInterviews}</h2>

                    </div>

                </div>

                <div className="col-lg-4 mb-4">

                    <div className="insight-card">

                        <FaBullseye className="insight-icon" />

                        <h6>Hired Candidates</h6>

                        <h2>{stats.hiredCandidates}</h2>

                    </div>

                </div>

            </div>


            {/* ================= RECENT INTERVIEWS ================= */}

            <div className="recent-section mt-4">

                <div className="d-flex justify-content-between align-items-center mb-3">

                    <h3>Recent Interviews</h3>

                    <button className="btn btn-primary">
                        View All
                    </button>

                </div>

                <table className="table table-hover align-middle">

                    <thead>

                        <tr>

                            <th>Candidate</th>

                            <th>Job</th>

                            <th>Interviewer</th>

                            <th>Date</th>

                            <th>Status</th>

                        </tr>

                    </thead>

                    <tbody>

                        <tr>

                            <td colSpan="5" className="text-center text-muted py-5">

                                Recent interview records will appear here.

                            </td>

                        </tr>

                    </tbody>

                </table>

            </div>

        </div>

    );

}

export default Dashboard;