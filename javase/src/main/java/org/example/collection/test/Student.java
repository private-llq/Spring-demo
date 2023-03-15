package org.example.collection.test;

import java.util.List;

/**
 * @author liuliangqi
 * @date 2023/3/15 14:31
 */
//这是我们的类Student类，并没有set方法
class Student {
  private String sid;
  private String sname;
  private List<Course> cources;

  public Student() {}

  public Student(String sid, String sname, List<Course> cources) {
    this.sid = sid;
    this.sname = sname;
    this.cources = cources;
  }

  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }

  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }

  public List<Course> getCources() {
    return cources;
  }

  @Override
  public String toString() {
    return "Student{"
        + "sid='"
        + sid
        + '\''
        + ", sname='"
        + sname
        + '\''
        + ", cources="
        + cources
        + '}';
  }

  static class Course {
    private String cid;
    private String cname;

    public Course(String cid, String cname) {
      this.cid = cid;
      this.cname = cname;
    }

    public Course() {}

    public String getCid() {
      return cid;
    }

    public void setCid(String cid) {
      this.cid = cid;
    }

    public String getCname() {
      return cname;
    }

    public void setCname(String cname) {
      this.cname = cname;
    }

    @Override
    public String toString() {
      return "Course{" + "cid='" + cid + '\'' + ", cname='" + cname + '\'' + '}';
    }
  }
}
