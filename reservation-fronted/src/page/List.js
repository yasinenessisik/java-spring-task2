import React from 'react';
import axios from "axios";
import '../pagecss/List.css';
const List = () => {
    const [reservations, setReservations] = React.useState([]);

    React.useEffect(() => {
        const fetchReservations = async () => {
            try{
                const response = await axios.get('http://localhost:8080/v1/reservation');
                console.log(response);
                setReservations(response.data)
            }catch(err){
                console.log(err);
            }
        }
        fetchReservations()
    })


    return (
        <div>
            <h1>List reservations</h1>
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
                        <th>{reservation.customer.phoneNumber}</th>
                        <td>{reservation.reservationNumberOfPeople}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}
export default List;