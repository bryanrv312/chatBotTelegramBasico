package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



@Service
public class TelegramBoot extends TelegramLongPollingBot{//para que las app se comuniquen entre si, como websocket
	
	
	
	@Override
    public void onUpdateReceived(Update update) {
        // Se obtiene el mensaje escrito por el usuario
        final String messageTextReceived = update.getMessage().getText();

        System.out.println("Escribieron en el bot " + messageTextReceived);

        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();
        
        System.out.println("Chat ID: " + chatId);
        
        // Se crea un objeto mensaje
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Gracias por escribirnos");
        
        
        if(messageTextReceived.equalsIgnoreCase("papu")) {
        	message.setText("escribiste papu no pillin xd");
        }
        

        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
	
	//pasamos el nombre del bot
	@Override
    public String getBotUsername() {
        return "bruman2_bot";
    }
	
	
	//padre de todos los bots botfather q crea token y permite crear bot y nos entrega una apikey para q interactue
    @Override
    public String getBotToken() {
        return "5493633754:AAEI_usc6jgXUMyvE165hrz0LwY_cVS_V4M";
    }

}
