package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution210 {

    public int[] res;
    public int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        res = new int[numCourses];

        Course[] courses = new Course[numCourses];
        for(int i = 0; i < courses.length; i++){
            courses[i] = new Course(i); //initialize course number
        }
        for(int i = 0; i < prerequisites.length; i++){
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]); //add prerequisite courses of each course
        }
        for(int i = 0; i<courses.length; i++){
            if(isCyclic(courses[i])){
                return new int[0];
            }
        }
        return res;
    }

    public boolean isCyclic(Course c){
        if(c.isTested) return false; //is tested before, not cyclic
        if(c.isVisited) return true; //is visiting the precourse, cyclic
        c.isVisited = true; //temporarily marked its visited state as true
        for(Course preC : c.pre){
            if(isCyclic(preC)) return true; // DFS search the pre course
        }
        c.isTested = true;
        res[index++] = c.courseNum;
        return false;
    }

    class Course{
        boolean isVisited;
        boolean isTested;
        int courseNum;
        List<Course> pre = new ArrayList<>();

        public Course(int i){
            this.courseNum = i;
        }

        public void add(Course c){
            this.pre.add(c);
        }
    }
}
