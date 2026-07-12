import {
    FaUsers,
    FaBriefcase,
    FaCalendarAlt,
    FaStar
} from "react-icons/fa";

function DashboardPreview() {

    return (

        <div className="preview-card">

            <h4>Today's Recruitment</h4>

            <div className="preview-item">
                <FaUsers />
                <span>Candidates</span>
                <strong>124</strong>
            </div>

            <div className="preview-item">
                <FaBriefcase />
                <span>Jobs</span>
                <strong>18</strong>
            </div>

            <div className="preview-item">
                <FaCalendarAlt />
                <span>Interviews</span>
                <strong>32</strong>
            </div>

            <div className="preview-item">
                <FaStar />
                <span>Feedback</span>
                <strong>56</strong>
            </div>

            <div className="trend">

                <div className="trend-title">

                    <span>Recruitment Growth</span>

                    <strong>+18%</strong>

                </div>

                <div className="trend-bars">

                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>

                </div>

            </div>

        </div>

    );

}

export default DashboardPreview;