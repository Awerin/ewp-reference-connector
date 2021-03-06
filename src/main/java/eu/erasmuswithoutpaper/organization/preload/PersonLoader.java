
package eu.erasmuswithoutpaper.organization.preload;

import eu.erasmuswithoutpaper.internal.JsonHelper;
import eu.erasmuswithoutpaper.organization.entity.Person;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersonLoader {
    @PersistenceContext(unitName = "connector")
    EntityManager em;
    
    public void createDemoDataIkea() throws IOException {
        persistPerson("{'personId':'9001013344','firstNames':'Billy','lastName':'Thomas','birthDate':'1990-01-01'}");
        persistPerson("{'personId':'9011046365','firstNames':'Kate Alice','lastName':'Moneypenny','birthDate':'1990-11-04'}");
        persistPerson("{'personId':'8704122398','firstNames':'Carl Henry','lastName':'Simson','birthDate':'1987-04-12'}");
        persistPerson("{'personId':'8906093845','firstNames':'Mary','lastName':'Carter','birthDate':'1989-06-09'}");
        persistPerson("{'personId':'9107146991','firstNames':'Emily Nicole','lastName':'Morgan','birthDate':'1991-07-14'}");
    }

    public void createDemoDataPomodoro() throws IOException {
        persistPerson("{'personId':'8810126789','firstNames':'Ann Paige','lastName':'White','birthDate':'1988-10-12'}");
        persistPerson("{'personId':'8712146574','firstNames':'Kirk Gregory','lastName':'Willis','birthDate':'1987-12-14'}");
        persistPerson("{'personId':'9003228402','firstNames':'Arnold','lastName':'Jones','birthDate':'1990-03-22'}");
        persistPerson("{'personId':'8602181287','firstNames':'Sharon Hannah','lastName':'Lopez','birthDate':'1986-02-18'}");
        persistPerson("{'personId':'9104125620','firstNames':'Lucy','lastName':'Roberts','birthDate':'1991-04-12'}");
    }
    
    private void persistPerson(String personJson) throws IOException {
        Person person = JsonHelper.mapToObject(Person.class, personJson);
        em.persist(person);
    }
}
