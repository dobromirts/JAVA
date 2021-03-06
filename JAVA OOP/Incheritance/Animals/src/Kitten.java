public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound() {
        return "Miau";
    }

    @Override
    protected void setGender(String gender) {
        super.setGender("female");
    }
}
