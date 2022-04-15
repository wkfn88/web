package dto.board;

public class BoardVo {
	private int boardid;
	private String id;
	private String boardpwd;
	private String title;
	private String content;
	private String boarddate;
	private int boardstatus;
	private int viewcount;
	private int commentsize;

	public int getCommentsize() {
		return this.commentsize;
	}

	public void setCommentsize(int commentsize) {
		this.commentsize = commentsize;
	}

	public int getViewcount() {
		return this.viewcount;
	}

	public String getBoardpwd() {
		return this.boardpwd;
	}

	public void setBoardpwd(String boardpwd) {
		this.boardpwd = boardpwd;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public int getBoardid() {
		return this.boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoarddate() {
		return this.boarddate;
	}

	public void setBoarddate(String boarddate) {
		this.boarddate = boarddate;
	}

	public int getBoardstatus() {
		return this.boardstatus;
	}

	public void setBoardstatus(int boardstatus) {
		this.boardstatus = boardstatus;
	}
}
