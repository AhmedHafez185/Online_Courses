package net.ahmed.app.dal.entity;
// Generated Sep 5, 2020 12:30:41 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * CourseOutlines generated by hbm2java
 */
@Entity(name="course_outlines")
public class CourseOutlines  implements java.io.Serializable {


     private Integer id;
     private Course course;
     private String outline;
     private Set<Content> contents = new HashSet<Content>(0);

    public CourseOutlines() {
    }

	
    public CourseOutlines(Course course, String outline) {
        this.course = course;
        this.outline = outline;
    }
    public CourseOutlines(Course course, String outline, Set<Content> contents) {
       this.course = course;
       this.outline = outline;
       this.contents = contents;
    }
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="course_id", nullable=false)
    public Course getCourse() {
        return this.course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }

    
    @Column(name="outline", nullable=false)
    public String getOutline() {
        return this.outline;
    }
    
    public void setOutline(String outline) {
        this.outline = outline;
    }

@OneToMany(fetch=FetchType.EAGER, mappedBy="courseOutlines")
    public Set<Content> getContents() {
        return this.contents;
    }
    
    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }




}


