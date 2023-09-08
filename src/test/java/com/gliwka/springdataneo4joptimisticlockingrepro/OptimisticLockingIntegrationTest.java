package com.gliwka.springdataneo4joptimisticlockingrepro;

import com.gliwka.springdataneo4joptimisticlockingrepro.domain.Organization;
import com.gliwka.springdataneo4joptimisticlockingrepro.domain.OrganizationRepository;
import com.gliwka.springdataneo4joptimisticlockingrepro.domain.User;
import com.gliwka.springdataneo4joptimisticlockingrepro.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class OptimisticLockingIntegrationTest extends IntegrationTest{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    void shouldNotBumpVersionOfUnchangedRelatedNodes() {
        Organization orga = new Organization();
        orga.setName("Wayne Enterprises");

        User user = new User();
        user.setName("Bruce Wayne");
        user.setOrganization(orga);
        userRepository.save(user);

        Organization orgaBeforeUserChange = organizationRepository.findAll().iterator().next();
        assertThat(orgaBeforeUserChange.getVersion()).isEqualTo(0);

        User batman = userRepository.findAll().iterator().next();
        batman.setName("Batman");
        userRepository.save(user);

        Organization orgaAfterUserChange = organizationRepository.findAll().iterator().next();
        assertThat(orgaAfterUserChange.getVersion()).isEqualTo(0);
    }
}
