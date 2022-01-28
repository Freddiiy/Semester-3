import type { NextApiRequest, NextApiResponse } from 'next'
import { insertText } from '../../util/dbconnect'

export default function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
    insertText();
    res.status(200).send("Ok");
}
