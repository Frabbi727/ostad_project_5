public final class Student {
    private final long id;
    private final String fullName;
    private final String bloodGroup;
    private final float cgpa;

    public Student(long id, String fullName, String bloodGroup, float cgpa) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.cgpa = cgpa;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public float getCgpa() {
        return cgpa;
    }

    private String getLastName() {
        String[] nameParts = fullName.trim().split("\\s+");
        return nameParts.length > 1 ? nameParts[nameParts.length - 1] : "";
    }

    public void print() {
        System.out.println("ID: " + id + ", Name: " + fullName + ", Blood Group: " + bloodGroup + ", CGPA: " + cgpa);
    }

    public boolean matchesCriteria(String query) {
        if (query == null || query.trim().isEmpty()) {
            return false;
        }

        String queryLower = query.toLowerCase().trim();
        String lastName = getLastName().toLowerCase();
        String bloodGroupLower = bloodGroup.toLowerCase();

        return (!lastName.isEmpty() && lastName.equals(queryLower)) ||
               bloodGroupLower.equals(queryLower);
    }
}