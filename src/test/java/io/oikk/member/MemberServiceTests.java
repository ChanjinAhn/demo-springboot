package io.oikk.member;

import static org.assertj.core.api.Assertions.assertThat;

import io.oikk.member.entity.Member;
import io.oikk.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Rollback(false)
public class MemberServiceTests {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("Member insert test")
    @Test
    public void saveMemberTest() {

        //given
        Member member = new Member();
        member.setName("andrew");
        member.setAge(32);
        memberRepository.save(member);

        // when
        Member retriedMember = memberRepository.findById(member.getId()).get();

        // then
        assertThat(retriedMember.getName()).isEqualTo("andrew");
        assertThat(retriedMember.getAge()).isEqualTo(Integer.valueOf(32));
    }
}