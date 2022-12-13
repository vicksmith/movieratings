<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




  <jsp:include page="include/header.jsp" />






  <div class="container">
    <div class="row">
      <div class="col">
        <img src="${movie.image}" alt="Movie Image" style="max-width: 300px;max-height: 400px" />
      </div>

      <div class="col">
        Movie: ${movie.title}
        <br><br>
        Director: ${movie.director}
        <br>
        <br>
        Year: ${movie.year}
        <br>
        <br>
        Genre: ${movie.name}
        <br><br>
        <form action="/movie/rating" method="POST" class="rating_form">
          <input type="hidden" name="movieId" value="${movie.id}">
          Please Give The Movie A Star Rating
          <br>
          <select name="stars" id="stars">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>

          </select>
          <br><br>
          <label for="comment">Give Your Critique of The Movie:</label>
          <textarea id="comment" name="comment" rows="4" cols="80">

</textarea><br>
          <input type="submit" value="Submit">
        </form>
      </div>
    </div>
  </div>
  </div>
  <br><br>

  <div class="container">
    <h2>How Others Rated It:</h2>
    <table class="table table-bordered table-dark">
      <thead>
        <tr>
          <th scope="col">User</th>
          <th scope="col">Stars</th>
          <th scope="col">Comment</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${ratings}" var="rating">
          <tr>
            <td>${rating.userId}</td>
            <td>${rating.noStars}</td>
            <td>${rating.comment}</td>
          </tr>
          <tr>

      </tbody>
      </c:forEach>
    </table>
  </div>
  <style>
    .rating_form {
      background-color: white;
      border: solid black 2px;
    }

    .table-striped:nth-child(even) {
      background-color: white;
    }

    body {
      background-color: dimgray;
    }
  </style>

  <jsp:include page="include/footer.jsp" />