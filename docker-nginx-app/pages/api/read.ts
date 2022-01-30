import type { NextApiRequest, NextApiResponse } from 'next'
import { getText } from '../../util/dbconnect'

export default function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
    getText().then((result) => {
        res.status(200).json(result);
    }).catch((err) => {
        console.log(err);
        res.status(500).end();
    }).finally(() => {
        res.end();
    })
}
