package com.example.demoThymeleaf.controller;

import com.example.demoThymeleaf.business.DirectoryService;
import com.example.demoThymeleaf.business.HelloService;
import com.example.demoThymeleaf.business.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    // MVC : Modèle Vue Contrôleur
    // Modèle : contient les données à afficher ainsi que la logique en rapport avec les données
    // Vue : contient la présentation (partie visible) de l'interface graphique, se sert du modèle pour
    // afficher les données y provenant (fichier html)
    // Contrôleur : traite les actions de l'utilisateur (requête http), modifie les données du modèle et de la vue

    // 1. L'utilisateur fait une requête http au contrôleur
    // 2. Le contrôleur demande des données au modèle
    // 3. Le modèle retourne les données au contrôleur
    // 4. Le contrôleur transmet les données à la vue
    // 5. La vue renvoie la réponse http sous la forme d'une page html à l'utilisateur


    // Ici :
    // L'utilisateur fait une requête http de type GET via http://localhost:8080/hello sur HelloController
    // HelloController demande des données de la méthode sayHello à HelloService
    // HelloService lui renvoi les informations demandées = "Bonjour Marion !"
    // qui sont stockées dans le String "message"
    // HelloController transmet les données à hello.html
    // via l'attribut "monmessage" qui contient le String "message"
    // hello.html envoie une réponse http de la forme "'Mon message ' + ${monmessage}"
    // c'est à dire ici "Mon message Bonjour Marion !"

    @GetMapping("/hello")
    public String hello(Model model) {
        String message = helloService.sayHello();

        model.addAttribute("monmessage", message);

        return "hello.html";
    }

    // Ici :
    // L'utilisateur fait une requête http de type GET via http://localhost:8080/time sur HelloController
    // HelloController demande des données de la méthode sayTime à HelloService
    // HelloService lui renvoi les informations demandées = La date et l'heure au moment de la requête
    // qui sont stockées dans le String "message"
    // HelloController transmet les données à hello.html
    // via l'attribut "monmessage" qui contient le String "message"
    // hello.html envoie une réponse http de la forme "'Mon message ' + ${monmessage}"
    // c'est à dire ici "Mon message 2022-07-26T12:26:25" (par exemple)
    // La page étant dynamique, si je la recharge (sans relancer le serveur), la date et l'heure seront
    // mises à jour grace au return

    @GetMapping("/time")
    public String time(Model model) {
        String message = helloService.sayTime();

        model.addAttribute("monmessage", message);

        return "hello.html";
    }

    @Autowired
    DirectoryService directoryService;

    @GetMapping("/people")
    public String people(Model model){

        model.addAttribute("people", directoryService.getPeople());

        return "people.html";
    }

    @PostMapping("/people")
    public String addPerson(Person person, Model model) {

        directoryService.addPerson(person);
        model.addAttribute("people", directoryService.getPeople());

        return "people.html";
    }
}