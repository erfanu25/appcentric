**Java**

_`1.`_ Reflection API    
https://www.geeksforgeeks.org/reflection-in-java/

https://www.javatpoint.com/java-reflection

_`2.`_ Gradle vs Maven     
https://dzone.com/articles/gradle-vs-maven     
Gradle - https://www.vogella.com/tutorials/Gradle/article.html

_`3.`_ Java Optional Class
https://www.baeldung.com/java-optional

_`4.`_ Generics in Java
https://www.geeksforgeeks.org/generics-in-java/

_`5.`_ Lambda Expression in Java
https://www.geeksforgeeks.org/lambda-expressions-java-8/  
   
Interface -

    public interface ResultMapper<T,R> {
        R map(T entity);
    }   
Without Lambda--   
     
    ResultMapper<OrderEntity, Order> entityToDomainMapper() {
               return new ResultMapper<OrderEntity, Order>() {
                   @Override
                   public Order map(OrderEntity entity) {
                       Order order = new Order();
                       order.setQuantity(entity.getQuantity());
                       return order;
                   }
               };
           }
   
By using Lambda--

    public ResultMapper<OrderEntity, Order> entityToDomainMapping() {
        return entity ->
            new Order().setQuantity(entity.getQuantity());
    }
