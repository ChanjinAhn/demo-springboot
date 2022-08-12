package io.oikk.member;

import static org.assertj.core.api.Assertions.assertThat;

import io.oikk.member.entity.Member;
import io.oikk.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MemberServiceTests {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Insert Member Test")
    public void saveMemberTest() {

        //given
        String name = "acj";
        int age = 13;

        Member member = Member.builder()
                .name(name)
                .age(age).build();

        memberRepository.save(member);

        // when
        Member retriedMember = memberRepository.findByName(name).orElseThrow(IllegalArgumentException::new);

        // then
        assertThat(retriedMember.getName()).isEqualTo(name);
        assertThat(retriedMember.getAge()).isEqualTo(Integer.valueOf(age));
    }
}