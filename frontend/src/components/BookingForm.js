import React from "react";
import {useForm} from "react-hook-form";
import axios from "axios";

function BookingForm() {
    const {register, handleSubmit, formState: {errors}} = useForm();

    const onSubmit = data => {
        axios
            .post(
                'http://localhost:8080/booking/addBooking',
                data,
                {headers: {'Content-Type': 'application/json'}}
            )
            .then(response => {
                console.log(response.data)
            })
            .catch(error => {
                console.log(error.data)
            });
    };

    return (
        <div>
            <h1>Add Booking</h1>
            <form onSubmit={handleSubmit(onSubmit)}>
                <input type="text" placeholder="ID #" {...register("id", {required: true})}/>
                <input type="text" placeholder="Ticket " {...register("ticket", {required: "Required"})}/>
                <input type="date"
                       placeholder="booking_start_time" {...register("booking_start_time", {required: "Required"})}/>
                <input type="date"
                       placeholder="booking_end_time" {...register("booking_end_time", {required: "Required"})}/>
                <input type="date" placeholder="Date created" {...register("date", {required: "Required"})}/>
                <input type="number" placeholder="car" {...register("car", {required: "Required"})}/>
                <input type="number" placeholder="user" {...register("user", {required: "Required"})}/>
                <input type="submit"/>
            </form>
        </div>
    )
}

export {BookingForm}