import React, { useState } from 'react';
import '../pagecss/Add.css';
import axios from "axios";
import {useNavigate} from "react-router-dom";

const Add = () => {
    const [formData, setFormData] = useState({
        restaurantId: '',
        name: '',
        surname: '',
        phoneNumber: '',
        secondPhoneNumber: '',
        kvkk: false,
        confirm: false,
        reservationDescription: '',
        reservationDate: '',
        reservationNumberOfPeople: "",
        email:""
    });
    const navigate = useNavigate();
    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: type === 'checkbox' ? checked : value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/v1/reservation/reserve", formData)
        const restaurantId = formData.restaurantId;

        navigate(`/listbyrestaurant/${formData.restaurantId}`);

    };

    return (
        <div className="form">

            <input
                type="text"
                name="restaurantId"
                placeholder="Restaurant ID"
                value={formData.restaurantId}
                onChange={handleChange}
            />
            <input
                type="text"
                name="name"
                placeholder="Name"
                value={formData.name}
                onChange={handleChange}
            />
            <input
                type="text"
                name="surname"
                placeholder="Surname"
                value={formData.surname}
                onChange={handleChange}
            />
            <input
                type="text"
                name="email"
                placeholder="email"
                value={formData.email}
                onChange={handleChange}
            />
            <input
                type="text"
                name="phoneNumber"
                placeholder="Phone Number"
                value={formData.phoneNumber}
                onChange={handleChange}
            />
            <input
                type="text"
                name="secondPhoneNumber"
                placeholder="Second Phone Number"
                value={formData.secondPhoneNumber}
                onChange={handleChange}
            />
            <label>
                KVKK:
                <input
                    type="checkbox"
                    name="kvkk"
                    checked={formData.kvkk}
                    onChange={handleChange}
                />
            </label>
            <label>
                Confirm:
                <input
                    type="checkbox"
                    name="confirm"
                    checked={formData.confirm}
                    onChange={handleChange}
                />
            </label>
            <input
                type="text"
                name="reservationDescription"
                placeholder="Reservation Description"
                value={formData.reservationDescription}
                onChange={handleChange}
            />
            <input
                type="text"
                name="reservationDate"
                placeholder="YYYY-MM-DD"
                value={formData.reservationDate}
                onChange={handleChange}
            />
            <input
                type="number"
                name="reservationNumberOfPeople"
                placeholder="Number of People"
                value={formData.reservationNumberOfPeople}
                onChange={handleChange}
            />
            <button
                type="submit"
                name="submit"
                placeholder="Submit"
                onClick={handleSubmit}
            >Submit
            </button>
        </div>

    );
};

export default Add;
