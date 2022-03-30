import { useEffect, useState } from "react";

export function Counter({ initCount = 5 }: { initCount?: number }) {
  const countKey = "countKey";
  const [count, setCount] = useState(initCount);

  let count2: number = 20;

  useEffect(() => {
    localStorage.getItem(countKey);
    const countExist = localStorage.getItem(countKey);
    setCount(countExist ? parseInt(countExist) : 200);
  }, []);

  function handleIncrease() {
    const newCount = count + 1;
    localStorage.setItem(countKey, String(newCount));
    setCount(newCount);
  }

  function handleDecrease() {
    const newCount = count - 1;
    localStorage.setItem(countKey, String(newCount));
    setCount(newCount);
  }

  return (
    <>
      <h1>{count}</h1>
      <button onClick={handleIncrease}>+</button>
      <button onClick={handleDecrease}>-</button>
    </>
  );
}
