<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="include/header.jsp" />


<div class="container text-center">
  <h1>User Profile Page</h1>
  <p>Name: ${user.email}</p>

    
        <h2>Past Ratings:</h2>
        <table class="table table-bordered table-dark">
          <thead>
            <tr>
              <th scope="col">Movie</th>
              <th scope="col">Stars</th>
              <th scope="col">Comment</th>
            </tr>
          </thead>
          <tbody>
      
            <c:forEach items="${ratings}" var="rating">
            <tr>
              <td>${rating.title}</td>
              <td>${rating.no_stars}</td>
              <td>${rating.comment}</td>
            </tr>
      
            </c:forEach>   
          </tbody>

        </table>
       </div>
</div>


































<jsp:include page="include/footer.jsp" />