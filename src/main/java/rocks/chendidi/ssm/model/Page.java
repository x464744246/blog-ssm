package rocks.chendidi.ssm.model;

import rocks.chendidi.ssm.util.PublicValue;

import java.util.*;

/**
 * Created by lenov0 on 2016/7/8.
 */
public class Page {
    private int totlePage;
    private int current;
    private int totleRows;
    private List<Integer> perPage=new ArrayList<Integer>() ;

    public void setPerPage(){
        if(current<=3)
            for(int i=0;i< PublicValue.PERPAGE;i++)
                perPage.add(i,i+1);
        else if(current>=(totlePage-2)){
            for(int i=0;i< PublicValue.PERPAGE;i++)
                perPage.add(i,totlePage-(PublicValue.PERPAGE-i)+1);
        }
        else{
            for(int i=0;i< PublicValue.PERPAGE;i++)
                perPage.add(i,current-2+i);
        }

    }


    public int getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(int totlePage) {
        this.totlePage = totlePage;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTotleRows() {
        return totleRows;
    }

    public void setTotleRows(int totleRows) {
        this.totleRows = totleRows;
    }

    public List<Integer> getPerPage() {
        return perPage;
    }

    public void setPerPage(List<Integer> perPage) {
        this.perPage = perPage;
    }
}
