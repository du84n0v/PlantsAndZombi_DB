import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    private SessionFactory factory;

    static void main() {
        getPlansNameAndCode();
    }
    public static void getPlansNameAndCode() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate-config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        List<Object[]> ans = session.createQuery("select commonName, code from Plant ").getResultList();
        for(Object[] ii :ans){
            System.out.println("Name: " + ii[0] + "  Code:" + ii[1]);
        }

        factory.close();
        session.close();


    }


}
