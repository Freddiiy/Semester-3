import type { NextPage } from "next"
import { useCallback, useEffect, useState } from "react"
import axios from "axios"

const Home: NextPage = () => {
  return (
    <>
      <InsertForm />
    </>
  )
}

function InsertForm() {
  const [formData, setFormData] = useState({
    text: "",
  })

  function handleChange(event: any) {
    const value = event.target.value
    setFormData({
      ...formData,
      [event.target.name]: value,
    })
  }

  const handleSubmit = useCallback(
    (event: any) => {
      event.preventDefault()

      const data = {
        text: formData.text,
      }

      axios.post("/api/insert", data)
      fetchData()

      formData.text = ""
    },
    [formData]
  )

  const [items, setItems] = useState([])

  async function fetchData() {
    axios.get("/api/read").then((res) => {
      setItems(res.data)
    })
  }

  useEffect(() => {
    fetchData()
  }, [])

  interface Items {
    id: number
    text: string
  }

  return (
    <>
      <ul>
        {items.map((item: Items) => (
          <li key={item.id}>
            {item.id} {item.text}
          </li>
        ))}
      </ul>

      <form>
        <label htmlFor="text">Insert text</label>
        <input
          type="text"
          name="text"
          id="text"
          value={formData.text}
          onChange={handleChange}
        ></input>
        <input type="submit" value="send" onClick={handleSubmit}></input>
      </form>
    </>
  )
}

export default Home
