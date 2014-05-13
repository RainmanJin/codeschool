package cn.fh.codeschool.controller;

import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fh.codeschool.model.CourseChapter;
import cn.fh.codeschool.model.CourseSection;
import cn.fh.codeschool.model.Member;
import cn.fh.codeschool.service.ChapterService;
import cn.fh.codeschool.service.SectionService;
import cn.fh.codeschool.service.ValidationService;

/**
 * 执行与 课程 有关页面的逻辑
 * @author whf
 *
 */
@Controller
public class LessonController {
	private static final Logger logger = LoggerFactory.getLogger(LessonController.class);
	
	@Autowired
	private ChapterService chapterService;

	@Autowired
	private SectionService sectionService;
	
	@Autowired
	private ValidationService validationService;
	
	/**
	 * 用户请求课程学习页面，将小节放到model中
	 * @return
	 */
	@RequestMapping(value = "/courses/start")
	public String startCourse(@RequestParam Integer sectionId, Model model) {
		CourseSection cs = sectionService.findSectionEager(sectionId);
		model.addAttribute("section", cs);

		return "/courses/course-content";
	}
	
	/**
	 * 验证处理用户代码
	 * @param reqMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/courses/start/submit-code", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody String validateCode(@RequestBody Map<String, Object> reqMap, HttpSession session) {
		// 取出参数
		String code = (String)reqMap.get("code");
		Integer sectionId = Integer.valueOf((String)reqMap.get("sectionId"));
		
		// 取出session中的Member
		Member m = (Member)session.getAttribute("currentUser");
		
		CourseSection cs = sectionService.findSection(sectionId);
		boolean result = validationService.process(cs, m, code);
		
		// 得到反馈信息
		String msg = validationService.getMessage();
		
		// 返回结果
		JsonObject json = Json.createObjectBuilder()
				.add("result", result) // 验证结果
				.add("message", msg) // 反馈信息
				.add("point", m.getPoint()) // 用户最新的分数
				.build();
		
		return json.toString();
	}
	
	/**
	 * 显示某一课程的所有章节，小节
	 * @return
	 */
	@RequestMapping(value = "/courses/list")
	public String showCourseList(@RequestParam Integer courseId, Model model, HttpServletRequest req) {
		List<CourseChapter> chapters = chapterService.chapterListEager(courseId);
		model.addAttribute("chapterList", chapters);
		
		return "/courses/course-list";
	}
}
