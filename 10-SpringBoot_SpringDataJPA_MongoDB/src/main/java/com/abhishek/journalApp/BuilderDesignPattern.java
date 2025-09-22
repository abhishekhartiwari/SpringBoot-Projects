package com.abhishek.journalApp;

public class BuilderDesignPattern {

	public static void main(String[] args) {
		
		

	}

}
class Pizza {
    private String dough;
    private String topping;

    public static class Builder {
        private String dough;
        private String topping;

        public Builder setDough(String dough) {
            this.dough = dough;
            return this;
        }

        public Builder setTopping(String topping) {
            this.topping = topping;
            return this;
        }

        public Pizza build() {
            Pizza pizza = new Pizza();
            pizza.dough = this.dough;
            pizza.topping = this.topping;
            return pizza;
        }
    }
}
//
//// Usage:
//Pizza pizza = new Pizza.Builder()
//    .setDough("Thin Crust")
//    .setTopping("Cheese")
//    .build();

