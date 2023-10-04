// You shouldn't have to modify this code since it only contains the communication between the server and your bot.
// Your code logic should be in ./Bot.ts.
import WebSocket from "ws";
import { Bot } from "./Bot";
import { GameMessage } from "./GameInterface";

const webSocket = new WebSocket("ws://0.0.0.0:8765");
let bot: Bot;

webSocket.onopen = (event: WebSocket.OpenEvent) => {
  bot = new Bot();
  if (process.env.TOKEN) {
    webSocket.send(
      JSON.stringify({ type: "REGISTER", token: process.env.TOKEN })
    );
  } else {
    webSocket.send(
      JSON.stringify({ type: "REGISTER", teamName: "MyBot TypeScript" })
    );
  }
};

webSocket.onmessage = (message: WebSocket.MessageEvent) => {
  const rawGameMessage = JSON.parse(message.data.toString());
  const gameMessage = new GameMessage(rawGameMessage);

  console.log(`Playing tick ${gameMessage.tick}`);

  webSocket.send(
    JSON.stringify({
      type: "COMMAND",
      tick: gameMessage.tick,
      actions: bot.getNextMoves(gameMessage),
    })
  );
};
