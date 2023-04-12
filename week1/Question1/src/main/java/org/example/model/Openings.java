package org.example.model;

import static org.example.model.Roles.*;

public enum Openings {

        JAVA(8,MANAGER),
        SAP(4,SRASSOCIATE),
        QA(3,ASSOCIATE);
        private final int experience;
        private final Roles role;

         Openings(int experience, Roles role){
                this.experience=experience;
                this.role=role;
        }

        public int getExperience()
        {
                return this.experience;
        }

        public Roles getRole() {
                return this.role;
        }
}
