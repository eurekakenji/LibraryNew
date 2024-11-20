package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.User;

import java.util.List;

public class UserAppHelper implements AppHelper<User> {
    private final Input input;

    public UserAppHelper(Input input) {
        this.input = input;
    }

    @Override
    public User create() {
        try {
            User user = new User();
            System.out.print("User name: ");
            user.setFirstName(input.nextLine());
            System.out.print("User surname: ");
            user.setLastName(input.nextLine());
            System.out.print("Phone number: ");
            user.setPhone(input.nextLine());
            return user;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean printList(List<User>users) {
        try {
            if(users.size() == 0) return false;
            for(int i = 0; i < users.size(); i++){
                System.out.printf("%d. %s %s. %s%n",
                        i+1,
                        users.get(i).getFirstName(),
                        users.get(i).getLastName(),
                        users.get(i).getPhone()
                );
            }
            return true;
        }catch (Exception e){
            System.out.println("Error: "+e.toString());
            return false;
        }
    }

    @Override
    public List<User> edit(List<User> users) {
        try {
            System.out.println("---- Editing User -----");
            this.printList(users);
            System.out.print("Choose user: ");
            int numberUser = Integer.parseInt(input.nextLine());
            System.out.println("Name: " + users.get(numberUser-1).getFirstName());
            System.out.print("Edit? (y/n): ");
            String choice = input.nextLine();
            if(choice.equals("y")){
                System.out.print("New name: ");
                users.get(numberUser-1).setFirstName(input.nextLine());
            }
            System.out.println("Surname: " + users.get(numberUser-1).getLastName());
            System.out.print("Edit? (y/n): ");
            choice = input.nextLine();
            if(choice.equals("y")){
                System.out.print("New surname: ");
                users.get(numberUser-1).setLastName(input.nextLine());
            }
            System.out.println("Phone number: " + users.get(numberUser-1).getLastName());
            System.out.print("Edit? (y/n): ");
            choice = input.nextLine();
            if(choice.equals("y")){
                System.out.print("New phone number: ");
                users.get(numberUser-1).setPhone(input.nextLine());
            }
            return users;
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
            return null;
        }

    }
}
