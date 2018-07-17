package service;

import java.util.List;

import dao.ExamDAOImpl;
import dao.RecordDAOImpl;
import dao.SubjectDAOImpl;
import domain.ExamBean;
import domain.MemberBean;
import domain.RecordBean;
import domain.SubjectBean;

public class ExamServiceImpl implements ExamService {
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {
		return instance;
	}
	private ExamServiceImpl() {}
	@Override
	public void createScore(ExamBean bean) {
		System.out.println("===== ExamService =====");
        System.out.println(bean);
        // 과목SEQ=null,
        // 성적표SEQ=null
        System.out.println("----- RECORD TABLE INSERT ------");
        RecordBean rec = new RecordBean();
        rec.setAvg("80");
        rec.setGrade("");
        RecordDAOImpl.getInstance().insertRecord(rec);
        System.out.println("------ Exam TABLE INSERT ------");
        bean.setScore(bean.getScore().split("/")[0]);
        bean.setSubSeq(
                SubjectDAOImpl.getInstance().
                selectSomeList("JAVA").get(0)
                .getSubSeq())
                ;
        bean.setRecordSeq(RecordDAOImpl.getInstance()
                .selectFirstRowNum());    
        ExamDAOImpl.getInstance().insertScore(bean);
	
	}
	@Override
	public List<ExamBean> showAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ExamBean> showSomeList(String exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ExamBean showOneList(String exam) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyExam(String exam) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeExam(String exam) {
		// TODO Auto-generated method stub
		
	}
}
