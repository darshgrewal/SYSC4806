package Application;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;
    private String cellphone;

    @ManyToOne
    @JoinColumn(name="addressBookId")
    private AddressBook addressBook;

    public BuddyInfo(){
    }

    public BuddyInfo(String name, String cellphone){
        this.name = name;
        this.cellphone = cellphone;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCellphone(String cellphone){
        this.cellphone = cellphone;
    }

    public String getName(){
        return this.name;
    }

    public String getCellphone(){
        return this.cellphone;
    }

    @Override
    public String toString(){
        return this.name+" "+this.cellphone;
    }
}
