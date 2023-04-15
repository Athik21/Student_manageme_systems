package com.giri.manage.demo.student.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.websocket.Session;

import org.apache.commons.math3.linear.RRQRDecomposition;
import org.apache.poi.ss.usermodel.Row;
import org.apache.xmlbeans.impl.store.Cur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.giri.manage.demo.student.ExcelExport;
import com.giri.manage.demo.student.UserExcel3;
import com.giri.manage.demo.student.UserExcel4;
import com.giri.manage.demo.student.UserExcelExporter;
import com.giri.manage.demo.student.entity.Achievements;
import com.giri.manage.demo.student.entity.Attendance;
import com.giri.manage.demo.student.entity.Attendance3;
import com.giri.manage.demo.student.entity.Attendance4;
import com.giri.manage.demo.student.entity.Curriculum;
import com.giri.manage.demo.student.entity.FinalYear;
import com.giri.manage.demo.student.entity.Image;
import com.giri.manage.demo.student.entity.Professional;
import com.giri.manage.demo.student.entity.SecondYear;
import com.giri.manage.demo.student.entity.Teachers;
import com.giri.manage.demo.student.entity.ThirdYear;
import com.giri.manage.demo.student.entity.TimeSet;
import com.giri.manage.demo.student.entity.TimeTable;
import com.giri.manage.demo.student.entity.TimeTable3;
import com.giri.manage.demo.student.entity.TimeTable4;
import com.giri.manage.demo.student.repo.StudentRepo_sec_year;
import com.giri.manage.demo.student.service.AchieveService;
import com.giri.manage.demo.student.service.Attendance3Service;
import com.giri.manage.demo.student.service.Attendance4Service;
import com.giri.manage.demo.student.service.AttendanceService;
import com.giri.manage.demo.student.service.CourceService;
import com.giri.manage.demo.student.service.CurriculumService;
import com.giri.manage.demo.student.service.ExcelUploadFinal;
import com.giri.manage.demo.student.service.ExcelUploadSecond;
import com.giri.manage.demo.student.service.ExcelUploadThird;
import com.giri.manage.demo.student.service.IExcelDataService;
import com.giri.manage.demo.student.service.ImageService;
import com.giri.manage.demo.student.service.ProfessionalSer;
import com.giri.manage.demo.student.service.StudentService_final_year;
import com.giri.manage.demo.student.service.StudentService_sec_year;
import com.giri.manage.demo.student.service.StudentService_third_year;
import com.giri.manage.demo.student.service.Teacher_Services;
import com.giri.manage.demo.student.service.TimeSetService;
import com.giri.manage.demo.student.service.TimeTable3Service;
import com.giri.manage.demo.student.service.TimeTable4Service;
import com.giri.manage.demo.student.service.TimeTableService;
import com.giri.manage.demo.student.service.impl.IFileUploaderService;

import antlr.StringUtils;

@Controller
public class BaseController {
	@Autowired
	private StudentService_sec_year ser2;
	@Autowired
	private StudentService_third_year ser3;
	@Autowired
	private StudentService_final_year ser4;
	@Autowired
	private Teacher_Services tec_ser;
	@Autowired
	private CourceService cou_ser;
	@Autowired
	private CurriculumService curi_ser;
	@Autowired
	private TimeTableService time_ser;
	@Autowired
	private TimeSetService time_set;
	@Autowired
	private TimeTable3Service time3_ser;
	@Autowired
	private TimeTable4Service time4_ser;
	@Autowired
	private AttendanceService att_ser;
	@Autowired
	private Attendance3Service att_ser3;
	@Autowired
	private Attendance4Service att_ser4;
	@Autowired
	private TimeSetService tss;
	
	@RequestMapping("/")
	public String map(HttpSession session) {
		return "frontpage";
	}
	@RequestMapping("/list")
	public String list(HttpSession session) {
		session.setAttribute("what", "abcd");
		return "listofyear";
	}
	@RequestMapping("/listss")
	public String listss(HttpSession session) {
		session.setAttribute("what", 0);
		return "listofyear";
	}
	
	
	@RequestMapping("/student4")
	public String add(Model model){
		model.addAttribute("stude",ser4.getDetails());
		return "stu4";
	}
	
	@GetMapping("/student4/new")
	public String Create(Model model) {
		FinalYear student = new FinalYear();
		model.addAttribute("student",student);
		return "create4";
	}
	
	@PostMapping("/student4")
	public String saveStudent(@ModelAttribute("student") FinalYear student) {
		ser4.saveStudent(student);
		return "redirect:/student4";
	}
	@PostMapping("/find4")
	public String finding4(HttpServletRequest req,Model model) {
		String id= req.getParameter("id");
		model.addAttribute("student",ser4.findByRoll(id));
		return "details";
	}
	@RequestMapping("/teacher/edit/{id}")
	public String teacheredit(@PathVariable("id") int id,Model model) {
		model.addAttribute("teacher",tec_ser.findbyid(id));
		return "editteacher";
	}
	@PostMapping("/teacheredit/{id}")
	public String teacheredit(@PathVariable("id") int id,@ModelAttribute("teacher") Teachers teacher) {
		Teachers teachers = tec_ser.findbyid(id);
		teachers.setTecid(teacher.getTecid());
		teachers.setName(teacher.getName());
		teachers.setDisignation(teacher.getDisignation());
		teachers.setEmail(teacher.getEmail());
		teachers.setPhone(teacher.getPhone());
		teachers.setDob(teacher.getDob());
		teachers.setExperience(teacher.getExperience());
		tec_ser.savetec(teachers);
		return "redirect:/teachers";
	}
	@RequestMapping("/student4/edit/{id}")
	public String edit(@PathVariable("id") int id,Model model) {
		model.addAttribute("student",ser4.createById(id));
		return "edit4";
	}
	@PostMapping("/student4/{id}")
	public String updated(@PathVariable("id") int id,@ModelAttribute("student") FinalYear student){
		
		FinalYear student1 = ser4.createById(id);
		student1.setRoll(student.getRoll());
		student1.setName(student.getName());
		student1.setDob(student.getDob());
		student1.setFather(student.getFather());
		student1.setMother(student.getMother());
		student1.setPar_num(student.getPar_num());
		student1.setYear(student.getYear());
		student1.setPhone(student.getPhone());
		student1.setEmail(student.getEmail());
		student1.setAadhar(student.getAadhar());
		student1.setCast(student.getCast());
		student1.setRegulation(student.getRegulation());
		student1.setSem(student.getSem());
		student1.setAddress(student.getAddress());
		student1.setState(student.getState());
		student1.setTaluk(student.getTaluk());
		student1.setDistrict(student.getDistrict());
		student1.setPincode(student.getPincode());
		student1.setB_grp(student.getB_grp());
		student1.setGender(student.getGender());
		ser4.updateStudent(student1);
		return "redirect:/student4";
	}
	@RequestMapping("/student4/delete")
	public String deletebyid() {
		ser4.delete();
		return "upload4";
	}
	@RequestMapping("/student4/details/{id}")
	public String info4(@PathVariable("id") int id,Model model) {
		model.addAttribute("student",ser4.createById(id));
		return "details";
	}
	
	
	
	
	@RequestMapping("/student2")
	public String add2(Model model){
		model.addAttribute("stude",ser2.getDetails());
		return "stu2";
	}
	
	@GetMapping("/student2/new")
	public String Create2(Model model) {
		SecondYear student = new SecondYear();
		model.addAttribute("student",student);
		return "create2";
	}
	
	@PostMapping("/student2")
	public String saveStudent2(@ModelAttribute("student2") SecondYear student) throws IOException {
		
		ser2.saveStudent(student);
		return "redirect:/student2";
	}
	@PostMapping("/find2")
	public String finding(HttpServletRequest req,Model model) {
		String id= req.getParameter("id");
		model.addAttribute("student",ser2.findByRoll(id));
		return "details";
	}
	
	
	@RequestMapping("/student2/edit/{id}")
	public String edit2(@PathVariable("id") int id,Model model) {
		model.addAttribute("student",ser2.createById(id));
		return "edit2";
	}
	@PostMapping("/student2/{id}")
	public String updated2(@PathVariable("id") int id,@ModelAttribute("student") SecondYear student){
		SecondYear student1 = ser2.createById(id);
		student1.setRoll(student.getRoll());
		student1.setName(student.getName());
		student1.setDob(student.getDob());
		student1.setFather(student.getFather());
		student1.setMother(student.getMother());
		student1.setPar_num(student.getPar_num());
		student1.setYear(student.getYear());
		student1.setPhone(student.getPhone());
		student1.setEmail(student.getEmail());
		student1.setAadhar(student.getAadhar());
		student1.setCast(student.getCast());
		student1.setRegulation(student.getRegulation());
		student1.setSem(student.getSem());
		student1.setAddress(student.getAddress());
		student1.setState(student.getState());
		student1.setTaluk(student.getTaluk());
		student1.setDistrict(student.getDistrict());
		student1.setPincode(student.getPincode());
		student1.setB_grp(student.getB_grp());
		student1.setGender(student.getGender());
		ser2.updateStudent(student1);
		return "redirect:/student2";
	}
	@RequestMapping("/student2/delete")
	public String deletebyid2() {
		ser2.delete();
		return "upload";
	}
	@RequestMapping("/student2/details/{id}")
	public String info2(@PathVariable("id") int id,Model model) {
		model.addAttribute("student",ser2.createById(id));
		return "details";
	}
	
	@RequestMapping("/student3")
	public String add3(Model model){
		model.addAttribute("stude",ser3.getDetails());
		return "stu3";
	}
	
	@GetMapping("/student3/new")
	public String Create3(Model model) {
		ThirdYear student = new ThirdYear();
		model.addAttribute("student",student);
		return "create3";
	}
	
	@PostMapping("/student3")
	public String saveStudent3(@ModelAttribute("student") ThirdYear student) {
		ser3.saveStudent(student);
		return "redirect:/student3";
	}
	@PostMapping("/find3")
	public String finding3(HttpServletRequest req,Model model) {
		String id= req.getParameter("id");
		model.addAttribute("student",ser3.findByRoll(id));
		return "details";
	}
	@RequestMapping("/student3/edit/{id}")
	public String edit3(@PathVariable("id") int id,Model model) {
		model.addAttribute("student",ser3.createById(id));
		return "edit3";
	}
	@RequestMapping("/student3/details/{id}")
	public String info3(@PathVariable("id") int id,Model model) {
		model.addAttribute("student",ser3.createById(id));
		return "details";
	}
	@PostMapping("/student3/{id}")
	public String updated4(@PathVariable("id") int id,@ModelAttribute("student") ThirdYear student){
		
		ThirdYear student1 = ser3.createById(id);
		student1.setRoll(student.getRoll());
		student1.setName(student.getName());
		student1.setDob(student.getDob());
		student1.setFather(student.getFather());
		student1.setMother(student.getMother());
		student1.setPar_num(student.getPar_num());
		student1.setYear(student.getYear());
		student1.setPhone(student.getPhone());
		student1.setEmail(student.getEmail());
		student1.setAadhar(student.getAadhar());
		student1.setCast(student.getCast());
		student1.setRegulation(student.getRegulation());
		student1.setSem(student.getSem());
		student1.setAddress(student.getAddress());
		student1.setState(student.getState());
		student1.setTaluk(student.getTaluk());
		student1.setDistrict(student.getDistrict());
		student1.setPincode(student.getPincode());
		student1.setB_grp(student.getB_grp());
		student1.setGender(student.getGender());
		ser3.updateStudent(student1);
		return "redirect:/student3";
	}
	@RequestMapping("/student3/delete")
	public String deletebyid4() {
		ser3.delete();
		return "upload3";
	}
	
	
	@PostMapping("/validate2")
	public String validate2(HttpSession session,HttpServletRequest req) {
		String uname = req.getParameter("UserName");
		String password = req.getParameter("Password");
		if(uname.equals("gcesalem") && password.equals("12345abcde")) {
			session.setAttribute("msg", "gce");
			return "listofyear";
		}
		else {
			session.setAttribute("msg", 10);
			return "frontpage";
		}
	}
	
	@PostMapping("/validate")
	public String validate(HttpSession session,Model model,HttpServletRequest req) {
		String uname = req.getParameter("UserName");
		String password = req.getParameter("Password");
		int year = Integer.parseInt(req.getParameter("1"));
		session.setAttribute("yer", year);
		if(year==2) {
			String msg = ser2.auth(uname,password);
			if(msg.equals("valid")) {
				session.invalidate();
				model.addAttribute("student",ser2.findByuname(uname));
				return "works";
			}
			if(msg.equals("invalid")) {
				session.setAttribute("msg", 0);
			}
			if(msg.equals("notfound")) {
				session.setAttribute("msg", 1);
			}
		}
		if(year==3) {
			String msg = ser3.auth(uname,password);
			if(msg.equals("valid")) {
				session.invalidate();
				model.addAttribute("student",ser3.findByuname(uname));
				return "works";
			}
			if(msg.equals("invalid")) {
				session.setAttribute("msg", 0);
			}
			if(msg.equals("notfound")) {
				session.setAttribute("msg", 1);
			}
		}
		if(year==4) {
			String msg = ser4.auth(uname,password);
			if(msg.equals("valid")) {
				session.invalidate();
				model.addAttribute("student",ser4.findByuname(uname));
				return "works";
			}
			if(msg.equals("invalid")) {
				session.setAttribute("msg", 0);
			}
			if(msg.equals("notfound")) {
				session.setAttribute("msg", 1);
			}
		}
		return "redirect:/";
	}
	@PostMapping("/addimage/{uname}")
	public String addimage(@PathVariable("uname") String uname,HttpServletRequest req,HttpSession session,Model model,@RequestParam("fileimage") MultipartFile file) throws IOException {
		String year = uname.split(" ")[1];
		String name = uname.split(" ")[0];
		if(year.equals("2")) {
			ser2.saveimage(file, name);
			session.setAttribute("msg", "0");
			model.addAttribute("student",ser2.findByuname(name));
		}if(year.equals("3")) {
			ser3.saveimage(file, name);
			session.setAttribute("msg", "0");
			model.addAttribute("student",ser3.findByuname(name));
		}if(year.equals("4")) {
			ser4.saveimage(file, name);
			session.setAttribute("msg", "0");
			model.addAttribute("student",ser4.findByuname(name));
		}
		return "works";
	}
	@RequestMapping("/req/{year}")
	public String req(@PathVariable("year")String year,HttpSession session) {
		session.setAttribute("year", year);
		session.setAttribute("ms", 2);
		session.setAttribute("sets", -1);
		return "req";
	}
	@PostMapping("/change/{year}")
	public String changepassword(HttpSession session,@PathVariable("year") String year,Model model,HttpServletRequest req) {
		String uname = req.getParameter("uname");
		String old = req.getParameter("oldpass");
		String newo = req.getParameter("newpass");
		
		if(year.equals("2")){
		String msg = ser2.change(uname,old,newo);
		model.addAttribute("student",ser2.findByuname(uname));
		if(msg.equals("not")) {session.setAttribute("sets", 0);return "req";}
		if(msg.equals("noo")) {session.setAttribute("sets", 1);return "req";
		}else {return "works";}
		}
		if(year.equals("3")){
			String msg = ser3.change(uname,old,newo);
			model.addAttribute("student",ser3.findByuname(uname));
			if(msg.equals("not")) {session.setAttribute("sets", 0);return "req";}
			if(msg.equals("noo")) {session.setAttribute("sets", 1);return "req";
			}else {return "works";}
		}
		if(year.equals("4")){
			String msg = ser4.change(uname,old,newo);
			model.addAttribute("student",ser4.findByuname(uname));
			if(msg.equals("not")) {session.setAttribute("sets", 0);return "req";}
			if(msg.equals("noo")) {session.setAttribute("sets", 1);return "req";
			}else {return "works";}
		}return null;
	}
	//teacher management
	
