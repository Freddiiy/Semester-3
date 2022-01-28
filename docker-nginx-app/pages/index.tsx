import type { NextPage } from "next"
import Head from "next/head"
import Image from "next/image"
import { useEffect, useState } from "react"
import styles from "../styles/Home.module.css"
import { getText } from "../util/dbconnect"
import axios from "axios"

const Home: NextPage = () => {
  const [text, setText] = useState("")
  const [loaded, setLoaded] = useState(false)

  useEffect(() => {
    axios.get("/api/db").then((res) => {
      setText(res.data)
      setLoaded(true)
    })
  }, [])

  return (
    <>
      <h1>from db: {loaded ? text : "not loaded"}</h1>
    </>
  )
}

export default Home
