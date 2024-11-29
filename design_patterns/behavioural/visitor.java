package design_patterns.behavioural;

// Element interface
interface File {
    void accept(Visitor visitor);
}

// Concrete element classes
class TextFile implements File {
    private String name;
    private String content;

    public TextFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class ImageFile implements File {
    private String name;
    private String format;

    public ImageFile(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class AudioFile implements File {
    private String name;
    private String format;

    public AudioFile(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor interface
interface Visitor {
    void visit(TextFile textFile);
    void visit(ImageFile imageFile);
    void visit(AudioFile audioFile);
}

// Concrete visitor classes
class PrintVisitor implements Visitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Printing text file: " + textFile.getName());
        System.out.println("Content: " + textFile.getContent());
    }

    @Override
    public void visit(ImageFile imageFile) {
        System.out.println("Printing image file: " + imageFile.getName());
        System.out.println("Format: " + imageFile.getFormat());
    }

    @Override
    public void visit(AudioFile audioFile) {
        System.out.println("Printing audio file: " + audioFile.getName());
        System.out.println("Format: " + audioFile.getFormat());
    }
}

class PlayVisitor implements Visitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Cannot play text file: " + textFile.getName());
    }

    @Override
    public void visit(ImageFile imageFile) {
        System.out.println("Cannot play image file: " + imageFile.getName());
    }

    @Override
    public void visit(AudioFile audioFile) {
        System.out.println("Playing audio file: " + audioFile.getName());
        System.out.println("Format: " + audioFile.getFormat());
    }
}

// Client code
class FileSystem {
    public static void main(String[] args) {
        TextFile textFile = new TextFile("example.txt", "Hello, world!");
        ImageFile imageFile = new ImageFile("example.jpg", "JPEG");
        AudioFile audioFile = new AudioFile("example.mp3", "MP3");

        PrintVisitor printVisitor = new PrintVisitor();
        PlayVisitor playVisitor = new PlayVisitor();

        textFile.accept(printVisitor);
        imageFile.accept(printVisitor);
        audioFile.accept(printVisitor);

        System.out.println();

        textFile.accept(playVisitor);
        imageFile.accept(playVisitor);
        audioFile.accept(playVisitor);
    }
}
