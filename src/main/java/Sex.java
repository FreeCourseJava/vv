package main.java;

    public class Sex implements SexInfo {
        private final String desc;
        private final String name;


        public Sex(String name, String desc) {
            this.desc = desc;
            this.name = name;
        }

        @Override
        public String getSexDescription() {
            return desc;
        }

        public String getName() {
            return name;
        }

    }