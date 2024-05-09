package de.tschuehly.easy.spring.auth.user;

import static de.tschuehly.easy.spring.auth.user.management.UserManagement.CLOSE_MODAL_EVENT;
import static de.tschuehly.easy.spring.auth.user.management.table.UserTableComponent.USER_TABLE_BODY_ID;

import de.tschuehly.easy.spring.auth.user.management.UserManagement;
import de.tschuehly.easy.spring.auth.user.management.create.CreateUserComponent;
import de.tschuehly.easy.spring.auth.user.management.edit.EditUserComponent;
import de.tschuehly.easy.spring.auth.user.management.table.row.UserRowComponent;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private final UserService userService;
  private final UserManagement userManagement;
  private final EditUserComponent editUserComponent;
  private final UserRowComponent userRowComponent;
  private final CreateUserComponent createUserComponent;

  public UserController(UserService userService, UserManagement userManagement, EditUserComponent editUserComponent,
      UserRowComponent userRowComponent, CreateUserComponent createUserComponent) {
    this.userService = userService;
    this.userManagement = userManagement;
    this.editUserComponent = editUserComponent;
    this.userRowComponent = userRowComponent;
    this.createUserComponent = createUserComponent;
  }

  @GetMapping("/")
  public ViewContext index() {
    return userManagement.render();
  }

  public static final String POST_SAVE_USER = "/save-user";
  public static final String GET_EDIT_USER_MODAL = "/save-user/modal/{uuid}";

  @GetMapping(GET_EDIT_USER_MODAL)
  public ViewContext editUserModal(@PathVariable UUID uuid) {
    return editUserComponent.render(uuid);
  }

  @PostMapping(POST_SAVE_USER)
  public ViewContext saveUser(UUID uuid, String username, String password) {
    EasyUser user = userService.saveUser(uuid, username, password);
    return userRowComponent.rerender(user);
  }


  public static final String POST_CREATE_USER = "/create-user";
  public static final String GET_CREATE_USER_MODAL = "/create-user/modal";

  @GetMapping(GET_CREATE_USER_MODAL)
  public ViewContext getCreateUserModal() {
    return createUserComponent.render();
  }

  @PostMapping(POST_CREATE_USER)
  public ViewContext createUser(String username, String password) {
    EasyUser user = userService.createUser(username, password);
    return userRowComponent.renderNewRow(user);
  }

}
