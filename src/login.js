import { useState } from "react";

export default function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);

  const handleUsername = (e) => {
    setUsername(e.target.value);
    setSubmitted(false);
  };


  const handlePassword = (e) => {
    setPassword(e.target.value);
    setSubmitted(false);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (username === "" || password === "") {
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
        <h1>you loged as {username} !!</h1>
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
          
        <h1> Log-in</h1>
      </div>

      <div className="messages">
        {errorMessage()}
        {successMessage()}
      </div>

      <form>
        <label className="label">User Name</label><br></br>
        <input
          onChange={handleUsername}
          className="input"
          value={username}
          type="text"
        /><br></br>

        <label className="label">Password</label><br></br>
        <input
          onChange={handlePassword}
          className="input"
          value={password}
          type="password"
        /><br></br><br></br>

        <button onClick={handleSubmit} className="btnn" type="submit">
          Log in
        </button> <br></br><br></br>
      </form>
      New User ? <a href="registration">Register here</a>
    </div>
  );
}