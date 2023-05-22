import './App.css';
import React, { useEffect, useState } from 'react';


function App() {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await fetch('http://localhost:82/listAjaxData');
      const jsonData = await response.json();
      setData(jsonData);
    } catch (error) {
      console.log('데이터를 가져오는 중 에러가 발생했습니다:', error);
    }
  };

  return (
    <div className="App-header">
      {data ? (
        <table border="1">
          {data.map((item) => (
            <tr key={item.book_id}>
            <td>{item.book_id}</td>
            <td>{item.title}</td>
            </tr>
          ))}
        </table>
      ) : (
        <p>데이터를 로딩 중입니다..ㅠ</p>
      )}
    </div>
  );
}

export default App;