// Import necessary modules
import React, { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  // Define state variables and refs
  const [numbrid, setNumbrid] = useState([]);
  const idRef = useRef();
  const nimiRef = useRef();
  const numberRef = useRef();

  // useEffect to fetch data from backend on component mount
  useEffect(() => {
    fetch('http://localhost:8080/api/numbrid')
      .then(response => response.json())
      .then(data => {
        setNumbrid(data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  // Function to delete a number
  function kustuta(primaarvoti) {
    fetch('http://localhost:8080/api/numbrid/' + primaarvoti, { method: 'DELETE' })
      .then(response => {
        if (response.ok) {
          // If the response status is in the 200 range (success), update the state
          // You can choose to fetch the updated list of numbers here if needed
          setNumbrid([]);
        } else {
          // If the response status is not in the 200 range (error), log an error message
          console.error('Failed to delete number:', response.status);
        }
      })
      .catch(error => {
        // Catch any network errors
        console.error('Error deleting number:', error);
      });
  }

  // Function to add a number
  function lisa() {
    const entity = {
      id: idRef.current.value,
      nimi: nimiRef.current.value,
      number: numberRef.current.value,
    };
  
    fetch('http://localhost:8080/api/numbrid', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(entity),
    })
      .then(response => response.json())
      .then(data => {
        setNumbrid(data);
      })
      .catch(error => {
        console.error('Error adding number:', error);
      });
  }
  

  return (
    <div className="App">
      <label>Numbri id</label> <br />
      <input ref={idRef} type="text" /> <br />
      <label>Numbri nimi</label> <br />
      <input ref={nimiRef} type="text" /> <br />
      <label>Numbrer</label> <br />
      <input ref={numberRef} type="text" /> <br />
      <button onClick={() => lisa()}>Sisesta</button> <br />
      <br />

      {numbrid.length > 0 && numbrid.map(t => (
  <div key={t.id}>{t.nimi} <button onClick={() => kustuta(t.id)}>x</button></div>
))}
    </div>
  );
}

export default App;
