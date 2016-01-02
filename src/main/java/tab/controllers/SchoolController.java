package tab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tab.model.School;
import tab.services.ISchoolService;

/**
 * Created by kate on 1/1/16.
 */
public class SchoolController {
    @Autowired
    ISchoolService schoolService;

    public void setSchoolService(ISchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/school", method = RequestMethod.POST)
    @ResponseBody
    String saveSchool(@RequestBody School school) {
        schoolService.saveSchool(school);
        return "{\"data\":\"School saved successfully\"}";
    }

    @RequestMapping(value="/school/{schoolId}")
    @ResponseBody
    School getSchool(@PathVariable("schoolId") int schoolId) throws Exception {
        School school = schoolService.getSchool(schoolId);
        if (school==null)
            throw new Exception("School does not exist");
        return school;
    }

    @RequestMapping(value="/school/{schoolId")
    @ResponseBody
    String updateSchool(@RequestBody School school, @PathVariable("schoolId") int schoolId) {
        schoolService.updateSchool(school,schoolId);
        return "School Details updated successfully";
    }
}
