import type { NextApiRequest, NextApiResponse } from 'next'
import { insertText } from '../../util/dbconnect'

export default function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
    console.log(req.body);
    insertText(req.body);
    res.status(200).redirect("/");
}
