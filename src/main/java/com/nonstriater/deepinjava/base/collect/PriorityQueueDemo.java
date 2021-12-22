package com.nonstriater.deepinjava.base.collect;

import java.time.LocalDate;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static class Employee implements Comparable<Employee> {
        private Long id;
        private String name;
        private LocalDate dob;

        public Employee(Long id, String name, LocalDate dob) {
            super();
            this.id = id;
            this.name = name;
            this.dob = dob;
        }

        @Override
        public int compareTo(Employee emp) {
            return this.getId().compareTo(emp.getId());
        }

        //Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + "]";
        }

    }


    public static void main(String[] args){

        {
            PriorityQueue<Employee> pq = new PriorityQueue();
            pq.add(new Employee(1L, "AAA", LocalDate.now()));
            pq.add(new Employee(4L, "BBB", LocalDate.now()));
            pq.add(new Employee(3L, "DDD", LocalDate.now()));
            pq.add(new Employee(7L, "GGG", LocalDate.now()));
            pq.add(new Employee(2L, "CCC", LocalDate.now()));

            while (true) {
                Employee head = pq.poll();
                System.out.println(head);
                if (head == null) {
                    return;
                }
            }
        }
    }

}
