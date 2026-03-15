import { Link, useNavigate } from 'react-router-dom';
import img from './img/student.jpg'
import { useEffect, useState } from 'react';
import axios from 'axios';
function Login(){
    const[reg,setreg]=useState("");//=>
        const[password,setpassword]=useState("");
    useEffect(
      ()=>  {
            
sessionStorage.clear();//=>12345remove == display
        },[]
    )
const navigate=useNavigate();
    const loginhanding=async()=>{
        const login={reg,password}
        try {
            const response= await axios.post("http://localhost:8080/Login",login);
            console.log(response.data);
            if(response.data==="Login successfull"){
                alert("login successful");
                navigate("/home")
                sessionStorage.setItem('reg',reg);//=>login(reg=> set)
            }else{
                alert("login failed");
                navigate("/Register")
            }
        } catch (error) {
            alert("backend is not connected");
        }
    }
    return(
       <div className="row">
        <div className="col-6">
<img src={img} alt='' width="600px" height="600px" />
        </div>
        <div className="col-6">
<div className='form-group shadow border border-primary p-3 rounded' style={{width:"350px",marginTop:"120px"}}>
    <p className='h4 text-center'>Student Login</p>
    <label className='form-label mt-2'>Name</label>
    <input value={reg} onChange={(e)=>setreg(e.target.value)} className='form-control mt-2' type='number' placeholder='Enter your Reg no'/>
    <label className='form-label mt-2'>Password</label>
    <input value={password} onChange={(e)=>setpassword(e.target.value)} className='form-control mt-2' type='password' placeholder='Enter your password'/>
    <button className='btn btn-primary w-100 mt-3' onClick={loginhanding}>Login</button>
    <p className='mt-3 ms-5'>Do not have an account?<Link to="/Register" className='btn btn-outline-success ms-2'>Register</Link></p>
</div>
        </div>
       </div>
    )
}
export default Login;