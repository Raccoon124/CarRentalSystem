import { useState, useEffect } from "react";
import MUIDataTable from "mui-datatables";
import axios from "axios";
import Switch from "@material-ui/core/Switch";

export const TableAxios = () => {
  const [cars, setCars] = useState([]);

  const endpoint = "http://localhost:8080/car/allCars";

  const getData = async () => {
    await axios.get(endpoint).then((response) => {
      const data = response.data;
      console.log(data);
      setCars(data);
    });
  };

  useEffect(() => {
    getData();
  }, []);

  const columns = [
    {
      name: "id",
      label: "ID",
    },
    {
      name: "available",
      label: "AVAILABLE",
      options: {
        filter: true,
        sort:false,
        customBodyRender: (value, tableMeta, updateValue) => {
          return (
            <div>
              <Switch checked={value}/>
            </div>
          );
        },
      },
    },
    {
      name: "classification",
      label: "CLASSIFICATION",
    },
    {
      name: "model",
      label: "MODEL",
    },
    {
      name: "name",
      label: "NAME",
    },
    {
      name: "price",
      label: "PRICE",
    },
  ];

  //render
  return <MUIDataTable title={"Cars"} data={cars} columns={columns} />;
};
