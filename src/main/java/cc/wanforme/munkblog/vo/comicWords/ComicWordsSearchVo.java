package cc.wanforme.munkblog.vo.comicWords;

import cc.wanforme.munkblog.vo.SearchVo;

/**
 * @author wanne
 * 2020年9月20日
 */
public class ComicWordsSearchVo extends SearchVo{

    private String author;
    
    private String text;
    
    private String valid;
    
    public String getAuthor() {
		return author;
	}
    public void setAuthor(String author) {
		this.author = author;
	}
    public String getText() {
		return text;
	}
    public void setText(String text) {
		this.text = text;
	}
    public String getValid() {
		return valid;
	}
    public void setValid(String valid) {
		this.valid = valid;
	}
}
