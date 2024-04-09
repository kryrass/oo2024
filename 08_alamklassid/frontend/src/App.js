//import logo from './logo.svg';
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(); //HTMLs esinevad muutujad peavad olema useState sees
  const [toiduained, setToiduained] = useState([]);
  const nimiRef = useRef();
  const valkRef = useRef();
  const rasvRef = useRef();
  const sysivesikRef = useRef();
  const [toidukomponendid, setToidukomponendid] = useState([]);
  
  //reacti gookid: use eesliidessega, neide peab importima. reacti erikood
  //springis annotatsioonid: @RestController, @GetMapping. neid peab importima. springi erikood
  useEffect(() => {
    fetch('http://localhost:8080/toidukomponendid')
    .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
    .then(json =>  {
      setToidukomponendid(json);
    }) // body
  }, []);

  // uef -> JS: onLoad()
  useEffect(() => {
    fetch('http://localhost:8080/api/toiduained')
    .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
    .then(json =>  {
      setKogus(json.length);
      setToiduained(json);
    }) // body
  }, []);

 

function kustuta(primaarvoti) {
  fetch('http://localhost:8080/api/toiduained/' + primaarvoti, {"method": "DELETE"})
    .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
    .then(json =>  {
      setKogus(json.length);
      setToiduained(json);
  }) // body
}

function lisa(){
  const toiduaine = {
      "nimetus": nimiRef.current.value,
      "valk": valkRef.current.value,
      "rasv": rasvRef.current.value,
      "sysivesik": sysivesikRef.current.value
  }
  fetch('http://localhost:8080/api/toiduained', 
  {
    "method": "POST", 
    "body": JSON.stringify(toiduaine), 
    "headers": {"Content-Type": "application/json"}})
    .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
    .then(json =>  {
      setKogus(json.length);
      setToiduained(json);
  })
}


function kustutaTK(primaarvoti) {
  fetch('http://localhost:8080/toidukomponendid/' + primaarvoti, {"method": "DELETE"})
    .then(response => response.json()) // koos metadataga (headerid, staatuskood, OK)
    .then(json =>  {
      setToidukomponendid(json);
  }) // body
}

const taNimiRef = useRef();
const kogusRef = useRef();

function lisaTK() {
  const lisatavTK = {
    "toiduaine": {"nimetus": nimiRef.current.value},
    "kogus": kogusRef.current.value
  };

  fetch('http://localhost:8080/toidukomponendid', {
    method: "POST",
    body: JSON.stringify(lisatavTK),
    headers: {
      "Content-Type": "application/json"
    }
  })
  .then(response => response.json())
  .then(json => {
    setToidukomponendid(json);
  })
  .catch(error => {
    console.error('Error adding toidukomponent:', error);
  });
}


  return (
    <div className="App">
       Mul on {kogus} toiduainet
       <br /><br />

       <label>Toiduaine nimi</label> <br/>
       <input ref={nimiRef} type="text" /> <br/>
       <label>Toiduaine valk</label> <br/>
       <input ref={valkRef} type="text" /> <br />
       <label>Toiduaine rasv</label> <br/>
       <input ref={rasvRef} type="text" /> <br />
       <label>Toiduaine süsivesik</label> <br/>
       <input ref={sysivesikRef} type="text" /> <br />
       <button onClick={() => lisa()}>Sisesta</button> <br />
       <br />

      {toiduained.map(t => <div>{t.nimetus} | {t.valk} | {t.rasv} | {t.sysivesik} <button onClick={() => kustuta(t.nimetus)}>x</button></div>)}
<hr/>
      <label>Toidukomponendi nimi (Täpne nimi andmebaasist</label> <br/>
      <input ref={taNimiRef} type="text" /> <br />
      <label>Kogus</label> <br/>
       <input ref={kogusRef} type="text" /> <br />
       <button onClick={() => lisaTK()}>Sisesta</button> <br />
      {toidukomponendid.map(tk => <div>{tk.id} | {tk.toiduaine?.nimetus} | {tk.kogus} | <button onClick={() => kustutaTK(tk.id)}>x</button></div>)}

    </div>
  );
}

export default App;
