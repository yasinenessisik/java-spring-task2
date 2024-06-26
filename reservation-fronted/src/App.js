import * as React from "react";
import * as ReactDOM from "react-dom/client";
import {
    BrowserRouter,
    createBrowserRouter, Route, Router,
    RouterProvider, Routes,
} from "react-router-dom";
import "./index.css";
import './App.css';
import Add from "./page/Add";
import List from "./page/List";
import ListByRestaurantId from "./page/ListByRestaurantId";
import ConfirmReservation from "./page/ConfirmReservation";

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path="/add" element={<Add />} />
                <Route path="/list" element={<List />} />
                <Route path="/listbyrestaurant/:restaurantId" element={<ListByRestaurantId />} />
                <Route path="/confirmreservation/:customerId/:reservationId" element={<ConfirmReservation />} />
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
