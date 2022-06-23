package board.model;

public class BoardDto {		//Dto(Data Transfer Object)는 Vo(Value Object)
	
	private long no;
	private String title;
	private String name;
	private String password;
	private String content;
	private String writeday;
	private int readcount;
		
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BoardDto [no=" + getNo() + ", title=" + getTitle() + ", name= " + getName() + ", password=" + getPassword() + ", content= " + getContent() + ", writeday= " + getWriteday()
		+ ", readcount= " + getReadcount() + "]";
	}
	
	

}
