public class SLO {

    private String name;
    private double value;
    private String operator;
    private String unit;
    private String level;

    public SLO(String name, double value,String operator) {
        this.name=name;
        this.value=value;
        this.operator=operator;
        this.unit="";
        this.level="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
