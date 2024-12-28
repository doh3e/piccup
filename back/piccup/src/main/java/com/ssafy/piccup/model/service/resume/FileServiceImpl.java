package com.ssafy.piccup.model.service.resume;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.piccup.model.dao.resume.FileDao;
import com.ssafy.piccup.model.dto.resume.FileDto;

@Service
public class FileServiceImpl implements FileService {

	private final FileDao fileDao;
	private final ResourceLoader resourceLoader;
	
	public FileServiceImpl(FileDao fileDao, ResourceLoader resourceLoader) {
		this.fileDao = fileDao;
		this.resourceLoader = resourceLoader;
	}
	
	// 삽입
	// - 성적증명서 삽입
	@Transactional
	@Override
	public void uploadEduFile(int resumeId, MultipartFile file) {
		// 파일이 존재할 때 처리
 		try {
 			if (file != null && file.getSize() > 0) {
 				// 파일 변환
 				// - 실제 파일이름 생성
 				String eduFileName = file.getOriginalFilename(); 
 				// - 확장자 추출
 				String fileExtension = "";
 				if (eduFileName != null && eduFileName.contains(".")) {
 					fileExtension = eduFileName.substring(eduFileName.lastIndexOf("."));
 				}
 				// - 고유한 파일 이름 생성 (UUID + 확장자)
 				String eduFilePath = UUID.randomUUID().toString() + fileExtension;
		 				
 				// 파일 객체 생성
 				FileDto fileDto = new FileDto();
 				fileDto.setResumeId(resumeId);
 				fileDto.setEduFileName(eduFileName);
 				fileDto.setEduFilePath(eduFilePath);

 				Resource resource = resourceLoader.getResource("classpath:/static/education_files");
 				file.transferTo(new File(resource.getFile(), eduFilePath)); // 파일저장
		 				
 				if (fileDao.insertEduFile(fileDto) != 1) {
 					throw new RuntimeException("upload Education File 실패");
 				}
 			}
 		} catch (IllegalStateException | IOException e) {
 			e.printStackTrace();
 	        throw new RuntimeException("파일 입출력 오류 발생 : " + e.getMessage(), e);
 		 } catch (Exception e) {
 		        throw new RuntimeException("성적증명서 업로드 실패 : "+ e.getMessage(), e);
 		}
 	}

	// - 포트폴리오 삽입
	@Transactional
	@Override
    public void uploadPortFile(int resumeId, MultipartFile file) {
 		// 파일이 존재할 때 처리
 		try {
 			if (file != null && file.getSize() > 0) {
 				// 파일 변환
 				// - 실제 파일이름 생성
 				String portFileName = file.getOriginalFilename(); 
 				// - 확장자 추출
 				String fileExtension = "";
 				if (portFileName != null && portFileName.contains(".")) {
 					fileExtension = portFileName.substring(portFileName.lastIndexOf("."));
 				}
 				// - 고유한 파일 이름 생성 (UUID + 확장자)
 				String portFilePath = UUID.randomUUID().toString() + fileExtension;
 				
 				// 파일 객체 생성
 				FileDto fileDto = new FileDto();
 				fileDto.setResumeId(resumeId);
 				fileDto.setPortFileName(portFileName);
 				fileDto.setPortFilePath(portFilePath);

 				Resource resource = resourceLoader.getResource("classpath:/static/portfolio_files");
 				file.transferTo(new File(resource.getFile(), portFilePath)); // 파일저장
 				
 				if (fileDao.insertPortFile(fileDto) != 1) {

 					throw new RuntimeException("upload Portfolio File 실패");
 				}
 			}
 		} catch (IllegalStateException | IOException e) {
 			e.printStackTrace();
 	        throw new RuntimeException("포트폴리오 파일 입출력 오류 발생 : " + e.getMessage(), e);
 		 } catch (Exception e) {
 		        throw new RuntimeException("포트폴리오 파일 업로드 실패 : "+ e.getMessage(), e);
 		}
 	}
	
	// - 경력증명서 삽입
	@Transactional
	@Override
	public void uploadWorkFile(int resumeId, MultipartFile file) {
		// 파일이 존재할 때 처리
		try {
			if (file != null && file.getSize() > 0) {
				// 파일 변환
				// - 실제 파일이름 생성
				String workFileName = file.getOriginalFilename(); 
				// - 확장자 추출
				String fileExtension = "";
				if (workFileName != null && workFileName.contains(".")) {
					fileExtension = workFileName.substring(workFileName.lastIndexOf("."));
				}
				// - 고유한 파일 이름 생성 (UUID + 확장자)
				String workFilePath = UUID.randomUUID().toString() + fileExtension;
				
				// 파일 객체 생성
				FileDto fileDto = new FileDto();
				fileDto.setResumeId(resumeId);
				fileDto.setWorkFileName(workFileName);
				fileDto.setWorkFilePath(workFilePath);
				
				Resource resource = resourceLoader.getResource("classpath:/static/work_files");
				file.transferTo(new File(resource.getFile(), workFilePath)); // 파일저장
				
				if (fileDao.insertWorkFile(fileDto) != 1) {
					
					throw new RuntimeException("upload Work File 실패");
				}
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException("경력증명서 파일 입출력 오류 발생 : " + e.getMessage(), e);
		} catch (Exception e) {
			throw new RuntimeException("경력증명서 업로드 실패 : "+ e.getMessage(), e);
		}
	}
	
	// 조회
	
	// - 성적증명서 조회
	@Override
	public FileDto readEduFile(int resumeId) {
		try {
	        return fileDao.selectEduFile(resumeId);
	    } catch (RuntimeException e) {
	        System.err.println("성적증명서 조회 런타임 예외 발생: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        // 일반 예외 처리
	        System.err.println("알 수 없는 오류 발생: " + e.getMessage());
        	throw new RuntimeException("교육 파일 정보를 가져오는 중 오류가 발생했습니다.", e);
	    }
	}
	
	// - 포트폴리오 조회
	@Override
	public List<FileDto> readPortFileList(int resumeId) {
		try {
	        return fileDao.selectPortFileList(resumeId);
	    } catch (RuntimeException e) {
	        System.err.println("포트폴리오 파일 조회 런타임 예외 발생: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        // 일반 예외 처리
	        System.err.println("알 수 없는 오류 발생: " + e.getMessage());
        	throw new RuntimeException("포트폴리오 파일 정보를 가져오는 중 오류가 발생했습니다.", e);
	    }
	}

	// - 경력증명서 조회
	@Override
	public FileDto readWorkFile(int resumeId) {
		try {
	        return fileDao.selectWorkFile(resumeId);
	    } catch (RuntimeException e) {
	        System.err.println("경력증명서 조회 런타임 예외 발생: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        // 일반 예외 처리
	        System.err.println("알 수 없는 오류 발생: " + e.getMessage());
        	throw new RuntimeException("경력증명서 정보를 가져오는 중 오류가 발생했습니다.", e);
		}
	}
	
}
