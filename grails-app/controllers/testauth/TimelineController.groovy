package testauth

import grails.converters.*

class TimelineController {

def apiUrl = "http://twitter.com/statuses/friends_timeline.json"
    def oauthService
    
    def index = {

        if (session.oauthToken == null) {
            redirect(uri:"/")
        }

        if (params?.apiUrl) apiUrl = params.apiUrl
        
        def response = oauthService.accessResource(
                apiUrl, 'twitter', [key:session.oauthToken.key, secret:session.oauthToken.secret])

        def statuses = JSON.parse(response)
		def payload = ''

        for (status in statuses)
         payload += status.get("text") + "\n\n"

        render(view: 'index', model: [timeline: payload, apiUrl: apiUrl])
    }

    def change = {
        if (params?.apiUrl) {
            println("Setting api url to " + params.apiUrl)
            apiUrl = params.apiUrl
        }
        
        redirect(action:index,params:params)
    }
}
