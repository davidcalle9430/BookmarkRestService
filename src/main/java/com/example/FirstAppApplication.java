package com.example;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import entities.Account;
import entities.Booking;
import entities.Bookmark;
import repositories.AccountRepository;
import repositories.BookingRepository;
import repositories.BookmarkRepository;

@SpringBootApplication
@EntityScan(basePackages = {"entities","restcontrollers"})
@EnableJpaRepositories(basePackages={"repositories"})
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={"com.example","restcontrollers"})
public class FirstAppApplication {
	@Autowired
	BookingRepository bookingRepository;
    public static void main(String[] args) {
        SpringApplication.run(FirstAppApplication.class, args);
        
    }
}
@Component
class BookingCommandLineRunner implements CommandLineRunner{
	@Override
	public void run(String... arg0) throws Exception {
		Booking booking = new Booking("Harry Potter");
		this.bookingRepository.save(booking);
		Booking second = new Booking("Hunger Games");
		this.bookingRepository.save(second);
		
		
		Arrays.asList(
				"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong,davidcalle9430,armandochindoy".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,"password"));
							bookmarkRepository.save( new Bookmark(account,"http://bookmark.com/1/" + a, "Great Movie" ) );
							bookmarkRepository.save( new Bookmark(account, "http://bookmark.com/2/" + a, "Learn SpringBoot" ) );
							bookmarkRepository.save( new Bookmark(account, "http://bookmark.com/3/" + a, "The Hunger Games" ) );
							bookmarkRepository.save( new Bookmark(account, "http://bookmark.com/4/" + a, "Xenoblade Chronicles X walkthrough" ) );
						}
						);
		Collection<Account> accounts = accountRepository.findAll();
		for (Account account : accounts) {
			System.out.println(account.toString());
			Collection<Bookmark> bookmarks = bookmarkRepository.findByAccountUsername(account.getUsername());
			for (Bookmark bookmark : bookmarks) {
				System.out.println("    "+ bookmark.toString());
			}
		}
		
		
	}
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	BookmarkRepository bookmarkRepository;
	
}
