node ("$NodeName"){
    wrks = env.WORKSPACE
    stage("Prepare"){
        println("Preparing...")
        git(
            url: "git@github.com:jayabalandevops/plshome.git",
            branch: "master"
        )
        dir('config'){
            git(
                url: "git@github.com:jayabalandevops/confhome.git",
                branch: "master"
            )
        }
        println("Prepared the workspace for groovy scripts and configurations from git repos.")
    }
    stage("Application Cloning"){
        println("Cloning the Application in to workspace app repo...")
        load 'app/clone.groovy'
        println("Cloned the App Repo in to workspace from git repos.") 
    }
    stage("Application Build"){
        println("Building the Application...")
        load 'app/build.groovy'
        println("Complted the application Build..!")
    }

}