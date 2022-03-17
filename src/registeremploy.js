
import { useState } from "react";


export default function Register() {

    
    const [companyname, setCompanyname] = useState("");
    const [address, setAddrss] = useState("");
    const [email, setEmail] = useState("");
    const [city, setCity] = useState("");
    const [state, setState] = useState("");
    const [website, setWebsite] = useState("");
    const [mobileno, setMobileno] = useState("");
    const [password,setPassword]=useState("");

  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState(false);

}