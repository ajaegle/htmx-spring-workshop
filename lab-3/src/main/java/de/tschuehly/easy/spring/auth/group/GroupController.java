package de.tschuehly.easy.spring.auth.group;

import de.tschuehly.easy.spring.auth.group.management.GroupManagement;
import de.tschuehly.spring.viewcomponent.jte.ViewContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GroupController {
  private final GroupService groupService;
  private final GroupManagement groupManagement;

  public GroupController(GroupService groupService, GroupManagement groupManagement) {
    this.groupService = groupService;
    this.groupManagement = groupManagement;
  }

  @GetMapping("/groupManagement")
  public ViewContext groupManagement(){
    return groupManagement.render();
  }
}
