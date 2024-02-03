package com.rin.redispractice.redisRepository;

import com.rin.redispractice.RedisRepository.Person;
import com.rin.redispractice.RedisRepository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisRepositoryTests {
    @Autowired
    private PersonRepository personRepository;

    @Test
    void test() {
        Person person = new Person("Giraffe", "Kim");
        personRepository.save(person);

        Person person2 = new Person("turtle", "Kim");
        personRepository.save(person2);

        personRepository.findById(person.getId());
//        personRepository.delete(person);
    }
}
