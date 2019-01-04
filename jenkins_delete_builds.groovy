/**
 * Groovy Code to save only some last builds on Jenkins
 * Not recommend this approache, because
 * any job on Jenkins has the additional option method
 * "Discard old builds" that contains "Max # of builds to keep" field
 */

import jenkins.model.Jenkins

def countLastBuilds = 5
def jobName = “Job Name”
def job = Jenkins.instance.getItem(jobName)

job.getBuilds().each {
  if (countLastBuilds <= 0) {
    it.delete()
  } else {
    countLastBuilds -= 1
  }
}
job.save()
