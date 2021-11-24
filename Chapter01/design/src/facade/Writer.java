package facade;

public class Writer {
    private String fileName;

    public Writer(String name) {
        this.fileName = name;
    }

    public void fileConnect() {
        String format = String.format("Writer %s 로 연결합니다.", fileName);
        System.out.println(format);
    }

    public void fileDisConnect() {
        String format = String.format("Writer %s 로 연결 종료합니다.", fileName);
        System.out.println(format);
    }

    public void fileWrite() {
        String format = String.format("Writer %s 로 파일 쓰기를 합니다.", fileName);
        System.out.println(format);
    }
}
