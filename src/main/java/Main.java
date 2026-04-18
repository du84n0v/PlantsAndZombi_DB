import entity.Plant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class Main {
    private SessionFactory factory;

    static void main() {
//        getPlansNameAndCode();
        getFloweringAndExotic();
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

    public static void getFloweringAndExotic() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate-config.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Query<Plant> query = session.createQuery("from Plant where isFlowering = true and isExotic = true");
        List<Plant> ans = query.getResultList();
        for(Plant ii :ans){
            System.out.println(ii);
        }
        factory.close();
        session.close();
    }


}
