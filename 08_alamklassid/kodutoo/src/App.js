// Import necessary modules
import React, { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  // Define state variables and refs
  const [kogus, setKogus] = useState(0);
  const [numbrid, setNumbrid] = useState([]);
  const idRef = useRef();
  const nimiRef = useRef();
  const numberRef = useRef();
  //const asukohtRef = useRef();
  const [numbrikomponendid, setNumbriKomponendid] = useState([]); 

  useEffect(() => {
    fetch('http://localhost:8080/numbrikomponendid')
    .then(response => response.json())
    .then(json =>  {
      setNumbriKomponendid(json);
    })
    .catch(error => {
      console.error('Error fetching numbrikomponendid:', error);
    });
  }, []);

  useEffect(() => {
    fetch('http://localhost:8080/api/numbrid')
      .then(response => response.json())
      .then(json => {
        setKogus(json.length);//lisasin selle ja json yles ja alla
        setNumbrid(json);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  function kustuta(primaarvoti) {
    fetch('http://localhost:8080/api/numbrid/' + primaarvoti, { method: 'DELETE' })
      .then(response => {
        if (response.ok) {
          // Update state variables after successful deletion
          setKogus(prevKogus => prevKogus - 1);
          setNumbrid(prevNumbrid => prevNumbrid.filter(num => num.id !== primaarvoti));
        } else {
          console.error('Failed to delete number:', response.status);
        }
      })
      .catch(error => {
        console.error('Error deleting number:', error);
      });
  }
  
  
  function lisa() {
    const number = {
      id: idRef.current.value,
      nimi: nimiRef.current.value,
      number: numberRef.current.value,
    };
  
    fetch('http://localhost:8080/api/numbrid', {
      "method": "POST", 
      "body": JSON.stringify(number), 
      "headers": {"Content-Type": "application/json"}})
      .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
      .then(json =>  {
        setKogus(json.length);
        setNumbrid(json);
    })
  }
  
  function kustutaNK(primaarvoti) {
    console.log("Deleting item with ID:", primaarvoti); // Add this line for debugging
    if (primaarvoti) {
        // Existing code for DELETE request
    } else {
        console.error('Invalid ID for deletion:', primaarvoti);
    }
}

  
  
  
  const taNimiRef = useRef();
  const asukohtRef = useRef();
  
  function lisaNK() {
    const lisatavNK = {
      "number": {"nimetus": taNimiRef.current.value},
      "asukoht": asukohtRef.current.value
    };
  
  
    fetch('http://localhost:8080/numbrikomponent', {
      method: "POST",
      body: JSON.stringify(lisatavNK),
      headers: {
        "Content-Type": "application/json"
      }
    })
    .then(response => response.json())
    .then(json => {
      setNumbriKomponendid(json);
    })
    .catch(error => {
      console.error('Error adding numbrikomponent:', error);
    });
  }

  return (
    <div className="App">
       Mul on {kogus} numbrit
       <br /><br />


      <label>Numbri id</label> <br />
      <input ref={idRef} type="number" /> <br />
      <label>Numbri nimi</label> <br />
      <input ref={nimiRef} type="text" /> <br />
      <label>Number</label> <br />
      <input ref={numberRef} type="number" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {numbrid.length > 0 && numbrid.map(t => (
        <div key={t.id}>{t.nimi} <button onClick={() => kustuta(t.id)}>x</button></div>
      ))}

      {numbrid.map(t => <div>{t.id} | {t.nimi} | {t.number} <button onClick={() => kustuta(t.id)}>x</button></div>)}
      <hr/>
      <label>Numbrikomponendi nimi (Täpne nimi andmebaasist)</label> <br/>
      <input ref={taNimiRef} type="text" /> <br />
      <label>Asukoht</label> <br/>
       <input ref={asukohtRef} type="text" /> <br />
       <button onClick={() => lisaNK()}>Sisesta</button> <br />
      
       {numbrikomponendid.length > 0 && numbrikomponendid.map(tk => (
  <div key={tk.id}>
    {tk.id} | {tk.nimi} | {tk.asukoht} | <button onClick={() => kustutaNK(tk.id)}>x</button>
  </div>
))}

    </div>

  );
}


export default App;

