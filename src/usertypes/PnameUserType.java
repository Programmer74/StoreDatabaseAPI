package usertypes;

import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.*;

public class PnameUserType implements UserType {
    private static final int SQL_TYPE = Types.STRUCT;
    private static final String DB_OBJECT_TYPE = "PNAME_T";

    @Override
    public int[] sqlTypes(){
        return new int[]{ SQL_TYPE };
    }

    @Override
    public Class returnedClass(){
        return Pname.class;
    }

    @Override
    public boolean equals(Object o1, Object o2) throws HibernateException {
        if (o1 == null || o2 == null) return false;
        return o1.equals(o2);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, org.hibernate.engine.spi.SharedSessionContractImplementor session,
                              Object owner)
            throws HibernateException, SQLException {
        final Struct struct = (Struct) rs.getObject(names[0]);
        if (rs.wasNull()) return null;

        final Pname pname = new Pname();
        pname.setFirstName((String) struct.getAttributes()[0]);
        pname.setLastName((String) struct.getAttributes()[1]);
        pname.setMiddleName((String) struct.getAttributes()[2]);

        return pname;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, org.hibernate.engine.spi.SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        if (value == null) st.setNull(index, SQL_TYPE, DB_OBJECT_TYPE);
        else {
            final Pname pname = (Pname) value;
            final Object[] values = new Object[] { pname.getFirstName(),
                pname.getLastName(), pname.getMiddleName() };
            final Connection connection = st.getConnection();
            final STRUCT struct = new STRUCT(StructDescriptor.createDescriptor(DB_OBJECT_TYPE,
                    connection), connection, values);
            st.setObject(index, struct, SQL_TYPE);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) return null;
        final Pname pname = (Pname) value;
        final Pname clone = new Pname(pname.getFirstName(), pname.getLastName(),
                pname.getMiddleName());

        return clone;
    }

    public boolean isMutable(){
        return true;
    }

    // TODO: implement later
    @Override
    public Object assemble(Serializable arg0, Object arg1){
        return null;
    }

    @Override
    public Serializable disassemble(Object arg0) throws HibernateException{
        return null;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        return 0;
    }

    @Override
    public Object replace(Object o1, Object o2, Object o3) throws HibernateException{
        return null;
    }
}
