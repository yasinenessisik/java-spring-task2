import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from "react-router-dom";

const ListByRestaurantId = () => {
    const [reservations, setReservations] = useState([]);
    const { restaurantId } = useParams();
    const [restaurantInfo, setRestaurantInfo] = useState([]);
    console.log(restaurantId);
    useEffect(() => {
        const fetchReservations = async () => {
            try {
                const response= await axios.get(`http://localhost:8080/v1/reservation/${restaurantId}`);
                const restaurants = await axios.get(`http://localhost:8080/v1/restaurant/${restaurantId}`);
                setReservations(response.data)
                setRestaurantInfo(restaurants.data)
            } catch (err) {
                console.log(err);
            }
        }
        fetchReservations()
    }, [restaurantId]) // useEffect'i restaurantId'ye bağlı hale getir

    return (
        <div>
            <h1>List reservations</h1>
            <h2>{restaurantInfo.city}, {restaurantInfo.state}, {restaurantInfo.capacity}</h2>
            <table>
                <thead>
                <tr>
                    <th>Reservation ID</th>
                    <th>Restaurant</th>
                    <th>Customer Name</th>
                    <th>Customer Surname</th>
                    <th>Customer Phone Number</th>
                    <th>Number of People</th>
                </tr>
                </thead>
                <tbody>
                {reservations.map((reservation) => (
                    <tr key={reservation.reservationId}>
                        <td>{reservation.reservationId}</td>
                        <td>{reservation.restaurant.city}, {reservation.restaurant.state}</td>
                        <td>{reservation.customer.name}</td>
                        <td>{reservation.customer.surname}</td>
                        <td>{reservation.customer.phoneNumber}</td>
                        <td>{reservation.reservationNumberOfPeople}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default ListByRestaurantId;
