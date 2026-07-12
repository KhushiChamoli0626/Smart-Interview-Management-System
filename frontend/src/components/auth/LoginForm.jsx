import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

import InputField from "./InputField";
import PasswordField from "./PasswordField";

import { login } from "../../services/authService";

function LoginForm() {

    const navigate = useNavigate();

    const [email, setEmail] = useState("");

    const [password, setPassword] = useState("");

    const [loading, setLoading] = useState(false);

    async function handleSubmit(e) {

        e.preventDefault();

        setLoading(true);

        try {

            const response = await login({

                email,

                password

            });

            localStorage.setItem("token", response.data.token);

            toast.success("Login Successful");

            navigate("/dashboard");

        }

        catch (error) {

            toast.error("Invalid Email or Password");

        }

        finally {

            setLoading(false);

        }

    }

    return (

        <div className="login-card">

            <h2>

                Welcome Back 👋

            </h2>

            <p>

                Sign in to continue to your dashboard

            </p>

            <form onSubmit={handleSubmit}>

                <InputField

                    label="Email Address"

                    type="email"

                    placeholder="Enter your email"

                    value={email}

                    onChange={(e) => setEmail(e.target.value)}

                />

                <PasswordField

                    value={password}

                    onChange={(e) => setPassword(e.target.value)}

                />

                <div className="login-options">

                    <label>

                        <input type="checkbox" />

                        Remember Me

                    </label>

                    <a href="#">

                        Forgot Password?

                    </a>

                </div>

                <button
                    className="login-btn"
                    disabled={loading}
                >

                    {

                        loading ?

                            "Signing In..." :

                            "Sign In →"

                    }

                </button>

            </form>

            <div className="login-footer">

                Powered by Spring Boot & React

            </div>

        </div>

    );

}

export default LoginForm;