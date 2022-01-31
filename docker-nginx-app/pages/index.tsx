import type { NextPage } from "next"
import { useCallback, useEffect, useRef, useState } from "react"
import axios from "axios"
import { text } from "stream/consumers"

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

  interface Items {
    id: number
    text: string
  }

  const [send, setSend] = useState("")
  const [items, setItems] = useState<Items[]>([])
  const listItems = useRef<Items>()

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
      if (formData.text == "") return

      axios
        .post("/api/insert", data)
        .then((res) => {
          if (res.status == 200) {
            setSend("sendt")
            const next: Items[] = [
              ...items,
              { id: event.target.text, text: formData.text },
            ]
            setItems(next)
            setFormData({ text: "" })
          }
        })
        .catch(() => {
          setSend("Ikke sendt")
        })
    },
    [formData, items]
  )

  async function fetchData() {
    axios.get("/api/read").then((res) => {
      setItems(res.data)
    })
  }

  useEffect(() => {
    fetchData()
  }, [])

  return (
    <>
      <ul>
        {items.map((item: Items) => (
          <li key={item.id}>{item.text}</li>
        ))}
      </ul>

      <p>{send}</p>
      <form onSubmit={handleSubmit}>
        <label htmlFor="text">Insert text</label>
        <input
          type="text"
          name="text"
          id="text"
          value={formData.text}
          onChange={handleChange}
        ></input>
        <input type="submit" value="send"></input>
      </form>
    </>
  )
}

export default Home
