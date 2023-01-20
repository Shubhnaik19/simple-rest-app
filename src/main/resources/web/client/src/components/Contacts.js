import axios from 'axios';
import React, { useEffect, useState } from 'react';


const Contact = () => {
    const [allContacts,setAllContacts] = useState([]);

    useEffect(() => {
      fetchQuotes();
    }, []);

  
  
    const fetchQuotes = async () => {
          try {
              const res = await axios.get(`/clients/getAllContacts`);
              setAllContacts(res.data);
          } catch (err) {
              console.log(err);
          }
      };
    return (
    <div>
    <h1>
        lets make some Good projects 

        {JSON.stringify(allContacts)}
    
    </h1>
    </div>
    )
}

export default Contact