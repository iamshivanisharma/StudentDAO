package com.example.project;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class Data implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="Name")
    private String Name;

    @ColumnInfo(name="Marks")
    private String Marks;

    @ColumnInfo(name="Section")
    private String Section;

    @ColumnInfo(name = "finished")
    private boolean finished;


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public String getMarks() {
        return Marks;
    }

    public void setMarks(String Marks) {
        this.Marks=Marks;
    }
    public String getSection() {
        return Section;
    }

    public void setSection(String Section) {
        this.Section = Section;
    }


    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
