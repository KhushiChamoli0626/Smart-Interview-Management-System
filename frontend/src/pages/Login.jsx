import Logo from "../components/auth/Logo";
import DashboardPreview from "../components/auth/DashboardPreview";
import LoginForm from "../components/auth/LoginForm";

import "../styles/login.css";

function Login() {

    return (

        <div className="login-page">

            {/* LEFT SIDE */}

            <div className="login-left">

                <Logo />

                <div className="hero-text">

                    <h1>
                        Recruit Better.
                        <br />
                        Hire Faster.
                    </h1>

                    <p>
                        Simplify recruitment with one intelligent platform.
                        Manage candidates, interviews, jobs and feedback
                        from one beautiful dashboard.
                    </p>

                </div>

                <div className="features">

                    <div className="feature">
                        <div className="feature-icon">✓</div>
                        Candidate Management
                    </div>

                    <div className="feature">
                        <div className="feature-icon">✓</div>
                        Interview Scheduling
                    </div>

                    <div className="feature">
                        <div className="feature-icon">✓</div>
                        Recruitment Analytics
                    </div>

                    <div className="feature">
                        <div className="feature-icon">✓</div>
                        Secure JWT Authentication
                    </div>

                </div>

                <DashboardPreview />

            </div>

            {/* RIGHT SIDE */}

            <div className="login-right">

                <LoginForm />

            </div>

        </div>

    );

}

export default Login;