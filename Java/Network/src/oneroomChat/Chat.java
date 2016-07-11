package oneroomChat;

public interface Chat {

	// 클라이언트는 아이디를 입력하여 접속.
	// -> 아이디 생성 메소드
	// 아이디와 연결된 후 대기
	// (메세지) 보낼 것을 한꺼번에 묶어 전송 -> 객체전송 serializable  -> 전송 메소드
	// (메세지) 듣기 -> 듣기 메소드
	// 서버는 회원에 대한 정보가 있어야 한다 -> 리스트
	
	
	public void BroadCast(Object user);         // 메세지 전송 서버가 아니라 한명이 모두에게 보낸다
	public void sendMsg();
	public void readMsg();
	public void put(Object obj);
	
	
}
