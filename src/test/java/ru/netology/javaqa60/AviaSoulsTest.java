package ru.netology.javaqa60;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket(
            "Новосибирск",
            "Москва",
            10_000,
            6,
            10
    );
    Ticket ticket2 = new Ticket(
            "Новокузнецк",
            "Москва",
            5_000,
            7,
            8
    );
    Ticket ticket3 = new Ticket(
            "Москва",
            "Новосибирск",
            10_000,
            8,
            14
    );
    Ticket ticket4 = new Ticket(
            "Новосибирск",
            "Москва",
            14_000,
            6,
            10
    );

    Ticket ticket5 = new Ticket(
            "Новосибирск",
            "Москва",
            12_000,
            6,
            10
    );

    Ticket ticket6 = new Ticket(
            "Новосибирск",
            "Москва",
            12_000,
            3,
            10
    );

    Ticket ticket7 = new Ticket(
            "Новосибирск",
            "Москва",
            12_000,
            5,
            10
    );

    TicketTimeComparator timeComparator = new TicketTimeComparator();

    @Test
    public void shouldBeMoreCompareTo() {

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeLessCompareTo() {

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqualCompareTo() {

        int expected = 0;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortSearch() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] expected = {ticket1, ticket5, ticket4};
        Ticket[] actual = avia.search("Новосибирск", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeMoreComparator() {

        int expected = 1;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeLessComparator() {

        int expected = -1;
        int actual = timeComparator.compare(ticket2, ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqualComparator() {

        int expected = 0;
        int actual = timeComparator.compare(ticket4, ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortSearchAndSortBy() {

        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket6);
        avia.add(ticket7);

        Ticket[] expected = {ticket1, ticket7, ticket6};
        Ticket[] actual = avia.searchAndSortBy("Новосибирск", "Москва", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
