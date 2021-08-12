package com.kh.servlet.model.vo;

import lombok.Data;

/*
 * @Setter
 * @Getter
 * @ToString
 * @AllArgsConstructor
 * @NoArgsConstructor
 * @EqualsAndHashCode
 * 이렇게 나눠서 원하는것만 할 수도 있음
 * @Data는 다되는거
 */
@Data
public class Member {
	
	private String memberId;
	private String memberPwd;
	private String memberName; 
	
}
