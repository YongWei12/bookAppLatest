package com.example.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class BookstoreApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void BcryptGenerator(){

				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				String rawPassword1 = "password1";
				String rawPassword2 = "adminpass";

				String encodedPassword1 = encoder.encode(rawPassword1);
				String encodedPassword2 = encoder.encode(rawPassword2);
				System.out.println("password1 hash: " + encodedPassword1);
				System.out.println("adminpass hash: " + encodedPassword2);

	}

}
