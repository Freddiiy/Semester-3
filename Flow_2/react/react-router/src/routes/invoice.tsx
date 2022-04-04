import { useParams } from "react-router-dom";
import { getInvoice } from "../data";

export default function Invoice() {
  let params = useParams();
  if (params.invoiceId === undefined) return;

  let invoice = getInvoice(parseInt(params.invoiceId, 10));
  return <h2>Invoice: {params.invoiceId}</h2>;
}
