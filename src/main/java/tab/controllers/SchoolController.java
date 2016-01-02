package tab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tab.model.School;
import tab.services.ISchoolService;

public class SchoolController {
    private static final Logger LOG = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    ISchoolService schoolService;

    public void setSchoolService(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/school", method = RequestMethod.POST)
    @ResponseBody
    String saveSchool(@RequestBody School school) {
        LOG.info("Request to save new school. name: " + school.getName() + ", mascot: " + school.getMascot());
        schoolService.saveSchool(school);
        return "{\"data\":\"School saved successfully\"}";
    }

    @RequestMapping(value="/school/{schoolId}")
    @ResponseBody
    School getSchool(@PathVariable("schoolId") int schoolId) throws Exception {
        LOG.info("Request to get school by id: " + schoolId);
        School school = schoolService.getSchool(schoolId);
        if (school==null)
            throw new Exception("School does not exist");
        return school;
    }

    @RequestMapping(value="/school/{schoolId")
    @ResponseBody
    String updateSchool(@RequestBody School school, @PathVariable("schoolId") int schoolId) {
        schoolService.updateSchool(school,schoolId);
        LOG.info( "Request to update school by id: " + schoolId + ". New school request details: "
            + "name: " + school.getName() + ", mascot: " +school.getMascot());
        return "School Details updated successfully";
    }
}
