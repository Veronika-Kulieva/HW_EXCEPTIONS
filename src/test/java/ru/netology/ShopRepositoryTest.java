package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Платье", 10_000);
        Product product2 = new Product(2, "Туфли", 20_000);
        Product product3 = new Product(3, "Сумка", 40_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.remove(2);

        Product[] actual = repository.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Платье", 10_000);
        Product product2 = new Product(2, "Туфли", 20_000);
        Product product3 = new Product(3, "Сумка", 40_000);

        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        //repository.remove(4);

        //Product[] actual = repository.findAll();
        //Product[] expected = {product1, product2, product3};

        //Assertions.assertArrayEquals(expected, actual); // тест не пройден

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.remove(4)
        ); // вызвали исключение и тест прошел

    }

}