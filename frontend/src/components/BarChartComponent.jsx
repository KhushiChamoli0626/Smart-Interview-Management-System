import {

    ResponsiveContainer,

    BarChart,

    Bar,

    XAxis,

    YAxis,

    CartesianGrid,

    Tooltip

} from "recharts";

function BarChartComponent({ stats }) {

    const data = [

        {
            name: "Scheduled",
            count: stats.scheduledInterviews || 0
        },

        {
            name: "Completed",
            count: stats.completedInterviews || 0
        }

    ];

    return (

        <div className="chart-card">

            <h5>Interview Status</h5>

            <ResponsiveContainer width="100%" height={300}>

                <BarChart data={data}>

                    <CartesianGrid strokeDasharray="3 3"/>

                    <XAxis dataKey="name"/>

                    <YAxis/>

                    <Tooltip/>

                    <Bar
                        dataKey="count"
                        fill="#2563EB"
                    />

                </BarChart>

            </ResponsiveContainer>

        </div>

    );

}

export default BarChartComponent;