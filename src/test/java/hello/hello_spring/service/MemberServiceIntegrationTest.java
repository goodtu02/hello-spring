package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        Long saveId = memberService.join(member1);

        Member findMember = memberService.findOne(saveId).get();
        assertThat(member1.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복회원() {
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e1) {
            assertThat(e1.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}