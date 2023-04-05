package com.interactingwithapi.task1;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    private User() {
    }

    public int getId() {
        return id;
    }

    public static class Builder {
        private int id;
        private String name;
        private String username;
        private String email;
        private Address address;
        private String phone;
        private String website;
        private Company company;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public User build() {
            User user = new User();
            user.id = this.id;
            user.name = this.name;
            user.username = this.username;
            user.email = this.email;
            user.address = this.address;
            user.phone = this.phone;
            user.website = this.website;
            user.company = this.company;
            return user;
        }
    }

    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", suite='" + suite + '\'' +
                    ", city='" + city + '\'' +
                    ", zipcode='" + zipcode + '\'' +
                    ", geo=" + geo +
                    '}';
        }

        private Address() {
        }

        public static class Builder {
            private String street;
            private String suite;
            private String city;
            private String zipcode;
            private Geo geo;

            public Builder setStreet(String street) {
                this.street = street;
                return this;
            }

            public Builder setSuite(String suite) {
                this.suite = suite;
                return this;
            }

            public Builder setCity(String city) {
                this.city = city;
                return this;
            }

            public Builder setZipcode(String zipcode) {
                this.zipcode = zipcode;
                return this;
            }

            public Builder setGeo(Geo geo) {
                this.geo = geo;
                return this;
            }

            public Address build() {
                Address address = new Address();
                address.street = this.street;
                address.suite = this.suite;
                address.city = this.city;
                address.zipcode = this.zipcode;
                address.geo = this.geo;
                return address;
            }
        }

        public static class Geo {
            private String lat;
            private String lng;

            private Geo() {
            }

            @Override
            public String toString() {
                return "Geo{" +
                        "lat='" + lat + '\'' +
                        ", lng='" + lng + '\'' +
                        '}';
            }

            public Geo(String lat, String lng) {
                this.lat = lat;
                this.lng = lng;
            }

            public static class Builder {
                private String lat;
                private String lng;

                public Builder setLat(String lat) {
                    this.lat = lat;
                    return this;
                }

                public Builder setLng(String lng) {
                    this.lng = lng;
                    return this;
                }

                public Geo build() {
                    Geo geo = new Geo();
                    geo.lat = this.lat;
                    geo.lng = this.lng;
                    return geo;
                }
            }
        }
    }

    public static class Company {
        private String name;
        private String catchPhrase;
        private String bs;

        private Company() {
        }

        @Override
        public String toString() {
            return "Company{" +
                    "name='" + name + '\'' +
                    ", catchPhrase='" + catchPhrase + '\'' +
                    ", bs='" + bs + '\'' +
                    '}';
        }

        public static class Builder {
            private String name;
            private String catchPhrase;
            private String bs;

            public Builder setName(String name) {
                this.name = name;
                return this;
            }

            public Builder setCatchPhrase(String catchPhrase) {
                this.catchPhrase = catchPhrase;
                return this;
            }

            public Builder setBs(String bs) {
                this.bs = bs;
                return this;
            }

            public Company build() {
                Company company = new Company();
                company.name = this.name;
                company.catchPhrase = this.catchPhrase;
                company.bs = this.bs;
                return company;
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}

