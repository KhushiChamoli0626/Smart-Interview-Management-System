import {
    FaUserPlus,
    FaCalendarPlus,
    FaBriefcase,
    FaClipboardCheck
} from "react-icons/fa";

import { useNavigate } from "react-router-dom";

function QuickActions() {

    const navigate = useNavigate();

    const actions = [

        {
            title: "Add Candidate",
            icon: <FaUserPlus />,
            color: "#2563EB",
            path: "/candidates"
        },

        {
            title: "Schedule Interview",
            icon: <FaCalendarPlus />,
            color: "#10B981",
            path: "/interviews"
        },

        {
            title: "Create Job",
            icon: <FaBriefcase />,
            color: "#F59E0B",
            path: "/jobs"
        },

        {
            title: "Add Feedback",
            icon: <FaClipboardCheck />,
            color: "#8B5CF6",
            path: "/feedback"
        }

    ];

    return (

        <div className="quick-actions">

            <h4>⚡ Quick Actions</h4>

            <div className="row mt-3">

                {

                    actions.map((action, index) => (

                        <div
                            className="col-md-6 mb-3"
                            key={index}
                        >

                            <div
                                className="action-card"
                                onClick={() => navigate(action.path)}
                            >

                                <div
                                    className="action-icon"
                                    style={{ background: action.color }}
                                >
                                    {action.icon}
                                </div>

                                <span>{action.title}</span>

                            </div>

                        </div>

                    ))

                }

            </div>

        </div>

    );

}

export default QuickActions;