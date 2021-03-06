package com.coachcoach.service;

import java.util.List;
import java.util.Map;
import com.coachcoach.domain.CoachingProgram;

public interface CoachingProgramService {

  int add(CoachingProgram coachingProgram) throws Exception;

  List<CoachingProgram> list(int coachNo) throws Exception;

  List<CoachingProgram> list() throws Exception;

  List<CoachingProgram> pageList(Map<String, Object> params) throws Exception;

  List<CoachingProgram> applyList(Map<String, Object> params) throws Exception;

  int update(CoachingProgram coachingProgram) throws Exception;

  int delete(int no) throws Exception;

  List<CoachingProgram> search(Map<String, Object> params) throws Exception;

  List<CoachingProgram> findByGender(Map<String, Object> params) throws Exception;

  List<CoachingProgram> searchTag(Map<String, Object> params) throws Exception;

  List<CoachingProgram> searchReview(Map<String, Object> params) throws Exception;

  List<CoachingProgram> searchStar(Map<String, Object> params) throws Exception;

  CoachingProgram get(int no) throws Exception;

  CoachingProgram getProgram(int no) throws Exception;

  List<CoachingProgram> findByMemberNo(Map<String, Object> params) throws Exception;

  CoachingProgram findByOrderNo(Map<String, Object> params) throws Exception;

  CoachingProgram getDetail(int no) throws Exception;

  int pageCount() throws Exception;

  int deleteUpdate(int programNo) throws Exception;

  CoachingProgram selectStar(int no) throws Exception;

  int searchCnt(String keyword) throws Exception;

  int searchTagCnt(Map<String, Object> param) throws Exception;

  int findByGenderCnt(Map<String, Object> param) throws Exception;

  int findByStarCnt() throws Exception;

  int findByReviewCnt() throws Exception;
}
