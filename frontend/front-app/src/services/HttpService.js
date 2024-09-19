export class HttpService {

    doGet(path, successCallback, errorCallback, containToken) {
        let headers = {};
        if (containToken && localStorage.getItem('token')) {
            let token = localStorage.getItem('token');
            headers = {'Authorization': token};
        }
        let success = true;

        fetch('http://localhost:8080/' + path, {method: "GET", headers: headers})
            .then(response => {
                    if (response.ok) {
                        return response.json();
                    } else {
                        success = false;
                        return response.text();
                    }
                }
            )
            .then(data => success ? successCallback(data) : errorCallback(data));
    }

    doPost(path, body, successCallback, errorCallback, containToken, contentType) {
        let headers = {};

        headers = {'Content-type': 'application/json'};

        if (containToken && localStorage.getItem('token')) {
            let token = localStorage.getItem('token');
            headers.authorization = token;
        }

        let success = true;

        fetch('http://localhost:8080' + path, {method: "POST", headers: headers, body: JSON.stringify(body)})
            .then(response => {
                    if (response.ok) {
                        if (contentType == "json") {
                            return response.json();
                        }
                        if (contentType == "text") {
                            return response.text();
                        }

                    } else {
                        success = false;
                        return response.text();
                    }
                }
            )
            .then(data => success ? successCallback(data) : errorCallback(data));
    }
}
