import { Link } from 'react-router-dom';
import img from './img/student.jpg'
import Footer from './Footer';
import { useEffect, useState } from 'react';
import axios from 'axios';
function Home(){
    const reg= sessionStorage.getItem('reg');
    const [display ,setdisplay]=useState([]);
    const [namereg,setnamereg]=useState("");
    useEffect(()=>{
const regs= reg;
if(regs){
    displayapi(regs)
}else{
    alert("error");
}
    },[reg])
    const displayapi=async(regs)=>{
        try {
            const response = await axios.get(`http://localhost:8080/display/${regs}`);
            if(response.data.length===0){
                alert("result is not published");
            }
            console.log("response",response.data);
            setdisplay(response.data);// reg all
        setnamereg(response.data[0]);//=> data collect  0
        console.log("check",response.data[0]);
        } catch (error) {
            alert("backend is not connected")
        }
    }
    return(
        <>
        <div className="row" >
           <div className="col-6">
<img src={img} alt='home' width="600px" height="600px"/>
           </div>
           <div className="col-5">
<p className='h4 text-primary' style={{marginTop:"120px"}}>Name:<span className='text-success'>{namereg?.name||"result is not published"}</span></p>
<p className='h4 text-primary mt-3'>Reg:<span style={{color:"#8FBABC"}}>{namereg?.reg||"result is not published"}</span></p>
<table className='table table-bordered table-shadow table-info border border-success' style={{marginTop:"50px",width:"450px"}}>
    <thead>
        <tr>
            <th>Subject Name</th>
            <th>Subject code</th>
            <th>Mark</th>
            <th>Grade</th>
            <th>Result</th>
        </tr>
    </thead>
    <tbody>
        {
            display.map((display,index)=>(
                <tr key={index}>
                    <td>{display.subjectname}</td>
                    <td>{display.subjectcode}</td>
                    <td>{display.mark}</td>
                    <td>{display.grade}</td>
                    <td>{display.result}</td>
                </tr>
            ))
        }
    </tbody>
</table>
           </div>
           <div className="col-1">
<Link className='btn btn-danger mt-5' to="/">Logout</Link>
           </div>
        </div>
        <Footer></Footer>
        </>
    )
}
export default Home;
