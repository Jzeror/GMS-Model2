package domain;

import lombok.Data;

@Data
public class ImageBean {
	private String imgSeq; //얘가 pk
	private String imgName;
	private String extension;
	private String memId;
}
