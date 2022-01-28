FROM node:16

WORKDIR /app

COPY package*.json ./

RUN npm install

RUN NODE_ENV=production

COPY . .

RUN npm run build

ENV PORT=3000

EXPOSE 3000

CMD [ "npm", "start" ]