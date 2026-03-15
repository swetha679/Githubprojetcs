import { useState } from 'react';
import img from './img/student.jpg'
import axios from "axios";
import { Link, useNavigate } from 'react-router-dom';
function Register(){
    const[reg,setreg]=useState("");

    const[name,setname]=useState("");
    const[password,setpassword]=useState("");
    const[year,setyear]= useState("");
    const[clg,setclg]=useState("");
     const navigate =useNavigate();
const registerhandling=async()=>{
    const register={
        reg,name,password,year,clg
    }
    try {
        const response= await axios.post("http://localhost:8080/Register",register);
        console.log(response.data);
        if(response.data){
            alert("register successfull");
            navigate("/")
        }
    } catch (error) {
        alert("backend is not connected");
    }
}
    return(
        <div className="row">
<div className="col-6">
    <img src={img} alt="" style={{marginTop:"50px"}} width="600px" height="600px" />
</div>
<div className="col-6">
<div className="form-group shadow border border-primary rounded p-3" style={{marginTop:"120px",width:"350px"}}>
    <p className="h4 text-center">Student Register</p>
    <input value={reg} onChange={(e)=>setreg(e.target.value)} className="form-control mt-2" type="text" placeholder="Enter your reg no"/>
    <input value={name} onChange={(e)=>setname(e.target.value)} className="form-control mt-2" type="text" placeholder="Enter your name"/>
    <input value={password} onChange={(e)=>setpassword(e.target.value)} className="form-control mt-2" type="password" placeholder="Enter your password"/>
    <input value={year} onChange={(e)=>setyear(e.target.value)} className="form-control mt-2" type="text" placeholder="Enter your year"/>
    <input value={clg} onChange={(e)=>setclg(e.target.value)} className="form-control mt-2" type="text" placeholder="Enter your clg" />
    <button className="btn btn-primary w-100 mt-2" onClick={registerhandling}>Register</button>
    <p className="mt-3" style={{marginLeft:"65px"}}>Do you hava an account?<Link to="/" className="btn btn-success ms-2 ">Login</Link></p>
</div>
</div>
        </div>
    )
}
export default Register;


// private String reg;
//     private String name;
//     private String password;
//     private String year;
//     private String clg;
