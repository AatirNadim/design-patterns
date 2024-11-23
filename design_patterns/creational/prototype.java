package design_patterns.creational;

interface Employee extends Cloneable {
    void setEmpId(int id);
    void setEmpName(String name);
    Employee clone() throws CloneNotSupportedException;
}


class Developer implements Employee {
    private int empId;
    private String empName;

    @Override
    public void setEmpId(int id) {
        this.empId = id;
    }

    @Override
    public void setEmpName(String name) {
        this.empName = name;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

}