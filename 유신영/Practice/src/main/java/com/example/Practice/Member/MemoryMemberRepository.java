package com.example.Practice.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // 해시맵에서 값을 호출하되, 빈 값이면 0을 호출
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

        // 컬렉션에 속한 값들을 collection 형태로 반환 -> 스트림 생성 -> 필터를 통해 getMember()
        // name과 같은 값인지 확인 -> 그중 임의의 값을 호출
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        // 새로운 리스트를 만들고, store의 값들을 반환
    }

    public void clearStore() {
        store.clear();
    }
}
