package com.codexa.data.coapserver;

import com.codexa.data.coapserver.api.CmdRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
public class CoapDataGeneratorApplication implements CommandLineRunner {

	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private CmdRunner cmdRunner;


	public static void main(String[] args) {
		SpringApplication.run(CoapDataGeneratorApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Arrays.asList(strings).stream().forEach(log::info);

		if (strings.length != 1) {
			log.info("First input argument is required : try (number of generated coap messages per thread) ");
			return;
		}

		String numberOfMessages = strings[0].toLowerCase();
		cmdRunner.writeGeneratedCoapData(number(numberOfMessages));
	}



	private Integer number(String str) {
		Integer result = 128;
		try {
			result = Integer.valueOf(str);
		} catch (NumberFormatException ex) {
			log.info("First argument must be a number but is not. " +
					"Application is running with default value " + result);
		}
		return result;
	}
}