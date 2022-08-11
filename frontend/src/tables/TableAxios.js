import { useState, useEffect } from "react";
import MUIDataTable from "mui-datatables";
import axios from "axios";

export const TableAxios = () => {
//1 - configuramos Los hooks
const [cars, setCars] = useState( [] )

//2 - fcion para mostrar los datos con axios
const endpoint = 'http://localhost:8080/cars/allCars'

const getData = async () => {
    await axios.get(endpoint).then((response) => {
        const data = response.data
        console.log(data)
        setCars(data)
    })
}

useEffect( ()=>{
    getData()
}, [])


//3 - Definimos las columns
const columns = [
    {
        name: "id",
        label: "ID"
    },
    {
        name: "name",
        label: "NAME"
    },
    {
        name: "model",
        label: "MODEL"
    },
    {
        name: "available",
        label: "AVAILABLE",
    },
    {
        name: "classification",
        label: "CLASSIFICATION"
    }
    ,
    {
        name: "Reservation",
        label: "Reservation",
        options: {
            customBodyRender: (value, tableMeta, updateValue) => {
                return (
                    <button onClick={() => console.log(value, tableMeta) }>
                        Edit
                    </button>
                )
            }
        }
    }
]


//4 - renderizamos la datatable
        return (
            <MUIDataTable 
            title={"Cars"}
            data={cars}
            columns={columns}
            />
        )

}