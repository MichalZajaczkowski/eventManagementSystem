package com.michal.eventmanagementsystem;

public class ToDoBoPotemSieZgubi {

    //TODO:
    //1. Wstrzykiwanie zależności przez konstruktor, kiedyś na LinkedIn Co wysłałem linka do tego.
    //2. Nazewnictwo i konwencja endpointow do zmiany ;) Pamiętaj że możesz mieć te same endpointy dla
    // @GetMapiing i @DeleteMapping spring to rozróżnia I nie będzie konfliktów.
    //
    //3. Zwrotki z kontrolerów możesz opakować w ResponseEntity i zwracasz statusy np created itp. nie zwracasz wtedy
    // nic nie mówiących wartości 1 lub 0 jak masz w patchu. https://sztukakodu.pl/jak-definiowac-kody-http-odpowiedzi-w-springu/
    //4. Jakaś warstwa pośrednia by się przydała nie stukamy z controllera do do repository tylko można jakiś pośredni service zrobić.
    //5. Przydało by się jakieś DTO i mapowanie żeby na front zwracać przekonwertowany obiekt a nie bazodanowa encje.
    // Czyli np w kontrolerze zwracasz PlaceAddressDTO i service malujesz PlaceAddress pobierane z repository na DTO.
}
