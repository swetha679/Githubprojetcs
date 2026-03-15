import Register from "./Component/Register";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from "./Component/Login";
import Home from "./Component/Home";
function App() {
  return (
<Router>
  <Routes>
    <Route path="/" element={<Login></Login>}/>
    <Route path="/Register" element={<Register></Register>}/>
    <Route path="/Home" element={<Home></Home>}/>
  </Routes>
</Router>
  );
}

export default App;
