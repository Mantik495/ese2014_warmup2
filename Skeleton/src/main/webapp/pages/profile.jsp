<?xml version="1.0" encoding="UTF-8"?>
<flow xmlns="http://www.springframework.org/schema/webflow"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/webflow
                          http://www.springframework.org/schema/webflow/spring-webflow-2.0.xsd">

</flow>

<c:import url="template/header.jsp" />

<view-state id="SearchBookingStages" />


<named-query name="User.findByLastname">
  <query>select u from User u where u.lastname = ?1</query>
</named-query>



<c:import url="template/footer.jsp" />