	@RequestMapping("/teachers")
	public String tec_det(Model model) {
		model.addAttribute("teacher",tec_ser.getDetails());
		return "tec_det";
	}
	@GetMapping("/staff/new")
	public String Create_staff(Model model) {
		Teachers teacher = new Teachers();
		model.addAttribute("teacher",teacher);
		return "create_staff";
	}
	@PostMapping("/teachers")
	public String save_tec(@ModelAttribute("teacher") Teachers teacher) {
		if(teacher.getSub11()=="") {
			teacher.setSub11(" ");
		}if(teacher.getSub22()=="") {
			teacher.setSub22(" ");
		}if(teacher.getSub33()=="") {
			teacher.setSub33(" ");
		}
		tec_ser.savetec(teacher);
		return "redirect:/teachers";
	}
	@GetMapping("/teacher/details/{id}")
	public String det(@PathVariable("id") int id,Model model){
		model.addAttribute("teacher",tec_ser.find(id));
		return "teachersdetails";
	}
	@RequestMapping("/teacher/delete/{id}")
	public String delete_tec(@PathVariable("id") int id) {
		tec_ser.delete(id);
		return "redirect:/teachers";
	}
	
	
	//cource details
	@RequestMapping("/cources")
	public String cources(Model model) {
		model.addAttribute("cources",curi_ser.findall());
		return "cources";
	}
	@RequestMapping("/staffs")
	public String staf_details(Model model) {
		model.addAttribute("teacher",tec_ser.getDetails());
		return "Staffs";
	}
	@RequestMapping("/regulations")
	public String regulations() {
		return "regulations";
	}
	@GetMapping("/curriculum")
	public String curriculum(Model model,HttpServletRequest req,HttpSession session) {
		String reg = req.getParameter("reg");
		System.out.println(reg);
		session.setAttribute("reg", reg);
		return "curriculums";
	}
	@Autowired
	private ProfessionalSer pro_ser;
	@RequestMapping("/third/{year}/{reg}")
	public String getthird(HttpServletRequest req,Model model,@PathVariable("reg") String regu,@PathVariable("year") String yer,HttpSession session) {
		String[] yar = yer.split("=");
		String year = yar[0];
		if(yar.length==2) {year = yar[1];}
		String reg = regu;
		session.setAttribute("reg", reg);
		System.out.println(reg+"really");
		System.out.println(year);
		if(year.equals("3")) {
			model.addAttribute("third",curi_ser.findBySem("3",reg));
			model.addAttribute("prof",pro_ser.findBySem("3",reg));
		}
		if(year.equals("4")) {
			model.addAttribute("third",curi_ser.findBySem("4",reg));
			model.addAttribute("prof",pro_ser.findBySem("4",reg));
		}
		if(year.equals("5")) {
			model.addAttribute("third",curi_ser.findBySem("5",reg));
			model.addAttribute("prof",pro_ser.findBySem("5",reg));
		}
		if(year.equals("6")) {
			model.addAttribute("third",curi_ser.findBySem("6",reg));
			model.addAttribute("prof",pro_ser.findBySem("6",reg));
		}
		if(year.equals("7")) {
			model.addAttribute("third",curi_ser.findBySem("7",reg));
			model.addAttribute("prof",pro_ser.findBySem("7",reg));
		}
		if(year.equals("8")) {
			model.addAttribute("third",curi_ser.findBySem("8",reg));
			model.addAttribute("prof",pro_ser.findBySem("8",reg));
		}
		session.setAttribute("yer", year);
		return "third_display";
	}
	@GetMapping("/third/new/{year}")
	public String third(Model model,@PathVariable("year") String year,HttpSession session) {
		session.setAttribute("m", 0);
		String yer = year.split(" ")[0];
		String reg = year.split(" ")[1];
		session.setAttribute("reg", reg);
		System.out.println(yer);
		Curriculum third = new Curriculum();
		if(yer.equals("3")){third.setSem("3");third.setReg(reg);}
		if(yer.equals("4")){third.setSem("4");third.setReg(reg);}
		if(yer.equals("5")){third.setSem("5");third.setReg(reg);}
		if(yer.equals("6")){third.setSem("6");third.setReg(reg);}
		if(yer.equals("7")){third.setSem("7");third.setReg(reg);}
		if(yer.equals("8")){third.setSem("8");third.setReg(reg);}
		model.addAttribute("third",third);
		return "third"; 
	}@GetMapping("/prof/new/{year}")
	public String prof(Model model,@PathVariable("year") String year,HttpSession session) {
		session.setAttribute("m", 1);
		String yer = year.split(" ")[0];
		String reg = year.split(" ")[1];
		session.setAttribute("reg", reg);
		System.out.println(yer);
		Professional third = new Professional();
		if(yer.equals("3")){third.setSem("3");third.setReg(reg);}
		if(yer.equals("4")){third.setSem("4");third.setReg(reg);}
		if(yer.equals("5")){third.setSem("5");third.setReg(reg);}
		if(yer.equals("6")){third.setSem("6");third.setReg(reg);}
		if(yer.equals("7")){third.setSem("7");third.setReg(reg);}
		if(yer.equals("8")){third.setSem("8");third.setReg(reg);}
		model.addAttribute("prof",third);
		return "third"; 
	}@PostMapping("/profsave/{reg}")
	public String profsave(@PathVariable("reg") String reg,@ModelAttribute("prof") Professional third) {
		System.out.println(third.getSem());
		if(third.getSem().equals("3")||third.getSem().equals("4")) {
			third.setYear("2");
		}if(third.getSem().equals("5")||third.getSem().equals("6")) {
			third.setYear("3");
		}if(third.getSem().equals("7")||third.getSem().equals("8")) {
			third.setYear("4");
		}
		pro_ser.add(third);
		return "redirect:/display/year="+third.getSem()+"="+reg;
	}
	@PostMapping("/thirds/{reg}")
	public String thirds(@PathVariable("reg") String reg,@ModelAttribute("third") Curriculum third) {
		System.out.println(third.getSem());
		if(third.getCode().equals("")) {
			third.setCode("-");
			third.setName("-");
		}
		if(third.getSem().equals("3")||third.getSem().equals("4")) {
			third.setYear("2");
		}if(third.getSem().equals("5")||third.getSem().equals("6")) {
			third.setYear("3");
		}if(third.getSem().equals("7")||third.getSem().equals("8")) {
			third.setYear("4");
		}
		curi_ser.add(third);
		return "redirect:/display/year="+third.getSem()+"="+reg;
	}
	@GetMapping("/display/{year}")
	public String dis(Model model,@PathVariable("year") String yer) {
		String year = yer.split("=")[1];
		String reg = yer.split("=")[2];
		model.addAttribute("third",curi_ser.findBySem(year,reg));
		model.addAttribute("prof",pro_ser.findBySem(year,reg));
		return "third_display";
	}
	@RequestMapping("/delete3/{id}")
	public String delete3(@PathVariable("id") int id) {
		Optional<Curriculum> curi = curi_ser.finds(id);
		Curriculum cur = curi.get();
		String yer = cur.getSem();
		curi_ser.deletes(id);
		return "redirect:/third/year="+yer;
	}@RequestMapping("/delpro/{id}")
	public String delpro(@PathVariable("id") int id) {
		Optional<Professional> curi = pro_ser.finds(id);
		Professional cur = curi.get();
		String yer = cur.getSem();
		pro_ser.deletes(id);
		return "redirect:/third/year="+yer;
	}
	@RequestMapping("/excel/new")
	public String odds(Model model,HttpSession session) {
		session.setAttribute("sgs", "dfg");
		return "upload";
	}
	@RequestMapping("/excel/new3")
	public String odds3(Model model) {
		return "upload3";
	}
	@RequestMapping("/excel/new4")
	public String odds4(Model model) {
		return "upload4";
	}
	@Autowired
	IFileUploaderService fileService;
	
