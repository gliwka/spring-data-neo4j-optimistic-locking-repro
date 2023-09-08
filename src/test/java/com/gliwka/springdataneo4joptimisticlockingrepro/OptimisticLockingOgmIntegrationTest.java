package com.gliwka.springdataneo4joptimisticlockingrepro;

import com.gliwka.springdataneo4joptimisticlockingrepro.ogm.domain.Organization;
import com.gliwka.springdataneo4joptimisticlockingrepro.ogm.domain.User;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.Driver;
import org.neo4j.ogm.drivers.bolt.driver.BoltDriver;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class OptimisticLockingOgmIntegrationTest extends IntegrationTest {

    @Autowired
    Driver driver;

    @Test
    void shouldNotBumpVersionOfUnchangedRelatedNodes() {
        org.neo4j.ogm.driver.Driver ogmDriver = new BoltDriver(driver);
        SessionFactory factory = new SessionFactory(ogmDriver, "com.gliwka.*");
        Session session = factory.openSession();

        Organization orga = new Organization();
        orga.setName("Wayne Enterprises");

        User user = new User();
        user.setName("Bruce Wayne");
        user.setOrganization(orga);
        session.save(user);

        Organization orgaBeforeUserChange = session.loadAll(Organization.class).iterator().next();
        assertThat(orgaBeforeUserChange.getVersion()).isEqualTo(0);

        User batman = session.loadAll(User.class).iterator().next();
        batman.setName("Batman");
        session.save(user);

        Organization orgaAfterUserChange = session.loadAll(Organization.class).iterator().next();
        assertThat(orgaAfterUserChange.getVersion()).isEqualTo(0);
    }
}
