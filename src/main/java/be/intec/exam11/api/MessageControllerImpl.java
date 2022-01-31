package be.intec.exam11.api;

import be.intec.exam11.models.Message;
import be.intec.exam11.models.User;
import be.intec.exam11.repositories.MessageRepository;
import be.intec.exam11.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/messages")
public class MessageControllerImpl implements IMessageController {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Override
    @PostMapping(path = "/params")
    public String addNewMessageUsingRequestParams(@RequestParam Integer senderId,
                                                  @RequestParam Set<Integer> recipientIdSet,
                                                  @RequestParam String subject,
                                                  @RequestParam String content) {

Message message = new Message();
Optional<User> sender = userRepository.findById(senderId);
if (sender.isPresent()){
    List<User>recipients = userRepository.findAllById(recipientIdSet);
    message.setSender(sender.get());
    message.setRecipients(recipients);
    message.setContent(content);
    message.setSubject(subject);
    messageRepository.save(message);

}

        return message.getSubject();
    }

    @Override
    @PostMapping(path = "/json")
    public String addNewMessageUsingJSONData(@RequestBody Message message) {

        Optional<User> sender = userRepository.findById(message.getSender().getId());
        if (sender.isPresent()) {
            Message addedMessage = messageRepository.save(message);
            return addedMessage.getSubject();

        } else {
            return "The sender is not found";
        }

    }

    @Override
    @GetMapping(path = "/all")
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    @GetMapping(path = "/{message_id}")
    public Optional<Message> getMessageById(@PathVariable("message_id") Integer messageId) {
        Optional<Message> oMessage = messageRepository.findById(messageId);
        return oMessage;
    }
}