	@Autowired
	StudentRepo_sec_year repo;
	@PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
		fileService.uploadFile(file);
        return "upload";
    }
	@PostMapping("/uploadFile3")
    public String uploadFile3(@RequestParam("file") MultipartFile file) {
		fileService.uploadFile(file);
        return "upload3";
    }
	@PostMapping("/uploadFile4")
    public String uploadFile4(@RequestParam("file") MultipartFile file) {
		fileService.uploadFile(file);
        return "upload4";
    }
	@Autowired
	ExcelUploadSecond excelservice;
	@GetMapping("/saveData")
	public String saveExcelData(Model model) {
		List<SecondYear> excel = excelservice.getExcelDataAsList();
		int noOfRecords = excelservice.saveExcelData(excel);
		model.addAttribute("noOfRecords",noOfRecords);
		return "upload";
	}
	@Autowired
	ExcelUploadThird excelservice3;
	@GetMapping("/saveData3")
    public String saveExcelData2(Model model) {
		try {
		List<ThirdYear> excelDataAsList = excelservice3.getExcelDataAsList();
		System.out.println("again");
		int noOfRecords = excelservice3.saveExcelData(excelDataAsList);
    	model.addAttribute("noOfRecords",noOfRecords);
		}catch(Exception e) {}
    	return "upload3";
    }
	@Autowired
	ExcelUploadFinal excelservice4;
	@GetMapping("/saveData4")
    public String saveExcelData3(Model model) {
		try{
		List<FinalYear> excelDataAsList = excelservice4.getExcelDataAsList();
    	int noOfRecords = excelservice4.saveExcelData(excelDataAsList);
    	model.addAttribute("noOfRecords",noOfRecords);
		}catch(Exception e) {}
    	return "upload4";
    }
	@RequestMapping("/teacherlog")
	public String log(Model model) {
		model.addAttribute("teachers",tec_ser.getDetails());
		return "logins";
	}
	@RequestMapping("/logreq")
	public String rets(HttpSession session) {
		session.setAttribute("msgs", "abcd");
		session.setAttribute("one", "two");
		return "tecreq";
	}
	@RequestMapping("/tedet/{uname}")
	public String tecreq(@PathVariable("uname") String uname,Model model,HttpSession session) {
		String un = uname.split(" ")[0];
		String year = uname.split(" ")[1];
		session.setAttribute("yer", year);
		Teachers tec = tec_ser.findbyuname(un);
		model.addAttribute("teacher",tec);
		return "tedet";
	}
	@PostMapping("/addimagetec/{uname}")
	public String addimagetec(@PathVariable("uname") String uname,HttpServletRequest req,HttpSession session,Model model,@RequestParam("fileimage") MultipartFile file) throws IOException {
		tec_ser.saveimage(file, uname);
		session.setAttribute("msg", "0");
		model.addAttribute("teacher",tec_ser.findbyuname(uname));
		return "tedet";
	}
	@PostMapping("/asks/{year}")
	public String ask(HttpSession session,@PathVariable("year") String year) {
		session.setAttribute("yer", year);
		session.setAttribute("ms", 1);
		return "req";
	}
	@PostMapping("/tecchange/{year}")
	public String tecchange(@PathVariable("year") String year,HttpServletRequest req,Model model,HttpSession session) {
		String uname = req.getParameter("uname");
		String oldpass = req.getParameter("oldpass");
		String newpass = req.getParameter("newpass");
		String msg = tec_ser.change(uname, oldpass, newpass);
		System.out.println(msg);
		if(msg.equals("not")) {
			session.setAttribute("ms", 1);
			session.setAttribute("sets", 0);
			return "req";
		}
		if(msg.equals("noo")) {
			session.setAttribute("ms", 1);
			session.setAttribute("sets", 1);
			return "req";
		}
		if(msg.equals("changed")) {
			session.setAttribute("sets", -1);
		}
		model.addAttribute("teacher",tec_ser.findbyuname(uname));
		return "redirect:/tedets/uname="+uname+"="+year;
	}
	@RequestMapping("/rollreqs/{rate}")
	public String rollreqs(HttpSession session,@PathVariable("rate") String rate) {
		session.setAttribute("rate", rate);
		session.setAttribute("msgs", 1234);
		return "rollreq";
	}
	@PostMapping("/rollreq")
	public String rollreq(Model model,HttpServletRequest req,HttpSession session) {
		try{String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		String year = req.getParameter("year");
		String rate = req.getParameter("rate");
		String m;
		System.out.println(rate);
		if(rate.equals("2")) {
		if(year.equals("2")) {
			m = tec_ser.rollauth(uname, pass, "Class Advisor 2");
			if(m.equals("valid")) {
				model.addAttribute("stude",ser2.getDetails());
				return "redirect:/student2";
			}if(m.equals("invalid")) {
				session.setAttribute("msgs", 0);
			}
			if(m.equals("notfound")) {
				session.setAttribute("msgs", 1);
			}
		}
		if(year.equals("3")) {
			m = tec_ser.rollauth(uname, pass, "Class Advisor 3");
			if(m.equals("valid")) {
				model.addAttribute("stude",ser3.getDetails());
				return "redirect:/student3";
			}if(m.equals("invalid")) {
				session.setAttribute("msgs", 0);
			}
			if(m.equals("notfound")) {
				session.setAttribute("msgs", 1);
			}
		}
		if(year.equals("4")) {
			m = tec_ser.rollauth(uname, pass, "Class Advisor 4");
			if(m.equals("valid")) {
				model.addAttribute("stude",ser4.getDetails());
				return "redirect:/student4";
			}if(m.equals("invalid")) {
				session.setAttribute("msgs", 0);
			}
			if(m.equals("notfound")) {
				session.setAttribute("msgs", 1);
			}
		}}
		if(rate.equals("3")) {
			m=tec_ser.rollauth(uname, pass, "Teacher's Admin");
			System.out.println(m);
			if(m.equals("valid")) {
				model.addAttribute("teacher",tec_ser.getDetails());
				return "tec_det";
			}if(m.equals("invalid")) {
				session.setAttribute("msgs", 0);
			}
			if(m.equals("notfound")) {
				session.setAttribute("msgs", 1);
			}
		}if(rate.equals("4")) {
			m=tec_ser.rollauth(uname, pass, "Curriculum Admin");
			if(m.equals("valid")) {
				return "regulations";
			}if(m.equals("invalid")) {
				session.setAttribute("msgs", 0);
			}
			if(m.equals("notfound")) {
				session.setAttribute("msgs", 1);
			}
		}if(rate.equals("5")) {
			m=tec_ser.rollauth(uname, pass, "TimeTable Admin");
			if(m.equals("valid")) {
				return "timemanage";
			}if(m.equals("invalid")) {
				session.setAttribute("msgs", 0);
			}
			if(m.equals("notfound")) {
				session.setAttribute("msgs", 1);
			}
		}if(rate.equals("6")) {
			m=tec_ser.rollauth(uname, pass, "Subject Admin");
			if(m.equals("valid")) {
				model.addAttribute("teacher",tec_ser.getDetails());
				return "allocation";
			}if(m.equals("invalid")) {
				session.setAttribute("msgs", 0);
			}
			if(m.equals("notfound")) {
				session.setAttribute("msgs", 1);
			}
		}
		}catch(Exception e) {}
		return null;
	}
	@PostMapping("/logreqs")
	public String logreq(Model model,HttpServletRequest req,HttpSession session) {
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		String year = req.getParameter("year");
		String msg = tec_ser.auth(uname, pass);
		if(msg.equals("valid")) {
			Teachers tec = tec_ser.findbyuname(uname);
			
			if(year.equals("2")) {
				String sub = tec.getSub11();
				if(sub==null||sub.equals(" ")||sub.equals("-")) {
					return "redirect:/logins/name="+uname+"="+year;
				}
				else {
					session.setAttribute("one",123);
					session.setAttribute("subj1", tec.getSub1());
					session.setAttribute("subj", sub);
					
				}
			}
			if(year.equals("3")) {
				String sub = tec.getSub22();
				if(sub==null||sub.equals(" ")||sub.equals("-")) {return "redirect:/logins/name="+uname+"="+year;
				}else {
						session.setAttribute("one",123);
						session.setAttribute("subj1", tec.getSub2());
						session.setAttribute("subj", sub);}
			}
			if(year.equals("4")) {
				String sub = tec.getSub33();
				if(sub==null||sub.equals(" ")||sub.equals("-")) {
					return "redirect:/logins/name="+uname+"="+year;
				}else {
					session.setAttribute("one",123);
					session.setAttribute("subj1", tec.getSub3());
					session.setAttribute("subj", sub);
				}
				
			}
			session.setAttribute("msgs", "abcd");
			session.setAttribute("name",tec.getUname());
			session.setAttribute("year", year);
			return "tecreq";
		}
		if(msg.equals("invalid")) {
			session.setAttribute("msgs", 0);
		}
		if(msg.equals("notfound")) {
			session.setAttribute("msgs", 1);
		}
		return "tecreq";
	}
	@PostMapping("/logsreq/{name}")
	public String logreq(@PathVariable("name") String name,HttpServletRequest req) { 
		String sub = req.getParameter("subs");
		String year = name.split(" ")[1];
		String n = name.split(" ")[0];
		return "redirect:/logins/name="+n+"="+year+"="+sub+"=";
	}
	@RequestMapping("/logins/{name}")
	public String trys(@PathVariable("name") String name,HttpServletRequest req,HttpServletResponse res,Model model,HttpSession session) {
		String[] getting = name.split("=");
		String uname = getting[1];
		int id = Integer.parseInt(getting[2]);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String si= new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		session.setAttribute("dates",dtf.format(now)+" ("+si+") ");
		Teachers teachers = tec_ser.findbyuname(uname);
		String sub="";
		session.setAttribute("name", teachers.getName());
		session.setAttribute("uname", teachers.getUname());
		if(id==2) {
			sub = teachers.getSub1();
			session.setAttribute("yer", "2");
			model.addAttribute("students",ser2.getDetails());
			List<TimeTable> times=time_ser.getAll();;
			String[] strarr = new String[7];
			for(TimeTable rows: times) {
				String stime="";String etime="";String hour="";String app="";
				strarr[0]=rows.getHour1();strarr[1]=rows.getHour2();strarr[2]=rows.getHour3();strarr[3]=rows.getHour4();strarr[4]=rows.getHour5();strarr[5]=rows.getHour6();strarr[6]=rows.getHour7();
				int c=0;
				List<TimeSet> set = time_set.get();
				int ids=0;
				for(TimeSet time:set) {ids = time.getHour();}
				TimeSet timeset = time_set.getByIds(ids);
				if(getting.length==4) {
					String[] ss= getting[3].split(" ");
					sub=ss[0];
					session.setAttribute("subject", sub);
					System.out.println(sub);
					String[] super1 = rows.getHour1().split("/");
						if(super1.length==2&&rows.getHour1().split("/")[0].equals(sub)){strarr[0]=rows.getHour1().split("/")[0];}
						super1 = rows.getHour2().split("/");
						if(super1.length==2&&rows.getHour2().split("/")[0].equals(sub)){strarr[1]=rows.getHour2().split("/")[0];}
						super1 = rows.getHour3().split("/");
						if(super1.length==2&&rows.getHour3().split("/")[0].equals(sub)){strarr[2]=rows.getHour3().split("/")[0];}
						super1 = rows.getHour4().split("/");
						if(super1.length==2&&rows.getHour4().split("/")[0].equals(sub)){strarr[3]=rows.getHour4().split("/")[0];}
						super1 = rows.getHour5().split("/");
						if(super1.length==2&&rows.getHour5().split("/")[0].equals(sub)){strarr[4]=rows.getHour5().split("/")[0];}
						super1 = rows.getHour6().split("/");
						if(super1.length==2&&rows.getHour6().split("/")[0].equals(sub)){strarr[5]=rows.getHour6().split("/")[0];}
						super1 = rows.getHour7().split("/");
						if(super1.length==2&&rows.getHour7().split("/")[0].equals(sub)){strarr[6]=rows.getHour7().split("/")[0];}
						super1 = rows.getHour1().split("/");
						if(super1.length==2&&rows.getHour1().split("/")[1].equals(sub)){strarr[0]=rows.getHour1().split("/")[1];}
						super1 = rows.getHour2().split("/");
						if(super1.length==2&&rows.getHour2().split("/")[1].equals(sub)){strarr[1]=rows.getHour2().split("/")[1];}
						super1 = rows.getHour3().split("/");
						if(super1.length==2&&rows.getHour3().split("/")[1].equals(sub)){strarr[2]=rows.getHour3().split("/")[1];}
						super1 = rows.getHour4().split("/");
						if(super1.length==2&&rows.getHour4().split("/")[1].equals(sub)){strarr[3]=rows.getHour4().split("/")[1];}
						super1 = rows.getHour5().split("/");
						if(super1.length==2&&rows.getHour5().split("/")[1].equals(sub)){strarr[4]=rows.getHour5().split("/")[1];}
						super1 = rows.getHour6().split("/");
						if(super1.length==2&&rows.getHour6().split("/")[1].equals(sub)){strarr[5]=rows.getHour6().split("/")[1];}
						super1 = rows.getHour7().split("/");
						if(super1.length==2&&rows.getHour7().split("/")[1].equals(sub)){strarr[6]=rows.getHour7().split("/")[1];}
				}
				int count=0;
				model.addAttribute("subject",att_ser.findBySubs(sub));
				for(int i=0;i<7;i++) {
					c++;
					if(strarr[i].equals(sub)&&c==1) {
						count++;
						if(count==1) {stime=timeset.getStarthour();}
						etime=timeset.getEndhour();
						if(count>1) {app="1";}
						else {hour="1";}
					}
					if(strarr[i].equals(sub)&&c==2) {
						count++;
						if(count==1) {stime=timeset.getS2();}
						etime=timeset.getE2();
						if(count>1) {app="2";}
						else {hour="2";}
					}
					if(strarr[i].equals(sub)&&c==3) {
						count++;if(count==1) {stime=timeset.getS3();}
						etime=timeset.getE3();
						if(count>1) {	app="3";}
						else {hour="3";}
					}
					if(strarr[i].equals(sub)&&c==4) {
						count++;
						if(count==1) {stime=timeset.getS4();}
						etime=timeset.getE4();
						if(count>1) {app="4";}
						else {hour="4";}
					}
					if(strarr[i].equals(sub)&&c==5) {
						count++;
						if(count==1) {stime=timeset.getS5();}
						etime=timeset.getE5();
						if(count>1) {app="5";}
						else {hour="5";}
					}
					if(strarr[i].equals(sub)&&c==6) {
						count++;
						if(count==1) {stime=timeset.getS6();}
						etime=timeset.getE6();
						if(count>1) {app="6";}
						else {hour="6";}
					}
					if(strarr[i].equals(sub)&&c==7) {
						count++;
						if(count==1) {stime=timeset.getS7();}
						etime=timeset.getE7();
						if(count>1) {app="7";}
						else {hour="7";}
					}
					if(stime==""&&etime==""&& hour=="") {stime="-";etime="-";hour="No Class";}
					String place = hour+"  "+app;
					if(rows.getDays().equals("MONDAY")) {
						session.setAttribute("st1", stime);
						session.setAttribute("et1", etime);
						session.setAttribute("mh", place);
					}
					if(rows.getDays().equals("TUESDAY")) {
						session.setAttribute("st2", stime);
						session.setAttribute("et2", etime);
						session.setAttribute("th",place);
					}
					if(rows.getDays().equals("WEDNESDAY")) {
						session.setAttribute("st3", stime);
						session.setAttribute("et3", etime);
						session.setAttribute("wh", place);
					}
					if(rows.getDays().equals("THURSDAY")) {
						session.setAttribute("st4", stime);
						session.setAttribute("et4", etime);
						session.setAttribute("thh", place);
					}
					if(rows.getDays().equals("FRIDAY")) {
						session.setAttribute("st5", stime);
						session.setAttribute("et5", etime);
						session.setAttribute("fh", place);
					}}}
		}
		else if(id==3) {
			sub = teachers.getSub2();
			session.setAttribute("yer", "3");
			model.addAttribute("students",ser3.getDetails());
			List<TimeTable3> times=time3_ser.getAll();;
			String[] strarr = new String[7];
			for(TimeTable3 rows: times) {
				String stime="";String etime="";String hour="";String app="";
				strarr[0]=rows.getHour1();strarr[1]=rows.getHour2();strarr[2]=rows.getHour3();strarr[3]=rows.getHour4();strarr[4]=rows.getHour5();strarr[5]=rows.getHour6();strarr[6]=rows.getHour7();
				int c=0;
				List<TimeSet> set = time_set.get();
				int ids=0;
				for(TimeSet time:set) {ids = time.getHour();}
				TimeSet timeset = time_set.getByIds(ids);
				if(getting.length==4) {
					String[] ss= getting[3].split(" ");
					sub=ss[0];
					System.out.println(sub);
					session.setAttribute("subject", sub);
					String[] super1 = rows.getHour1().split("/");
						if(super1.length==2&&rows.getHour1().split("/")[0].equals(sub)){strarr[0]=rows.getHour1().split("/")[0];}
						super1 = rows.getHour2().split("/");
						if(super1.length==2&&rows.getHour2().split("/")[0].equals(sub)){strarr[1]=rows.getHour2().split("/")[0];}
						super1 = rows.getHour3().split("/");
						if(super1.length==2&&rows.getHour3().split("/")[0].equals(sub)){strarr[2]=rows.getHour3().split("/")[0];}
						super1 = rows.getHour4().split("/");
						if(super1.length==2&&rows.getHour4().split("/")[0].equals(sub)){strarr[3]=rows.getHour4().split("/")[0];}
						super1 = rows.getHour5().split("/");
						if(super1.length==2&&rows.getHour5().split("/")[0].equals(sub)){strarr[4]=rows.getHour5().split("/")[0];}
						super1 = rows.getHour6().split("/");
						if(super1.length==2&&rows.getHour6().split("/")[0].equals(sub)){strarr[5]=rows.getHour6().split("/")[0];}
						super1 = rows.getHour7().split("/");
						if(super1.length==2&&rows.getHour7().split("/")[0].equals(sub)){strarr[6]=rows.getHour7().split("/")[0];}
						super1 = rows.getHour1().split("/");
						if(super1.length==2&&rows.getHour1().split("/")[1].equals(sub)){strarr[0]=rows.getHour1().split("/")[1];}
						super1 = rows.getHour2().split("/");
						if(super1.length==2&&rows.getHour2().split("/")[1].equals(sub)){strarr[1]=rows.getHour2().split("/")[1];}
						super1 = rows.getHour3().split("/");
						if(super1.length==2&&rows.getHour3().split("/")[1].equals(sub)){strarr[2]=rows.getHour3().split("/")[1];}
						super1 = rows.getHour4().split("/");
						if(super1.length==2&&rows.getHour4().split("/")[1].equals(sub)){strarr[3]=rows.getHour4().split("/")[1];}
						super1 = rows.getHour5().split("/");
						if(super1.length==2&&rows.getHour5().split("/")[1].equals(sub)){strarr[4]=rows.getHour5().split("/")[1];}
						super1 = rows.getHour6().split("/");
						if(super1.length==2&&rows.getHour6().split("/")[1].equals(sub)){strarr[5]=rows.getHour6().split("/")[1];}
						super1 = rows.getHour7().split("/");
						if(super1.length==2&&rows.getHour7().split("/")[1].equals(sub)){strarr[6]=rows.getHour7().split("/")[1];}
				}
				int count=0;
				model.addAttribute("subject",att_ser3.findBySubs(sub));
				for(int i=0;i<7;i++) {
					c++;
					if(strarr[i].equals(sub)&&c==1) {
						count++;
						if(count==1) {stime=timeset.getStarthour();}
						etime=timeset.getEndhour();
						if(count>1) {app="1";}
						else {hour="1";}
					}
					if(strarr[i].equals(sub)&&c==2) {
						count++;
						if(count==1) {stime=timeset.getS2();}
						etime=timeset.getE2();
						if(count>1) {app="2";}
						else {hour="2";}
					}
					if(strarr[i].equals(sub)&&c==3) {
						count++;if(count==1) {stime=timeset.getS3();}
						etime=timeset.getE3();
						if(count>1) {	app="3";}
						else {hour="3";}
					}
					if(strarr[i].equals(sub)&&c==4) {
						count++;
						if(count==1) {stime=timeset.getS4();}
						etime=timeset.getE4();
						if(count>1) {app="4";}
						else {hour="4";}
					}
					if(strarr[i].equals(sub)&&c==5) {
						count++;
						if(count==1) {stime=timeset.getS5();}
						etime=timeset.getE5();
						if(count>1) {app="5";}
						else {hour="5";}
					}
					if(strarr[i].equals(sub)&&c==6) {
						count++;
						if(count==1) {stime=timeset.getS6();}
						etime=timeset.getE6();
						if(count>1) {app="6";}
						else {hour="6";}
					}
					if(strarr[i].equals(sub)&&c==7) {
						count++;
						if(count==1) {stime=timeset.getS7();}
						etime=timeset.getE7();
						if(count>1) {app="7";}
						else {hour="7";}
					}
					if(stime==""&&etime==""&& hour=="") {stime="-";etime="-";hour="No Class";}
					String place = hour+"  "+app;
					if(rows.getDays().equals("MONDAY")) {
						session.setAttribute("st1", stime);
						session.setAttribute("et1", etime);
						session.setAttribute("mh", place);
					}
					if(rows.getDays().equals("TUESDAY")) {
						session.setAttribute("st2", stime);
						session.setAttribute("et2", etime);
						session.setAttribute("th",place);
					}
					if(rows.getDays().equals("WEDNESDAY")) {
						session.setAttribute("st3", stime);
						session.setAttribute("et3", etime);
						session.setAttribute("wh", place);
					}
					if(rows.getDays().equals("THURSDAY")) {
						session.setAttribute("st4", stime);
						session.setAttribute("et4", etime);
						session.setAttribute("thh", place);
					}
					if(rows.getDays().equals("FRIDAY")) {
						session.setAttribute("st5", stime);
						session.setAttribute("et5", etime);
						session.setAttribute("fh", place);
					}}}
		}
		
		else if(id==4) {
			sub = teachers.getSub3();
			session.setAttribute("yer", "4");
			model.addAttribute("students",ser4.getDetails());
			List<TimeTable4> times = time4_ser.getAll();
			String[] strarr = new String[7];
			for(TimeTable4 rows: times) {
				String stime="";String etime="";String hour="";String app="";
				strarr[0]=rows.getHour1();strarr[1]=rows.getHour2();strarr[2]=rows.getHour3();strarr[3]=rows.getHour4();strarr[4]=rows.getHour5();strarr[5]=rows.getHour6();strarr[6]=rows.getHour7();
				int c=0;
				List<TimeSet> set = time_set.get();
				int ids=0;
				for(TimeSet time:set) {ids = time.getHour();}
				TimeSet timeset = time_set.getByIds(ids);
				if(getting.length==4) {
					String[] ss= getting[3].split(" ");
					sub=ss[0];
					session.setAttribute("subject", sub);
					System.out.println(sub);
					String[] super1 = rows.getHour1().split("/");
						if(super1.length==2&&rows.getHour1().split("/")[0].equals(sub)){strarr[0]=rows.getHour1().split("/")[0];}
						super1 = rows.getHour2().split("/");
						if(super1.length==2&&rows.getHour2().split("/")[0].equals(sub)){strarr[1]=rows.getHour2().split("/")[0];}
						super1 = rows.getHour3().split("/");
						if(super1.length==2&&rows.getHour3().split("/")[0].equals(sub)){strarr[2]=rows.getHour3().split("/")[0];}
						super1 = rows.getHour4().split("/");
						if(super1.length==2&&rows.getHour4().split("/")[0].equals(sub)){strarr[3]=rows.getHour4().split("/")[0];}
						super1 = rows.getHour5().split("/");
						if(super1.length==2&&rows.getHour5().split("/")[0].equals(sub)){strarr[4]=rows.getHour5().split("/")[0];}
						super1 = rows.getHour6().split("/");
						if(super1.length==2&&rows.getHour6().split("/")[0].equals(sub)){strarr[5]=rows.getHour6().split("/")[0];}
						super1 = rows.getHour7().split("/");
						if(super1.length==2&&rows.getHour7().split("/")[0].equals(sub)){strarr[6]=rows.getHour7().split("/")[0];}
						super1 = rows.getHour1().split("/");
						if(super1.length==2&&rows.getHour1().split("/")[1].equals(sub)){strarr[0]=rows.getHour1().split("/")[1];}
						super1 = rows.getHour2().split("/");
						if(super1.length==2&&rows.getHour2().split("/")[1].equals(sub)){strarr[1]=rows.getHour2().split("/")[1];}
						super1 = rows.getHour3().split("/");
						if(super1.length==2&&rows.getHour3().split("/")[1].equals(sub)){strarr[2]=rows.getHour3().split("/")[1];}
						super1 = rows.getHour4().split("/");
						if(super1.length==2&&rows.getHour4().split("/")[1].equals(sub)){strarr[3]=rows.getHour4().split("/")[1];}
						super1 = rows.getHour5().split("/");
						if(super1.length==2&&rows.getHour5().split("/")[1].equals(sub)){strarr[4]=rows.getHour5().split("/")[1];}
						super1 = rows.getHour6().split("/");
						if(super1.length==2&&rows.getHour6().split("/")[1].equals(sub)){strarr[5]=rows.getHour6().split("/")[1];}
						super1 = rows.getHour7().split("/");
						if(super1.length==2&&rows.getHour7().split("/")[1].equals(sub)){strarr[6]=rows.getHour7().split("/")[1];}
				}
				int count=0;
				model.addAttribute("subject",att_ser4.findBySubs(sub));
				for(int i=0;i<7;i++) {
					c++;
					if(strarr[i].equals(sub)&&c==1) {
						count++;
						if(count==1) {stime=timeset.getStarthour();}
						etime=timeset.getEndhour();
						if(count>1) {app="1";}
						else {hour="1";}
					}
					if(strarr[i].equals(sub)&&c==2) {
						count++;
						if(count==1) {stime=timeset.getS2();}
						etime=timeset.getE2();
						if(count>1) {app="2";}
						else {hour="2";}
					}
					if(strarr[i].equals(sub)&&c==3) {
						count++;if(count==1) {stime=timeset.getS3();}
						etime=timeset.getE3();
						if(count>1) {	app="3";}
						else {hour="3";}
					}
					if(strarr[i].equals(sub)&&c==4) {
						count++;
						if(count==1) {stime=timeset.getS4();}
						etime=timeset.getE4();
						if(count>1) {app="4";}
						else {hour="4";}
					}
					if(strarr[i].equals(sub)&&c==5) {
						count++;
						if(count==1) {stime=timeset.getS5();}
						etime=timeset.getE5();
						if(count>1) {app="5";}
						else {hour="5";}
					}
					if(strarr[i].equals(sub)&&c==6) {
						count++;
						if(count==1) {stime=timeset.getS6();}
						etime=timeset.getE6();
						if(count>1) {app="6";}
						else {hour="6";}
					}
					if(strarr[i].equals(sub)&&c==7) {
						count++;
						if(count==1) {stime=timeset.getS7();}
						etime=timeset.getE7();
						if(count>1) {app="7";}
						else {hour="7";}
					}
					if(stime==""&&etime==""&& hour=="") {stime="-";etime="-";hour="No Class";}
					String place = hour+"  "+app;
					if(rows.getDays().equals("MONDAY")) {
						session.setAttribute("st1", stime);
						session.setAttribute("et1", etime);
						session.setAttribute("mh", place);
					}
					if(rows.getDays().equals("TUESDAY")) {
						session.setAttribute("st2", stime);
						session.setAttribute("et2", etime);
						session.setAttribute("th",place);
					}
					if(rows.getDays().equals("WEDNESDAY")) {
						session.setAttribute("st3", stime);
						session.setAttribute("et3", etime);
						session.setAttribute("wh", place);
					}
					if(rows.getDays().equals("THURSDAY")) {
						session.setAttribute("st4", stime);
						session.setAttribute("et4", etime);
						session.setAttribute("thh", place);
					}
					if(rows.getDays().equals("FRIDAY")) {
						session.setAttribute("st5", stime);
						session.setAttribute("et5", etime);
						session.setAttribute("fh", place);
					}}}
		}
		session.setAttribute("subject", sub);
		session.setAttribute("sub", id);
		return "teacher1";
	}
	
	@RequestMapping("/timetable")
	public String timetable(Model model) {
		return "timemanage";
	}
	@RequestMapping("/timetable/two")
	public String t2(Model model,HttpSession session) {
		Optional<TimeSet> ts = tss.finds(1);
		if(ts.isPresent()) {
			TimeSet tts = ts.get();
			model.addAttribute("ts",tts);
		}
		model.addAttribute("table",time_ser.getAll());
		session.setAttribute("ids", 2);
		return "timetable";
	}
	@RequestMapping("/timetable/three")
	public String t3(Model model,HttpSession session){
		Optional<TimeSet> ts = tss.finds(1);
		if(ts.isPresent()) {
			TimeSet tts = ts.get();
			model.addAttribute("ts",tts);
		}
		model.addAttribute("table",time3_ser.getAll());
		session.setAttribute("ids", 3);
		return "timetable";
	}
	@RequestMapping("/timetable/four")
	public String t4(Model model,HttpSession session){
		Optional<TimeSet> ts = tss.finds(1);
		if(ts.isPresent()) {
			TimeSet tts = ts.get();
			model.addAttribute("ts",tts);
		}
		model.addAttribute("table",time4_ser.getAll());
		session.setAttribute("ids", 4);
		return "timetable";
	}
	@RequestMapping("/timetable/new")
	public String timetables(Model model,HttpServletRequest req,HttpSession session) {
		int id = Integer.parseInt( req.getParameter("Go"));
		Optional<TimeSet> ts = tss.finds(1);
		if(ts.isPresent()) {
			TimeSet tts = ts.get();
			model.addAttribute("ts",tts);
		}
		if(id>10) {
			session.setAttribute("no", 20);
			System.out.println(id);
		}else {
			session.setAttribute("no", 34);
		}
		if((id%10)==2) {
			int i=1;
			session.setAttribute("sem", "3");
			if(time_ser.gets("MONDAY")==null) {
			for(int j=0;j<5;j++) {
				TimeTable time = new TimeTable();
				time.setId(i);
				if(time.getId()==1) {time.setDays("MONDAY");}
				if(time.getId()==2) {time.setDays("TUESDAY");}
				if(time.getId()==3) {time.setDays("WEDNESDAY");}
				if(time.getId()==4) {time.setDays("THURSDAY");}
				if(time.getId()==5) {time.setDays("FRIDAY");}
				i++;
				time_ser.save(time);
			}}
			model.addAttribute("table",time_ser.getAll());
			session.setAttribute("ids", id);
		}
		if((id%10)==3) {
			int i=1;
			session.setAttribute("sem", "5");
			if(time3_ser.gets("MONDAY")==null) {
			for(int j=0;j<5;j++) {
				TimeTable3 time = new TimeTable3();
				time.setId(i);
				if(time.getId()==1) {time.setDays("MONDAY");}
				if(time.getId()==2) {time.setDays("TUESDAY");}
				if(time.getId()==3) {time.setDays("WEDNESDAY");}
				if(time.getId()==4) {time.setDays("THURSDAY");}
				if(time.getId()==5) {time.setDays("FRIDAY");}
				i++;
				time3_ser.save(time);
			}}
			model.addAttribute("table",time3_ser.getAll());
			session.setAttribute("ids", id);
		}
		if((id%10)==4) {
			int i=1;
			session.setAttribute("sem", "7");
			if(time4_ser.gets("MONDAY")==null) {
			for(int j=0;j<5;j++) {
				TimeTable4 time = new TimeTable4();
				time.setId(i);
				if(time.getId()==1) {time.setDays("MONDAY");}
				if(time.getId()==2) {time.setDays("TUESDAY");}
				if(time.getId()==3) {time.setDays("WEDNESDAY");}
				if(time.getId()==4) {time.setDays("THURSDAY");}
				if(time.getId()==5) {time.setDays("FRIDAY");}
				i++;
				time4_ser.save(time);
			}}
			model.addAttribute("table",time4_ser.getAll());
			session.setAttribute("ids", id);
		}
		return "timetable";
	}
	@RequestMapping("/newday/two/{id}")
	public String adds(@PathVariable("id") int id, Model model,HttpSession session) {
		model.addAttribute("table",time_ser.getOne(id));
		model.addAttribute("curi",curi_ser.findByYear("2"));
		model.addAttribute("prof",pro_ser.findByYear("2"));
		session.setAttribute("year", "2");
		return "days";
	}
	@RequestMapping("/newday/three/{id}")
	public String add(@PathVariable("id") int id, Model model,HttpSession session) {
		model.addAttribute("table",time3_ser.getOne(id));
		model.addAttribute("curi",curi_ser.findByYear("3"));
		model.addAttribute("prof",pro_ser.findByYear("3"));
		session.setAttribute("year", "3");
		return "days";
	}
	@RequestMapping("/newday/four/{id}")
	public String add4(@PathVariable("id") int id, Model model,HttpSession session) {
		model.addAttribute("table",time4_ser.getOne(id));
		model.addAttribute("curi",curi_ser.findByYear("4"));
		model.addAttribute("prof",pro_ser.findByYear("4"));
		session.setAttribute("year", "4");
		return "days";
	}
	@RequestMapping("/timetable/{id}")
	public String done(HttpSession session,@PathVariable("id") int id,HttpServletRequest req,@ModelAttribute("table") TimeTable table) {
		int years = Integer.parseInt(req.getParameter("get"));
		if(table.getHour1()==null) {table.setHour1("-");}
		if(table.getHour2()==null) {table.setHour2("-");}
		if(table.getHour3()==null) {table.setHour3("-");}
		if(table.getHour4()==null) {table.setHour4("-");}
		if(table.getHour5()==null) {table.setHour5("-");}
		if(table.getHour6()==null) {table.setHour6("-");}
		if(table.getHour7()==null) {table.setHour7("-");}
		if(years==2) {
		TimeTable table2 = time_ser.getOne(id);
		table2.setHour1(table.getHour1().replace(",", "/"));
		table2.setHour2(table.getHour2().replace(",", "/"));
		table2.setHour3(table.getHour3().replace(",", "/"));
		table2.setHour4(table.getHour4().replace(",", "/"));
		table2.setHour5(table.getHour5().replace(",", "/"));
		table2.setHour6(table.getHour6().replace(",", "/"));
		table2.setHour7(table.getHour7().replace(",", "/"));
		time_ser.save(table2);
		return "redirect:/timetable/two";
		}
		if(years==3) {
			TimeTable3 table2 = time3_ser.getOne(id);
			table2.setHour1(table.getHour1().replace(",", "/"));
			table2.setHour2(table.getHour2().replace(",", "/"));
			table2.setHour3(table.getHour3().replace(",", "/"));
			table2.setHour4(table.getHour4().replace(",", "/"));
			table2.setHour5(table.getHour5().replace(",", "/"));
			table2.setHour6(table.getHour6().replace(",", "/"));
			table2.setHour7(table.getHour7().replace(",", "/"));
			time3_ser.save(table2);
			return "redirect:/timetable/three";
		}
		if(years==4) {
			TimeTable4 table2 = time4_ser.getOne(id);
			table2.setHour1(table.getHour1().replace(",", "/"));
			table2.setHour2(table.getHour2().replace(",", "/"));
			table2.setHour3(table.getHour3().replace(",", "/"));
			table2.setHour4(table.getHour4().replace(",", "/"));
			table2.setHour5(table.getHour5().replace(",", "/"));
			table2.setHour6(table.getHour6().replace(",", "/"));
			table2.setHour7(table.getHour7().replace(",", "/"));
			time4_ser.save(table2);
			return "redirect:/timetable/four";
		}
		return "redirect:/timetable";
	}
	@RequestMapping("/settime")
	public String retss() {
		return "try";
	}
	@RequestMapping("/showing")
	public String done(HttpServletRequest req) {
		String st1 = req.getParameter("st1");
		String et1 = req.getParameter("et1");
		String st2 = req.getParameter("st2");
		String et2 = req.getParameter("et2");
		String st3 = req.getParameter("st3");
		String et3 = req.getParameter("et3");
		String st4 = req.getParameter("st4");
		String et4 = req.getParameter("et4");
		String st5 = req.getParameter("st5");
		String et5 = req.getParameter("et5");
		String st6 = req.getParameter("st6");
		String et6 = req.getParameter("et6");
		String st7 = req.getParameter("st7");
		String et7 = req.getParameter("et7");
		String sl = req.getParameter("sl");
		String el = req.getParameter("el");
		TimeSet timeset = new TimeSet();
		timeset.setStarthour(st1);
		timeset.setEndhour(et1);
		timeset.setS2(st2);
		timeset.setE2(et2);
		timeset.setS3(st3);
		timeset.setE3(et3);
		timeset.setS4(st4);
		timeset.setE4(et4);
		timeset.setS5(st5);
		timeset.setE5(et5);
		timeset.setS6(st6);
		timeset.setE6(et6);
		timeset.setS7(st7);
		timeset.setE7(et7);
		timeset.setSl(sl);
		timeset.setEl(el);
		time_set.del();
		time_set.saves(timeset);
		return "redirect:/timetable";
	}
	@RequestMapping("/attpass/{sub}")
	public String attend(@PathVariable("sub") String sub, Model model,HttpSession session) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String si= new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		session.setAttribute("date",dtf.format(now)+" ("+si+") ");
		session.setAttribute("sub", sub);
		String[] splits = sub.split(" ");
		String year = splits[1];
		session.setAttribute("ye", year);
		if(year.equals("2")) {
			Attendance att = new Attendance();
			model.addAttribute("att",att);
			model.addAttribute("stu",ser2.getDetails());
			return "attendance";
		}
		if(year.equals("3")) {
			Attendance3 att = new Attendance3();
			model.addAttribute("att",att);
			model.addAttribute("stu",ser3.getDetails());
			return "attendance3";
		}
		if(year.equals("4")) {
			Attendance4 att = new Attendance4();
			model.addAttribute("att",att);
			model.addAttribute("stu",ser4.getDetails());
			return "attendance4";
		}
		return "attendance";
	}
	@PostMapping("/saveatt/{subs}")
	public ModelAndView saveatts(@PathVariable("subs") String sub,@ModelAttribute("att") Attendance att,HttpSession session) {
		String[] gets = sub.split(" ");
		String subs = gets[0];String year = gets[1];
		att.setSub(gets[0]);
		att.setDates(gets[2]+" "+gets[3]+" ");
		int present=0;
		int absent=0;
		int p=0;
		int total=0;
		p=(att.getA()==null)?0:(att.getA().equals("Present"))?present++:absent++;
		p=(att.getB()==null)?0:(att.getB().equals("Present"))?present++:absent++;
		p=(att.getC()==null)?0:(att.getC().equals("Present"))?present++:absent++;
		p=(att.getD()==null)?0:(att.getD().equals("Present"))?present++:absent++;
		p=(att.getE()==null)?0:(att.getE().equals("Present"))?present++:absent++;
		p=(att.getF()==null)?0:(att.getF().equals("Present"))?present++:absent++;
		p=(att.getG()==null)?0:(att.getG().equals("Present"))?present++:absent++;
		p=(att.getH()==null)?0:(att.getH().equals("Present"))?present++:absent++;
		p=(att.getI()==null)?0:(att.getI().equals("Present"))?present++:absent++;
		p=(att.getJ()==null)?0:(att.getJ().equals("Present"))?present++:absent++;
		p=(att.getK()==null)?0:(att.getK().equals("Present"))?present++:absent++;
		p=(att.getL()==null)?0:(att.getL().equals("Present"))?present++:absent++;
		p=(att.getM()==null)?0:(att.getM().equals("Present"))?present++:absent++;
		p=(att.getN()==null)?0:(att.getN().equals("Present"))?present++:absent++;
		p=(att.getO()==null)?0:(att.getO().equals("Present"))?present++:absent++;
		p=(att.getP()==null)?0:(att.getP().equals("Present"))?present++:absent++;
		p=(att.getQ()==null)?0:(att.getQ().equals("Present"))?present++:absent++;
		p=(att.getR()==null)?0:(att.getR().equals("Present"))?present++:absent++;
		p=(att.getS()==null)?0:(att.getS().equals("Present"))?present++:absent++;
		p=(att.getT()==null)?0:(att.getT().equals("Present"))?present++:absent++;
		p=(att.getU()==null)?0:(att.getU().equals("Present"))?present++:absent++;
		p=(att.getV()==null)?0:(att.getV().equals("Present"))?present++:absent++;
		p=(att.getW()==null)?0:(att.getW().equals("Present"))?present++:absent++;
		p=(att.getX()==null)?0:(att.getX().equals("Present"))?present++:absent++;
		p=(att.getY()==null)?0:(att.getY().equals("Present"))?present++:absent++;
		p=(att.getZ()==null)?0:(att.getZ().equals("Present"))?present++:absent++;
		p=(att.getA1()==null)?0:(att.getA1().equals("Present"))?present++:absent++;
		p=(att.getA2()==null)?0:(att.getA2().equals("Present"))?present++:absent++;
		p=(att.getA3()==null)?0:(att.getA3().equals("Present"))?present++:absent++;
		p=(att.getA4()==null)?0:(att.getA4().equals("Present"))?present++:absent++;
		p=(att.getA5()==null)?0:(att.getA5().equals("Present"))?present++:absent++;
		p=(att.getA6()==null)?0:(att.getA6().equals("Present"))?present++:absent++;
		p=(att.getA7()==null)?0:(att.getA7().equals("Present"))?present++:absent++;
		p=(att.getA8()==null)?0:(att.getA8().equals("Present"))?present++:absent++;
		p=(att.getA9()==null)?0:(att.getA9().equals("Present"))?present++:absent++;
		p=(att.getA10()==null)?0:(att.getA10().equals("Present"))?present++:absent++;
		p=(att.getA11()==null)?0:(att.getA11().equals("Present"))?present++:absent++;
		p=(att.getA12()==null)?0:(att.getA12().equals("Present"))?present++:absent++;
		p=(att.getA13()==null)?0:(att.getA13().equals("Present"))?present++:absent++;
		p=(att.getA14()==null)?0:(att.getA14().equals("Present"))?present++:absent++;
		p=(att.getA15()==null)?0:(att.getA15().equals("Present"))?present++:absent++;
		p=(att.getA16()==null)?0:(att.getA16().equals("Present"))?present++:absent++;
		p=(att.getA17()==null)?0:(att.getA17().equals("Present"))?present++:absent++;
		p=(att.getA18()==null)?0:(att.getA18().equals("Present"))?present++:absent++;
		p=(att.getA19()==null)?0:(att.getA19().equals("Present"))?present++:absent++;
		p=(att.getA20()==null)?0:(att.getA20().equals("Present"))?present++:absent++;
		p=(att.getA21()==null)?0:(att.getA21().equals("Present"))?present++:absent++;
		p=(att.getA22()==null)?0:(att.getA22().equals("Present"))?present++:absent++;
		p=(att.getA23()==null)?0:(att.getA23().equals("Present"))?present++:absent++;
		p=(att.getA24()==null)?0:(att.getA24().equals("Present"))?present++:absent++;
		p=(att.getA25()==null)?0:(att.getA25().equals("Present"))?present++:absent++;
		p=(att.getA26()==null)?0:(att.getA26().equals("Present"))?present++:absent++;
		p=(att.getA27()==null)?0:(att.getA27().equals("Present"))?present++:absent++;
		p=(att.getA28()==null)?0:(att.getA28().equals("Present"))?present++:absent++;
		p=(att.getA29()==null)?0:(att.getA29().equals("Present"))?present++:absent++;
		p=(att.getA30()==null)?0:(att.getA30().equals("Present"))?present++:absent++;
		p=(att.getA31()==null)?0:(att.getA31().equals("Present"))?present++:absent++;
		p=(att.getA32()==null)?0:(att.getA32().equals("Present"))?present++:absent++;
		p=(att.getA33()==null)?0:(att.getA33().equals("Present"))?present++:absent++;
		p=(att.getA34()==null)?0:(att.getA34().equals("Present"))?present++:absent++;
		p=(att.getA35()==null)?0:(att.getA35().equals("Present"))?present++:absent++;
		p=(att.getA36()==null)?0:(att.getA36().equals("Present"))?present++:absent++;
		p=(att.getA37()==null)?0:(att.getA37().equals("Present"))?present++:absent++;
		p=(att.getA38()==null)?0:(att.getA38().equals("Present"))?present++:absent++;
		p=(att.getA39()==null)?0:(att.getA39().equals("Present"))?present++:absent++;
		p=(att.getA40()==null)?0:(att.getA40().equals("Present"))?present++:absent++;
		p=(att.getA41()==null)?0:(att.getA41().equals("Present"))?present++:absent++;
		p=(att.getA42()==null)?0:(att.getA42().equals("Present"))?present++:absent++;
		p=(att.getA43()==null)?0:(att.getA43().equals("Present"))?present++:absent++;
		p=(att.getA44()==null)?0:(att.getA44().equals("Present"))?present++:absent++;
		att.setPresent(present);
		att.setAbsent(absent);
		att_ser.saves(att);
		return new ModelAndView("redirect:/saveatt/year="+year);
	}
	@RequestMapping("/saveatt/{year}")
	public String prints(@PathVariable("year") String year,Model model) {
		if(year=="2") {
			Attendance atts = null;
			model.addAttribute("att",atts);
			return "attendance";
		}
		if(year=="3") {
			Attendance3 atts = null;
			model.addAttribute("att",atts);
			return "attendance3";
		}
		if(year=="4") {
			Attendance4 atts = null;
			model.addAttribute("att",atts);
			return "attendance4";
		}
		return "attendance";
	}
	@PostMapping("/saveatt3/{subs}")
	public ModelAndView saveatts3(@PathVariable("subs") String sub,@ModelAttribute("att") Attendance3 att,HttpSession session) {
		String[] gets = sub.split(" ");
		att.setSub(gets[0]);
		String year = gets[1];
		att.setDates(gets[2]+" "+gets[3]+" ");
		int present=0;
		int absent=0;
		int p=0;
		p=(att.getA()==null)?0:(att.getA().equals("Present"))?present++:absent++;
		p=(att.getB()==null)?0:(att.getB().equals("Present"))?present++:absent++;
		p=(att.getC()==null)?0:(att.getC().equals("Present"))?present++:absent++;
		p=(att.getD()==null)?0:(att.getD().equals("Present"))?present++:absent++;
		p=(att.getE()==null)?0:(att.getE().equals("Present"))?present++:absent++;
		p=(att.getF()==null)?0:(att.getF().equals("Present"))?present++:absent++;
		p=(att.getG()==null)?0:(att.getG().equals("Present"))?present++:absent++;
		p=(att.getH()==null)?0:(att.getH().equals("Present"))?present++:absent++;
		p=(att.getI()==null)?0:(att.getI().equals("Present"))?present++:absent++;
		p=(att.getJ()==null)?0:(att.getJ().equals("Present"))?present++:absent++;
		p=(att.getK()==null)?0:(att.getK().equals("Present"))?present++:absent++;
		p=(att.getL()==null)?0:(att.getL().equals("Present"))?present++:absent++;
		p=(att.getM()==null)?0:(att.getM().equals("Present"))?present++:absent++;
		p=(att.getN()==null)?0:(att.getN().equals("Present"))?present++:absent++;
		p=(att.getO()==null)?0:(att.getO().equals("Present"))?present++:absent++;
		p=(att.getP()==null)?0:(att.getP().equals("Present"))?present++:absent++;
		p=(att.getQ()==null)?0:(att.getQ().equals("Present"))?present++:absent++;
		p=(att.getR()==null)?0:(att.getR().equals("Present"))?present++:absent++;
		p=(att.getS()==null)?0:(att.getS().equals("Present"))?present++:absent++;
		p=(att.getT()==null)?0:(att.getT().equals("Present"))?present++:absent++;
		p=(att.getU()==null)?0:(att.getU().equals("Present"))?present++:absent++;
		p=(att.getV()==null)?0:(att.getV().equals("Present"))?present++:absent++;
		p=(att.getW()==null)?0:(att.getW().equals("Present"))?present++:absent++;
		p=(att.getX()==null)?0:(att.getX().equals("Present"))?present++:absent++;
		p=(att.getY()==null)?0:(att.getY().equals("Present"))?present++:absent++;
		p=(att.getZ()==null)?0:(att.getZ().equals("Present"))?present++:absent++;
		p=(att.getA1()==null)?0:(att.getA1().equals("Present"))?present++:absent++;
		p=(att.getA2()==null)?0:(att.getA2().equals("Present"))?present++:absent++;
		p=(att.getA3()==null)?0:(att.getA3().equals("Present"))?present++:absent++;
		p=(att.getA4()==null)?0:(att.getA4().equals("Present"))?present++:absent++;
		p=(att.getA5()==null)?0:(att.getA5().equals("Present"))?present++:absent++;
		p=(att.getA6()==null)?0:(att.getA6().equals("Present"))?present++:absent++;
		p=(att.getA7()==null)?0:(att.getA7().equals("Present"))?present++:absent++;
		p=(att.getA8()==null)?0:(att.getA8().equals("Present"))?present++:absent++;
		p=(att.getA9()==null)?0:(att.getA9().equals("Present"))?present++:absent++;
		p=(att.getA10()==null)?0:(att.getA10().equals("Present"))?present++:absent++;
		p=(att.getA11()==null)?0:(att.getA11().equals("Present"))?present++:absent++;
		p=(att.getA12()==null)?0:(att.getA12().equals("Present"))?present++:absent++;
		p=(att.getA13()==null)?0:(att.getA13().equals("Present"))?present++:absent++;
		p=(att.getA14()==null)?0:(att.getA14().equals("Present"))?present++:absent++;
		p=(att.getA15()==null)?0:(att.getA15().equals("Present"))?present++:absent++;
		p=(att.getA16()==null)?0:(att.getA16().equals("Present"))?present++:absent++;
		p=(att.getA17()==null)?0:(att.getA17().equals("Present"))?present++:absent++;
		p=(att.getA18()==null)?0:(att.getA18().equals("Present"))?present++:absent++;
		p=(att.getA19()==null)?0:(att.getA19().equals("Present"))?present++:absent++;
		p=(att.getA20()==null)?0:(att.getA20().equals("Present"))?present++:absent++;
		p=(att.getA21()==null)?0:(att.getA21().equals("Present"))?present++:absent++;
		p=(att.getA22()==null)?0:(att.getA22().equals("Present"))?present++:absent++;
		p=(att.getA23()==null)?0:(att.getA23().equals("Present"))?present++:absent++;
		p=(att.getA24()==null)?0:(att.getA24().equals("Present"))?present++:absent++;
		p=(att.getA25()==null)?0:(att.getA25().equals("Present"))?present++:absent++;
		p=(att.getA26()==null)?0:(att.getA26().equals("Present"))?present++:absent++;
		p=(att.getA27()==null)?0:(att.getA27().equals("Present"))?present++:absent++;
		p=(att.getA28()==null)?0:(att.getA28().equals("Present"))?present++:absent++;
		p=(att.getA29()==null)?0:(att.getA29().equals("Present"))?present++:absent++;
		p=(att.getA30()==null)?0:(att.getA30().equals("Present"))?present++:absent++;
		p=(att.getA31()==null)?0:(att.getA31().equals("Present"))?present++:absent++;
		p=(att.getA32()==null)?0:(att.getA32().equals("Present"))?present++:absent++;
		p=(att.getA33()==null)?0:(att.getA33().equals("Present"))?present++:absent++;
		p=(att.getA34()==null)?0:(att.getA34().equals("Present"))?present++:absent++;
		p=(att.getA35()==null)?0:(att.getA35().equals("Present"))?present++:absent++;
		p=(att.getA36()==null)?0:(att.getA36().equals("Present"))?present++:absent++;
		p=(att.getA37()==null)?0:(att.getA37().equals("Present"))?present++:absent++;
		p=(att.getA38()==null)?0:(att.getA38().equals("Present"))?present++:absent++;
		p=(att.getA39()==null)?0:(att.getA39().equals("Present"))?present++:absent++;
		p=(att.getA40()==null)?0:(att.getA40().equals("Present"))?present++:absent++;
		p=(att.getA41()==null)?0:(att.getA41().equals("Present"))?present++:absent++;
		p=(att.getA42()==null)?0:(att.getA42().equals("Present"))?present++:absent++;
		p=(att.getA43()==null)?0:(att.getA43().equals("Present"))?present++:absent++;
		p=(att.getA44()==null)?0:(att.getA44().equals("Present"))?present++:absent++;
		att.setPresent(present);
		att.setAbsent(absent);
		att_ser3.saves(att);
		return new ModelAndView("redirect:/saveatt/year="+year);
	}
	@PostMapping("/saveatt4/{subs}")
	public ModelAndView saveatts4(@PathVariable("subs") String sub,@ModelAttribute("att") Attendance4 att,HttpSession session) {
		String[] gets = sub.split(" ");
		String year = gets[0];
		att.setSub(gets[0]);
		att.setDates(gets[2]+" "+gets[3]+" ");
		int present=0;
		int absent=0;
		int p=0;
		p=(att.getA()==null)?0:(att.getA().equals("Present"))?present++:absent++;
		p=(att.getB()==null)?0:(att.getB().equals("Present"))?present++:absent++;
		p=(att.getC()==null)?0:(att.getC().equals("Present"))?present++:absent++;
		p=(att.getD()==null)?0:(att.getD().equals("Present"))?present++:absent++;
		p=(att.getE()==null)?0:(att.getE().equals("Present"))?present++:absent++;
		p=(att.getF()==null)?0:(att.getF().equals("Present"))?present++:absent++;
		p=(att.getG()==null)?0:(att.getG().equals("Present"))?present++:absent++;
		p=(att.getH()==null)?0:(att.getH().equals("Present"))?present++:absent++;
		p=(att.getI()==null)?0:(att.getI().equals("Present"))?present++:absent++;
		p=(att.getJ()==null)?0:(att.getJ().equals("Present"))?present++:absent++;
		p=(att.getK()==null)?0:(att.getK().equals("Present"))?present++:absent++;
		p=(att.getL()==null)?0:(att.getL().equals("Present"))?present++:absent++;
		p=(att.getM()==null)?0:(att.getM().equals("Present"))?present++:absent++;
		p=(att.getN()==null)?0:(att.getN().equals("Present"))?present++:absent++;
		p=(att.getO()==null)?0:(att.getO().equals("Present"))?present++:absent++;
		p=(att.getP()==null)?0:(att.getP().equals("Present"))?present++:absent++;
		p=(att.getQ()==null)?0:(att.getQ().equals("Present"))?present++:absent++;
		p=(att.getR()==null)?0:(att.getR().equals("Present"))?present++:absent++;
		p=(att.getS()==null)?0:(att.getS().equals("Present"))?present++:absent++;
		p=(att.getT()==null)?0:(att.getT().equals("Present"))?present++:absent++;
		p=(att.getU()==null)?0:(att.getU().equals("Present"))?present++:absent++;
		p=(att.getV()==null)?0:(att.getV().equals("Present"))?present++:absent++;
		p=(att.getW()==null)?0:(att.getW().equals("Present"))?present++:absent++;
		p=(att.getX()==null)?0:(att.getX().equals("Present"))?present++:absent++;
		p=(att.getY()==null)?0:(att.getY().equals("Present"))?present++:absent++;
		p=(att.getZ()==null)?0:(att.getZ().equals("Present"))?present++:absent++;
		p=(att.getA1()==null)?0:(att.getA1().equals("Present"))?present++:absent++;
		p=(att.getA2()==null)?0:(att.getA2().equals("Present"))?present++:absent++;
		p=(att.getA3()==null)?0:(att.getA3().equals("Present"))?present++:absent++;
		p=(att.getA4()==null)?0:(att.getA4().equals("Present"))?present++:absent++;
		p=(att.getA5()==null)?0:(att.getA5().equals("Present"))?present++:absent++;
		p=(att.getA6()==null)?0:(att.getA6().equals("Present"))?present++:absent++;
		p=(att.getA7()==null)?0:(att.getA7().equals("Present"))?present++:absent++;
		p=(att.getA8()==null)?0:(att.getA8().equals("Present"))?present++:absent++;
		p=(att.getA9()==null)?0:(att.getA9().equals("Present"))?present++:absent++;
		p=(att.getA10()==null)?0:(att.getA10().equals("Present"))?present++:absent++;
		p=(att.getA11()==null)?0:(att.getA11().equals("Present"))?present++:absent++;
		p=(att.getA12()==null)?0:(att.getA12().equals("Present"))?present++:absent++;
		p=(att.getA13()==null)?0:(att.getA13().equals("Present"))?present++:absent++;
		p=(att.getA14()==null)?0:(att.getA14().equals("Present"))?present++:absent++;
		p=(att.getA15()==null)?0:(att.getA15().equals("Present"))?present++:absent++;
		p=(att.getA16()==null)?0:(att.getA16().equals("Present"))?present++:absent++;
		p=(att.getA17()==null)?0:(att.getA17().equals("Present"))?present++:absent++;
		p=(att.getA18()==null)?0:(att.getA18().equals("Present"))?present++:absent++;
		p=(att.getA19()==null)?0:(att.getA19().equals("Present"))?present++:absent++;
		p=(att.getA20()==null)?0:(att.getA20().equals("Present"))?present++:absent++;
		p=(att.getA21()==null)?0:(att.getA21().equals("Present"))?present++:absent++;
		p=(att.getA22()==null)?0:(att.getA22().equals("Present"))?present++:absent++;
		p=(att.getA23()==null)?0:(att.getA23().equals("Present"))?present++:absent++;
		p=(att.getA24()==null)?0:(att.getA24().equals("Present"))?present++:absent++;
		p=(att.getA25()==null)?0:(att.getA25().equals("Present"))?present++:absent++;
		p=(att.getA26()==null)?0:(att.getA26().equals("Present"))?present++:absent++;
		p=(att.getA27()==null)?0:(att.getA27().equals("Present"))?present++:absent++;
		p=(att.getA28()==null)?0:(att.getA28().equals("Present"))?present++:absent++;
		p=(att.getA29()==null)?0:(att.getA29().equals("Present"))?present++:absent++;
		p=(att.getA30()==null)?0:(att.getA30().equals("Present"))?present++:absent++;
		p=(att.getA31()==null)?0:(att.getA31().equals("Present"))?present++:absent++;
		p=(att.getA32()==null)?0:(att.getA32().equals("Present"))?present++:absent++;
		p=(att.getA33()==null)?0:(att.getA33().equals("Present"))?present++:absent++;
		p=(att.getA34()==null)?0:(att.getA34().equals("Present"))?present++:absent++;
		p=(att.getA35()==null)?0:(att.getA35().equals("Present"))?present++:absent++;
		p=(att.getA36()==null)?0:(att.getA36().equals("Present"))?present++:absent++;
		p=(att.getA37()==null)?0:(att.getA37().equals("Present"))?present++:absent++;
		p=(att.getA38()==null)?0:(att.getA38().equals("Present"))?present++:absent++;
		p=(att.getA39()==null)?0:(att.getA39().equals("Present"))?present++:absent++;
		p=(att.getA40()==null)?0:(att.getA40().equals("Present"))?present++:absent++;
		p=(att.getA41()==null)?0:(att.getA41().equals("Present"))?present++:absent++;
		p=(att.getA42()==null)?0:(att.getA42().equals("Present"))?present++:absent++;
		p=(att.getA43()==null)?0:(att.getA43().equals("Present"))?present++:absent++;
		p=(att.getA44()==null)?0:(att.getA44().equals("Present"))?present++:absent++;
		att.setPresent(present);
		att.setAbsent(absent);
		att_ser4.saves(att);
		return new ModelAndView("redirect:/saveatt/year="+year);
	}
	@RequestMapping("/attdets/{dates}")
	public String attdets(@PathVariable("dates") String dates,Model model) {
		String[] gets = dates.split(" ");
		String dat=gets[0]+" "+gets[1];
		String sub=gets[2];
		String year = gets[3];
		String hour = gets[4];
		System.out.println(dat+sub);
		if(year.equals("2")) {
			List<SecondYear> stus = ser2.getDetails();
			model.addAttribute("stu",stus);
			model.addAttribute("spec",att_ser.findByDS(dat, sub,hour));
		}
		if(year.equals("3")) {
			List<ThirdYear> stus = ser3.getDetails();
			model.addAttribute("stu",stus);
			model.addAttribute("spec",att_ser3.findByDS(dat, sub,hour));
		}
		if(year.equals("4")) {
			List<FinalYear> stus = ser4.getDetails();
			model.addAttribute("stu",stus);
			model.addAttribute("spec",att_ser4.findByDS(dat, sub,hour));
		}
		System.out.println(year);
		return "specs";
		
	}
	int p=0;
	@RequestMapping("/stuatt/{sub}")
	public String stuatt(@PathVariable("sub") String subject,Model model,HttpSession session) {
		String[] splits = subject.split(" ");
		String sub = splits[0];
		String year = splits[1];
		session.setAttribute("year", year);int total=0;int[] stu1= new int[71];
		for(int i=0;i<71;i++) {stu1[i]=0;}
		try{if(year.equals("2")) {
		List<Attendance> collect = att_ser.findBySubs(sub);
		model.addAttribute("stu",ser2.getDetails());
		for(Attendance co:collect) {
			total++;
			System.out.println(co);
			p=(co.getA()==null)?0:(co.getA().equals("Present"))?stu1[0]++:0;
			p=(co.getB()==null)?0:(co.getB().equals("Present"))?stu1[1]++:0;
			p=(co.getC()==null)?0:(co.getC().equals("Present"))?stu1[2]++:0;
			p=(co.getD()==null)?0:(co.getD().equals("Present"))?stu1[3]++:0;
			p=(co.getE()==null)?0:(co.getE().equals("Present"))?stu1[4]++:0;
			p=(co.getF()==null)?0:(co.getF().equals("Present"))?stu1[5]++:0;
			p=(co.getG()==null)?0:(co.getG().equals("Present"))?stu1[6]++:0;
			p=(co.getH()==null)?0:(co.getH().equals("Present"))?stu1[7]++:0;
			p=(co.getI()==null)?0:(co.getI().equals("Present"))?stu1[8]++:0;
			p=(co.getJ()==null)?0:(co.getJ().equals("Present"))?stu1[9]++:0;
			p=(co.getK()==null)?0:(co.getK().equals("Present"))?stu1[10]++:0;
			p=(co.getL()==null)?0:(co.getL().equals("Present"))?stu1[11]++:0;
			p=(co.getM()==null)?0:(co.getM().equals("Present"))?stu1[12]++:0;
			p=(co.getN()==null)?0:(co.getN().equals("Present"))?stu1[13]++:0;
			p=(co.getO()==null)?0:(co.getO().equals("Present"))?stu1[14]++:0;
			p=(co.getP()==null)?0:(co.getP().equals("Present"))?stu1[15]++:0;
			p=(co.getQ()==null)?0:(co.getQ().equals("Present"))?stu1[16]++:0;
			p=(co.getR()==null)?0:(co.getR().equals("Present"))?stu1[17]++:0;
			p=(co.getS()==null)?0:(co.getS().equals("Present"))?stu1[18]++:0;
			p=(co.getT()==null)?0:(co.getT().equals("Present"))?stu1[19]++:0;
			p=(co.getU()==null)?0:(co.getU().equals("Present"))?stu1[20]++:0;
			p=(co.getV()==null)?0:(co.getV().equals("Present"))?stu1[21]++:0;
			p=(co.getW()==null)?0:(co.getW().equals("Present"))?stu1[22]++:0;
			p=(co.getX()==null)?0:(co.getX().equals("Present"))?stu1[23]++:0;
			p=(co.getY()==null)?0:(co.getY().equals("Present"))?stu1[24]++:0;
			p=(co.getZ()==null)?0:(co.getZ().equals("Present"))?stu1[25]++:0;
			p=(co.getA1()==null)?0:(co.getA1().equals("Present"))?stu1[26]++:0;
			p=(co.getA2()==null)?0:(co.getA2().equals("Present"))?stu1[28]++:0;
			p=(co.getA3()==null)?0:(co.getA3().equals("Present"))?stu1[29]++:0;
			p=(co.getA4()==null)?0:(co.getA4().equals("Present"))?stu1[30]++:0;
			p=(co.getA5()==null)?0:(co.getA5().equals("Present"))?stu1[31]++:0;
			p=(co.getA6()==null)?0:(co.getA6().equals("Present"))?stu1[32]++:0;
			p=(co.getA7()==null)?0:(co.getA7().equals("Present"))?stu1[33]++:0;
			p=(co.getA8()==null)?0:(co.getA8().equals("Present"))?stu1[34]++:0;
			p=(co.getA9()==null)?0:(co.getA9().equals("Present"))?stu1[35]++:0;
			p=(co.getA10()==null)?0:(co.getA10().equals("Present"))?stu1[36]++:0;
			p=(co.getA11()==null)?0:(co.getA11().equals("Present"))?stu1[37]++:0;
			p=(co.getA12()==null)?0:(co.getA12().equals("Present"))?stu1[38]++:0;
			p=(co.getA13()==null)?0:(co.getA13().equals("Present"))?stu1[39]++:0;
			p=(co.getA14()==null)?0:(co.getA14().equals("Present"))?stu1[40]++:0;
			p=(co.getA15()==null)?0:(co.getA15().equals("Present"))?stu1[41]++:0;
			p=(co.getA16()==null)?0:(co.getA16().equals("Present"))?stu1[42]++:0;
			p=(co.getA17()==null)?0:(co.getA17().equals("Present"))?stu1[43]++:0;
			p=(co.getA18()==null)?0:(co.getA18().equals("Present"))?stu1[44]++:0;
			p=(co.getA19()==null)?0:(co.getA19().equals("Present"))?stu1[45]++:0;
			p=(co.getA20()==null)?0:(co.getA20().equals("Present"))?stu1[46]++:0;
			p=(co.getA21()==null)?0:(co.getA21().equals("Present"))?stu1[47]++:0;
			p=(co.getA22()==null)?0:(co.getA22().equals("Present"))?stu1[48]++:0;
			p=(co.getA23()==null)?0:(co.getA23().equals("Present"))?stu1[49]++:0;
			p=(co.getA24()==null)?0:(co.getA24().equals("Present"))?stu1[50]++:0;
			p=(co.getA25()==null)?0:(co.getA25().equals("Present"))?stu1[51]++:0;
			p=(co.getA26()==null)?0:(co.getA26().equals("Present"))?stu1[52]++:0;
			p=(co.getA27()==null)?0:(co.getA27().equals("Present"))?stu1[53]++:0;
			p=(co.getA28()==null)?0:(co.getA28().equals("Present"))?stu1[54]++:0;
			p=(co.getA29()==null)?0:(co.getA29().equals("Present"))?stu1[55]++:0;
			p=(co.getA30()==null)?0:(co.getA30().equals("Present"))?stu1[56]++:0;
			p=(co.getA31()==null)?0:(co.getA31().equals("Present"))?stu1[57]++:0;
			p=(co.getA32()==null)?0:(co.getA32().equals("Present"))?stu1[58]++:0;
			p=(co.getA33()==null)?0:(co.getA33().equals("Present"))?stu1[59]++:0;
			p=(co.getA34()==null)?0:(co.getA34().equals("Present"))?stu1[60]++:0;
			p=(co.getA35()==null)?0:(co.getA35().equals("Present"))?stu1[61]++:0;
			p=(co.getA36()==null)?0:(co.getA36().equals("Present"))?stu1[62]++:0;
			p=(co.getA37()==null)?0:(co.getA37().equals("Present"))?stu1[63]++:0;
			p=(co.getA38()==null)?0:(co.getA38().equals("Present"))?stu1[64]++:0;
			p=(co.getA39()==null)?0:(co.getA39().equals("Present"))?stu1[65]++:0;
			p=(co.getA40()==null)?0:(co.getA40().equals("Present"))?stu1[66]++:0;
			p=(co.getA41()==null)?0:(co.getA41().equals("Present"))?stu1[67]++:0;
			p=(co.getA42()==null)?0:(co.getA42().equals("Present"))?stu1[68]++:0;
			p=(co.getA43()==null)?0:(co.getA43().equals("Present"))?stu1[69]++:0;
			p=(co.getA44()==null)?0:(co.getA44().equals("Present"))?stu1[70]++:0;
		}
		}
		if(year.equals("3")) {
			List<Attendance3> collect = att_ser3.findBySubs(sub);
			model.addAttribute("stu",ser3.getDetails());
			for(Attendance3 co:collect) {
				total++;
				System.out.println(co);
				p=(co.getA()==null)?0:(co.getA().equals("Present"))?stu1[0]++:0;
				p=(co.getB()==null)?0:(co.getB().equals("Present"))?stu1[1]++:0;
				p=(co.getC()==null)?0:(co.getC().equals("Present"))?stu1[2]++:0;
				p=(co.getD()==null)?0:(co.getD().equals("Present"))?stu1[3]++:0;
				p=(co.getE()==null)?0:(co.getE().equals("Present"))?stu1[4]++:0;
				p=(co.getF()==null)?0:(co.getF().equals("Present"))?stu1[5]++:0;
				p=(co.getG()==null)?0:(co.getG().equals("Present"))?stu1[6]++:0;
				p=(co.getH()==null)?0:(co.getH().equals("Present"))?stu1[7]++:0;
				p=(co.getI()==null)?0:(co.getI().equals("Present"))?stu1[8]++:0;
				p=(co.getJ()==null)?0:(co.getJ().equals("Present"))?stu1[9]++:0;
				p=(co.getK()==null)?0:(co.getK().equals("Present"))?stu1[10]++:0;
				p=(co.getL()==null)?0:(co.getL().equals("Present"))?stu1[11]++:0;
				p=(co.getM()==null)?0:(co.getM().equals("Present"))?stu1[12]++:0;
				p=(co.getN()==null)?0:(co.getN().equals("Present"))?stu1[13]++:0;
				p=(co.getO()==null)?0:(co.getO().equals("Present"))?stu1[14]++:0;
				p=(co.getP()==null)?0:(co.getP().equals("Present"))?stu1[15]++:0;
				p=(co.getQ()==null)?0:(co.getQ().equals("Present"))?stu1[16]++:0;
				p=(co.getR()==null)?0:(co.getR().equals("Present"))?stu1[17]++:0;
				p=(co.getS()==null)?0:(co.getS().equals("Present"))?stu1[18]++:0;
				p=(co.getT()==null)?0:(co.getT().equals("Present"))?stu1[19]++:0;
				p=(co.getU()==null)?0:(co.getU().equals("Present"))?stu1[20]++:0;
				p=(co.getV()==null)?0:(co.getV().equals("Present"))?stu1[21]++:0;
				p=(co.getW()==null)?0:(co.getW().equals("Present"))?stu1[22]++:0;
				p=(co.getX()==null)?0:(co.getX().equals("Present"))?stu1[23]++:0;
				p=(co.getY()==null)?0:(co.getY().equals("Present"))?stu1[24]++:0;
				p=(co.getZ()==null)?0:(co.getZ().equals("Present"))?stu1[25]++:0;
				p=(co.getA1()==null)?0:(co.getA1().equals("Present"))?stu1[26]++:0;
				p=(co.getA2()==null)?0:(co.getA2().equals("Present"))?stu1[28]++:0;
				p=(co.getA3()==null)?0:(co.getA3().equals("Present"))?stu1[29]++:0;
				p=(co.getA4()==null)?0:(co.getA4().equals("Present"))?stu1[30]++:0;
				p=(co.getA5()==null)?0:(co.getA5().equals("Present"))?stu1[31]++:0;
				p=(co.getA6()==null)?0:(co.getA6().equals("Present"))?stu1[32]++:0;
				p=(co.getA7()==null)?0:(co.getA7().equals("Present"))?stu1[33]++:0;
				p=(co.getA8()==null)?0:(co.getA8().equals("Present"))?stu1[34]++:0;
				p=(co.getA9()==null)?0:(co.getA9().equals("Present"))?stu1[35]++:0;
				p=(co.getA10()==null)?0:(co.getA10().equals("Present"))?stu1[36]++:0;
				p=(co.getA11()==null)?0:(co.getA11().equals("Present"))?stu1[37]++:0;
				p=(co.getA12()==null)?0:(co.getA12().equals("Present"))?stu1[38]++:0;
				p=(co.getA13()==null)?0:(co.getA13().equals("Present"))?stu1[39]++:0;
				p=(co.getA14()==null)?0:(co.getA14().equals("Present"))?stu1[40]++:0;
				p=(co.getA15()==null)?0:(co.getA15().equals("Present"))?stu1[41]++:0;
				p=(co.getA16()==null)?0:(co.getA16().equals("Present"))?stu1[42]++:0;
				p=(co.getA17()==null)?0:(co.getA17().equals("Present"))?stu1[43]++:0;
				p=(co.getA18()==null)?0:(co.getA18().equals("Present"))?stu1[44]++:0;
				p=(co.getA19()==null)?0:(co.getA19().equals("Present"))?stu1[45]++:0;
				p=(co.getA20()==null)?0:(co.getA20().equals("Present"))?stu1[46]++:0;
				p=(co.getA21()==null)?0:(co.getA21().equals("Present"))?stu1[47]++:0;
				p=(co.getA22()==null)?0:(co.getA22().equals("Present"))?stu1[48]++:0;
				p=(co.getA23()==null)?0:(co.getA23().equals("Present"))?stu1[49]++:0;
				p=(co.getA24()==null)?0:(co.getA24().equals("Present"))?stu1[50]++:0;
				p=(co.getA25()==null)?0:(co.getA25().equals("Present"))?stu1[51]++:0;
				p=(co.getA26()==null)?0:(co.getA26().equals("Present"))?stu1[52]++:0;
				p=(co.getA27()==null)?0:(co.getA27().equals("Present"))?stu1[53]++:0;
				p=(co.getA28()==null)?0:(co.getA28().equals("Present"))?stu1[54]++:0;
				p=(co.getA29()==null)?0:(co.getA29().equals("Present"))?stu1[55]++:0;
				p=(co.getA30()==null)?0:(co.getA30().equals("Present"))?stu1[56]++:0;
				p=(co.getA31()==null)?0:(co.getA31().equals("Present"))?stu1[57]++:0;
				p=(co.getA32()==null)?0:(co.getA32().equals("Present"))?stu1[58]++:0;
				p=(co.getA33()==null)?0:(co.getA33().equals("Present"))?stu1[59]++:0;
				p=(co.getA34()==null)?0:(co.getA34().equals("Present"))?stu1[60]++:0;
				p=(co.getA35()==null)?0:(co.getA35().equals("Present"))?stu1[61]++:0;
				p=(co.getA36()==null)?0:(co.getA36().equals("Present"))?stu1[62]++:0;
				p=(co.getA37()==null)?0:(co.getA37().equals("Present"))?stu1[63]++:0;
				p=(co.getA38()==null)?0:(co.getA38().equals("Present"))?stu1[64]++:0;
				p=(co.getA39()==null)?0:(co.getA39().equals("Present"))?stu1[65]++:0;
				p=(co.getA40()==null)?0:(co.getA40().equals("Present"))?stu1[66]++:0;
				p=(co.getA41()==null)?0:(co.getA41().equals("Present"))?stu1[67]++:0;
				p=(co.getA42()==null)?0:(co.getA42().equals("Present"))?stu1[68]++:0;
				p=(co.getA43()==null)?0:(co.getA43().equals("Present"))?stu1[69]++:0;
				p=(co.getA44()==null)?0:(co.getA44().equals("Present"))?stu1[70]++:0;
			}
			}
		if(year.equals("4")) {
			List<Attendance4> collect = att_ser4.findBySubs(sub);
			model.addAttribute("stu",ser4.getDetails());
			for(Attendance4 co:collect) {
				total++;
				System.out.println(co);
				p=(co.getA()==null)?0:(co.getA().equals("Present"))?stu1[0]++:0;
				p=(co.getB()==null)?0:(co.getB().equals("Present"))?stu1[1]++:0;
				p=(co.getC()==null)?0:(co.getC().equals("Present"))?stu1[2]++:0;
				p=(co.getD()==null)?0:(co.getD().equals("Present"))?stu1[3]++:0;
				p=(co.getE()==null)?0:(co.getE().equals("Present"))?stu1[4]++:0;
				p=(co.getF()==null)?0:(co.getF().equals("Present"))?stu1[5]++:0;
				p=(co.getG()==null)?0:(co.getG().equals("Present"))?stu1[6]++:0;
				p=(co.getH()==null)?0:(co.getH().equals("Present"))?stu1[7]++:0;
				p=(co.getI()==null)?0:(co.getI().equals("Present"))?stu1[8]++:0;
				p=(co.getJ()==null)?0:(co.getJ().equals("Present"))?stu1[9]++:0;
				p=(co.getK()==null)?0:(co.getK().equals("Present"))?stu1[10]++:0;
				p=(co.getL()==null)?0:(co.getL().equals("Present"))?stu1[11]++:0;
				p=(co.getM()==null)?0:(co.getM().equals("Present"))?stu1[12]++:0;
				p=(co.getN()==null)?0:(co.getN().equals("Present"))?stu1[13]++:0;
				p=(co.getO()==null)?0:(co.getO().equals("Present"))?stu1[14]++:0;
				p=(co.getP()==null)?0:(co.getP().equals("Present"))?stu1[15]++:0;
				p=(co.getQ()==null)?0:(co.getQ().equals("Present"))?stu1[16]++:0;
				p=(co.getR()==null)?0:(co.getR().equals("Present"))?stu1[17]++:0;
				p=(co.getS()==null)?0:(co.getS().equals("Present"))?stu1[18]++:0;
				p=(co.getT()==null)?0:(co.getT().equals("Present"))?stu1[19]++:0;
				p=(co.getU()==null)?0:(co.getU().equals("Present"))?stu1[20]++:0;
				p=(co.getV()==null)?0:(co.getV().equals("Present"))?stu1[21]++:0;
				p=(co.getW()==null)?0:(co.getW().equals("Present"))?stu1[22]++:0;
				p=(co.getX()==null)?0:(co.getX().equals("Present"))?stu1[23]++:0;
				p=(co.getY()==null)?0:(co.getY().equals("Present"))?stu1[24]++:0;
				p=(co.getZ()==null)?0:(co.getZ().equals("Present"))?stu1[25]++:0;
				p=(co.getA1()==null)?0:(co.getA1().equals("Present"))?stu1[26]++:0;
				p=(co.getA2()==null)?0:(co.getA2().equals("Present"))?stu1[28]++:0;
				p=(co.getA3()==null)?0:(co.getA3().equals("Present"))?stu1[29]++:0;
				p=(co.getA4()==null)?0:(co.getA4().equals("Present"))?stu1[30]++:0;
				p=(co.getA5()==null)?0:(co.getA5().equals("Present"))?stu1[31]++:0;
				p=(co.getA6()==null)?0:(co.getA6().equals("Present"))?stu1[32]++:0;
				p=(co.getA7()==null)?0:(co.getA7().equals("Present"))?stu1[33]++:0;
				p=(co.getA8()==null)?0:(co.getA8().equals("Present"))?stu1[34]++:0;
				p=(co.getA9()==null)?0:(co.getA9().equals("Present"))?stu1[35]++:0;
				p=(co.getA10()==null)?0:(co.getA10().equals("Present"))?stu1[36]++:0;
				p=(co.getA11()==null)?0:(co.getA11().equals("Present"))?stu1[37]++:0;
				p=(co.getA12()==null)?0:(co.getA12().equals("Present"))?stu1[38]++:0;
				p=(co.getA13()==null)?0:(co.getA13().equals("Present"))?stu1[39]++:0;
				p=(co.getA14()==null)?0:(co.getA14().equals("Present"))?stu1[40]++:0;
				p=(co.getA15()==null)?0:(co.getA15().equals("Present"))?stu1[41]++:0;
				p=(co.getA16()==null)?0:(co.getA16().equals("Present"))?stu1[42]++:0;
				p=(co.getA17()==null)?0:(co.getA17().equals("Present"))?stu1[43]++:0;
				p=(co.getA18()==null)?0:(co.getA18().equals("Present"))?stu1[44]++:0;
				p=(co.getA19()==null)?0:(co.getA19().equals("Present"))?stu1[45]++:0;
				p=(co.getA20()==null)?0:(co.getA20().equals("Present"))?stu1[46]++:0;
				p=(co.getA21()==null)?0:(co.getA21().equals("Present"))?stu1[47]++:0;
				p=(co.getA22()==null)?0:(co.getA22().equals("Present"))?stu1[48]++:0;
				p=(co.getA23()==null)?0:(co.getA23().equals("Present"))?stu1[49]++:0;
				p=(co.getA24()==null)?0:(co.getA24().equals("Present"))?stu1[50]++:0;
				p=(co.getA25()==null)?0:(co.getA25().equals("Present"))?stu1[51]++:0;
				p=(co.getA26()==null)?0:(co.getA26().equals("Present"))?stu1[52]++:0;
				p=(co.getA27()==null)?0:(co.getA27().equals("Present"))?stu1[53]++:0;
				p=(co.getA28()==null)?0:(co.getA28().equals("Present"))?stu1[54]++:0;
				p=(co.getA29()==null)?0:(co.getA29().equals("Present"))?stu1[55]++:0;
				p=(co.getA30()==null)?0:(co.getA30().equals("Present"))?stu1[56]++:0;
				p=(co.getA31()==null)?0:(co.getA31().equals("Present"))?stu1[57]++:0;
				p=(co.getA32()==null)?0:(co.getA32().equals("Present"))?stu1[58]++:0;
				p=(co.getA33()==null)?0:(co.getA33().equals("Present"))?stu1[59]++:0;
				p=(co.getA34()==null)?0:(co.getA34().equals("Present"))?stu1[60]++:0;
				p=(co.getA35()==null)?0:(co.getA35().equals("Present"))?stu1[61]++:0;
				p=(co.getA36()==null)?0:(co.getA36().equals("Present"))?stu1[62]++:0;
				p=(co.getA37()==null)?0:(co.getA37().equals("Present"))?stu1[63]++:0;
				p=(co.getA38()==null)?0:(co.getA38().equals("Present"))?stu1[64]++:0;
				p=(co.getA39()==null)?0:(co.getA39().equals("Present"))?stu1[65]++:0;
				p=(co.getA40()==null)?0:(co.getA40().equals("Present"))?stu1[66]++:0;
				p=(co.getA41()==null)?0:(co.getA41().equals("Present"))?stu1[67]++:0;
				p=(co.getA42()==null)?0:(co.getA42().equals("Present"))?stu1[68]++:0;
				p=(co.getA43()==null)?0:(co.getA43().equals("Present"))?stu1[69]++:0;
				p=(co.getA44()==null)?0:(co.getA44().equals("Present"))?stu1[70]++:0;
			}
			}
		for(int i=0;i<71;i++) {
			System.out.print((((float)stu1[i]/total)*100)+" ");
		}
		session.setAttribute("stu1", stu1);
		session.setAttribute("total", total);
		System.out.println(total);return "attper";}
		catch(Exception e) {}
		return null;
	}
	@RequestMapping("/exceldownload/{year}")
	public void exp(@PathVariable("year") String year,HttpServletResponse response) throws IOException {
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue="attachement; filename=Student_details.xlsx";
		if(year.equals("2")) {
			headerValue = "attachement; filename=Second_year_students.xlsx";
		}
		if(year.equals("3")) {
			headerValue = "attachement; filename=Third_year_students.xlsx";
		}
		if(year.equals("4")) {
			headerValue = "attachement; filename=Final_year_students.xlsx";
		}
		response.setHeader(headerKey, headerValue);
		ExcelExport excel = new ExcelExport();
		excel.export(response);
	}
	@GetMapping("/exceldetail/{sub}")
	public void export(@PathVariable("sub") String sub,HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String year = sub.split(" ")[1];
		String subs = sub.split(" ")[0];
		String headerKey = "Content-Disposition";
		if(year.equals("2")) {
			String headerValue = "attachement; filename=second_year_attendance.xlsx";
			response.setHeader(headerKey, headerValue);
			List<Attendance> att2 = att_ser.findBySubs(subs);
			List<SecondYear> secondyear = ser2.getDetails();
			UserExcelExporter excel = new UserExcelExporter(secondyear,att2);
			excel.export(response);
		}
		if(year.equals("3")) {
			String headerValue = "attachement; filename=third_year_attendance.xlsx";
			response.setHeader(headerKey, headerValue);
			List<Attendance3> att3 = att_ser3.findBySubs(subs);
			List<ThirdYear> thirdyear = ser3.getDetails();
			UserExcel3 excel = new UserExcel3(thirdyear,att3);
			excel.export(response);
		}
		if(year.equals("4")) {
			String headerValue = "attachement; filename=final_year_attendance.xlsx";
			response.setHeader(headerKey, headerValue);
			List<Attendance4> att4 = att_ser4.findBySubs(subs);
			List<FinalYear> finalyear = ser4.getDetails();
			UserExcel4 excel = new UserExcel4(finalyear,att4);
			excel.export(response);
		}
	}
	@Autowired
	private AchieveService achieve_ser;
	@RequestMapping("/oness/{uname}")
	public String oness(Model model,HttpSession session,@PathVariable("uname") String uname) {
		session.setAttribute("uname", uname);
		model.addAttribute("achieve",achieve_ser.finds(uname));
		System.out.println(uname);
		return "NewFile";
	}
	@PostMapping("/achievs/{uname}")
	public String achievs(HttpServletRequest req,@PathVariable("uname") String uname, Model model,@RequestParam("fileimage") MultipartFile fileImage) throws IOException {
		String name=uname;
		System.out.println(uname);
		String desc = req.getParameter("desc");
		if(desc==null) {
			desc="-";
		}
		achieve_ser.saveimage(fileImage, name, desc);
		return "redirect:/achiev/uname="+name;
	}
	@RequestMapping("/achiev/{uname}")
	public String achiev(@PathVariable("uname") String uname,Model model) {
		String name = uname.split("=")[1];
		model.addAttribute("achieve",achieve_ser.finds(name));
		return "NewFile";
	}
	@RequestMapping("/shows")
	public String sysou() {
		return "studets";
	}
	@RequestMapping("/done")
	public void sysouts() {
		System.out.println("done!!!");
	}
	@Autowired
	private ImageService img_ser;
	@RequestMapping("/images")
	public String images(Model model) {
		Image im = new Image();
		model.addAttribute("image",im);
		return "images";
	}
	
	@RequestMapping("/image/save")
	public String imagessave(Model model,@RequestParam("fileimage") MultipartFile fileImage,@RequestParam("name") String name) throws IOException {
		img_ser.savess(fileImage, name);
		model.addAttribute("sees",img_ser.getAll());
		return "frontpage";
	}
	@GetMapping("/intrested/{uname}")
	public String intrested(Model model,@PathVariable("uname") String uname,HttpSession session) {
		String un = uname.split(" ")[0];
		String year = uname.split(" ")[1];
		session.setAttribute("yer", year);
		Teachers tecs = tec_ser.findbyuname(un);
		model.addAttribute("users",tecs);
		if(year.equals("2")) {
			model.addAttribute("curi",curi_ser.findByYear("2"));
			model.addAttribute("curi",curi_ser.findByYear("2"));
			model.addAttribute("prof",pro_ser.findByYear("2"));
		}
		if(year.equals("3")) {
			model.addAttribute("curi",curi_ser.findByYear("3"));
			model.addAttribute("curi",curi_ser.findByYear("3"));
			model.addAttribute("prof",pro_ser.findByYear("3"));
		}
		if(year.equals("4")) {
			model.addAttribute("curi",curi_ser.findByYear("4"));
			model.addAttribute("curi",curi_ser.findByYear("4"));
			model.addAttribute("prof",pro_ser.findByYear("4"));
		}
		return "intrested";
	}
	@PostMapping("/intsave/{uname}")
	public String intsave(HttpSession session,@ModelAttribute("user") Teachers user,Model model,@PathVariable("uname") String uname) {
		String un = uname.split(" ")[0];
		String year = uname.split(" ")[1];
		Teachers tec = tec_ser.findbyuname(un);
		if(year.equals("2")) {
			tec.setSubi21(user.getSubi21());
			tec.setSubi22(user.getSubi22());
			tec.setSubi23(user.getSubi23());
		}if(year.equals("3")) {
			tec.setSubi31(user.getSubi31());
			tec.setSubi32(user.getSubi32());
			tec.setSubi33(user.getSubi33());
		}if(year.equals("4")) {
			tec.setSubi41(user.getSubi41());
			tec.setSubi42(user.getSubi42());
			tec.setSubi43(user.getSubi43());
		}
		tec_ser.savetec(tec);
		model.addAttribute("teacher",tec);
		session.setAttribute("yer", year);
		return "tedet";
		
	}
	@RequestMapping("/tedets/{uname}")
	public String tecreqq(HttpSession session,@PathVariable("uname") String uname,Model model) {
		String name = uname.split("=")[1];
		String year = uname.split("=")[2];
		session.setAttribute("yer", year);
		Teachers tec = tec_ser.findbyuname(name);
		model.addAttribute("teacher",tec);
		return "tedet";
	}
	@GetMapping("/allocation")
	public String allocation(Model model) {
		model.addAttribute("teachers",tec_ser.getDetails());
		return "allocation";
	}
	@RequestMapping("/suballot/{uname}")
	public String suballot(Model model,@PathVariable("uname") String uname) {
		model.addAttribute("det",tec_ser.findbyuname(uname));
		return "suballot";
	}
	@PostMapping("/suballotsave")
	public String suballotsave(HttpServletRequest req,Model model,@ModelAttribute("det") Teachers det) {
		String name = req.getParameter("uname");
		Teachers tec = tec_ser.findbyuname(name);
		tec.setSub1(det.getSub1());
		tec.setSub11(det.getSub11());
		tec.setSub2(det.getSub2());
		tec.setSub22(det.getSub22());
		tec.setSub3(det.getSub3());
		tec.setSub33(det.getSub33());
		tec_ser.savetec(tec);
		model.addAttribute("teacher",tec_ser.getDetails());
		return "allocation";
	}
}

