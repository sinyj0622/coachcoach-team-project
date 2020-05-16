package com.coachcoach.web.coachPage;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.coachcoach.domain.Coach;
import com.coachcoach.domain.CoachingProgram;
import com.coachcoach.domain.CoachingProgramTag;
import com.coachcoach.interceptor.Auth;
import com.coachcoach.interceptor.Auth.Role;
import com.coachcoach.service.CoachService;
import com.coachcoach.service.CoachingProgramService;
import com.coachcoach.service.CoachingProgramTagService;

@Auth(role = Role.COACH)
@Controller
@RequestMapping("/coachPage/programManagement")
public class ProgramManagementController {

  @Autowired
  HttpSession session;

  @Autowired
  ServletContext servletContext;

  @Autowired
  CoachService coachService;

  @Autowired
  CoachingProgramService coachingProgramService;

  @Autowired
  CoachingProgramTagService coachingProgramTagService;

  @PostMapping("addForm")
  public void addForm(Model model) throws Exception {
    model.addAttribute("coachNo", ((Coach) session.getAttribute("loginUser")).getNo());
  }

  @Transactional
  @PostMapping("add")
  public String add(CoachingProgram coachingProgram, @RequestParam("tags") int[] tags)
      throws Exception {
    List<CoachingProgramTag> selectedTags = new ArrayList<>();
    for (int i : tags) {
      selectedTags.add(new CoachingProgramTag().setTagNo(i));
    }
    coachingProgram.setCoachingProgramTags(selectedTags);
    if (coachingProgramService.add(coachingProgram) > 0) {
      coachingProgramTagService.add(coachingProgram);
      return "redirect:list";
    } else {
      throw new Exception(" 프로그램을 추가할 수 없습니다.");
    }
  }

  @Transactional
  @PostMapping("delete")
  public void delete(int programNo) throws Exception {
    if (coachingProgramService.deleteUpdate(programNo) > 0) {
    } else {
      throw new Exception("삭제할 게시물 번호가 유효하지 않습니다.");
    }
  }

  @GetMapping("detail")
  public void detail(int programNo, Model model) throws Exception {
    CoachingProgram coachingProgram = coachingProgramService.getDetail(programNo);
    coachingProgram.setCoachingProgramTags(coachingProgramTagService.list(programNo));
    model.addAttribute("program", coachingProgram);

  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    Coach coach = (Coach) session.getAttribute("loginUser");
    model.addAttribute("list", coachingProgramService.list(coach.getNo()));
    model.addAttribute("coachNo", coach.getNo());
  }

  @Transactional
  @PostMapping("update")
  public void update(CoachingProgram coachingProgram, @RequestParam("tags") int[] tags)
      throws Exception {
    List<CoachingProgramTag> selectedTags = new ArrayList<>();
    for (int i : tags) {
      selectedTags.add(new CoachingProgramTag().setTagNo(i));
    }
    coachingProgram.setCoachingProgramTags(selectedTags);
    if (coachingProgramService.update(coachingProgram) > 0) {
      coachingProgramTagService.deleteAll(coachingProgram.getNo());
      coachingProgramTagService.add(coachingProgram);
    } else {
      throw new Exception("프로그램을 추가할 수 없습니다.");
    }
  }

  @GetMapping("updateForm")
  public void updateForm(int programNo, Model model) throws Exception {
    model.addAttribute("program", coachingProgramService.getDetail(programNo));
  }

}
