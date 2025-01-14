package de.tschuehly.easy.spring.auth.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public final static List<EasyUser> easyUserList = new ArrayList<>();

  public List<EasyUser> findAll() {
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return easyUserList;
  }

  public EasyUser createUser(String username, String password) {
    EasyUser newUser = new EasyUser(
        username,
        password
    );
    easyUserList.add(newUser);
    return newUser;
  }


  public EasyUser findById(UUID uuid) {
    return easyUserList.stream().filter(it -> Objects.equals(uuid, it.uuid)).findFirst()
        .orElseThrow(() -> new RuntimeException("User Not Found"));
  }

  public EasyUser saveUser(UUID uuid, String username, String password) {
    EasyUser userToUpdate = findById(uuid);
    EasyUser newUser = new EasyUser(
        userToUpdate.uuid,
        username,
        password
    );
    easyUserList.set(
        easyUserList.indexOf(userToUpdate),
        newUser
    );
    return newUser;
  }
}
