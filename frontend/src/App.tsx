import { useState, useEffect } from 'react';
import { generateRandomMatrix } from './api/matrix';
import { RandomAlgorithms } from './repository/Algorithms';
import './App.css'

function App() {
  const [matrizSize, setMatrixSize] = useState<number>();
  const initialMatrix = Array.from({ length: matrizSize ? matrizSize : 0 }, () =>
    Array.from({ length: matrizSize ? matrizSize : 0 }, () => 0)
  );
  const [matrix, setMatrix] = useState(initialMatrix);
  const [showOneCells, setShowOneCells] = useState(false);
  const [gameStarted, setGameStarted] = useState(false);
  const [score, setScore] = useState<number>(0);

  useEffect(() => {
    const emptyMatrix = Array.from({ length: 25 }, () =>
      Array.from({ length: 25 }, () => 0)
    );
    setMatrix(emptyMatrix);
  }, []);

  const generateRandomMatrixHandler = async (event: React.FormEvent) => {
    event.preventDefault();
    const matrix = await generateRandomMatrix({
      numChanges: 90,
      size: 25,
      randomAlgorithm: RandomAlgorithms.MIX_MAX
    });
    setMatrix(matrix);
    setGameStarted(true);
  };

  return (
    <div className="container">
      {/* Formulario en la parte izquierda */}
      <div className="formContainer">
        <h1>Minesweeper 💣</h1>
        <form className="form">
          <button
            type="submit"
            className="submitButton"
            onClick={generateRandomMatrixHandler}
          >
            Start
          </button>
        </form>
        <form className="form">
          <button
            type="submit"
            className="submitButton"
            onClick={() => {
              window.location.reload();
            }}
          >
            Restart
          </button>
        </form>
      </div>

      {/* Matriz de 30x30 en la parte derecha */}
      <div className="matrixContainer">
        <table className="matrixTable">
          <tbody>
            {matrix.map((row, rowIndex) => (
              <tr key={rowIndex}>
                {row.map((cell, colIndex) => (
                  <td
                    key={colIndex}
                    className="matrixCell"
                    onClick={() => {
                      if (cell === 1) {
                        setShowOneCells(true);
                        alert(`Your score is ${score}`);
                      } else {
                        if(!showOneCells && gameStarted) setScore(score + 1);
                      }
                    }}
                    style={{
                      backgroundColor:
                        showOneCells && cell === 1 ? 'red' : 'azure'
                    }}
                  >
                    {showOneCells && cell === 1 ? '1' : '?'}
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
        <p>score {score}</p>
      </div>
    </div>
  );
}


export default App
