package Application;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "addressBook")
    private List<BuddyInfo> buddyList;

    public AddressBook(){
        buddyList = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy){
        buddyList.add(buddy);
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public Integer getSize(){
        return buddyList.size();
    }

    public List<BuddyInfo> getBuddyList(){
        return buddyList;
    }

    public void setBuddyList(List buddyList){
        this.buddyList = buddyList;
    }

    public String toString(){
        String content = "";
        for (int i=0; i<buddyList.size();i++){
            content = buddyList.get(i).toString()+content;
        }
        return content;
    }


    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        ab.addBuddy(new BuddyInfo("Darsh","123"));
        ab.addBuddy(new BuddyInfo("Daman","321"));
        ab.addBuddy(new BuddyInfo("John","911"));
        System.out.println(ab.toString());

    }

}
