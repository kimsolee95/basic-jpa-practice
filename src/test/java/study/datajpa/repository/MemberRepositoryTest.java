package study.datajpa.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

@SpringBootTest
@Transactional
@Rollback(false)
public class MemberRepositoryTest {

  @Autowired
  MemberRepository memberRepository;

  @Test
  public void testMember() {

    Member member = new Member("memberA");
    Member savedMember = memberRepository.save(member);

    Member findMember = memberRepository.findById(savedMember.getId()).get();
    assertThat(findMember.getId()).isEqualTo(member.getId());
    assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    assertThat(findMember).isEqualTo(member);
  }

}
