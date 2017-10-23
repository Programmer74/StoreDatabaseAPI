package usertypes;

import org.hibernate.HibernateException;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressUserType implements UserType{
    @Override
    public int[] sqlTypes() {
        return new int[] {StandardBasicTypes.INTEGER.sqlType(), StandardBasicTypes.INTEGER.sqlType(),
                StandardBasicTypes.STRING.sqlType(), StandardBasicTypes.STRING.sqlType(),
                StandardBasicTypes.STRING.sqlType()};
    }

    @Override
    public Class<Address> returnedClass(){
        return Address.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException{
        if (null == x || null == y) return false;
        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, org.hibernate.engine.spi.SharedSessionContractImplementor session,
                              Object owner)
            throws HibernateException, SQLException {
        Address address = new Address();
        Integer appartement = rs.getInt(names[0]);
        if (appartement != null) address.setAppartement(new Integer(appartement));

        Integer building = rs.getInt(names[1]);
        if(building != null) address.setBuilding(new Integer(building));

        String street = rs.getString(names[2]);
        if (street != null) address.setStreet(new String(street));

        String city = rs.getString(names[3]);
        if (city != null) address.setCity(new String(city));

        String zipcode = rs.getString(names[4]);
        if (zipcode != null) address.setZipCode(new String(zipcode));

        return address;
    }

    /*public void nullSafeSet(java.sql.PreparedStatement st, java.lang.Object value, int index),
                            org.hibernate.engine.spi.SessionImplementor session)*/
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, org.hibernate.engine.spi.SharedSessionContractImplementor session)
    throws HibernateException, SQLException {
        Address address = (Address) value;

        if (null != address.getAppartement()) {
            Integer appartement = new Integer(address.getAppartement());
            st.setInt(index, appartement);
        }
        else {
            st.setNull(index, StandardBasicTypes.INTEGER.sqlType());
        }

        if (null != address.getBuilding()) {
            Integer building = new Integer(address.getBuilding());
            st.setInt(index + 1, building);
        }
        else {
            st.setNull(index + 1, StandardBasicTypes.INTEGER.sqlType());
        }


        if (null != address.getStreet()) {
            String street = new String(address.getStreet());
            st.setString(index + 2, street);
        }
        else {
            st.setNull(index + 2, StandardBasicTypes.STRING.sqlType());
        }


        if (null != address.getCity()) {
            String city = new String(address.getCity());
            st.setString(index + 3, city);
        }
        else {
            st.setNull(index + 3, StandardBasicTypes.STRING.sqlType());
        }

        if (null != address.getZipCode()) {
            String zipCode = new String(address.getZipCode());
            st.setString(index + 4, zipCode);
        }
        else {
            st.setNull(index + 4, StandardBasicTypes.STRING.sqlType());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        Address address = (Address) value;
        Address copy = new Address(address.getAppartement(), address.getBuilding(), address.getStreet(),
                address.getCity(), address.getZipCode());
        return copy;
    }

    @Override
    public boolean isMutable(){
        return true;
    }

    @Override
    public Serializable disassemble(Object value)
            throws HibernateException {
        return (Serializable) this.deepCopy(value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return this.deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return this.deepCopy(original);
    }

}
