import { useState } from "react";
import { FaLock, FaEye, FaEyeSlash } from "react-icons/fa";

function PasswordField({ value, onChange }) {

    const [showPassword, setShowPassword] = useState(false);

    return (

        <div className="input-group-custom">

            <label>Password</label>

            <div className="input-wrapper">

                <FaLock className="input-icon" />

                <input
                    type={showPassword ? "text" : "password"}
                    placeholder="Enter your password"
                    value={value}
                    onChange={onChange}
                />

                <button
                    type="button"
                    className="password-toggle"
                    onClick={() => setShowPassword(!showPassword)}
                >

                    {showPassword ? <FaEyeSlash /> : <FaEye />}

                </button>

            </div>

        </div>

    );

}

export default PasswordField;