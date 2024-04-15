import axios from 'axios';
import { RandomAlgorithms } from '../repository/Algorithms';

interface generateRandomMatrixRequestBody {
  numChanges: number,
  size: number,
  randomAlgorithm: RandomAlgorithms
}

export const generateRandomMatrix = async (data: generateRandomMatrixRequestBody) : Promise<number[][]> => {
  return (await axios.post("http://localhost:8080/api/v1/generate", data)).data;
}

