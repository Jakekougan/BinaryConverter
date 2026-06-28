import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

function InputPage() {
  const handleSubmit = async (event) => {
    event.preventDefault();
    const form = new FormData(event.target);
    const inputValue = form.get('number');
    const conversionType = form.get('conversion');

    const requestBody = {
      data: inputValue,
      fromFmt: conversionType === 'base10-to-binary' ? 'base10' : 'binary',
      toFmt: conversionType === 'base10-to-binary' ? 'binary' : 'base10'
    };

    try {
      const response = await fetch("http://localhost:8080/api/get-data", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(requestBody)
      });
      const data = await response.json();
      console.log(data);
      root.render(<OutputPage output={data} />)

    }
    catch (error) {
      console.error("Error performing operation", error)
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <h1>Base 10 to Binary</h1>
        <label>
          <input type="radio" name="conversion" value="base10-to-binary" defaultChecked />
          Base 10 to Binary
        </label>
        <label>
          <input type="radio" name="conversion" value="binary-to-base10" />
          Binary to Base 10
        </label>
      </div>
      <div>
        <header>
          Input your number here
        </header>
        <input type="text" name="number" />
      </div>
      <div>
        <button type="submit">Convert</button>
      </div>
    </form>
  )
}


function OutputPage({ output }) {
  const display = output?.value ?? (output ? JSON.stringify(output) : null);
  return (
    <div class="output">
      <p>{display || 'There is nothing here to display yet. Please be patient.'}</p>
      <button onClick={() => root.render(<InputPage />)}>Press me to go Home</button>
    </div>
  )
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <InputPage />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
