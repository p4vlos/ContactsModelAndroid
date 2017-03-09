package info.efstratiou.contacts;

/**
 * Created by ce208 on 16/02/2017.
 */

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int imageResource;

    public Contact(String firstName, String lastName, String phoneNumber, int imageResource) {
        this.firstName = firstName;
        this.imageResource = imageResource;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
