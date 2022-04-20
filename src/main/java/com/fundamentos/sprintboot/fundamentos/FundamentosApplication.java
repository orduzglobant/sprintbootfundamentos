package com.fundamentos.sprintboot.fundamentos;

import com.fundamentos.sprintboot.fundamentos.bean.MyBean;
import com.fundamentos.sprintboot.fundamentos.bean.MyBeanCar;
import com.fundamentos.sprintboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.sprintboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.sprintboot.fundamentos.component.ComponentDependency;
import com.fundamentos.sprintboot.fundamentos.component.ComponentImplement;
import com.fundamentos.sprintboot.fundamentos.entity.User;
import com.fundamentos.sprintboot.fundamentos.pojo.UserPojo;
import com.fundamentos.sprintboot.fundamentos.repository.UserRepository;
import com.fundamentos.sprintboot.fundamentos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanCar myBeanCar;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;
	@Autowired
	private UserService userService;

	@Autowired
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean,
								  MyBeanWithDependency myBeanWithDependency,
								  MyBeanCar myBeanCar,
								  MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo,
								  UserRepository userRepository) {

		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanCar = myBeanCar;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		//saveUsersInDatabase();
		//getInformationJpqlFromUser("daniela@domain.com");
		saveWithErrorTransactional();
	}

	private void getInformationJpqlFromUser(String email){
		//LOGGER.info("USUARIO 1 CON QUERY JPQL" + userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("No se encontro el usuario")));


		//userRepository.findAndSort("J", Sort.by("id").descending()).forEach(user -> LOGGER.info("Usuario con metodo sort" +user));

		//userRepository.findByName("Jose").stream().forEach(user -> log.info("Usuario :"+user.getName()));

		//log.info(String.valueOf(userRepository.findByEmailAndName("daniela@domain.com","Daniela").orElseThrow(()-> new RuntimeException("No encontro al usuario"))));

		//userRepository.findByNameLikeOrderByIdAsc("%J%").stream().forEach(user -> log.info("User name findByNameLikeOrderByIdAsc:"+user.getName()));

		//userRepository.findByEmailAndName(null,"Jose").stream().forEach(user -> log.info("User name findByEmailAndName:"+user.getName()));

		//userRepository.findByBirthDateBetween(LocalDate.of(2021,1,1),LocalDate.of(2021,3,15))
		//		.stream().forEach(user -> log.info("findByBirthDateBetween:"+user.getName()));

		userRepository.findByNameContainingOrderByIdDesc("Jo").stream().forEach(user -> log.info("findByNameLikeOrderByIdDesc"+user));

		log.info(String.valueOf(userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021,3,13),"john@domain.com").
				orElseThrow(() -> new RuntimeException("No se encontro usuario getAllByBirthDateAndEmail"))));
	}

	private void ejemplosAnteriores() {
		componentDependency.saludar();
		ComponentImplement componentImplement = new ComponentImplement();
		componentImplement.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanCar.encender());
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+" - "+ userPojo.getPassword());
		try {
			int value = 10/0;
			LOGGER.debug("Esto es un error de division");
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero "+e.getStackTrace());
		}
	}

	private void saveUsersInDatabase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("James", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Jose", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));

		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6,user7, user8, user9);
		list.forEach(userRepository::save);
		//list.stream().forEach(userRepository::save);
		//userRepository.saveAll(list);
	}

	private void saveWithErrorTransactional(){
		User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
		User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
		User test3 = new User("TestTransactional3", "TestTransactional3@domain.com", LocalDate.now());
		User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());

		List<User> users = Arrays.asList(test1,test2,test3,test4);


		try {
			userService.saveTransactional(users);

		}catch (Exception e){
			log.info("Este es un error del metodo transaccional "+e.getMessage());
		}

		userService.getAllUsers().stream().forEach(user -> log.info("este es el usuario dentro del metodo transaccional : "+user));


	}
}
