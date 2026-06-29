import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

function InputPage({ onResult }) {
  const [inputValue, setInputValue] = useState('');
  const [conversionType, setConversionType] = useState('base10-to-binary');
  const [feedback, setFeedback] = useState('');
  const [error, setError] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (event) => {
    event.preventDefault();
    setError('');
    setFeedback('Processing conversion...');
    setLoading(true);

    const requestBody = {
      data: inputValue,
      fromFmt: conversionType === 'base10-to-binary' ? 'base10' : 'binary',
      toFmt: conversionType === 'base10-to-binary' ? 'binary' : 'base10'
    };

    try {
      const response = await fetch('http://localhost:8080/api/get-data', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
      });

      if (!response.ok) {
        throw new Error(`Server error ${response.status}`);
      }

      const data = await response.json();
      setLoading(false);
      setFeedback('Conversion completed');
      onResult(data);
    } catch (err) {
      console.error('Error performing operation', err);
      setLoading(false);
      setError('Unable to convert this input. Please try again with a valid number.');
      setFeedback('');
    }
  };

  return (
    <div className="page-shell">
      <div className="card">
        <div className="card-title">
          <h1>Binary Converter</h1>
          <p>Convert quickly between Base 10 and Binary.</p>
        </div>

        <form className="converter-form" onSubmit={handleSubmit}>
          <div className="selection-row">
            <label className="radio-label">
              <input
                type="radio"
                name="conversion"
                value="base10-to-binary"
                checked={conversionType === 'base10-to-binary'}
                onChange={() => setConversionType('base10-to-binary')}
              />
              Base 10 → Binary
            </label>
            <label className="radio-label">
              <input
                type="radio"
                name="conversion"
                value="binary-to-base10"
                checked={conversionType === 'binary-to-base10'}
                onChange={() => setConversionType('binary-to-base10')}
              />
              Binary → Base 10
            </label>
          </div>

          <label className="field-label" htmlFor="number-input">
            Enter a number
          </label>
          <input
            id="number-input"
            className="text-input"
            type="text"
            name="number"
            value={inputValue}
            onChange={(event) => setInputValue(event.target.value)}
            placeholder={conversionType === 'base10-to-binary' ? 'e.g. 42' : 'e.g. 101010'}
          />

          {error && <div className="feedback error">{error}</div>}
          {feedback && !error && <div className="feedback status">{feedback}</div>}

          <button className="primary-button" type="submit" disabled={loading || !inputValue.trim()}>
            {loading ? 'Converting...' : 'Convert'}
          </button>
        </form>
      </div>
    </div>
  );
}

function OutputPage({ output, onBack }) {
  const display = output?.value ?? JSON.stringify(output, null, 2);

  return (
    <div className="page-shell">
      <div className="card result-card">
        <div className="card-title">
          <h1>Result</h1>
          <p>Here is your converted value.</p>
        </div>

        <div className="result-box">
          <pre>{display}</pre>
        </div>

        <button className="secondary-button" type="button" onClick={onBack}>
          Convert another number
        </button>
      </div>
    </div>
  );
}

function App() {
  const [output, setOutput] = useState(null);

  return output ? <OutputPage output={output} onBack={() => setOutput(null)} /> : <InputPage onResult={setOutput} />;
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

reportWebVitals();

