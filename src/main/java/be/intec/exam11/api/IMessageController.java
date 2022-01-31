package be.intec.exam11.api;

import be.intec.exam11.models.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IMessageController {

    @PostMapping( path = "/params" )
    // Map ONLY POST Requests
    String addNewMessageUsingRequestParams( @RequestParam Integer senderId,
                                            @RequestParam Set< Integer > recipientIdSet,
                                            @RequestParam String subject,
                                            @RequestParam String content );

    @PostMapping ( path = "/json" )
    // Map ONLY POST Requests
    String addNewMessageUsingJSONData( @RequestBody Message message );


    @GetMapping( path = "/all" )
    List< Message > getAllMessages();


    @GetMapping ( path = "/{message_id}" )
    Optional< Message > getMessageById( @PathVariable( "message_id" ) Integer
                                                messageId );
}