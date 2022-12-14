<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <jsp:include page="include/header.jsp" />


    <div class="container">
        <div class="row mt-3 mb-1 justify-content-center !important">
            <h2>Add A Movie</h2>
        </div>

        <c:if test="${bindingResult.hasErrors()}">
            <c:forEach items="${bindingResult.hasErrors()}" var="error">
                <p style="color:red">${error.getDefaultMessage}</p>
            </c:forEach>

        </c:if>

        <form action="/movie/addmovie" method="POST">
            <div class="row mt-2 mb-3 justify-content-center">
                <label for="inputTitle" class="form-label">Title</label>
                <input type="title" value="${form.title}" name="title" class="form-control" id="title"
                    aria-describedby="titleNameHelp">
                <div id="titleNameHelp" class="form-text">Enter the title of the movie</div>
            </div>
            <div class="row mt-2 mb-3 col-6 justify-content-center">
                <label for="inputDirector" class="form-label">Director</label>
                <input type="director" value="${form.director}" name="director" class="form-control" id="director"
                    aria-describedby="directorNameHelp">
                <div id="directorNameHelp" class="form-text">Enter the name of the director</div>
            </div>
            <div class="row mt-2 mb-3 col-3 justify-content-center">
                <label for="inputYear" class="form-label">Year</label>
                <input type="year" value="${form.year}" name="year" class="form-control" id="year"
                    aria-describedby="yearNameHelp">
                <div id="yearNameHelp" class="form-text">Enter the year the movie released</div>
            </div>
            <div class="row mt-2 mb-3 col-2 justify-content-center">
                <label for="inputGenre" class="form-label">Genre</label>
                <input type="genre" value="${form.genre}" name="genre" class="form-control" id="genre"
                    aria-describedby="genreNameHelp">
                <div id="genreNameHelp" class="form-text">Enter the genre code for the movie</div>
            </div>
            <div class="row mt-2 mb-3 col-6 justify-content-center">
                <label for="inputImage" class="form-label">Image</label>
                <input type="text" value="${form.image}" name="image" class="form-control" id="image"
                    aria-describedby="imageNameHelp">
                <div id="imageNameHelp" class="form-text">Enter a url for the movie image </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

<jsp:include page="include/footer.jsp" />