import "./DashboardCard.css";

function DashboardCard({ title, value, icon, color }) {

    return (

        <div className="col-xl-3 col-lg-6 col-md-6 mb-4">

            <div className="dashboard-card">

                <div className="card-left">

                    <div
                        className="card-icon"
                        style={{ backgroundColor: color }}
                    >
                        {icon}
                    </div>

                    <div>

                        <p className="card-title">
                            {title}
                        </p>

                        <h2>
                            {value ?? 0}
                        </h2>

                        <span className="card-subtitle">
                            Updated just now
                        </span>

                    </div>

                </div>

                <div className="card-trend">

                    <span className="trend-up">
                        ↑ 12%
                    </span>

                </div>

            </div>

        </div>

    );

}

export default DashboardCard;