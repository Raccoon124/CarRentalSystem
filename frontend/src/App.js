import React from "react";
import "./App.css";
import ResponsiveAppBar from "./components/Nav";
import Booking from "./components/Booking";
import Car from "./components/Car";
import { Route,Routes} from "react-router"


function App() {
  return (
    <div className="App">
      <ResponsiveAppBar />
      <Routes>
      <Route path="Car" element={<Car />}/>
      <Route path="booking" element={<Booking />}/>
      </Routes>
    </div>
  );
}

export default App;
