package Test;

import java.io.Serializable;

/**
 * Created by Think on 2017/10/30.
 */
public class User implements Serializable {
    public String id;
    public String name;
    public String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        //return new HashCodeBuilder().append(name).toHashCode();
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj) {
            return true;
        }
        if (obj instanceof User) {
            User other = (User) obj;
            return (other.name).equals(this.name);
        }
        return false;
    }
}
