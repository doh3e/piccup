package com.ssafy.piccup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.piccup.model.dto.PersonalInfo;
import com.ssafy.piccup.service.PersonalInfoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/resume")
public class ResumeController {

	// 서비스 의존성 주입
	private final PersonalInfoService personalInfoService;
	
	public ResumeController(PersonalInfoService personalInfoService) {
		this.personalInfoService = personalInfoService;
	}
	
	// 이력서 전체 조회
	@GetMapping("/")
	public ResponseEntity<List<PersonalInfo>> list(Model model) {
		// 인적사항
		List<PersonalInfo> personalInfos = personalInfoService.readPersonalList();
		return new ResponseEntity<>(personalInfos, HttpStatus.OK);
	}
	
	// 특정 인적사항 조회
	@GetMapping("/{infoId}")
	public ResponseEntity<?> detail(@PathVariable int infoId) {
		PersonalInfo personalinfo = personalInfoService.readPersonal(infoId);
		if (personalinfo != null) {
			return new ResponseEntity<PersonalInfo>(personalinfo, HttpStatus.OK);
		}
		// infoId에 해당하는 데이터가 없는 경우
		return new ResponseEntity<String>("infoId에 해당하는 인적사항이 없습니다.", HttpStatus.NOT_FOUND);
	}
	
	// 인적사항 생성
	@PostMapping("/")
	public ResponseEntity<PersonalInfo> write(@RequestBody PersonalInfo personalInfo) {
		personalInfoService.createPersonal(personalInfo);
		return new ResponseEntity<>(personalInfo, HttpStatus.CREATED);
	}	

	
//  // 인적사항 삭제
//  @DeleteMapping("/{infoId}")
//  public ResponseEntity<String> deletePersonalInfo(@PathVariable int infoId) {
//      personalInfoService.deletePersonalInfoById(infoId);
//      return new ResponseEntity<>("Personal info deleted successfully.", HttpStatus.NO_CONTENT);
//  }

	
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
	

//
//    // 인적사항 수정
//    @PutMapping("/{infoId}")
//    public ResponseEntity<String> updatePersonal(@PathVariable int infoId, @RequestBody PersonalInfo personalInfo) {
//        personalInfo.setInfoId(infoId);
//        personalInfoService.updatePersonal(personalInfo);
//        return new ResponseEntity<>("Personal info updated successfully.", HttpStatus.OK);
//    }
//	
}
