import React, { useEffect, useState } from 'react';
import { useParams } from "react-router-dom";
import axios from "axios";

const ConfirmReservation = () => {
    const { customerId, reservationId } = useParams();
    const [responseData, setResponseData] = useState({});

    useEffect(() => {
        const fetchReservation = async () => {
            try {
                const response = await axios.post(`http://localhost:8080/v1/reservation/${customerId}/${reservationId}`);
                setResponseData(response.data); // Assuming response contains the data you need
            } catch (err) {
                console.log(err);
            }
        };
        fetchReservation();
    }, [customerId, reservationId]);

    return (
        <div>
            <pre>{JSON.stringify(responseData, null, 2)}</pre>
        </div>
    );
};

export default ConfirmReservation;
