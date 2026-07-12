import { FaEnvelope } from "react-icons/fa";

function InputField({ label, type, placeholder, value, onChange }) {

    return (

        <div className="input-group-custom">

            <label>{label}</label>

            <div className="input-wrapper">

                <FaEnvelope className="input-icon" />

                <input
                    type={type}
                    placeholder={placeholder}
                    value={value}
                    onChange={onChange}
                />

            </div>

        </div>

    );

}

export default InputField;