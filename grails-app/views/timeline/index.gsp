<html>
<head><title>Your Timeline</title></head>
<body>
<a class="home" href="${createLinkTo(dir:'')}">Home</a>
<g:hasOauthError>
    <div class="errors">
        <g:renderOauthError/>
    </div>
</g:hasOauthError>

<g:form url="[action:'change',controller:'timeline']" method="get">
    <h2>Your Timeline:</h2>
    <textarea id="payload" rows="12" cols="80" color: black">${timeline}</textarea>
    <p>
        <br/>
        <g:submitButton name="send" value="View latest tweets"/>
    </p>
</g:form>
</body>
</html>