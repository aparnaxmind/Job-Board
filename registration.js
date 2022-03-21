import { useState } from "react";
import axios from 'axios';
export default function Registration() {
    
    const [name, setName] = useState("");
    const [lastname, setLastname] = useState("");
    const [email, setEmail] = useState("");
    const [gender, setGender] = useState("");
    const [skills, setSkills] = useState("");
    const [dob, setDob] = useState("");
    const [password,setPassword]=useState("");

  const [submitted] = useState(false);
  const [error] = useState(false);



  const handleAddApplicant = (event) =>{
        alert("in handleaddapplicant");
    const applicant = {
      name:this.state.name,
      lastname:this.state.lastname,
      email:this.state.email,
      gender:this.state.gender,
      skills:this.state.skills,
      dob:this.state.dob
      };
    axios.post('http://localhost:8080/api/applicant/save',applicant)
      .then(response=>{
           if(response.data != null){
                this.setState(this.initialState);
                alert("applicant is registerd successfully");
            }
      });

   };

  const successMessage = () => {
    return (
      <div
        className="success"
        style={{
          display: submitted ? "" : "none",
        }}
      >
        <h1>User {name} successfully registered!!</h1>
      </div>
    );
  };

  const errorMessage = () => {
    return (
      <div


        className="error"
        style={{
          display: error ? "" : "none",
        }}
      >
        <h1>Please enter all the fields</h1>
      </div>
    );
  };

  return (
    <div className="form">
      <div>
      
        <h1> Registration For New Applicant</h1>
      </div>

      <div className="messages">
        {errorMessage()}
        {successMessage()}
      </div>

      <form>
        <label className="label">First Name</label><br></br>
        <input
          onChange={() =>setName()}
          className="input"
          value={name}
          type="text"
        /><br></br>

        <label className="label">Last Name</label><br></br>
        <input
          onChange={() =>setLastname()}
          className="input"
          value={lastname}
          type="text"
        /><br></br>

        <label className="label">Email</label><br></br>
        <input
          onChange={() =>setEmail()}
          className="input"
          value={email}
          type="email"
        /><br></br>

        <label className="label">Gender</label><br></br>
        <input
          onChange={() =>setGender()}
          className="input"
          value={gender}
          type="text"
        /><br></br>

        <label className="label">Skills</label><br></br>
        <input
          onChange={() =>setSkills()}
          className="input"
          value={skills}
          type="text"
        /><br></br>

        <label className="label">Dob</label><br></br>
        <input
          onChange={() =>setDob()}
          className="input"
          value={dob}
          type="date"
        /><br></br>

        <label className="label">Password</label><br></br>
        <input
          onChange={() =>setPassword()}
          className="input"
          value={password}
          type="password"
        /><br></br><br></br>

        <button onClick={() =>handleAddApplicant} className="btn btn-info" type="submit">
          Register
        </button><br></br><br></br>
        Already registered ? <a href="signin">Login here</a>
      </form>
    </div>
  );
}