package design_patterns.structural;

interface Image {
    void display();

}


class RealImage implements Image {
    String path = "";
    RealImage(String path) {
        this.path = path;
        this.loadFileFromPath();
    }

    private void loadFileFromPath() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display() {}

}


class ProxyImage implements Image {
    RealImage realImage;
    private String path;

    ProxyImage(String path) {
        this.path = path;
    }

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(path);
        }
        realImage.display();
    }
}