package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Ivan", "Ivanov","Ivanov@gmail.com");
      User user2 = new User("Petr", "Petrov", "Petr@gmail.com");
      Car car1 = new Car("Mazda", 3);
      Car car2 = new Car("Lada", 9);
      user1.setCar(car1);
      user2.setCar(car2);
      userService.add(user1);
      userService.add(user2);
      List<User> allUsers = userService.listUsers();
      for(User u : allUsers){
         System.out.println(u);
      }

      User screachUser = userService.getUserByCar("Lada", 9);
      System.out.println(screachUser);

      context.close();
   }
}
