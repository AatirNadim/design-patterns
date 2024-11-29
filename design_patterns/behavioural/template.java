package design_patterns.behavioural;

// Abstract class
abstract class Beverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring in cup");
    }
}

// Concrete subclass for coffee
class Coffee extends Beverage {
    @Override
    void brew() {
        System.out.println("Brewing coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and cream");
    }
}

// Concrete subclass for tea
class Tea extends Beverage {
    @Override
    void brew() {
        System.out.println("Steeping tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Client code
class CoffeeShop {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        Beverage tea = new Tea();

        System.out.println("Preparing coffee:");
        coffee.prepareRecipe();

        System.out.println("\nPreparing tea:");
        tea.prepareRecipe();
    }
}
