package st.asojuku.ac.jp.familyapps;

/**
 * Created by Itchy on 2016/11/02.
 */
public class RData {
    private int number;
    private String content;

    public RData(int number,String content){
        this.number=number;
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public int getNumber() {
        return number;
    }
}
