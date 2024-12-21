package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.PersonalInfo;
import com.ssafy.piccup.service.PersonalInfoService;

@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 서비스 의존성 주입
	private final PersonalInfoService personalInfoService;
	
	public ResumeController(PersonalInfoService personalInfoService) {
		this.personalInfoService = personalInfoService;
	}
	
	// 이력서 전체조회
	@GetMapping("/")
	public ResponseEntity<List<PersonalInfo>> list(Model model) {
		List<PersonalInfo> personalInfos = personalInfoService.readPersonalList();
//		model.addAttribute("personalInfos", personalInfos);
		System.out.println(personalInfos); // 디버깅용
		return new ResponseEntity<>(personalInfos, HttpStatus.OK);
	}
//	
//	@GetMapping("/writeForm")
//	public String writeForm() {
//		return "board/writeform";
//	}
//	
//	@PostMapping("/write")
//	public String write(@ModelAttribute Board board) {
//		boardService.writeBoard(board);
//		return "redirect:list";
//	}
//	
//	@GetMapping("/detail")
//	public String detail(@RequestParam("id") int id, Model model) {
//		Board board = boardService.readBoard(id);
//		model.addAttribute("board", board);
//		return "/board/detail";
//	}
//	
//	
//	@GetMapping("/delete") // post요청이 더 적합함
//	public String delete(@RequestParam("id") int id) {
//		boardService.removeBoard(id);
//		return "redirect:list"; // servlet한테 list로 요청 다시 보내는 것
////		return "/board/list"; // 리졸버가 list 찾아오는 것 
//	}
//	
//	@GetMapping("/updateform")
//	public String updateform(@RequestParam("id") int id, Model model) {
//		// 현재는 readBoard로 해서 게시글 조회수 올라가는 것 유의
//		model.addAttribute("board", boardService.readBoard(id));
//		return "board/updateform";
//	}
//	
//	@PostMapping("/update")
//	public String update(@ModelAttribute Board board) {
//		boardService.modifyBoard(board);
//		return "redirect:detail?id="+board.getId();
//	}
//	
	

    // 특정 인적사항 조회
//    @GetMapping("/{infoId}")
//    public ResponseEntity<PersonalInfo> getPersonalInfo(@PathVariable int infoId) {
//        PersonalInfo personalInfo = personalInfoService.readPersonal(infoId);
//        if (personalInfo != null) {
//            return new ResponseEntity<>(personalInfo, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    // 인적사항 생성
//    @PostMapping("/")
//    public ResponseEntity<String> createPersonal(@RequestBody PersonalInfo personalInfo) {
//        personalInfoService.createPersonal(personalInfo);
//        return new ResponseEntity<>("Personal info created successfully.", HttpStatus.CREATED);
//    }
//
//    // 인적사항 수정
//    @PutMapping("/{infoId}")
//    public ResponseEntity<String> updatePersonal(@PathVariable int infoId, @RequestBody PersonalInfo personalInfo) {
//        personalInfo.setInfoId(infoId);
//        personalInfoService.updatePersonal(personalInfo);
//        return new ResponseEntity<>("Personal info updated successfully.", HttpStatus.OK);
//    }
//
//    // 인적사항 삭제
//    @DeleteMapping("/{infoId}")
//    public ResponseEntity<String> deletePersonalInfo(@PathVariable int infoId) {
//        personalInfoService.deletePersonalInfoById(infoId);
//        return new ResponseEntity<>("Personal info deleted successfully.", HttpStatus.NO_CONTENT);
//    }
	
}
