package domain;

import lombok.Data;

@Data 
public class ExamBean {
	private String examSeq, recordSeq, subSeq, memId, score, month;

	@Override
	public String toString() {
		return "시험정보 [시험Seq=" + examSeq 
				+ ",\n 성적표Seq=" + recordSeq 
				+ ",\n 과목Seq=" + subSeq 
				+ ",\n 학생Id=" + memId
				+ ",\n 점수=" + score + 
				",\n month=" + month + "]";
	}

}
