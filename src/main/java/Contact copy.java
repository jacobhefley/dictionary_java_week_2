import java.util.ArrayList;

public class Contact {
  private String mFirstName;
  private String mLastName;
  private String mHomePhone;
  private String mMobilePhone;
  private String mWorkPhone;
  private String mAddress;
  private String mEmail;
  private static ArrayList<Contact> instances = new ArrayList<Contact>();
  private int mId;

  public Contact(String firstName, String lastName, String homePhone, String mobilePhone, String workPhone, String address, String email) {
    mFirstName = firstName;
    mLastName = lastName;
    mHomePhone = homePhone;
    mMobilePhone = mobilePhone;
    mWorkPhone = workPhone;
    mAddress = address;
    mEmail = email;
    instances.add(this);
    mId = instances.size();
  }
  public Contact(String firstName, String lastName, String homePhone, String mobilePhone, String workPhone, String address, String email, int id) {
    mFirstName = firstName;
    mLastName = lastName;
    mHomePhone = homePhone;
    mMobilePhone = mobilePhone;
    mWorkPhone = workPhone;
    mAddress = address;
    mEmail = email;
    mId = id;
    instances.set(id - 1, this);
  }

  public String getfirstName() {
    return mFirstName;
  }
  public String getlastName() {
    return mLastName;
  }
  public String gethomePhone() {
    return mHomePhone;
  }
  public String getmobilePhone() {
    return mMobilePhone;
  }
  public String getworkPhone() {
    return mWorkPhone;
  }
  public String getaddress() {
    return mAddress;
  }
  public String getemail() {
    return mEmail;
  }
  public int getId() {
    return mId;
  }
  public static ArrayList<Contact> all() {
    return instances;
  }
  public static Contact find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }


}
