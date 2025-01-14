package edu.shop.demo.demoshop.controllers;

import edu.shop.demo.demoshop.domain.Client;
import edu.shop.demo.demoshop.exceptions.BadRequestException;
import edu.shop.demo.demoshop.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

    private final List<Client> clients = new ArrayList<>(
            Arrays.asList(
                    new Client("jek","123","Jose"),
                    new Client("val","123", "Valentina"),
                    new Client("Faaaaaarm", "222", "Fate")

            )
    );

    //Crud

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getClient(@PathVariable String userName)
    {

        if (userName.length() != 3)
        {
            throw new BadRequestException("Bad request!");
        }

        for (Client c : clients){
            if (c.getUserName().equalsIgnoreCase(userName)){
                return ResponseEntity.ok(c);
            }
        }

        throw new ResourceNotFoundException("Client not found " + userName);
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client)
    {
        clients.add(client);

        //Obtener url servicio
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userName}")
                .buildAndExpand(client.getUserName())
                .toUri();

        return ResponseEntity.created(location).body(client);
    }

    @PutMapping
    public ResponseEntity<?> updateClient(@RequestBody Client client)
    {
        for (Client c : clients){
            if (c.getUserName().equalsIgnoreCase(client.getUserName())){
                c.setName(client.getName());
                c.setPassword(client.getPassword());
                c.setUserName(client.getUserName());

                return ResponseEntity.ok(c);
            }
        }

        throw new ResourceNotFoundException("Client not found " + client);
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<?> deleteClient(@PathVariable String userName)
    {
        for (Client c : clients){
            if (c.getUserName().equalsIgnoreCase(userName)){
                clients.remove(c);
                return ResponseEntity.noContent().build();
            }
        }

        throw new ResourceNotFoundException("Client not found " + userName);
    }

}
