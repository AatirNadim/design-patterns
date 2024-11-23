package design_patterns.structural;

import java.util.ArrayList;
import java.util.List;

interface Department {
    void printDepartmentDetails();
}

class CSDepartment implements Department {
    @Override
    public void printDepartmentDetails() {
        System.out.println("this is the cs dept.");
    }
}


class University {
    List<Department> ls;

    University(List<Department> ls) {
        this.ls = new ArrayList<>();
        this.ls.addAll(ls);
    }


    public void addDepartment(Department dept) {
        this.ls.add(dept);
    }
}

