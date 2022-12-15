<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <jsp:include page="include/header.jsp" />

  <body>
    <section class="bg-dark d-flex justify-content-center align-items-center h-100 min-vh-100">

      <div class="container">
        <div class="row gy-2">
          <c:forEach items="${movies}" var="movie">
            <div class="col-lg-3 col-md-4">
              <div class="mt-3 box bg-primary h-100 d-flex p-4 flex-column text-white">
                <img src="${movie.image}
    " alt="Movie Poster">
                <h1>${movie.title}</h1>
                <p class="card-text">Director: ${movie.director}</p>
                <p>Year: ${movie.year} </p>
                <p>Genre: ${movie.name}</p>
                <a href="/moviedetails?id=${movie.id}" class="btn mt-auto btn-dark">Read More</a>
              </div>
            </div>
          </c:forEach>
        </div>
    </section>
  </body>




































  <jsp:include page="include/footer.jsp" />