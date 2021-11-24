package facade;

public class Reader {
    private String fileName;

    public Reader(String name) {
        this.fileName = name;
    }

    public void fileConnect() {
        String format = String.format("Reader %s 로 연결합니다.", fileName);
        System.out.println(format);
    }

    public void fileDisConnect() {

        String format = String.format("Reader %s 로 연결 종료합니다.", fileName);
        System.out.println(format);
    }

    public void fileReader() {
        String format = String.format("Reader %s 의 내용을 읽어옵니다.", fileName);
        System.out.println(format);
    }

}
