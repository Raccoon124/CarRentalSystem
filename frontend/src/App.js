import './App.css';
import { TableAxios } from './tables/TableAxios';
import ResponsiveAppBar from './bar/ResponsiveAppBar';

function App() {
  return (
    <div className="App">
      <ResponsiveAppBar/>
      <TableAxios /> 

    </div>
  );
}

export default App;
