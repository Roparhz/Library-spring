package fr.julienleveque.cefimtestcda2.review;

public class Review {

    private Integer id;
    private Integer note;
    private String content;

    public Review(Integer note, String content) {
        this.note = note;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }


    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
