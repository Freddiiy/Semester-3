import type { NextPage } from "next"
import Head from "next/head"
import Image from "next/image"
import { useEffect, useState } from "react"
import styles from "../styles/Home.module.css"
import { getText } from "../util/dbconnect"
import axios from "axios"

const Home: NextPage = () => {
  return (
    <>
      <List />
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

  function handleSubmit(event: any) {
    event.preventDefault()
    const form = event.currentTarget

    const data = {
      text: formData.text,
    }

    axios.post("/api/insert", data)
  }
  return (
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
  )
}

function List() {
  const [loaded, setLoaded] = useState(false)
  const [items, setItems] = useState([])

  useEffect(() => {
    axios
      .get("/api/db")
      .then((res) => {
        setItems(res.data)
      })
      .then(() => {
        setLoaded(true)
      })
  }, [])

  return (
    <>
      <ul>
        {items.map((item) => (
          <li key={item}>cock</li>
        ))}
      </ul>
    </>
  )
}

export default Home
