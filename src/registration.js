import { useState } from "react";

export default function Form() {
    
    const [name, setName] = useState("");
    const [lastname, setLastname] = useState("");
    const [email, setEmail] = useState("");
    const [gender, setGender] = useState("");
    const [skills, setSkills] = useState("");
    const [dob, setDob] = useState("");
    const [password,setPassword]=useState("");

  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);

  const handleName = (e) => {
    setName(e.target.value);
    setSubmitted(false);
  };

  const handleLastname = (e) => {
    setLastname(e.target.value);
    setSubmitted(false);
  };

  const handleEmail = (e) => {
    setEmail(e.target.value);
    setSubmitted(false);
  };

  const handleGender = (e) => {
    setGender(e.target.value);
    setSubmitted(false);
  };

  
  const handleSkills = (e) => {
    setSkills(e.target.value);
    setSubmitted(false);
  };
  
  const handleDob = (e) => {
    setDob(e.target.value);
    setSubmitted(false);
  };

  
  const handlePassword = (e) => {
    setPassword(e.target.value);
    setSubmitted(false);
  };




  const handleSubmit = (e) => {
    e.preventDefault();
    if (name === "" || email === "" || password === "") {
      setError(true);
    } else {
      setSubmitted(true);
      setError(false);
    }
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
          onChange={handleName}
          className="input"
          value={name}
          type="text"
        /><br></br>

        <label className="label">Last Name</label><br></br>
        <input
          onChange={handleLastname}
          className="input"
          value={lastname}
          type="text"
        /><br></br>

        <label className="label">Email</label><br></br>
        <input
          onChange={handleEmail}
          className="input"
          value={email}
          type="email"
        /><br></br>

        <label className="label">Gender</label><br></br>
        <input
          onChange={handleGender}
          className="input"
          value={gender}
          type="text"
        /><br></br>

        <label className="label">Skills</label><br></br>
        <input
          onChange={handleSkills}
          className="input"
          value={skills}
          type="text"
        /><br></br>

        <label className="label">Dob</label><br></br>
        <input
          onChange={handleDob}
          className="input"
          value={dob}
          type="date"
        /><br></br>

        <label className="label">Password</label><br></br>
        <input
          onChange={handlePassword}
          className="input"
          value={password}
          type="password"
        /><br></br><br></br>

        <button onClick={handleSubmit} className="btn btn-info" type="submit">
          Register
        </button><br></br><br></br>
        Already registered ? <a href="signin">Login here</a>
      </form>
    </div>
  );
}