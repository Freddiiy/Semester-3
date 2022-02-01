import type { NextPage } from "next";
import { useCallback, useEffect, useState } from "react";
import axios from "axios";
import {
  Container,
  ListGroup,
  ListGroupItem,
  Form,
  Button,
  Row,
  InputGroup,
} from "react-bootstrap";

const Home: NextPage = () => {
  return (
    <>
      <InsertForm />
    </>
  );
};

interface Items {
  id: number;
  text: string;
}

function InsertForm() {
  const [formData, setFormData] = useState({
    text: "",
  });

  const [send, setSend] = useState("");
  const [items, setItems] = useState<Items[]>([]);

  function handleChange(event: any) {
    const value = event.target.value;
    setFormData({
      ...formData,
      [event.target.name]: value,
    });
  }

  const handleSubmit = useCallback(
    (event: any) => {
      event.preventDefault();

      const data = {
        text: formData.text,
      };
      if (formData.text == "") return;

      axios
        .post("/api/insert", data)
        .then((res) => {
          if (res.status == 200) {
            setSend("sendt");
            const next: Items[] = [
              ...items,
              { id: event.target.text, text: formData.text },
            ];
            setItems(next);
            setFormData({ text: "" });
          }
        })
        .catch(() => {
          setSend("Ikke sendt");
        });
    },
    [formData, items]
  );

  async function fetchData() {
    axios.get("/api/read").then((res) => {
      setItems(res.data);
    });
  }

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <>
      <Container className="p-2">
        <div className="scroll-box">
          <ListGroup>
            {items.map((item: Items) => (
              <ListGroupItem key={item.id}>{item.text}</ListGroupItem>
            ))}
          </ListGroup>
        </div>
      </Container>
      <Container>
        <Form onSubmit={handleSubmit}>
          <InputGroup>
            <InputGroup.Text>Insert text</InputGroup.Text>
            <Form.Control
              name="text"
              type="text"
              placeholder="Skriv todo"
              value={formData.text}
              onChange={handleChange}
            />
            <Button type="submit">Send</Button>
          </InputGroup>
        </Form>
      </Container>
    </>
  );
}

export default Home;
