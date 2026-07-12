import Chart from "react-apexcharts";

function PieChartComponent({ stats }) {

    const series = [
        stats.appliedCandidates || 0,
        stats.shortlistedCandidates || 0,
        stats.interviewScheduledCandidates || 0,
        stats.hiredCandidates || 0,
        stats.rejectedCandidates || 0
    ];

    const options = {

        chart: {
            type: "donut",
            toolbar: {
                show: false
            }
        },

        labels: [
            "Applied",
            "Shortlisted",
            "Interview",
            "Hired",
            "Rejected"
        ],

        colors: [
            "#2563EB",
            "#10B981",
            "#F59E0B",
            "#8B5CF6",
            "#EF4444"
        ],

        legend: {
            position: "bottom",
            fontSize: "14px",
            fontWeight: 600,
            markers: {
                radius: 12
            }
        },

        dataLabels: {
            enabled: false
        },

        stroke: {
            width: 0
        },

        plotOptions: {

            pie: {

                donut: {

                    size: "72%",

                    labels: {

                        show: true,

                        total: {

                            show: true,

                            label: "Candidates",

                            formatter: function () {

                                return series.reduce((a, b) => a + b, 0);

                            }

                        }

                    }

                }

            }

        },

        tooltip: {

            theme: "light",

            y: {

                formatter: function (val) {

                    return val + " Candidates";

                }

            }

        }

    };

    return (

        <div className="chart-card">

            <h4 className="chart-title">
                Candidate Status
            </h4>

            <Chart
                options={options}
                series={series}
                type="donut"
                height={380}
            />

        </div>

    );

}

export default PieChartComponent;